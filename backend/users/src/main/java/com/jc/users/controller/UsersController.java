package com.jc.users.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jc.common.dto.ResponseDto;
import com.jc.users.dto.UsersDto;
import com.jc.users.service.IUsersService;
import com.jc.users.constants.UsersConstants;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
@AllArgsConstructor
@Validated
public class UsersController {
    private IUsersService usersService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto<UsersDto>> createUser(@Valid @RequestBody UsersDto usersDto) {
        UsersDto savedUsers = usersService.createUser(usersDto);
        if (savedUsers == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto<>(UsersConstants.STATUS_417, UsersConstants.MESSAGE_417_CREATE, null));
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto<>(UsersConstants.STATUS_201, UsersConstants.MESSAGE_201_CREATE, null));
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseDto<UsersDto>> getUser(@RequestParam String userEmail) {
        UsersDto user = usersService.getUserByEmail(userEmail);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto<>(UsersConstants.STATUS_417, UsersConstants.MESSAGE_417_GET, null));
        }
    return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto<UsersDto>(UsersConstants.STATUS_200, UsersConstants.MESSAGE_200_GET, user));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto<UsersDto>> updateUser(@Valid @RequestBody UsersDto usersDto) {
        boolean isUpdated = usersService.updateUser(usersDto);
        if (!isUpdated) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto<>(UsersConstants.STATUS_417, UsersConstants.MESSAGE_417_UPDATE, null));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto<>(UsersConstants.STATUS_200, UsersConstants.MESSAGE_200_UPDATE, null));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto<UsersDto>> deleteUser(@Valid @RequestBody UsersDto usersDto) {
        boolean isDeleted = usersService.deleteUser(usersDto);
        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto<>(UsersConstants.STATUS_417, UsersConstants.MESSAGE_417_DELETE, null));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto<>(UsersConstants.STATUS_200, UsersConstants.MESSAGE_200, null));
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}

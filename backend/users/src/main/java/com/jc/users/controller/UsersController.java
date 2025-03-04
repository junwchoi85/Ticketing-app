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
import com.jc.common.validation.ValidationGroups.CreateValidation;
import com.jc.common.validation.ValidationGroups.UpdateValidation;
import com.jc.users.constants.UsersConstants;
import com.jc.users.dto.CustomerDto;
import com.jc.users.service.IUsersService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
@AllArgsConstructor
@Validated
public class UsersController {
    private IUsersService usersService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto<CustomerDto>> signupCustomer(
            @Validated({ CreateValidation.class }) @RequestBody CustomerDto customerDto) {
        CustomerDto savedUsers = usersService.signUpCustomer(customerDto);
        if (savedUsers == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto<>(UsersConstants.STATUS_417, UsersConstants.MESSAGE_417_CREATE, null));
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto<CustomerDto>(UsersConstants.STATUS_201, UsersConstants.MESSAGE_201_CREATE,
                        savedUsers));
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseDto<CustomerDto>> getUser(@RequestParam String userEmail) {
        CustomerDto user = usersService.fetchCustomerByEmail(userEmail);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto<>(UsersConstants.STATUS_417, UsersConstants.MESSAGE_417_GET, null));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto<CustomerDto>(UsersConstants.STATUS_200, UsersConstants.MESSAGE_200_GET, user));
    }

    @GetMapping("/getByUuid")
    public ResponseEntity<ResponseDto<CustomerDto>> getUserByUuid(@RequestParam("uuid") String uuid) {
        CustomerDto user = usersService.fetchCustomerByUuid(uuid);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto<>(UsersConstants.STATUS_417, UsersConstants.MESSAGE_417_GET, null));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto<CustomerDto>(UsersConstants.STATUS_200, UsersConstants.MESSAGE_200_GET, user));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto<CustomerDto>> updateUser(
            @Validated({ UpdateValidation.class }) @RequestBody CustomerDto customerDto) {
        boolean isUpdated = usersService.editCustomerDetails(customerDto);
        if (!isUpdated) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto<>(UsersConstants.STATUS_417, UsersConstants.MESSAGE_417_UPDATE, null));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto<CustomerDto>(UsersConstants.STATUS_200, UsersConstants.MESSAGE_200_UPDATE, null));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto<CustomerDto>> deleteUser(
            @Validated({ UpdateValidation.class }) @RequestBody CustomerDto customerDto) {
        boolean isDeleted = usersService.deactivateCustomer(customerDto);
        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto<>(UsersConstants.STATUS_417, UsersConstants.MESSAGE_417_DELETE, null));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto<CustomerDto>(UsersConstants.STATUS_200, UsersConstants.MESSAGE_200, null));
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}

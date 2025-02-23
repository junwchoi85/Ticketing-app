package com.jc.users.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jc.common.exception.ConflictException;
import com.jc.common.exception.ResourceNotFoundException;
import com.jc.users.dto.UsersDto;
import com.jc.users.entity.Users;
import com.jc.users.mapper.UsersMapper;
import com.jc.users.repository.UsersRepository;
import com.jc.users.service.IUsersService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements IUsersService {
    private final UsersRepository usersRepository;

    @Override
    public UsersDto createUser(UsersDto usersDto) {
        Users users = UsersMapper.convertToEntity(usersDto);
        Optional<Users> user = usersRepository.findByEmail(users.getEmail());
        if (user.isPresent()) {
            throw new ConflictException("User", "email", users.getEmail());
        }
        Users savedUsers = usersRepository.save(users);
        return UsersMapper.convertToDto(savedUsers);
    }

    @Override
    public UsersDto getUserById(Long id) {
        Users users = usersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id.toString()));
        return UsersMapper.convertToDto(users);
    }

    @Override
    public UsersDto getUserByEmail(String email) {
        Users users = usersRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User", "email", email));
        return UsersMapper.convertToDto(users);
    }

    @Override
    public boolean updateUser(UsersDto usersDto) {
        Users users = usersRepository.findByEmail(usersDto.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User", "email", usersDto.getEmail()));
        Users updatedUsers = UsersMapper.mapToEntity(usersDto, users);
        usersRepository.save(updatedUsers);
        return true;
    }

    @Override
    public boolean deleteUser(UsersDto usersDto) {
        Users users = usersRepository.findByEmail(usersDto.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User", "email", usersDto.getEmail()));
        usersRepository.deleteById(users.getId());
        return true;
    }

    @Override
    public List<UsersDto> getAllUsers() {
        List<Users> users = usersRepository.findAll();
        return users.stream().map(UsersMapper::convertToDto).collect(Collectors.toList());
    }

}

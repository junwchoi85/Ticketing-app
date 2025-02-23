package com.jc.users.service;

import java.util.List;

import com.jc.users.dto.UsersDto;

public interface IUsersService {
    public UsersDto createUser(UsersDto usersDto);
    public UsersDto getUserById(Long id);
    public UsersDto getUserByEmail(String email);
    public boolean updateUser(UsersDto usersDto);
    public boolean deleteUser(UsersDto usersDto);
    public List<UsersDto> getAllUsers();
}

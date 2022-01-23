package com.nmironov.internetshop.service.admin;

import com.nmironov.internetshop.dto.admin.UserDto;
import com.nmironov.internetshop.model.User;
import org.springframework.stereotype.Service;

@Service
public class MappingUtils {

    public UserDto mapToUserDto(User user) {
        UserDto dto = new UserDto();
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setRole(user.getRole());
        return dto;
    }


}

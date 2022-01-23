package com.nmironov.internetshop.service.admin;

import com.nmironov.internetshop.model.User;
import com.nmironov.internetshop.repository.admin.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class SpringUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final MappingUtils mappingUtils;

    public SpringUserDetailsService(
            UserRepository userRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder,
            MappingUtils mappingUtils) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.mappingUtils = mappingUtils;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.getUserByUsername(username);
        return mappingUtils.mapToUserDto(user);

    }
}

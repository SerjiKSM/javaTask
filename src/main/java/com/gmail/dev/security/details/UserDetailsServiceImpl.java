package com.gmail.dev.security.details;

import com.gmail.dev.domain.User;
import com.gmail.dev.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> userCandidate = userRepository.findOneByLogin(login);
        if (userCandidate.isPresent()) {
            return new UserDetailsImpl(userCandidate.get());
        } else throw new IllegalArgumentException("User not found");
    }
}

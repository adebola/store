package io.factorialsystems.store.service.user;

import io.factorialsystems.store.domain.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if (user == null) {
            throw (new UsernameNotFoundException("User Not Found : " + username));
        }

        log.info(String.format("User is username: %s, role count: %d",  user.getUsername(), user.getRoles().size()));

        return UserDetailsImpl.build(user);
    }
}

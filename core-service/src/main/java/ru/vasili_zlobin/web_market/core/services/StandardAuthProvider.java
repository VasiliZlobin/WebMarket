package ru.vasili_zlobin.web_market.core.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class StandardAuthProvider extends AbstractUserDetailsAuthenticationProvider {
    private final AuthenticationService service;
    private final PasswordEncoder encoder;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        if (!encoder.matches(authentication.getCredentials().toString(), userDetails.getPassword())) {
            log.error("Bad credentials for {}", userDetails.getUsername());
            throw new BadCredentialsException("Bad credentials");
        }
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        return service.loadUserByUsername(username);
    }
}

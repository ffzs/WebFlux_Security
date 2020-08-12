package com.ffzs.webflux.security_demo.service;

import com.ffzs.webflux.security_demo.repository.MyUserDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author: ffzs
 * @Date: 2020/8/12 上午9:13
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class MyUserDetailsService implements ReactiveUserDetailsService {

    private final MyUserDetailsRepository myUserDetailsRepository;

    @Override
    public Mono<UserDetails> findByUsername(String username) {

        return myUserDetailsRepository.findByUsername(username)
                .log()
                .doOnNext(i -> System.out.println(PasswordEncoderFactories.createDelegatingPasswordEncoder().matches("admin", i.getPassword())))
                .cast(UserDetails.class);
    }
}

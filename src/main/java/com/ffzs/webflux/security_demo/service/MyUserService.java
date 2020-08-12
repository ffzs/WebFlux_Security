package com.ffzs.webflux.security_demo.service;

import com.ffzs.webflux.security_demo.model.MyUser;
import com.ffzs.webflux.security_demo.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author: ffzs
 * @Date: 2020/8/11 下午5:35
 */

@Service
@RequiredArgsConstructor
public class MyUserService {

    private final MyUserRepository myUserRepository;

    public Flux<MyUser> findAll () {
        return myUserRepository.findAll();
    }

    public Mono<MyUser> findByUsername (String username) {
        return myUserRepository.findByUsername(username);
    }

    public Mono<MyUser> save (MyUser user) {
        return myUserRepository.save(user);
    }

    public Mono<Void> deleteById (Long id) {
        return myUserRepository.deleteById(id);
    }
}

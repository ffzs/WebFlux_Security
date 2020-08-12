package com.ffzs.webflux.security_demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @author: ffzs
 * @Date: 2020/8/11 下午4:38
 */

@RestController
@Slf4j
@RequiredArgsConstructor
public class HelloController {

    @GetMapping
    public Mono<String> hi () {
        return Mono.just("hello ffzs!! ");
    }


    @GetMapping(value = "hello", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Flux<String> fluxString() {
        return Flux.just("ffzs", "dz", "tony", "vincent", "sleepycat")
                .repeat(10)
                .delayElements(Duration.ofMillis(1000))
                .map(i -> "hello !! " + i);
    }
}

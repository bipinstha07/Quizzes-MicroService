package com.api_gateway.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping
public class FallBackController {

    @GetMapping("/categoryServiceFallback")
    public Mono<String> categoryServiceFallback(){
        return Mono.just("Category Service is down. Please try again...CB");
    }

}

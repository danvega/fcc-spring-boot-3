package dev.danvega.runnerz.user;

import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface UserHttpClient {

    @GetExchange("/users")
    List<User> findAll();

    @GetExchange("/{id}")
    User findById(Integer id);

}
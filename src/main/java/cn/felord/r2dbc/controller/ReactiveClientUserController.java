package cn.felord.r2dbc.controller;

import cn.felord.r2dbc.domain.ClientUser;
import cn.felord.r2dbc.repository.ReactiveClientUserSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * The type Reactive client user controller.
 */
@RestController
@RequestMapping("/user")
public class ReactiveClientUserController {

    @Autowired
    private ReactiveClientUserSortingRepository reactiveClientUserSortingRepository;


    /**
     * 这里为了检验默认api 就不分层了
     *
     * @param userId the user id
     * @return the mono
     */
    @GetMapping("/{userId}")
    public Mono<ClientUser> findUserById(@PathVariable String userId) {
        return reactiveClientUserSortingRepository.findById(userId);
    }

}

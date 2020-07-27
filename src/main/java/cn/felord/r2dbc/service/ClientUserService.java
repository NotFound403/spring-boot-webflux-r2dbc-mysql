package cn.felord.r2dbc.service;


import cn.felord.r2dbc.domain.ClientUser;
import reactor.core.publisher.Mono;

/**
 * The interface Client user service.
 *
 * @author a
 * @since 10 :04
 */
public interface ClientUserService {

    /**
     * Save mono.
     *
     * @param clientUser the client user
     * @return the mono
     */
    Mono<Integer> add(ClientUser clientUser);
}

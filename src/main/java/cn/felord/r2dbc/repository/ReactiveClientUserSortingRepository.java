package cn.felord.r2dbc.repository;

import cn.felord.r2dbc.domain.ClientUser;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ReactiveClientUserSortingRepository extends ReactiveCrudRepository<ClientUser,String> {

    @Modifying
    @Query("insert into client_user (user_id,nick_name,phone_number,gender) values (:userId,:nickName,:phoneNumber,:gender)")
    Mono<Integer> addClientUser(String userId, String nickName, String phoneNumber, Integer gender);

}

package cn.felord.r2dbc;

import cn.felord.r2dbc.domain.ClientUser;
import cn.felord.r2dbc.repository.ReactiveClientUserSortingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.r2dbc.core.DatabaseClient;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class R2DbcMysqlApplicationTests {



    @Autowired
    DatabaseClient databaseClient;
    @Autowired
    ReactiveClientUserSortingRepository reactiveClientUserSortingRepository;

    @Test
    void doDDL() {

        List<String> ddl = Collections.unmodifiableList(Arrays.asList("drop table if exists client_user;", "create table client_user(user_id varchar(64) not null primary key,nick_name varchar(32),phone_number varchar(16),gender tinyint default 0) charset = utf8mb4;"));
        ddl.forEach(sql -> databaseClient.execute(sql)
                .fetch()
                .rowsUpdated()
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete());
    }


    @Test
    void saveTest() {
        ClientUser clientUser = new ClientUser();

        clientUser.setGender(2);
        clientUser.setNickName("r2dbc");
        clientUser.setPhoneNumber("9527");
        clientUser.setUserId("snowflake");


//  并不能直接运行      Mono<ClientUser> save = reactiveClientUserSortingRepository.save(clientUser);

        reactiveClientUserSortingRepository.save(clientUser)
                .log()
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete();

    }


    @Test
    void contextLoads() {
        reactiveClientUserSortingRepository
                .addClientUser("snowflake",
                        "r2dbc",
                        "132****155",
                        0)
                .log()
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete();
    }

}

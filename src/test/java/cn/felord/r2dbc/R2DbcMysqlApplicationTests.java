package cn.felord.r2dbc;

import cn.felord.r2dbc.domain.ClientUser;
import cn.felord.r2dbc.service.ClientUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import javax.annotation.Resource;

@SpringBootTest
class R2DbcMysqlApplicationTests {
    @Resource
    ClientUserService clientUserService;
    @Test
    void contextLoads() {

        ClientUser clientUser = new ClientUser();


        clientUser.setGender(2);
        clientUser.setNickName("r2dbc");
        clientUser.setPhoneNumber("9527");
        clientUser.setUserId("snowflake");

        Mono<Integer> save = clientUserService.add(clientUser);
        save.as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete();
    }

}

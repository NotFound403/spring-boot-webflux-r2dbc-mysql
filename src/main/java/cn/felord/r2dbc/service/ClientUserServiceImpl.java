package cn.felord.r2dbc.service;


import cn.felord.r2dbc.domain.ClientUser;
import cn.felord.r2dbc.repository.ClientUserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author a
 * @since 10:05
 **/

@Service
public class ClientUserServiceImpl implements ClientUserService {

    private final ClientUserRepository clientUserRepository;

    public ClientUserServiceImpl(ClientUserRepository clientUserRepository) {
        this.clientUserRepository = clientUserRepository;
    }

    @Override
    public Mono<Integer> add(ClientUser clientUser) {
        return clientUserRepository.addClientUser(clientUser.getUserId(), clientUser.getNickName(), clientUser.getPhoneNumber(), clientUser.getGender());
    }
}

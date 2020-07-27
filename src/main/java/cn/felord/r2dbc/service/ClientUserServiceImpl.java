package cn.felord.r2dbc.service;


import cn.felord.r2dbc.domain.ClientUser;
import cn.felord.r2dbc.repository.ReactiveClientUserSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

/**
 * @author felord.cn
 * @since 10:05
 **/

@Service
public class ClientUserServiceImpl implements ClientUserService {


    private final ReactiveClientUserSortingRepository reactiveClientUserSortingRepository;

    public ClientUserServiceImpl(ReactiveClientUserSortingRepository reactiveClientUserSortingRepository) {

        this.reactiveClientUserSortingRepository = reactiveClientUserSortingRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Mono<Integer> add(ClientUser clientUser) {

        return reactiveClientUserSortingRepository.addClientUser(clientUser.getUserId(), clientUser.getNickName(), clientUser.getPhoneNumber(), clientUser.getGender());
    }

    @Override
    public Mono<ClientUser> findById(String userId) {
        return reactiveClientUserSortingRepository.findById(userId);
    }
}

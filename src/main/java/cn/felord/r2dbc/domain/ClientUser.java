package cn.felord.r2dbc.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 *  custom
 *
 *
 * @author felord.cn
 */
@Data
@Table
public class ClientUser {

    @Id
    private String userId;
    private String nickName;
    private String phoneNumber;
    private Integer gender;
}

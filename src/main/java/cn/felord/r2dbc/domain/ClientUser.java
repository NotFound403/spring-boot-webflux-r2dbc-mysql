package cn.felord.r2dbc.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

/**
 *  the client user type
 *
 * @author felord.cn
 */
@Data
@Table
public class ClientUser implements Persistable<String>,Serializable {
    private static final long serialVersionUID = -558043294043707772L;
    @Id
    private String userId;
    private String nickName;
    private String phoneNumber;
    private Integer gender;

    @Override
    public String getId() {
        return userId;
    }

    @Override
    public boolean isNew() {
        return false;
    }
}

package com.example.shriodemo.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/*
 * @Author liuxin
 * @Description //TODO
 **/

@Entity(name = "user_info")
@Data
@NoArgsConstructor
public class UserInfo extends BasePo {

    /**
     *  用户名
     */
    @Column(length = 255)
    private String username;

    /**
     * 密码
     */
    @Column(length = 255)
    private String password;

}

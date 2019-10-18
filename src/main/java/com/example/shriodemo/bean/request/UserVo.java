package com.example.shriodemo.bean.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.validation.constraints.Size;
import java.io.Serializable;

/*
 * @Author liuxin
 * @Description //TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo implements Serializable{

    @NonNull
    private Long uid;

    @NonNull
    private String username;


    @Size(min = 1,max = 5)
    private String password;
}

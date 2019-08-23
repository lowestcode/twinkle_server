package com.twinkle.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 用户实体类
 */
@Entity
@Data
@Table(name = "twinkle_user")
public class User implements Serializable {

    @Id
    @Column(name = "user_id")
    private String userId;

    private String userName;

    private String userPassword;

    private String userHobby;

    private String userCreateTime;

    private String userIntroduction;

    private String userRoles;
}

package com.situ.springboot.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//实体类：和数据库中表一一对应
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private Integer id;
    private String name;
    private String password;
    private Integer role;
    private String nickName;
    private String email;
    private String phone;
    private String image;
    private Integer status;
    private Integer deleted;
    private Date gmtCreate;
    private Date gmtModified;

}

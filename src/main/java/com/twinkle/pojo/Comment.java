package com.twinkle.pojo;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Comment {

    @Id
    private String _id;
    private String articleId;
    private String articleName;
    private String parentId;
    private String content;
    private String createTime;
    private String nickname;
    private String state;

}

package com.twinkle.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 文章实体类
 */
@Entity
@Data
@Table(name = "twinkle_article")
public class Article implements Serializable {

    @Id
    @Column(name = "article_id")
    private String articleId;

    private String labelId;

    private String articleTag;

    private String title;

    private String content;

    private String image;

    private String createtime;

    private String updatetime;

    private String ispublic;

    private String istop;

    private int visits;

    private int thumbup;

    private int comment;

    private String state;

    private String url;

    private String type;
}

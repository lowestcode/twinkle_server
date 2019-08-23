package com.twinkle.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 文章实体类
 */
@Entity
@Data
public class Article implements Serializable {
    @Id
    @Column(name = "article_id")
    private String articleId;

    private String articleTitle;

    private String articleIntroduction;

    private String articleAuthor;

    private String articleDetails;

    private String articleBase_id;

    private String articleComments_id;

    private String articlePraise;

    private String articleCreatetime;
}

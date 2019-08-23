package com.twinkle.pojo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/***
 * 分类实体类
 */
@Entity
@Data
@Table(name = "twinkle_label")
public class Label implements Serializable {

    @Id
    @Column(name = "label_id")
    private String labelId;

    private String labelName;
}

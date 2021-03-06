package com.twinkle.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "twinkle_img")
public class Img implements Serializable {

    @Id
    @Column(name = "name")
    private String name;

    private String url;
}

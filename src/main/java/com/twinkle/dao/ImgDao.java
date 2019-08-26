package com.twinkle.dao;

import com.twinkle.pojo.Img;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ImgDao extends JpaRepository<Img,String>, JpaSpecificationExecutor<Img> {
}

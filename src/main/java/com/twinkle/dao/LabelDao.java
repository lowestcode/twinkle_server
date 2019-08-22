package com.twinkle.dao;

import com.twinkle.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelDao extends JpaRepository<Label, String>, JpaSpecificationExecutor<Label> {

    /**
     * 根据labelName查询
     * @return
     */
    Label findByLabelName(String labelName);

    /**
     * 根据labelId查询
     * @param labelId
     * @return
     */
    Label findByLabelId(String labelId);

    /**
     * 删除分类
     * @param labelName
     */
    void deleteByLabelName(String labelName);
}

package com.twinkle.service;

import com.twinkle.dao.LabelDao;
import com.twinkle.pojo.Label;
import com.twinkle.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private HttpServletRequest httpRequest;


    /**
     * 保存分类
     *
     * @param label
     */
    public void save(Label label) {
        label.setLabelId(idWorker.nextId() + "");
        label.setLabelName(label.getLabelName().toLowerCase());
        labelDao.save(label);
    }


    /**
     * 删除分类
     *
     * @param labelName
     */
    public void delete(String labelName) {
        String admin_claims = (String) httpRequest.getAttribute("admin_claims");
        if(admin_claims.isEmpty()){
            throw new RuntimeException("权限不足");
        }
        labelDao.deleteByLabelName(labelName);
    }

    /**
     * 更新分类
     */
    public void update(Label label) {
        label.setLabelName(label.getLabelName().toLowerCase());
        labelDao.save(label);
    }

    /**
     * 根据id查询
     */
    public Label findByLabelId(String labelId) {
        return labelDao.findByLabelId(labelId);
    }

    /**
     * 根据分类名查询
     *
     * @param labelName
     * @return
     */
    public Label findByLabelName(String labelName) {
        return labelDao.findByLabelName(labelName);
    }

    public List<Label> findAll() {
        return labelDao.findAll();
    }
}

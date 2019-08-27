package com.twinkle.service;

import com.twinkle.dao.ImgDao;
import com.twinkle.pojo.Img;
import com.twinkle.util.IdWorker;
import com.twinkle.util.QiniuUpload;
import com.twinkle.util.QiniuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ImgService {

    @Autowired
    private ImgDao imgDao;

    @Autowired
    private QiniuUpload qiniuUpload;

    @Autowired
    private QiniuUtil qiniuUtil;

    @Autowired
    private IdWorker idWorker;

    /**
     * 将图片保存到七牛云,并将网址保存到本地数据库
     * @param img
     * @param file
     */
    public void saveImg(Img img, MultipartFile file) {
        String fileName = idWorker.nextId()+"";
        try {
            img.setName(fileName);
            img.setUrl(qiniuUpload.updateFile(file,fileName));
            imgDao.save(img);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除七牛云上的图片，并将本地数据库关于图片的信息删除
     * @param imageId
     */
    public void deleteImg(String imageId){
        qiniuUtil.deleteImg(imageId);
        imgDao.deleteById(imageId);
    }

    /**
     * 查询全部的图片地址
     * @param page
     * @param size
     * @return
     */
    public Page<Img> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return imgDao.findAll(pageable);
    }

    public List<Img> findImg() {
        return imgDao.findAll();
    }
}

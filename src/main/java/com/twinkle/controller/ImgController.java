package com.twinkle.controller;

import com.twinkle.pojo.Img;
import com.twinkle.result.PageResult;
import com.twinkle.result.Result;
import com.twinkle.result.StatusCode;
import com.twinkle.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
@CrossOrigin
public class ImgController {

    @Autowired
    private ImgService imgService;


    @RequestMapping(method = RequestMethod.POST)
    public Result saveImg(@RequestParam("image") MultipartFile file){
        imgService.saveImg(new Img(),file);
        return new Result(true, StatusCode.SAVESUCCESS, "保存成功");
    }

    @RequestMapping(value = "/{imageId}",method = RequestMethod.DELETE)
    public Result deleteImg(@PathVariable String imageId){
        imgService.deleteImg(imageId);
        return new Result(true, StatusCode.DELETESUCCESS, "删除成功");
    }

    @RequestMapping(value = "/findAll/{page}/{size}", method = RequestMethod.GET)
    public Result findAll(@PathVariable("page") int page, @PathVariable("size") int size){
        Page<Img> pageData = imgService.findAll(page, size);
        return new Result(true, StatusCode.OK, "查询图片列表成功", new PageResult<Img>(pageData.getTotalElements(), pageData.getContent()));
    }

    @RequestMapping(method = RequestMethod.GET)
    public Result findImg(){
        return new Result(true, StatusCode.OK, "查询成功",imgService.findImg()
        );
    }
}

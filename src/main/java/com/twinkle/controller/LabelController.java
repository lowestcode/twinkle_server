package com.twinkle.controller;

import com.twinkle.pojo.Label;
import com.twinkle.result.Result;
import com.twinkle.result.StatusCode;
import com.twinkle.service.LabelService;
import com.twinkle.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/label")
@CrossOrigin
public class LabelController {

    @Autowired
    private LabelService labelService;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 添加分类
     * @param label
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label) {
        Label byLabelName = labelService.findByLabelName(label.getLabelName().toLowerCase());
        if (byLabelName != null){
            return new Result(false, StatusCode.SAVEERROR, "分类已存在");
        }
        labelService.save(label);
        return new Result(true, StatusCode.SAVESUCCESS, "保存成功");
    }

    /**
     * 删除分类
     * @param labelName
     * @return
     */
    @RequestMapping(value = "/{labelName}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable("labelName") String labelName) {
        Label byLabelName = labelService.findByLabelName(labelName.toLowerCase());
        if (byLabelName == null){
            return new Result(false, StatusCode.SAVEERROR, "分类不存在");
        }
        labelService.delete(labelName.toLowerCase());
        return new Result(true, StatusCode.DELETESUCCESS, "删除成功");
    }

    /**
     * 更新分类
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Result update(@RequestBody Label label) {
        Label byLabelName = labelService.findByLabelName(label.getLabelName().toLowerCase());
        if (byLabelName == null){
            return new Result(false, StatusCode.SAVEERROR, "分类不存在");
        }
        labelService.update(label);
        return new Result(true, StatusCode.SAVESUCCESS, "更新成功");
    }

    /**
     * 根据labelId单个查询
     * @return
     */
//    @RequestMapping(value = "/{labelId}",method = RequestMethod.GET)
//    public Result findByLabelId(@PathVariable("labelId") String labelId) {
//        return new Result(true, StatusCode.SAVESUCCESS, "查询成功",labelService.findByLabelId(labelId));
//    }

    /**
     * 根据labelName单个查询
     * @return
     */
    @RequestMapping(value = "/{labelName}",method = RequestMethod.GET)
    public Result findByLabelName(@PathVariable("labelName") String labelName) {
        return new Result(true, StatusCode.OK, "查询成功",labelService.findByLabelName(labelName.toLowerCase()));
    }

    /**
     * 查询全部分类
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功",labelService.findAll());
    }
}

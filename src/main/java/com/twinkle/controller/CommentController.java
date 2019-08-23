package com.twinkle.controller;

import com.twinkle.pojo.Comment;
import com.twinkle.result.PageResult;
import com.twinkle.result.Result;
import com.twinkle.result.StatusCode;
import com.twinkle.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 查询全部数据
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", commentService.findAll());
    }

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findOne(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功", commentService.findById(id));
    }

    /**
     * 增加
     *
     * @param comment
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Comment comment) {
        commentService.add(comment);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    /**
     * 修改
     *
     * @param comment
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@RequestBody Comment comment, @PathVariable String id) {
        comment.set_id(id);
        commentService.update(comment);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String id) {
        commentService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /**
     * 通过文章id查找评论
     */
    @RequestMapping(value = "/{articleId}/{page}/{size}", method = RequestMethod.GET)
    public Result findyArticleId(@PathVariable String articleId, @PathVariable("page") int page, @PathVariable("size") int size) {
        Page<Comment> comments = commentService.findByArticleIdAndStateEquals(articleId, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Comment>(comments.getTotalElements(),comments.getContent()));
    }

    /**
     *  评论通过审核
     */
    @RequestMapping(value = "/{id}/{state}", method = RequestMethod.PUT)
    public Result findyArticleId(@PathVariable("id") String id,@PathVariable("state") String state,@RequestBody Comment comment) {
        commentService.updateState(id,state,comment);
        return new Result(true, StatusCode.OK, "更新成功");

    }
}

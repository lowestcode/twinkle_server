package com.twinkle.controller;

import com.twinkle.pojo.Article;
import com.twinkle.result.PageResult;
import com.twinkle.result.Result;
import com.twinkle.result.StatusCode;
import com.twinkle.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 添加文章
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result saveArticle(@RequestBody Article article) {
        articleService.saveArticle(article);
        return new Result(true, StatusCode.OK, "保存成功");
    }

    /***
     * 删除文章
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/{articleId}", method = RequestMethod.DELETE)
    public Result deleteArticle(@PathVariable("articleId") String articleId) {
        articleService.deleteArticle(articleId);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /**
     * 更新文章
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Result updateArticle(@RequestBody Article article) {
        System.out.println("article1" + article);
        articleService.updateArticle(article);
        return new Result(true, StatusCode.OK, "更新文章成功");
    }

    /**
     * 查询单个文章(通过文章名称和文章id)
     */
    @RequestMapping(value = "/searchOne", method = RequestMethod.GET)
    public Result findBySingleArticle(@RequestBody HashMap<String, String> article) {
        return new Result(true, StatusCode.OK, "查询文章成功", articleService.findBySingleArticle(article));
    }

    /**
     * 查询文章列表(查询文章列表),或者若传值为空则是全部查询
     */
    @RequestMapping(value = "/searchList/{page}/{size}", method = RequestMethod.GET)
    public Result findByArticleList(@RequestBody HashMap<String, String> article, @PathVariable("page") int page, @PathVariable("size") int size) {
        Page<Article> pageData = articleService.findByArticleList(article, page, size);
        return new Result(true, StatusCode.OK, "查询文章成功", new PageResult<Article>(pageData.getTotalElements(), pageData.getContent()));
    }

    /**
     * 更新文章状态
     */
    @RequestMapping(value = "/updateState/{articleId}/{state}", method = RequestMethod.PUT)
    public Result updateState(@PathVariable("articleId") String articleId, @PathVariable("state") int state) {
        articleService.updateState(articleId,state);
        return new Result(true, StatusCode.OK, "更新审核状态成功");
    }

    /**
     * 更新文章点赞数量
     */
    @RequestMapping(value = "/addThumbup/{articleId}/{addNum}", method = RequestMethod.PUT)
    public Result addThumbup(@PathVariable("articleId") String articleId,@PathVariable("addNum") int addNum) {
        articleService.addThumbup(articleId,addNum);
        return new Result(true, StatusCode.OK, "点赞成功");
    }

    /**
     * 更新文章评论数量
     */
//    @RequestMapping(value = "/addThumbup/{articleId}", method = RequestMethod.PUT)
//    public Result addComment(@PathVariable("articleId") String articleId) {
//        articleService.addComment(articleId);
//        return new Result(true, StatusCode.OK, "添加文章数量成功");
//    }


    /**
     * 更新文章浏览数量
     */
    @RequestMapping(value = "/addComment/{articleId}", method = RequestMethod.PUT)
    public Result addComment(@PathVariable("articleId") String articleId) {
        articleService.addVisits(articleId);
        return new Result(true, StatusCode.OK, "浏览数量添加成功");
    }
}

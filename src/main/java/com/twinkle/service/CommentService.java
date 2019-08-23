package com.twinkle.service;

import com.twinkle.dao.CommentDao;
import com.twinkle.pojo.Comment;
import com.twinkle.util.DateUtil;
import com.twinkle.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private DateUtil dateUtil;

    /**
     * 查询全部记录
     *
     * @return
     */
    public List<Comment> findAll() {
        return commentDao.findAll();
    }

    /**
     * 根据主键查询实体
     *
     * @param id
     * @return
     */
    public Comment findById(String id) {
        Comment comment = commentDao.findById(id).get();
        return comment;
    }

    /**
     * 增加
     * @param comment
     */
    public void add(Comment comment) {
        comment.set_id(idWorker.nextId() + "");
        comment.setCreateTime(dateUtil.returnDate());
        comment.setState("0");
        commentDao.save(comment);
        articleService.addComment(comment.getArticleId(), 1);
    }

    /**
     * 修改
     *
     * @param comment
     */
    public void update(Comment comment) {
        commentDao.save(comment);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(String id) {
        Comment comment = findById(id);
        System.out.println(comment.getArticleId());
        commentDao.deleteById(id);
        articleService.addComment(comment.getArticleId(), -1);
    }

    /**
     * 根据文章id查找
     *
     * @param articleId
     */
    public Page<Comment> findByArticleIdAndStateEquals(String articleId, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return commentDao.findByArticleIdAndStateEquals(articleId, "1",pageRequest);
    }

    /**
     *  评论通过审核
     *
     */
    public void updateState(String id,String state,Comment comment) {
        comment.set_id(id);
        comment.setState(state);
        commentDao.save(comment);
    }
}

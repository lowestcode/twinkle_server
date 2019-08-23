package com.twinkle.dao;

import com.twinkle.pojo.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDao extends MongoRepository<Comment,String> {
    /**
     * 根据上级ID查询吐槽列表（分页）
     * @param articleId
     * @param pageable
     * @return
     */
    public Page<Comment> findByArticleIdAndStateEquals(String articleId, String state,Pageable pageable);
}

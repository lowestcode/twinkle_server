package com.twinkle.dao;

import com.twinkle.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDao extends JpaRepository<Article, String>, JpaSpecificationExecutor<Article> {

    /**
     * 文章审核状态
     *
     * @param state
     */
    @Modifying
    @Query(value = "UPDATE twinkle_article SET state=:state WHERE article_id=:articleId", nativeQuery = true)
    public void updateState(@Param("articleId") String articleId, @Param("state") int state);

    /**
     * 点赞
     *
     * @param
     */
    @Modifying
    @Query(value = "UPDATE twinkle_article SET thumbup=thumbup+:addNum WHERE article_id= :articleId", nativeQuery = true)
    public void addThumbup(@Param("articleId") String articleId,@Param("addNum") int addNum);

    /**
     * 评论数量
     *
     * @param
     */
    @Modifying
    @Query(value = "UPDATE twinkle_article SET comment=comment+:addNum WHERE article_id= :articleId", nativeQuery = true)
    public void addComment(@Param("articleId") String articleId,@Param("addNum") int addNum);


    /**
     * 浏览数量
     *
     * @param
     */
    @Modifying
    @Query(value = "UPDATE twinkle_article SET visits=visits+1 WHERE article_id= :articleId", nativeQuery = true)
    public void addVisits(@Param("articleId") String articleId);

}

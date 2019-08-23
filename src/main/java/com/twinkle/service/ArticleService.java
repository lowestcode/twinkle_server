package com.twinkle.service;

import com.twinkle.dao.ArticleDao;
import com.twinkle.pojo.Article;
import com.twinkle.util.DateUtil;
import com.twinkle.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private DateUtil dateUtil;

    @Autowired
    private HttpServletRequest httpRequest;

    public void saveArticle(Article article) {
        article.setArticleId(idWorker.nextId() + "");
        article.setCreatetime(dateUtil.returnDate());
        article.setUpdatetime(dateUtil.returnDate());
        article.setVisits(0);
        article.setThumbup(0);
        article.setComment(0);
        article.setState("0");
        articleDao.save(article);
    }

    public void deleteArticle(String articleId) {
        String admin_claims = (String) httpRequest.getAttribute("admin_claims");
        if(admin_claims.isEmpty()){
            throw new RuntimeException("权限不足");
        }
        articleDao.deleteById(articleId);
    }

    /**
     * 更新文章
     */
    public void updateArticle(Article article) {
        article.setUpdatetime(dateUtil.returnDate());
        articleDao.save(article);
    }

    /**
     * 根据文章名称或者id查找文章
     *
     * @param article
     * @return
     */
    public List<Article> findBySingleArticle(HashMap<String, String> article) {
        try {
            return articleDao.findAll(createSpecification(article));
        }catch (Exception e){
            return null;
        }

    }

    /**
     * 通过文章分类查询文章
     *
     * @param article
     * @param page
     * @param size
     * @return
     */
    public Page<Article> findByArticleList(HashMap<String, String> article, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        if (article.get("labelId") != null && !"".equals(article.get("labelId"))) {
            Specification<Article> specification = new Specification<Article>() {
                @Override
                public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                    List<Predicate> list = new ArrayList<>();
                    list.add(criteriaBuilder.equal(root.get("labelId").as(String.class), article.get("labelId")));
                    list.add(criteriaBuilder.equal(root.get("state").as(String.class), 1));
                    Predicate[] p = new Predicate[list.size()];
                    return criteriaBuilder.and(list.toArray(p));
                }
            };
            Page<Article> pageList = articleDao.findAll(specification, pageable);
            return pageList;
        }
        Page<Article> pageList = articleDao.findAll(pageable);
        return pageList;
    }

    /**
     * 创建Specification
     *
     * @param article
     * @return
     */
    private Specification<Article> createSpecification(HashMap<String, String> article) {

        Specification<Article> specification = new Specification<Article>() {
            @Override
            public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if (!article.get("title").isEmpty()) {
                    list.add(criteriaBuilder.like(root.get("title").as(String.class), "%"+article.get("title")+"%"));
                }
                if (!article.get("articleId").isEmpty()) {
                    list.add(criteriaBuilder.equal(root.get("articleId").as(String.class), article.get("articleId")));
                }
                list.add(criteriaBuilder.equal(root.get("state").as(String.class), 1));
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        };
        return specification;
    }

    /**
     * 更新审核状态
     */
    public void updateState(String articleId,int state){
        articleDao.updateState(articleId,state);
    }

    public void addThumbup(String articleId){
        articleDao.addThumbup(articleId);

    }
}

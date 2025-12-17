package com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.services;

import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.ArticleRequest;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.dto.ArticleResponse;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Article;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.entities.Promotion;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.enums.TypeArticle;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.mapper.ArticleMapper;
import com.esprit.twin6.achrefarfaoui.tpcafe_achref_arfaoui.repositories.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ArticleService implements IArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    @Override
    public ArticleResponse addArticle(ArticleRequest article) {
        Article articleEntity = articleMapper.toentity(article);
        Article savedArticle = articleRepository.save(articleEntity);
        return articleMapper.todto(savedArticle);
    }

    @Override
    public List<ArticleResponse> saveArticles(List<ArticleRequest> articles) {
        List<Article> art = articleMapper.toentity2(articles);
        List<Article> savedArticle = articleRepository.saveAll(art);
        return articleMapper.todto2(savedArticle);
    }

    @Override
    public ArticleResponse selectArticleById(long id) {
        Article A = articleRepository.findById(id).orElseThrow();
        return articleMapper.todto(A);
    }

    @Override
    public List<ArticleResponse> selectAllArticles() {
        List<Article> arts = articleRepository.findAll();
        return articleMapper.todto2(arts);
    }

    @Override
    public void deleteArticle(ArticleRequest article) {
        Article A = articleMapper.toentity(article);
        articleRepository.delete(A);
    }

    @Override
    public void deleteAllArticles() {
        articleRepository.deleteAll();
    }

    @Override
    public void deleteArticleById(long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public long countingArticles() {
        return articleRepository.count();
    }

    @Override
    public boolean verifyArticleById(long id) {
        return articleRepository.existsById(id);
    }

    @Override
    public boolean deleteArticle(Long id) {
        if (articleRepository.existsById(id)) {
            articleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

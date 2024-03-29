package kr.co.sboard.mapper;

import kr.co.sboard.dto.ArticleDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface ArticleMapper {

    public void updateArticle(ArticleDTO articleDTO);
    public void deleteArticle(ArticleDTO articleDTO);

}

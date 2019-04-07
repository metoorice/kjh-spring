package org.kjh.article_1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * articleDao를 사용해서 글 목록, 조회, 추가, 수정, 삭제를 한다.
 * 
 * @author kjh
 */
@Service("articleService")
public class ArticleService {
	@Autowired
	ArticleDao articleDao;

	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	/**
	 * 글 목록
	 */
	public void listArticles() {
		List<Article> articles = articleDao.listArticles();
		System.out.println(articles);
	}

	/**
	 * 글 조회
	 */
	public void getArticle() {
		Article article = articleDao.getArticle("3");
		System.out.println(article);
	}

	/**
	 * 글 등록
	 */
	public void addArticle() {
		Article article = new Article();
		article.setTitle("\n" + 
				"류준열X유지태 ‘돈’, 300만 돌파…장기 흥행 잇는다");
		article.setContent(
				"‘돈’은 부자가 되고 싶었던 신입 주식 브로커 일현(류준열 분)이 베일에 싸인 작전 설계자 번호표(유지태 분)를 만나게 된 후 엄 청난 거액을 건 작전에 휘말리게 되면서 벌어지는 이야기다.");
		article.setUserId("1");
		article.setName("김재훈");
		if (articleDao.addArticle(article) > 0)
			System.out.println("글을 추가했습니다.");
		else
			System.out.println("글을 추가하지 못했습니다.");
	}

	/**
	 * 글 수정
	 */
	public void updateArticle() {
		Article article = new Article();
		article.setArticleId("7");
		article.setTitle("This is modified title.");
		article.setContent("This is modified content");
		if (articleDao.updateArticle(article) > 0)
			System.out.println("글을 수정했습니다.");
		else
			System.out.println("글을 수정하지 못했습니다.");
	}

	/**
	 * 글 삭제
	 */
	public void deleteArticle() {
		if (articleDao.deleteArticle("8") > 0)
			System.out.println("글을 삭제했습니다.");
		else
			System.out.println("글을 삭제하지 못했습니다.");
	}
}
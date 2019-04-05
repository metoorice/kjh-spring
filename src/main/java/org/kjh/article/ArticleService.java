package org.kjh.article;

import java.util.List;

/**
 * articleDao를 사용해서 글 목록, 조회, 추가, 수정, 삭제를 한다.
 * 
 * @author Jacob
 */
public class ArticleService {

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
		article.setTitle("화마에 '불바다'된 한반도…하룻밤 새 여의도 1.2배 잿더미)");
		article.setContent(
				"강원도 고성을 비롯해 전국 곳곳에서 산불이 동시다발적으로 발생, 막대한 피해를 남겼다.하룻밤 사이 전국 18곳에서 불이 났고 피해 추정 면적만 365ha에 이른다.1명이 숨지고 수십명이 다치는 등 인명피해도 발생했다.고성을 비롯해 곳곳에서 주민 수천 명이 화마를 피해 대피하는 소동이 벌어졌다.");
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
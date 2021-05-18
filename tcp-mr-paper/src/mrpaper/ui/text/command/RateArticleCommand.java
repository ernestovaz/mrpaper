package mrpaper.ui.text.command;

import java.util.List;

import mrpaper.business.ArticleService;
import mrpaper.business.domain.Article;
import mrpaper.business.domain.Review;
import mrpaper.exceptions.IllegalNumberException;
import mrpaper.exceptions.NoArticleException;
import mrpaper.exceptions.NoReviewerException;
import mrpaper.ui.text.MrPaperTextInterface;
import mrpaper.ui.text.UIUtils;

public class RateArticleCommand extends MrPaperCommand {

    ArticleService articleService;
    public RateArticleCommand(MrPaperTextInterface mrPaperInterface,
            ArticleService articleService) {
        super(mrPaperInterface);
        this.articleService = articleService;
    }

    @Override
    public void execute() throws Exception {
        List<Article> allArticles = articleService.getArticles();
        System.out.println("Artigos disponiveis:");
        for(Article article: allArticles)
            System.out.printf("%d:%s\n", article.getId(),article.getName());
        
        //pedir artigo
        int articleId = UIUtils.INSTANCE.readInteger("Escolha um Artigo") - 1;
        if(articleId > allArticles.size())
        	throw new NoArticleException("Nao ha artigo com este id");
        List<Article> articles = articleService.getArticles();
        Article article = articles.get(articleId);
        List<Review> reviews = article.getReviews();
        
        if(reviews.isEmpty()) 
        {
        	throw new NoReviewerException("Nao ha revisores para este artigo");
        }
        
        
        System.out.println("\nLista de Revisores\n");
		for (Review review : reviews) {
			System.out.printf("%d:Nome Revisor: %s\n",
					review.getReviewer().getId(),review.getReviewer().getName());
		}
		
		int reviewerId = UIUtils.INSTANCE.readInteger("Escolha um Revisor");
		Review chosenReview = null;
		for (Review review : reviews) {
			if (review.getReviewer().getId() == reviewerId)
					chosenReview = review;
		}
		
		int rating =  UIUtils.INSTANCE.readInteger("Escolha uma nota entre -3 e 3");
		
			if (rating > 3 || rating < -3)
			{
				throw new IllegalNumberException("Deve ser um numero entre -3 e 3"); 
			}
		
		articleService.setRating(chosenReview, rating);
    }

}
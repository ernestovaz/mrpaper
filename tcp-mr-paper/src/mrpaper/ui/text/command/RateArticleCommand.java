package mrpaper.ui.text.command;

import java.util.List;

import mrpaper.business.ArticleService;
import mrpaper.business.domain.Article;
import mrpaper.business.domain.Review;
import mrpaper.business.domain.Researcher;
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
        System.out.println("Artigos disponíveis:");
        for(Article article: allArticles)
            System.out.printf("%d:%s\n", article.getId(),article.getName());
        
        //pedir artigo
        int articleId = UIUtils.INSTANCE.readInteger("Escolha um Artigo:") - 1;
        List<Article> articles = articleService.getArticles();
        Article article = articles.get(articleId);
        List<Review> reviews = article.getReviews();
        
        System.out.println("\nLista de Revisores\n");
		for (Review review : reviews) {
			System.out.printf("%d:Nome Revisor: %s\n",
					review.getReviewer().getId(),review.getReviewer().getName());
		}
		
		int reviewerId = UIUtils.INSTANCE.readInteger("Escolha um Revisor:");
		Review chosenReview = null;
		for (Review review : reviews) {
			if (review.getReviewer().getId() == reviewerId)
					chosenReview = review;
		}
		
		int rating =  UIUtils.INSTANCE.readInteger("Escolha uma nota entre -3 e 3:");
		articleService.setRating(chosenReview, rating);
    }

}
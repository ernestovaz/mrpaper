package mrpaper;

import mrpaper.business.ArticleService;
import mrpaper.business.ConferenceService;
import mrpaper.business.impl.ArticleServiceImpl;
import mrpaper.business.impl.ConferenceServiceImpl;
import mrpaper.data.Database;
import mrpaper.ui.MrPaperInterface;

public abstract class MrPaper {
	
	protected final MrPaperInterface mrPaperInterface;
	
	public static void main(String[] args) throws Exception {
		MrPaper mrpaper = null;
		mrpaper = new MrPaperText();
		
		mrpaper.showUI();
	}
	
	
	public MrPaper() {
		Database database = new Database(true);
		
		ConferenceService conferenceService = new ConferenceServiceImpl(database);
		ArticleService articleService = new ArticleServiceImpl(database);
		
		this.mrPaperInterface = createMrPaperInterface(conferenceService, articleService);
		
	}
	
	public abstract MrPaperInterface createMrPaperInterface(
			ConferenceService conferenceService,
			ArticleService articleService
			);
	
	
	public abstract void showUI();

}

package mrpaper.ui.text.command;


import java.util.List;

import mrpaper.business.ConferenceService;
import mrpaper.business.domain.Article;
import mrpaper.ui.text.MrPaperTextInterface;
import mrpaper.ui.text.UIUtils;

public class ArticleReportCommand extends MrPaperCommand{

	private final ConferenceService conferenceService;
	
	public ArticleReportCommand(MrPaperTextInterface bankInterface, ConferenceService conferenceService) {
		super(bankInterface);
		this.conferenceService = conferenceService;
	}

	@Override
	public void execute() throws Exception {
		
		System.out.println("Conferencias disponíveis :");
		int i;
		for(i = 0; i < conferenceService.getConferences().size();i++)
			System.out.println(conferenceService.getConferences().get(i).getInitials());
		
		String conference = UIUtils.INSTANCE.readString("Escolha uma conferencia(Sigla)");
		
		List<Article> acceptedArticles = this.conferenceService.articleAcceptedReport(conference);
		List<Article> rejectedArticles = this.conferenceService.articleRejectedReport(conference);
		
		if(acceptedArticles == null || rejectedArticles == null)
			System.out.println("Conferência ainda não foi alocada completamente.");
		else {
			System.out.println("Artigos Aceitos :");
			for(i = 0; i < acceptedArticles.size();i ++) {
				System.out.println("Artigo - " +
					acceptedArticles.get(i).getName() 
					+ "  ID - " +
					acceptedArticles.get(i).getId() +
					" e média " +
					acceptedArticles.get(i).AverageGrade()
					);
			}
			System.out.println("Artigos Rejeitados :");
			for(i = 0; i < rejectedArticles.size();i ++) {
				System.out.println("Artigo - " +
					rejectedArticles.get(i).getName() 
					+ "  ID - " +
					rejectedArticles.get(i).getId() +
					" e média " +
					rejectedArticles.get(i).AverageGrade()
					);
			}
		}		
	}

}

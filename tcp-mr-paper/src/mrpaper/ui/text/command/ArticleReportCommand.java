package mrpaper.ui.text.command;

import mrpaper.business.ConferenceService;
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
		
		// TODO COISINHA QUE NAO DEIXA ELE COISAR SE ELE N ESTIVER COISADO		
		
		
		System.out.println("Artigos Aceitos :");
		for(i = 0; i < this.conferenceService.articleAcceptedReport(conference).size();i ++) {
			System.out.println("Artigo - " +
				this.conferenceService.articleAcceptedReport(conference).get(i).getName() 
				+ "  ID - " +
				this.conferenceService.articleAcceptedReport(conference).get(i).getId() +
				" e média " +
				this.conferenceService.articleAcceptedReport(conference).get(i).AverageGrade()
				);
		}
		
		System.out.println("Artigos Rejeitados :");
		for(i = 0; i < this.conferenceService.articleRejectedReport(conference).size();i ++) {
			System.out.println("Artigo - " +
				this.conferenceService.articleRejectedReport(conference).get(i).getName() 
				+ "  ID - " +
				this.conferenceService.articleRejectedReport(conference).get(i).getId() +
				" e média " +
				this.conferenceService.articleRejectedReport(conference).get(i).AverageGrade()
				);
		}
		
		
		
	}

}

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
		
		System.out.println("Conferencias disponíveis :\n");
		int i;
		for(i = 0; i < conferenceService.getConferences().size();i++)
			System.out.println(conferenceService.getConferences().get(i).getInitials());
		
		String conference = UIUtils.INSTANCE.readString("Escolha uma conferencia(Sigla)");
		
		System.out.println("Artigos Aceitos");
		System.out.println(this.conferenceService.articleAcceptedReport(conference));
		
		System.out.println("Artigos Rejeitados");
		System.out.println(this.conferenceService.articleRejectedReport(conference));
		
		
	}

}

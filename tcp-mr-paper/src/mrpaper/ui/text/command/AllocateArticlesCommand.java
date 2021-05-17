package mrpaper.ui.text.command;

import mrpaper.business.ConferenceService;
import mrpaper.ui.text.MrPaperTextInterface;
import mrpaper.ui.text.UIUtils;

public class AllocateArticlesCommand extends MrPaperCommand{

	private final ConferenceService conferenceService;

	public AllocateArticlesCommand(MrPaperTextInterface bankInterface,
			ConferenceService conferenceService) {
		super(bankInterface);
		this.conferenceService = conferenceService;
	}

	@Override
	public void execute() throws Exception {
		String conference = UIUtils.INSTANCE.readString("Conferência(sigla)");
		int quantity = UIUtils.INSTANCE.readInteger("Revisors por artigo");
		conferenceService.allocateConference(conference, quantity);
	}

}

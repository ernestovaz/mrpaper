package mrpaper.ui.text.command;

import java.util.List;

import mrpaper.business.ConferenceService;
import mrpaper.business.domain.Review;
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
		System.out.println("\nIniciando alocação.\n");
		List<Review> newReviews = conferenceService.allocateConference(conference, quantity);
		for (Review review : newReviews) {
			System.out.printf("Artigo id %d alocado ao revisor id %d.\n",
					review.getArticle().getId(),review.getReviewer().getId());
		}
		System.out.println("Fim da alocação.");
	}

}

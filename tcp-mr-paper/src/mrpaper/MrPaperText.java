package mrpaper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import mrpaper.business.ArticleService;
import mrpaper.business.ConferenceService;
import mrpaper.ui.MrPaperInterface;
import mrpaper.ui.text.MrPaperTextInterface;
import mrpaper.ui.text.UIUtils;

public class MrPaperText extends MrPaper {

	protected final BufferedReader reader;

	public MrPaperText() {
		this.reader = new BufferedReader(new InputStreamReader(System.in));

	}
	
	private String getMenu() {
		StringBuffer sb = new StringBuffer();
		return sb.toString();
	}
	
	public void showUI() {
		UIUtils uiUtils = UIUtils.INSTANCE;
		String option;
		do {
			System.out.println(getMenu());
			option = uiUtils.readString(null);
			this.mrPaperInterface.createAndShowUI();
		} while(option != "0");
	}

	@Override
	public MrPaperInterface createMrPaperInterface(ConferenceService conferenceService, ArticleService articleService) {
		return new MrPaperTextInterface(conferenceService, articleService);
	}
}

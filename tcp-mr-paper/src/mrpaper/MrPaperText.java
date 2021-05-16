package mrpaper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import mrpaper.business.ArticleService;
import mrpaper.business.ConferenceService;
import mrpaper.ui.MrPaperInterface;
import mrpaper.ui.text.MrPaperTextInterface;
import mrpaper.ui.text.UIUtils;
import mrpaper.ui.text.command.AllocateArticlesCommand;
import mrpaper.ui.text.command.ArticleReportCommand;
import mrpaper.ui.text.command.MrPaperCommand;
import mrpaper.ui.text.command.RateArticleCommand;

public class MrPaperText extends MrPaper {

	protected final BufferedReader reader;
	protected static final Map<Integer,MrPaperCommand> mapa = new HashMap<Integer,MrPaperCommand>();
	
	public MrPaperText() {
		this.reader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	private String getMenu() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Escolha operação:"
				+ "\n[0]Sair"
				+ "\n[1]Alocar Artigos"
				+ "\n[2]Avaliar Artigos"
				+ "\n[3]Exibir Artigos\n"
				);
		
		return sb.toString();
	}
	
	public void showUI() {
		UIUtils uiUtils = UIUtils.INSTANCE;
		Integer option;
		do {
			System.out.println(getMenu());
			option = uiUtils.readInteger(null);			
		} while(option != 0);
	}

	@Override
	public MrPaperInterface createMrPaperInterface(ConferenceService conferenceService, ArticleService articleService) {
		return new MrPaperTextInterface(conferenceService, articleService);
	}

	
}

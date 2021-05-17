package mrpaper.ui.text;

import mrpaper.business.ArticleService;
import mrpaper.business.ConferenceService;
import mrpaper.ui.MrPaperInterface;
import mrpaper.ui.UIAction;
import mrpaper.ui.text.command.*;

public class MrPaperTextInterface extends MrPaperInterface {
	
	public static final String EXIT_CODE = "0";
	
	public MrPaperTextInterface(ConferenceService conferenceService,
			ArticleService articleService) {
		this.addAction("1", new AllocateArticlesCommand(this, conferenceService));
		this.addAction("2", new RateArticleCommand(this));
		this.addAction("3", new ArticleReportCommand(this));
	}

	@Override
	public void createAndShowUI() {
		UIUtils uiUtils = UIUtils.INSTANCE;
		String commandKey = null;
		do {
			System.out.println();
			System.out.print(getMenu(uiUtils.getTextManager()));
			commandKey = uiUtils.readString(null);
			MrPaperCommand command = (MrPaperCommand) actions.get(commandKey);
			if (command != null) {
				try {
					command.execute();
				} catch (Exception e) {
					uiUtils.handleUnexceptedError(e);
				}
			}
		} while (!EXIT_CODE.equals(commandKey));
	}
	
	
	protected String getMenu(TextManager textManager) {
		StringBuffer sb = new StringBuffer();
		sb.append("Escolha operação:"
				+ "\n[1]Alocar Artigos"
				+ "\n[2]Avaliar Artigos"
				+ "\n[3]Exibir Artigos"
				+ "\n[0]Sair\n>"
				);	
		return sb.toString();
	}

}

package mrpaper.ui.text;

import mrpaper.business.ArticleService;
import mrpaper.business.ConferenceService;
import mrpaper.ui.MrPaperInterface;
import mrpaper.ui.UIAction;
import mrpaper.ui.text.command.MrPaperCommand;

public class MrPaperTextInterface extends MrPaperInterface {
	
	public static final String EXIT_CODE = "E";
	
	public MrPaperTextInterface(ConferenceService conferenceService,
			ArticleService articleService) {
		//this.addAction("C", new TesteCommand(this));
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
		sb.append(textManager.getText("message.options", EXIT_CODE, false))
				.append(":\n");
		for (String key : actions.keySet()) {
			UIAction action = actions.get(key);
			if (action.isEnabled()) {
				sb.append(key)
						.append(" - ")
						.append(textManager.getText(action.getClass()
								.getSimpleName())).append("\n");
			}
		}
		sb.append(textManager.getText("message.choose.option")).append(": ");

		return sb.toString();
	}

}

package mrpaper.ui.text.command;

import mrpaper.ui.UIAction;
import mrpaper.ui.text.MrPaperTextInterface;
import mrpaper.ui.text.TextManager;
import mrpaper.ui.text.UIUtils;

public abstract class Command implements UIAction {
	
	protected final MrPaperTextInterface mrPaperInterface;
	private boolean isEnabled;

	protected Command(MrPaperTextInterface bankInterface) {
		this(bankInterface, false);
	}

	protected Command(MrPaperTextInterface mrPaperInterface, boolean isEnabled) {
		this.mrPaperInterface = mrPaperInterface;
		this.isEnabled = isEnabled;
	}

	protected TextManager getTextManager() {
		return UIUtils.INSTANCE.getTextManager();
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
}

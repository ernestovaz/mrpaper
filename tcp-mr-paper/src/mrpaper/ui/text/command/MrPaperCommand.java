package mrpaper.ui.text.command;

import mrpaper.ui.UIAction;
import mrpaper.ui.text.MrPaperTextInterface;
import mrpaper.ui.text.TextManager;
import mrpaper.ui.text.UIUtils;

public abstract class MrPaperCommand implements UIAction {
	
	protected final MrPaperTextInterface mrPaperInterface;
	private boolean isEnabled;

	protected MrPaperCommand(MrPaperTextInterface mrPaperInterface) {
		this(mrPaperInterface, false);
	}

	protected MrPaperCommand(MrPaperTextInterface mrPaperInterface, boolean isEnabled) {
		this.mrPaperInterface = mrPaperInterface;
		this.isEnabled = isEnabled;
	}


	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
}

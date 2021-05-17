package mrpaper.ui;

import java.util.LinkedHashMap;
import java.util.Map;


public abstract class MrPaperInterface {
	
	protected final Map<String, UIAction> actions;
	
	protected MrPaperInterface() {
		this.actions = new LinkedHashMap<>();
	}
	
	protected void addAction(String code, UIAction action) {
		this.actions.put(code, action);
	}
	
	public abstract void createAndShowUI();

	protected void toggleActions() {
		for (UIAction action : actions.values()) {
			action.setEnabled(!action.isEnabled());
		}
	}

}

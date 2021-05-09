package mrpaper.ui;

public interface UIAction {
	
	public abstract void execute() throws Exception;

	public boolean isEnabled();

	public void setEnabled(boolean isEnabled);

}

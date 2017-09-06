package munk;

import java.util.HashMap;

/**
 * A window for displaying/changing/accessing program settings
 * 
 * @author CannedCans
 *
 */
public class SettingsWindow extends AbstractSimpleWindow {
	
	/** HashMap mapping a String of settingName to String settingValue */
	private HashMap<String, String> settingsValueHashmap = new HashMap<String, String>();
	
	public SettingsWindow() {
		super("Settings");
	}
	
	/**
	 * Resets the settings to the default settings for MUNk
	 */
	private void resetToDefault() {
		
	}
	
	/**
	 * Returns the setting's value as a String, null otherwise
	 * 
	 * @param setting the setting to access
	 * @return setting's value if available, null otherwise
	 */
	private String getSettingValue(String setting) {
		if (settingsValueHashmap.containsKey(setting)) {
			return settingsValueHashmap.get(setting);
		} else {
			return null;
		}
	}
	
	/**
	 * Set's the setting's value to value
	 * 
	 * @param setting
	 * @param value
	 */
	private void setSettingValue(String setting, String value) {
		
	}

}

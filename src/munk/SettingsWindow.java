package munk;

import java.io.File;
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
		resetToDefault();
		loadSettings();
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
	
	/**
	 * Loads settings from the default settings file, creating it if
	 * it does not exist.
	 */
	private void loadSettings() {
		File settingsFile = new File("config.conf");
		
		if (settingsFile.isFile()) {
			readSettingsFromFile(settingsFile);
		} else if (settingsFile.isDirectory()) {
			//Rely on default settings, do nothing to avoid messing up the system
			MainWindow.createInformationPopup("Settings Unable to Load", "The settings file location config.conf is detected as a directory and was unable to load. Please rename the directory to have a configuratio file generated.");
		} else { //Nothing is at the path
			saveSettingsToFile(settingsFile);
			MainWindow.createInformationPopup("Settings File Created", "A configuration file was created with the default MUNk settings in settings.conf");
		}
	}
	
	/**
	 * Loads settings from the File specified
	 * 
	 * @param file
	 */
	private void readSettingsFromFile(File file) {
		
	}
	
	/**
	 * Saves the settings to the File specified
	 * 
	 * @param file
	 */
	private void saveSettingsToFile(File file) {
		
	}

}

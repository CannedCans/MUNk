package munk;

import java.io.File;
import java.util.HashMap;
import java.util.Properties;

/**
 * A window for displaying/changing/accessing program settings (properties)
 * 
 * @author CannedCans
 *
 */
public class SettingsWindow extends AbstractSimpleWindow {
	
	/** HashMap mapping a String of settingName to String settingValue */
	private Properties propertiesList = new Properties();
	
	public SettingsWindow() {
		super("Settings");
		loadProperties();
	}
	
	/**
	 * Resets the settings to the default settings for MUNk
	 */
	private void resetToDefault() {
		
	}
	
	/**
	 * Returns the property's value as a String, null otherwise
	 * 
	 * @param property the property to access
	 * @return property's value if available, null otherwise
	 */
	private String getPropertyValue(String property) {
		if (propertiesList.containsKey(property)) {
			return propertiesList.getProperty(property);
		} else {
			return null;
		}
	}
	
	/**
	 * Set's the property's value to value
	 * 
	 * @param property
	 * @param value
	 */
	private void setPropertyValue(String property, String value) {
		
	}
	
	/**
	 * Loads settings/properties from the default settings file, creating it if
	 * it does not exist.
	 */
	private void loadProperties() {
		File settingsFile = new File("properties.xml");
		
		if (settingsFile.isFile()) {
			propertiesList = readPropertiesFromFile(settingsFile);
			//TODO: Validate any missing settings (from previous versions), loading from defaults if not in the file
		} else if (settingsFile.isDirectory()) {
			//Rely on default settings, do nothing to avoid messing up the system
			MainWindow.createInformationPopup("Settings Unable to Load", "The settings file location properties.xml is detected as a directory and was unable to load. Please rename the directory to have a configuratio file generated.");
		} else { //Nothing is at the path
			resetToDefault();
			savePropertiesToFile(settingsFile, propertiesList);
			MainWindow.createInformationPopup("Settings File Created", "A configuration file was created with the default MUNk settings in settings.conf");
		}
	}
	
	/**
	 * Loads properties from the File specified
	 * 
	 * @param file
	 * @return properties object with the properties in File
	 */
	private Properties readPropertiesFromFile(File file) {
		return null;
	}
	
	/**
	 * Saves the properties to the File specified
	 * 
	 * @param file
	 * @param properties properties to be saved
	 */
	private void savePropertiesToFile(File file, Properties properties) {
		
	}

}

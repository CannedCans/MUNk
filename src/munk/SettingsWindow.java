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
	
	/** Properties Object mapping a String of settingName to String settingValue */
	private Properties propertiesList;
	
	/** Default Properties for MUNk */
	private Properties defaultPropertiesList;
	
	public SettingsWindow() {
		super("Settings");
		
		defaultPropertiesList = generateDefaultProperties();
		propertiesList = defaultPropertiesList;
		
		loadProperties();
		generateGUI();
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
			MainWindow.createInformationPopup("Settings Unable to Load", "The settings file location properties.xml is detected as a directory and was unable to load. Please rename the directory to have a configuration file generated.");
		} else { //Nothing is at the path
			savePropertiesToFile(settingsFile, propertiesList);
			MainWindow.createInformationPopup("Settings File Created", "A configuration file was created with the default MUNk settings in properties.xml");
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
	
	/**
	 * Generates a default Properties object for the version and returns it
	 * 
	 * @return default Properties object
	 */
	private Properties generateDefaultProperties() {
		return new Properties();
	}
	
	/**
	 * Generate GUI components specific to this inheriting object
	 */
	private void generateGUI() {
		
	}

}

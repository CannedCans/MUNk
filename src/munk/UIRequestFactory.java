package munk;

public class UIRequestFactory {

	public static Committee makeNewCommittee() {
		return new Committee(MainWindow.requestInfoPopup("Committee Name", "Please provide a name for your Committee"));
	}
	
	public static String newCommitteeName() {
		return MainWindow.requestInfoPopup("Committee Name Update", "Please provide the new name for your Committee");
	}
}

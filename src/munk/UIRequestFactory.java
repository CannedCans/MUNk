package munk;

public class UIRequestFactory {

	public static Committee makeNewCommittee() {
		return new Committee(MainWindow.requestSimpleInfoPopup("Committee Name", "Please provide a name for your Committee"));
	}
	
	public static String newCommitteeName() {
		return MainWindow.requestSimpleInfoPopup("Committee Name Update", "Please provide the new name for your Committee");
	}
}

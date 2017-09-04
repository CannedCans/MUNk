package munk;

import java.util.ArrayList;

public class Delegate {

	/** The country/character the delegate is representing/playing. */
	private String role;

	/**
	 * Shorter version of a name/role in case a name is difficult to type
	 * Defaults to the same as the full name
	 *
	 */
	private String shortRole;

	/** The real name of the Delegate. */
	private String delegateName;

	/** The school that the Delegate attends. */
	private String delegateSchool;
	
	/** Notes about the Delegate (either IC or OOC) */
	private String notes;

	public Delegate(String role) {
		this.role = role;
		shortRole = role;
		notes = "";
	}

  public String getShortRole() {
    return shortRole;
  }
  
  public void setShortRole(String shortRole) {
	  this.shortRole = shortRole;
  }

  public String getRole() {
	return role;
  }

  public void setRole(String role) {
	this.role = role;
  }

  public String getDelegateName() {
	return delegateName;
  }

  public void setDelegateName(String delegateName) {
	this.delegateName = delegateName;
  }

  public String getDelegateSchool() {
	return delegateSchool;
  }

  public void setDelegateSchool(String delegateSchool) {
	this.delegateSchool = delegateSchool;
  }
  
  public String getNotes() {
	  return notes;
  }
  
  public void setNotes(String notes) {
	  this.notes = notes;
  }

}

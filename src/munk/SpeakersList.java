package munk;

import java.util.ArrayList;

public class SpeakersList<T> extends ArrayList<T> {
	
	public SpeakersList() {
		super();
	}
	
	/**
	 * Decreases the index of the item at index by 1, shifting around other objects
	 * Only does this if possible.
	 * 
	 * @param index
	 */
	public void shiftUp(int index) {
		shift(index, -1);
	}
	
	/**
	 * Increases the index of the item at index by 1, shifting around other objects
	 * Only does this if possible.
	 * 
	 * @param index
	 */
	public void shiftDown(int index) {
		shift(index, 1);
	}
	
	/**
	 * Increases/decreases the index of the item at index by amount, shifting around other objects.
	 * Only does this if possible.
	 * 
	 * @param index
	 * @param amount
	 */
	private void shift(int index, int amount) {
		if (index >= 0 && index < this.size()) { //Valid index
			if (!((index == 0 && amount < 1) || (index == (this.size() - 1) && amount > -1))) { //Valid movement
				T a = this.get(index);
				T b = this.get(index + amount);
				
				this.set(index, b);
				this.set(index + amount, a);
			}
		}
	}
	
	/**
	 * Removes the first item on the list.
	 * 
	 * @return
	 */
	public T remove() {
		return this.remove(0);
	}
	
	/**
	 * Gets the first item on the list.
	 * 
	 * @return
	 */
	public T get() {
		return this.get(0);
	}
	
	
}

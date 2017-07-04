package me.snikit.eatfull.domain;

import java.util.Arrays;

public class InputData {

	// used generic terms so that if needed can be used elsewhere

	// in case of gordon
	private int constraint; // will be timelimit
	private int itemCount;// will be menu item count
	private int[] objects;// will be menu items
	private int[] values;// will be satisfaction value of menu item

	public InputData() {

	}

	public InputData(int constraint, int itemCount, int[] objects, int[] values) {
		super();
		this.constraint = constraint;
		this.itemCount = itemCount;
		this.objects = objects;
		this.values = values;
	}

	public int getConstraint() {
		return constraint;
	}

	public void setConstraint(int constraint) {
		this.constraint = constraint;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public int[] getObjects() {
		return objects;
	}

	public void setObjects(int[] objects) {
		this.objects = objects;
	}

	public int[] getValues() {
		return values;
	}

	public void setValues(int[] values) {
		this.values = values;
	}

	@Override
	public String toString() {
		return "InputData [constraint=" + constraint + ", itemCount=" + itemCount + ", objects="
				+ Arrays.toString(objects) + ", values=" + Arrays.toString(values) + "]";
	}

}

package model;

public class Element {
	private int xLocation;
	private int yLocation;

	public Element() {
		super();
	}

	public Element(int xLocation, int yLocation) {
		super();
		this.xLocation = xLocation;
		this.yLocation = yLocation;
	}

	public int getxLocation() {
		return xLocation;
	}

	public void setxLocation(int xLocation) {
		this.xLocation = xLocation;
	}

	public int getyLocation() {
		return yLocation;
	}

	public void setyLocation(int yLocation) {
		this.yLocation = yLocation;
	}

}

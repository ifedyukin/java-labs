package ru.rsreu.fedyukin0515;

public class Exemption {
	private double percent;
	private String description;
	
	public Exemption(double percent) {
		this.percent = percent;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public double getPercent() {
		return this.percent;
	}

}

package main;

import java.awt.Color;

public enum STATUS {
	//@@@@  “An enum with custom data elements.”
	Healthy(Color.black),
	Effected(Color.green),
	Purified(Color.cyan);
	
	private Color color;
	STATUS(Color c){
		this.color = c;
	}
	public Color getColor(){
		return color;
	}
}

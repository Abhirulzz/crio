package com.codedecode.builder;


public class MainClass {
	public static void main(String[] args) {
		
	/*	//create object of required homebuilder
		EarthQuakeResistantBuilder earthQuakeResistantBuilder = new EarthQuakeResistantBuilder();
		
		//create object of director that will keep an eye on your builder
		Director director = new Director(earthQuakeResistantBuilder);
		
		Home homeConstructedAtTheEnd  =director.manageRequiredHomeConstruction();
		//Home homeConstructedAtTheEnd = director.getComplexObjectOfHome();  */
		
		Home homeConstructed  = new HometypeFactory().getType("snow");
		
		//System.out.println(homeConstructedAtTheEnd);
		System.out.println(homeConstructed.floor);
	}

}

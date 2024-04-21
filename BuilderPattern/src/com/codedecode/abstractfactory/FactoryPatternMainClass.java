package com.codedecode.abstractfactory;

import com.codedecode.factory.ProfessionFactory;

public class FactoryPatternMainClass {
	
	public static void main(String[] args) {
		//AbstractFactoryProducer abstractfactory = new AbstractFactoryProducer();
		
		Profession doc = ProfessionTypeAbstractFactory.getType(true).getProfession("Teacher");
		doc.print();
		
	}

}

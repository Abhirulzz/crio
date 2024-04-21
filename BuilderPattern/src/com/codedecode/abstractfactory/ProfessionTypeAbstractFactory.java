package com.codedecode.abstractfactory;

// this is factory of factory , gives u factory instance which wil in turn give u required class object
public class ProfessionTypeAbstractFactory {
	
	public static IProfessionFactory getType(boolean isTrainee) {
		if(isTrainee) {
			return new TraineeProfessionAbstractFactory();
		}
		else {
			return new ProfessionFactory();
		}
	}
	      
}

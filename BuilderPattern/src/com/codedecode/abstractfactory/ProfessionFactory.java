package com.codedecode.abstractfactory;

public class ProfessionFactory extends IProfessionFactory{
	
	@Override
	public Profession getProfession(String typeOfProfession){
	      
		  if(typeOfProfession == null){
	         return null;
	      }		
	         
		  else if(typeOfProfession.equalsIgnoreCase("Engineer")){
	         return new Engineer();
	         
	      } else if(typeOfProfession.equalsIgnoreCase("Teacher")){
	         return new Teacher();
	      }
	      
	      return null;
	   }

}

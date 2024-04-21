package com.codedecode.builder;

import com.codedecode.factory.Doctor;
import com.codedecode.factory.Engineer;
import com.codedecode.factory.Profession;
import com.codedecode.factory.Teacher;

public class HometypeFactory {
	
	public Home getType(String type){
	      if(type == null){
	         return null;
	      }		
	      if(type.equalsIgnoreCase("earthquake")){
	         return new Director(new EarthQuakeResistantBuilder()).manageRequiredHomeConstruction();
	         
	      } else if(type.equalsIgnoreCase("flood")){
	    	  return new Director(new FloodResistantBuilder()).manageRequiredHomeConstruction();
	         
	      } else if(type.equalsIgnoreCase("snow")){
	    	  return new Director(new SnowResistantBuilder()).manageRequiredHomeConstruction();
	      }
	      
	      return null;
	   }

}

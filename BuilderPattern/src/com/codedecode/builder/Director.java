package com.codedecode.builder;

class Director {
	
	private Builder builder;
	
	public Director(Builder builderType) {
		this.builder = builderType;
	}
	
	/*public Home getComplexObjectOfHome() 
    { 
        return this.builder.getComplexHomeObject(); 
    }  */
	
	public Home manageRequiredHomeConstruction() 
    { 
        this.builder.buildFloor(); 
        this.builder.buildWalls(); 
        this.builder.bulidTerrace(); 
        return this.builder.getComplexHomeObject(); 
    } 
    
	
	
}

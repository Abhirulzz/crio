package com.dailycode.decorator;
public class BasePizza extends Pizza{
    @Override
    public String bake() {
        return "Base Pizza";
    }
    
    public int price() {
    	return 10;
    }
}

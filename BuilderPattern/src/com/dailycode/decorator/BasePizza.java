package com.dailycode.decorator;
public class BasePizza implements Pizza{
    @Override
    public String bake() {
        return "Base Pizza";
    }
    
    public int price() {
    	return 10;
    }
}

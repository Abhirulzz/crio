package com.example.builder;
public abstract class MealBuilder {
    public abstract void addBriyani(String food);
    public  abstract  void  addBread();
    public abstract void  addColdDrink();
    public abstract void addCurry();
    public abstract Meal build();
}

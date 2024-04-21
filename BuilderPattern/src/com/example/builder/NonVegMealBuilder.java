package com.example.builder;
public class NonVegMealBuilder extends MealBuilder{
    private Meal meal;
    public NonVegMealBuilder() {
        meal = new Meal();
    }
    @Override
    public void addBriyani(String food) {
        this.meal.setBriyani(food);
    }

    @Override
    public void addBread() {
        this.meal.setBread("Roti");

    }

    @Override
    public void addColdDrink() {
        this.meal.setColdDrink("Sprite");

    }

    @Override
    public void addCurry() {
        this.meal.setCurry("Non-Veg");
    }

    @Override
    public Meal build() {
        return meal;
    }
}

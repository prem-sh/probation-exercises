package io.github.prem_sh.streams;

public class Dish {
    private String name;
    private int calories;
    private Type type;

    public Dish(String name, int calories, Type type) {
        this.name = name;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type {VEG, NON_VEG};
}

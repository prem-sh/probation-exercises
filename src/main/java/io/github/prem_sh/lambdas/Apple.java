package io.github.prem_sh.lambdas;


public class Apple {
    public String verity;
    public Integer weight;
    public AppleColour colour;

    public Apple(String verity, int weight, AppleColour colour) {
        this.verity = verity;
        this.weight = weight;
        this.colour = colour;
    }
    @Override
    public String toString(){
        return "("+verity+" : "+weight+"g : "+colour+")";
    }

    public String getVerity() {
        return verity;
    }

    public Integer getWeight() {
        return weight;
    }

    public AppleColour getColour() {
        return colour;
    }
}

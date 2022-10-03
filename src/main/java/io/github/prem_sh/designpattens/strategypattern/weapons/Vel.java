package io.github.prem_sh.designpattens.strategypattern.weapons;

public class Vel implements Weapon {
    @Override
    public void attack() {
        System.out.println("attack with vel");
    }

    @Override
    public void specialAttack() {
        System.out.println("special attack with vel");
    }
}

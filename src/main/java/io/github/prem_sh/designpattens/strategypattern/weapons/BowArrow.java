package io.github.prem_sh.designpattens.strategypattern.weapons;

public class BowArrow implements Weapon{
    @Override
    public void attack() {
        System.out.println("attack with BowArrow");
    }

    @Override
    public void specialAttack() {
        System.out.println("special attack with BowArrow");
    }
}

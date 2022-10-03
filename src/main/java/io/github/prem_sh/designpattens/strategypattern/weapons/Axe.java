package io.github.prem_sh.designpattens.strategypattern.weapons;

public class Axe implements Weapon{
    @Override
    public void attack() {
        System.out.println("attack with Axe");
    }

    @Override
    public void specialAttack() {
        System.out.println("specialAttack with Axe");
    }
}

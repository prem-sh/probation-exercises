package io.github.prem_sh.designpattens.strategypattern.weapons;

public class Sword implements Weapon{
    @Override
    public void attack() {
        System.out.println("attack with Sword");
    }

    @Override
    public void specialAttack() {
        System.out.println("specialAttack with Sword");
    }
}

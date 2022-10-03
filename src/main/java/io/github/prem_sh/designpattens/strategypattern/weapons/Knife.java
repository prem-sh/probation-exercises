package io.github.prem_sh.designpattens.strategypattern.weapons;

public class Knife implements Weapon{
    @Override
    public void attack() {
        System.out.println("Knife cut");
    }

    @Override
    public void specialAttack() {
        System.out.println("Knife power melee attack");
    }
}

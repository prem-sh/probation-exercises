package io.github.prem_sh.designpattens.strategypattern.characters;

import io.github.prem_sh.designpattens.strategypattern.weapons.Weapon;

public abstract class Character {
    protected String role;
    protected Weapon weapon;

    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }
    public void performAttack(){
        System.out.print(role+" : ");
        weapon.attack();
    }
    public void performSpecialAttack(){
        System.out.print(role+" : ");
        weapon.specialAttack();
    }
}

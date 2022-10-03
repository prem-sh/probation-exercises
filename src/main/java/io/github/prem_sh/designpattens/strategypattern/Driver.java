package io.github.prem_sh.designpattens.strategypattern;

import io.github.prem_sh.designpattens.strategypattern.characters.King;
import io.github.prem_sh.designpattens.strategypattern.characters.Knight;
import io.github.prem_sh.designpattens.strategypattern.characters.Queen;
import io.github.prem_sh.designpattens.strategypattern.characters.Character;
import io.github.prem_sh.designpattens.strategypattern.weapons.Axe;
import io.github.prem_sh.designpattens.strategypattern.weapons.Knife;
import io.github.prem_sh.designpattens.strategypattern.weapons.Sword;
import io.github.prem_sh.designpattens.strategypattern.weapons.Vel;

public class Driver {
    public static void main(String[] args) {
        Character king = new King();
        Character queen = new Queen();
        Character knight = new Knight();

        queen.performSpecialAttack();
        queen.setWeapon(new Sword());
        queen.performAttack();

        king.performAttack();
        king.setWeapon(new Axe());
        king.performAttack();
        king.setWeapon(new Knife());
        king.performSpecialAttack();

        knight.performAttack();
        knight.performSpecialAttack();
        knight.setWeapon(new Vel());
        knight.performSpecialAttack();
    }
}

package io.github.prem_sh.designpattens.strategypattern.characters;

import io.github.prem_sh.designpattens.strategypattern.weapons.Axe;

public class Knight extends Character {
    public Knight() {
        role = "Knight";
        weapon = new Axe();
    }
}

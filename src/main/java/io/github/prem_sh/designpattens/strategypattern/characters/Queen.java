package io.github.prem_sh.designpattens.strategypattern.characters;

import io.github.prem_sh.designpattens.strategypattern.weapons.BowArrow;

public class Queen extends Character{
    public Queen() {
        role = "Queen";
        weapon = new BowArrow();
    }
}

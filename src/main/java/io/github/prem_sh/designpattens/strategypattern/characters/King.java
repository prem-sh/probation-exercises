package io.github.prem_sh.designpattens.strategypattern.characters;

import io.github.prem_sh.designpattens.strategypattern.weapons.Sword;

    public class King extends Character {
        public King() {
            role = "King";
            weapon = new Sword();
        }
    }

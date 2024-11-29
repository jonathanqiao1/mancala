package us.jonathans.entities.engine;

import us.jonathans.entity.rule.MancalaRuleSet;

public class EngineManager {
    MancalaRuleSet ruleSet;

    public Engine getEngine(String Id, MancalaRuleSet ruleSet) {
        this.ruleSet = ruleSet;
        Engine engine = null;
        switch (Id) {
            case "minimax_easy":
                // add depths
                engine = new MancalaMinimax(ruleSet, 3);
            case "minimax_normal":
                engine = new MancalaMinimax(ruleSet, 5);
            case "minimax_hard":
                engine = new MancalaMinimax(ruleSet, 7);
        }
        return engine;
    }
}

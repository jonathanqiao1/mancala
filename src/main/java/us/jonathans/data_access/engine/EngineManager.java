package us.jonathans.data_access.engine;

import us.jonathans.entity.engine.Engine;
import us.jonathans.entity.engine.MancalaMinimax;
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
            case "minimax_medium":
                engine = new MancalaMinimax(ruleSet, 5);
            case "minimax_hard":
                engine = new MancalaMinimax(ruleSet, 8);
        }
        return engine;
    }
}

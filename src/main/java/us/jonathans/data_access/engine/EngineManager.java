package us.jonathans.data_access.engine;

import us.jonathans.entity.engine.Engine;
import us.jonathans.entity.engine.MancalaMinimax;
import us.jonathans.entity.rule.MancalaRuleSet;

public class EngineManager {
    private MancalaRuleSet ruleSet;

    // Returns Engine according to the level of difficulty
    public Engine getEngine(String Id, MancalaRuleSet ruleSet) {
        this.ruleSet = ruleSet;
        Engine engine = null;
        switch (Id) {
            case "minimax_easy":
                engine = new MancalaMinimax(ruleSet, 3);
            case "minimax_medium":
                engine = new MancalaMinimax(ruleSet, 5);
            case "minimax_hard":
                engine = new MancalaMinimax(ruleSet, 8);
        }
        return engine;
    }
}

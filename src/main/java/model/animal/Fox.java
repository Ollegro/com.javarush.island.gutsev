package model.animal;

import config.AnimalConfig;

public class Fox extends Animal implements Raptor {
    private static final Animal  fox = AnimalConfig.getINSTANCE().getAnimalsProps().get("Fox");


    public Fox() {
        super(fox.getName()
                , fox.getSymbol()
                , fox.getWeight()
                , fox.getCellsMove()
                , fox.getFoodSaturation());
    }
}

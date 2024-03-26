package model.animal;
import config.AnimalConfig;

public class Boa extends Animal implements Raptor {
    private static final Animal boa = AnimalConfig.getINSTANCE().getAnimalsProps().get("Boa");


    public Boa() {
        super(boa.getName()
                , boa.getSymbol()
                , boa.getWeight()
                , boa.getCellsMove()
                , boa.getFoodSaturation());
    }
}

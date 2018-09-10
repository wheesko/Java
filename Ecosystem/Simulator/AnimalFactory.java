package Simulator;

import AnimalControl.Animal;
import Fauna.*;

public class AnimalFactory {
    public Animal getAnimal(String AnimalName, int x, int y){
        if(AnimalName == "Bear"){
            return new Bear(x,y);
        }
        if(AnimalName == "Fox"){
            return new Fox(x,y);
        }
        if(AnimalName == "Rabbit"){
            return new Rabbit(x,y);
        }
        if(AnimalName == "Hawk"){
            return new Hawk(x,y);
        }
        else return null;
    }
}

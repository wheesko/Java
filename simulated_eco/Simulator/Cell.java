package Simulator;

import java.io.Serializable;

public class Cell implements Serializable{
    public boolean isOccupiedByAnimal;
    public boolean isOccupiedByPlant;
    public Cell(){
       isOccupiedByAnimal = false;
       isOccupiedByPlant = false;
    }
}

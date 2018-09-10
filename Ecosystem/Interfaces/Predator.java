package Interfaces;

import AnimalControl.Animal;
import Fauna.Rabbit;
import Simulator.World;
import Simulator.Cell;
public interface Predator {
    public void hunt(Cell[][] theCell,Rabbit[] target, int targetCount);
}

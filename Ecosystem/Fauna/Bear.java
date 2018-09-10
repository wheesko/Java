package Fauna;

import Exceptions.CoordinateException;
import Exceptions.MovementException;
import Interfaces.Omnivore;
import AnimalControl.Animal;
import Simulator.*;
import Fauna.Rabbit;
import Fauna.Fox;
import Flora.*;

import java.io.Serializable;

public class Bear extends Animal implements Serializable, Omnivore {
    public Bear(){
        this.isHungry = false;
        this.isAlive = true;
        pos = new Position(0,0);
    }
    public Bear(int x, int y){
        this.isHungry = false;
        this.isAlive = true;
        pos = new Position(x,y);
    }
    @Override
    public void hunt(Cell[][] theCell,Rabbit[] target, int targetCount) {
        for(int i = 0; i <= targetCount ; i++) {
            if((this.getX() == target[i].getX()+1) && (this.getY() == target[i].getY()+1) && (this.isHungry == true)){
                target[i].isAlive = false;
                theCell[target[i].getX()+1][target[i].getY()+1].isOccupiedByAnimal = false;
                System.out.println("Bear killed rabbit at (" +getX() + ","+ getY()+")");
                reduceHunger(10);
                break;
            }
            if((this.getX() == target[i].getX()-1) && (this.getY() == target[i].getY()+1) && (this.isHungry == true)){
                target[i].isAlive = false;
                theCell[target[i].getX()-1][target[i].getY()+1].isOccupiedByAnimal = false;
                System.out.println("Bear killed rabbit at (" +getX() + ","+ getY()+")");
                reduceHunger(10);
                break;
            }
            if((this.getX() == target[i].getX()-1) && (this.getY() == target[i].getY()-1) && (this.isHungry == true)){
                target[i].isAlive = false;
                theCell[target[i].getX()-1][target[i].getY()-1].isOccupiedByAnimal = false;
                System.out.println("Bear killed rabbit at (" +getX() + ","+ getY()+")");
                reduceHunger(10);
                break;
            }
            if((this.getX() == target[i].getX()+1) && (this.getY() == target[i].getY()-1) && (this.isHungry == true)){
                target[i].isAlive = false;
                theCell[target[i].getX()+1][target[i].getY()-1].isOccupiedByAnimal = false;
                System.out.println("Bear killed rabbit at (" +getX() + ","+ getY()+")");
                reduceHunger(10);
                break;
            }
        }
    }
    public void lookForPlants(Weed[] target, int targetCount){
        for(int i = 0; i < targetCount ; i++) {
            if((this.getX() == target[i].getX()) && (this.getY() == target[i].getY()) && (target[i].getSize() > 0)){
                target[i].reduceSize(1);
                System.out.println("Bear ate weed at (" +getX() + ","+ getY()+")");
                reduceHunger(5);
                break;
            }
        }
    }

    @Override
    public void move(Cell[][] theCell,char direction, int amount) throws MovementException, CoordinateException{
        super.getHungry();
        switch (direction) {
            case 'E':
                if(theCell[this.getX()+amount][this.getY()].isOccupiedByAnimal == false) {
                    theCell[this.getX()][this.getY()].isOccupiedByAnimal = false;
                    this.setX(amount);
                    theCell[this.getX()][this.getY()].isOccupiedByAnimal = true;
                }
                else
                {
                    throw new MovementException("Can't go there, there is already something there ",this.getX()+amount,this.getY());
                }
                break;
            case 'W':
                if(theCell[this.getX()-amount][this.getY()].isOccupiedByAnimal == false) {
                    theCell[this.getX()][this.getY()].isOccupiedByAnimal = false;
                    this.setX(0 - amount);
                    theCell[this.getX()][this.getY()].isOccupiedByAnimal = true;
                }
                else throw new MovementException("Can't go there, there is already something there ",this.getX()-amount,this.getY());
                break;
            case 'N':
                if(theCell[this.getX()][this.getY()+amount].isOccupiedByAnimal == false) {
                    theCell[this.getX()][this.getY()].isOccupiedByAnimal = false;
                    this.setY(amount);
                    theCell[this.getX()][this.getY()].isOccupiedByAnimal = true;
                }
                else throw new MovementException("Can't go there, there is already something there ",this.getX(),this.getY()+amount);
                break;
            case 'S':
                if(theCell[this.getX()][this.getY()-amount].isOccupiedByAnimal == false) {
                    theCell[this.getX()][this.getY()].isOccupiedByAnimal = false;
                    this.setY(0 - amount);
                    theCell[this.getX()][this.getY()].isOccupiedByAnimal = true;
                }
                else throw new MovementException("Can't go there, there is already something there ",this.getX(),this.getY()-amount);
                break;
        }
    }
    public String toString(){
        return("Bear at (" + this.getX() + "," + this.getY() +") is alive? " + isAlive + " is hungry? " + isHungry);
    }
}

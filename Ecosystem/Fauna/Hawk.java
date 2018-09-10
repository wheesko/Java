package Fauna;
import Exceptions.CoordinateException;
import Exceptions.MovementException;
import Interfaces.*;
import AnimalControl.Animal;
import Simulator.Cell;
import Simulator.Position;
import Simulator.World;

import java.io.Serializable;

public class Hawk extends Animal implements Serializable,Predator, CanFly{

    public Hawk(){
        this.isHungry = false;
        this.isAlive = true;
        pos = new Position(0,0);
    }
    public Hawk(int x, int y){
        this.isHungry = false;
        this.isAlive = true;
        pos = new Position(x,y);
    }
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
            if((this.getX() == target[i].getX()-1) && (this.getY() == target[i].getY()) && (this.isHungry == true)){
                target[i].isAlive = false;
                theCell[target[i].getX()-1][target[i].getY()].isOccupiedByAnimal = false;
                System.out.println("Bear killed rabbit at (" +getX() + ","+ getY()+")");
                reduceHunger(10);
                break;
            }
            if((this.getX() == target[i].getX()+1) && (this.getY() == target[i].getY()) && (this.isHungry == true)){
                target[i].isAlive = false;
                theCell[target[i].getX()+1][target[i].getY()].isOccupiedByAnimal = false;
                System.out.println("Bear killed rabbit at (" +getX() + ","+ getY()+")");
                reduceHunger(10);
                break;
            }
            if((this.getX() == target[i].getX()) && (this.getY() == target[i].getY()-1) && (this.isHungry == true)){
                target[i].isAlive = false;
                theCell[target[i].getX()][target[i].getY()+1].isOccupiedByAnimal = false;
                System.out.println("Bear killed rabbit at (" +getX() + ","+ getY()+")");
                reduceHunger(10);
                break;
            }
            if((this.getX() == target[i].getX()) && (this.getY() == target[i].getY()-1) && (this.isHungry == true)){
                target[i].isAlive = false;
                theCell[target[i].getX()][target[i].getY()-1].isOccupiedByAnimal = false;
                System.out.println("Bear killed rabbit at (" +getX() + ","+ getY()+")");
                reduceHunger(10);
                break;
            }
        }
    }

    public void fly(Cell[][] theCell, char direction, int amount) throws MovementException {
        switch (direction) {
            case 'E':
                if(theCell[this.getX()+amount][this.getY()].isOccupiedByAnimal == false) {
                    theCell[this.getX()][this.getY()].isOccupiedByAnimal = false;
                    this.setX(amount);
                    theCell[this.getX()][this.getY()].isOccupiedByAnimal = true;
                }
                else throw new MovementException("Can't go there, there is already something there ",this.getX()+amount,this.getY());
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

    public void move(Cell[][] theCell, char direction, int amount) throws MovementException, CoordinateException{
        super.getHungry();
        this.fly(theCell, direction, amount);
    }
    public String toString(){
        return("Hawk at (" + getX() + "," + getY() +") is alive? " + isAlive + " is hungry? " + isHungry);
    }
}

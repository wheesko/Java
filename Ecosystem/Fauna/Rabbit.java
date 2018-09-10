package Fauna;
import AnimalControl.Animal;
import Exceptions.CoordinateException;
import Exceptions.MovementException;
import Flora.Weed;
import Interfaces.Vegan;
import Simulator.Cell;
import Simulator.World;
import Simulator.Position;

import java.io.Serializable;

public class Rabbit extends Animal implements Serializable,Vegan, Cloneable {
    public Rabbit(){
        pos = new Position(0,0);
        this.isAlive = true;
    }
    public Rabbit(int x, int y){
        this.isAlive = true;
        pos = new Position(x,y);
    }
    @Override
    public void move(Cell[][] theCell,char direction, int amount) throws MovementException, CoordinateException {
        super.getHungry();
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
    public void lookForPlants(Weed[] target, int targetCount) {
        for(int i = 0; i < targetCount ; i++) {
            if((this.getX() == target[i].getX()) && (this.getY() == target[i].getY()) && (target[i].getSize() > 0)){
                target[i].reduceSize(1);
                System.out.println("Rabbit ate weed at (" +getX() + ","+ getY()+")");
                reduceHunger(5);
                break;
            }
        }
    }
    public String toString(){
        return("Rabbit at (" + getX() + "," + getY() +") is alive? " + isAlive + " is hungry? " + isHungry);
    }
    public void setAlive(boolean cond, Cell theCell){
        if(cond == false){
            this.isAlive = false;
            theCell.isOccupiedByAnimal = false;}
        else{
            this.isAlive = true;
            theCell.isOccupiedByAnimal = true;}
        }
    @Override
    public Rabbit clone() throws CloneNotSupportedException {
        Rabbit rc = (Rabbit) super.clone();
        rc.pos = new Position(this.pos.x, this.pos.y);
        return rc;
        }
    }


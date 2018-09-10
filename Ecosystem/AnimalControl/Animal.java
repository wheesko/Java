package AnimalControl;

import Exceptions.CoordinateException;
import Exceptions.MovementException;
import Simulator.Cell;
import Simulator.Position;

import java.io.Serializable;

public abstract class Animal implements Serializable{
    public Position pos;
    public boolean isAlive;
    private int hunger = 0;
    public boolean isHungry;

    abstract public void move(Cell[][] theCell, char direction, int amount) throws MovementException, CoordinateException;

    public int getX() {
        return pos.x;
    }

    public int getY() {
        return pos.y;
    }

    public void setX(int gx) {
        pos.x += gx;
    }

    public void setY(int gy) {
        pos.y += gy;
    }
    public void getHungry(){
        this.hunger++;
        if (this.hunger >= 5) {
            this.isHungry = true;
        }
        else this.isHungry = false;
    }
    public void reduceHunger(int k){
        this.hunger-= k;
    }

}

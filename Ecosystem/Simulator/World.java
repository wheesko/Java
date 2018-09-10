package Simulator;
import AnimalControl.*;
import Exceptions.CoordinateException;
import Exceptions.MovementException;
import Exceptions.SpawnException;
import Fauna.*;
import Flora.*;
import Interfaces.*;
import PlantControl.*;

import java.io.Serializable;
import java.util.Random;

public final class World implements Serializable, Runnable {
    private final static World createdWorld = new World();
    Hawk myHawks[];
    int k = 0;
    Rabbit myRabbits[];
    Bear myBears[];
    Fox myFoxes[];
    Weed myWeeds[];
    int rabbitCount;
    int foxCount ;
    int bearCount;
    int hawkCount;
    private int size;
    int weedCount ;
    Cell myCell[][];
    private World() {
        this.size = 20-1;
        myCell = new Cell[this.size][this.size];
        for(int i = 0; i < this.size; i++) {
            for (int k = 0; k < this.size; k++) {
                myCell[i][k] = new Cell();
            }
        }
        myHawks = new Hawk[100];
        myRabbits = new Rabbit[100];
        myBears = new Bear[100];
        myFoxes = new Fox[100];
        myWeeds = new Weed[100];
        rabbitCount = -1;
        foxCount = -1;
        bearCount = -1;
        hawkCount = -1;
        weedCount = -1;
   }
    public static World getCreatedWorld(){
        return createdWorld;
    }
    public void spawnRabbit(Rabbit gotRabbit,Rabbit[] myRabbits, int x, int y) throws SpawnException{
        if (myCell[x][y].isOccupiedByAnimal == false){
            rabbitCount++;
            myRabbits[rabbitCount] = gotRabbit;
            myCell[x][y].isOccupiedByAnimal = true;
        }
        else throw new SpawnException("Can't spawn there, there is already something there",x,y);

    }
    public void spawnFox(Fox[] myFoxes, int x, int y) throws SpawnException{
        if (myCell[x][y].isOccupiedByAnimal == false) {
            foxCount++;
            myFoxes[foxCount] = new Fox(x, y);
            myCell[x][y].isOccupiedByAnimal = true;
        }
        else throw new SpawnException("Can't spawn there, there is already something there",x,y);
    }
    public void spawnBear(Bear gotBear, Bear[] myBears, int x, int y) throws SpawnException{
        if (myCell[x][y].isOccupiedByAnimal == false) {
            bearCount++;
            myBears[bearCount] = gotBear;
            myCell[x][y].isOccupiedByAnimal = true;
        }
        else throw new SpawnException("Can't spawn there, there is already something there",x,y);
    }
    public void spawnHawk(Hawk[] myHawks, int x, int y)throws SpawnException{
        if (myCell[x][y].isOccupiedByAnimal == false) {
            hawkCount++;
            myHawks[rabbitCount] = new Hawk(x, y);
            myCell[x][y].isOccupiedByAnimal = true;
        }
        else throw new SpawnException("Can't spawn there, there is already something there",x,y);
    }
    public void spawnWeed(Weed[] myWeeds, int x, int y)throws SpawnException {
        if (myCell[x][y].isOccupiedByAnimal == false) {
            weedCount++;
            myWeeds[weedCount] = new Weed();
            myCell[x][y].isOccupiedByPlant = true;
        }
        else throw new SpawnException("Can't spawn there, there is already something there",x,y);
    }
    public void printWorld(){
        int printed = 0;
       for(int i = size; i >= 0; i--){
           for(int k = 0; k<=size; k++){
               printed = 0;
              for (int o = 0; o <= bearCount ;o++){
                  if((myBears[o].getX()) == k && (myBears[o].getY() == i)){
                      if(myBears[0].isAlive == true)
                          System.out.print('B');
                      else System.out.print('-');
                      printed++;
                  }
              }
               for (int o = 0; o <= hawkCount ;o++){
                   if((myHawks[o].getX()) == k && (myHawks[o].getY() == i)){
                       if(myHawks[0].isAlive == true)
                           System.out.print('H');
                       else System.out.print('-');
                       printed++;
                   }
               }
               for (int o = 0; o <= weedCount ;o++){
                   if((myWeeds[o].getX() == k) && (myWeeds[o].getY() == i)){
                           System.out.print('W');
                       printed++;
                   }
               }
               for (int o = 0; o <= rabbitCount ;o++){
                   if((myRabbits[o].getX()) == k && (myRabbits[o].getY() == i)){
                       if(myRabbits[o].isAlive == true)
                           System.out.print('R');
                       else System.out.print('-');
                       printed++;
                   }
               }
               for (int o = 0; o <= foxCount ;o++){
                   if((myFoxes[o].getX() == i) && (myFoxes[o].getY() == k)){
                       if(myFoxes[0].isAlive == true)
                       System.out.print('F');
                       printed++;
                   }
               }
               if (printed == 0) System.out.print('-');
           }
           System.out.println();
       }
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println();
    }
    public void run(){
        Random r = new Random();
        int j;
        try {
           /* for (int i = 0; i < 6; i++) {
                for(int k = 0; k <= bearCount; k++){
                    j = r.nextInt(4)+1;
                    switch(j){
                        case 1: try {myBears[k].move(myCell, 'N', 1);} catch(CoordinateException c) {}
                        case 2: try {myBears[k].move(myCell, 'W', 1);} catch(CoordinateException c) {}
                        case 3: try {myBears[k].move(myCell, 'S', 1);} catch(CoordinateException c) {}
                        case 4: try {myBears[k].move(myCell, 'E', 1);} catch(CoordinateException c) {}
                    }
                }
                for(int o = 0; o <= rabbitCount; o++){
                    j = r.nextInt(4)+1;
                    switch(j){
                        case 1: try {myRabbits[o].move(myCell, 'N', 1);} catch(CoordinateException c) {}
                        case 2: try {myRabbits[o].move(myCell, 'W', 1);} catch(CoordinateException c) {}
                        case 3: try {myRabbits[o].move(myCell, 'S', 1);} catch(CoordinateException c) {}
                        case 4: try {myRabbits[o].move(myCell, 'E', 1);} catch(CoordinateException c) {}
                    }
                }*/
           synchronized(this) {
               for (int i = 0; i < 100; i++) {
                   k++;
                   Thread.sleep(10);
              // }
               //printWorld();
              }
           }
            System.out.println("Integer: " + k);

        }
        catch(InterruptedException e){
            System.out.println("Thread interrupted.");
        }
    }

    public void start() {
    }
}

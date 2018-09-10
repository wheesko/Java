package Simulator;
import AnimalControl.*;
import Exceptions.CoordinateException;
import Exceptions.MovementException;
import Exceptions.SpawnException;

import Fauna.*;
import Flora.*;
import Interfaces.*;
import PlantControl.*;

import java.io.*;
import java.util.Random;

public class Simulation {

    public static void main(String [] args){
        World myWorld = World.getCreatedWorld();
        AnimalFactory animalFactory = new AnimalFactory();
        try{
            myWorld.spawnBear((Bear) animalFactory.getAnimal("Bear",10,10),myWorld.myBears, 10, 10);}
        catch(SpawnException exc){
            System.out.println(exc);
        }
        try{
            myWorld.spawnBear((Bear) animalFactory.getAnimal("Bear",12,12), myWorld.myBears, 12, 12);}
        catch(SpawnException exc){
            System.out.println(exc);
        }
       try {
            myWorld.spawnRabbit((Rabbit) animalFactory.getAnimal("Rabbit",8,8) ,myWorld.myRabbits, 8, 8);
        }
        catch(SpawnException exc){
            System.out.println(exc);
        }
        /*try{
            Rabbit r = (Rabbit)myWorld.myRabbits[0].clone();
            r.setX(1);
            myWorld.myCell[myWorld.myRabbits[0].getX()+1][myWorld.myRabbits[0].getY()].isOccupiedByAnimal = true;
            myWorld.rabbitCount++;
            myWorld.myRabbits[1] = r;
        }
        catch(CloneNotSupportedException exc){

        }*/
        /*myWorld.printWorld();
        myWorld.clearScreen();
        try{
            myWorld.myBears[0].move(myWorld.myCell, 'S', 1);
        }
        catch(MovementException exc){
            System.out.println(exc);
        }
        catch (CoordinateException exc){
            System.out.println(exc);
        }
        myWorld.printWorld();
        myWorld.clearScreen();
        try{
            myWorld.myBears[0].move(myWorld.myCell, 'W', 1);
        }
        catch(MovementException exc){
            System.out.println(exc);
        }
        catch (CoordinateException exc){
            System.out.println(exc);
        }
        myWorld.printWorld();
        myWorld.clearScreen();
        try{
            myWorld.myBears[0].move(myWorld.myCell, 'N', 1);
        }
        catch(MovementException exc){
            System.out.println(exc);
        }
        catch (CoordinateException exc){
            System.out.println(exc);
        }
        myWorld.printWorld();
        myWorld.clearScreen();
        try{
            myWorld.myBears[0].move(myWorld.myCell, 'N', 1);
        }
        catch(MovementException exc){
            System.out.println(exc);
        }
        catch(CoordinateException exc){
            System.out.println(exc);
        }*/

        /*myWorld.printWorld();
        myWorld.clearScreen();
        System.out.println(myWorld.myBears[0].toString());
        System.out.println(myWorld.myRabbits[0].toString());*/
        myWorld.printWorld();
        try{
            FileOutputStream fileOut = new FileOutputStream("C:\\Users\\n01\\Desktop\\Data.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(myWorld);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in C:\\Users\\n01\\Desktop\\Data.ser");
        }
        catch (IOException e){

        }
        myWorld = null;
        try {
            FileInputStream fileIn = new FileInputStream("C:\\Users\\n01\\Desktop\\Data.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            myWorld = (World) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("World class not found");
            c.printStackTrace();
            return;
        }
        myWorld.printWorld();
        Thread t = new Thread(myWorld,"t");
        Thread t1 = new Thread(myWorld,"t1");
        Thread t2 = new Thread(myWorld,"t2");
        Thread t3 = new Thread(myWorld,"t3");
        t.start();
        t1.start();
        t2.start();
        t3.start();
        try {
            Thread.sleep(5000);

        }catch(InterruptedException e){}
        System.out.println("Integer k: "+ myWorld.k);
    }
}

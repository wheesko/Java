package Flora;

import PlantControl.Plant;

import java.io.Serializable;

public class Weed extends Plant implements Serializable {
    private int size;
    public Weed(){
        this.size = 0;
    }
    public Weed(int x, int y){
        this.size = 0;
        this.setX(x);
        this.setY(y);
    }
}

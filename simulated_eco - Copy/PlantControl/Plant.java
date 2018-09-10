package PlantControl;

import java.io.Serializable;

public abstract class Plant implements Serializable {
    int size;
    private int x, y;
    public void grow(){
        this.size++;
    }
    public int getSize(){
        return this.size;
    }
    public void reduceSize(int amount){
        this.size -= amount;
    }
    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }
}

package Exceptions;

public class SpawnException extends CoordinateException {
    public SpawnException(String error, int x, int y){
        super(error, x, y);
    }
}

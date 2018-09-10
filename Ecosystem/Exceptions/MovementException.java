package Exceptions;

public class MovementException extends CoordinateException {
    public MovementException(String error, int x, int y){
        super(error, x, y);
    }
}

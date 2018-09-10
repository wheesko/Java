package Exceptions;

public class CoordinateException extends Exception {
    public CoordinateException(String error, int x, int y){
        super(error +"at " +" "+ x+ ","+" "+ y);
    }
}

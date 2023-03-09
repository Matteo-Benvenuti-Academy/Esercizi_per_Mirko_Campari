package Java.ristorante.src.utils;

public class MyRandom {

    public static int randomRange(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}

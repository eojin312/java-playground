package hachi.javaplayground.basic.lamda;

public class Worker implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "번째");
        }
    }
}

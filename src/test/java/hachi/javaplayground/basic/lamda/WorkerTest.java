package hachi.javaplayground.basic.lamda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {

    @Test
    void worker의run메소드_테스트() {
        Worker w = new Worker();
        new Thread(w).start();
    }
}
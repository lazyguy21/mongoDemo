package tobi.ye.mongodbDemo;

import java.io.IOException;

/**
 * Created by lazyguy on 2016-4-2.
 */
public class TestA {
    public void testThrows() throws IOException {
        System.out.println("haha");
    }

    public static void main(String[] args) {

        TestA testA = new TestA();
        try {
            testA.testThrows();
        } catch (IOException e) {
            e.printStackTrace();
        }

        TestB testB = new TestB();
        try {
            testB.testThrow();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

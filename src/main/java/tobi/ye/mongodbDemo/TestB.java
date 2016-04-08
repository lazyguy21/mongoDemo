package tobi.ye.mongodbDemo;

import tobi.ye.mongodbDemo.util.TestInterface;

import java.io.IOException;

/**
 * Created by lazyguy on 2016-4-2.
 */
public class TestB implements TestInterface{
    @Override
    public void testThrow() throws IOException {
        System.out.println("asdf");
    }
}

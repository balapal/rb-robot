package com.rb.robot;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class RobotAppTest {

    @Test
    public void runThreeRobotTest() {
        final RobotApp robotApp = new RobotApp();
        final List<String> output = robotApp.parseInputAndExecute(
                Arrays.asList("5 3", "1 1 E", "RFRFRFRF", "3 2 N", "FRRFLLFFRRFLL", "0 3 W", "LLFFFLFLFL"));
        assertEquals("1 1 E", output.get(0));
        assertEquals("3 3 N LOST", output.get(1));
        assertEquals("2 3 S", output.get(2));
    }
}

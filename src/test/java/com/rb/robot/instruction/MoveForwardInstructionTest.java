package com.rb.robot.instruction;

import static com.rb.robot.Direction.E;
import static com.rb.robot.Direction.N;
import static com.rb.robot.Direction.S;
import static com.rb.robot.Direction.W;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.rb.robot.Direction;
import com.rb.robot.Planet;
import com.rb.robot.Robot;

public class MoveForwardInstructionTest {

    private final MoveForwardInstruction moveForwardInstruction = new MoveForwardInstruction();

    @Test
    public void northFacingRobotMovesForward() {
        final Robot testRobot = createTestRobot(N);
        moveForwardInstruction.execute(testRobot);
        assertEquals(N, testRobot.getDirection());
        assertEquals(1, testRobot.getX());
        assertEquals(2, testRobot.getY());
    }

    @Test
    public void southFacingRobotMovesForward() {
        final Robot testRobot = createTestRobot(S);
        moveForwardInstruction.execute(testRobot);
        assertEquals(S, testRobot.getDirection());
        assertEquals(1, testRobot.getX());
        assertEquals(0, testRobot.getY());
    }

    @Test
    public void eastFacingRobotMovesForward() {
        final Robot testRobot = createTestRobot(E);
        moveForwardInstruction.execute(testRobot);
        assertEquals(E, testRobot.getDirection());
        assertEquals(2, testRobot.getX());
        assertEquals(1, testRobot.getY());
    }

    @Test
    public void westFacingRobotMovesForward() {
        final Robot testRobot = createTestRobot(W);
        moveForwardInstruction.execute(testRobot);
        assertEquals(W, testRobot.getDirection());
        assertEquals(0, testRobot.getX());
        assertEquals(1, testRobot.getY());
    }

    private Robot createTestRobot(final Direction direction) {
        return new Robot(1, 1, direction, new Planet(10, 10));
    }
}

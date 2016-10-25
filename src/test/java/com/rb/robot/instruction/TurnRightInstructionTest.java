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

public class TurnRightInstructionTest {

    private final TurnRightInstruction turnRightInstruction = new TurnRightInstruction();

    @Test
    public void northFacingRobotTurnsRight() {
        final Robot testRobot = createTestRobot(N);
        turnRightInstruction.execute(testRobot);
        assertEquals(E, testRobot.getDirection());
        assertThatTestRobotDidChangeItsInitialCoordinates(testRobot);
    }

    @Test
    public void southFacingRobotTurnsRight() {
        final Robot testRobot = createTestRobot(S);
        turnRightInstruction.execute(testRobot);
        assertEquals(W, testRobot.getDirection());
        assertThatTestRobotDidChangeItsInitialCoordinates(testRobot);
    }

    @Test
    public void eastFacingRobotTurnsRight() {
        final Robot testRobot = createTestRobot(E);
        turnRightInstruction.execute(testRobot);
        assertEquals(S, testRobot.getDirection());
        assertThatTestRobotDidChangeItsInitialCoordinates(testRobot);
    }

    @Test
    public void westFacingRobotTurnsRight() {
        final Robot testRobot = createTestRobot(W);
        turnRightInstruction.execute(testRobot);
        assertEquals(N, testRobot.getDirection());
        assertThatTestRobotDidChangeItsInitialCoordinates(testRobot);
    }

    private Robot createTestRobot(final Direction direction) {
        return new Robot(1, 1, direction, new Planet(10, 10));
    }

    private void assertThatTestRobotDidChangeItsInitialCoordinates(final Robot testRobot) {
        assertEquals(1, testRobot.getX());
        assertEquals(1, testRobot.getY());
    }
}

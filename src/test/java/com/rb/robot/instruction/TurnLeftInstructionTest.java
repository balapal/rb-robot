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

public class TurnLeftInstructionTest {

    private final TurnLeftInstruction turnLeftInstruction = new TurnLeftInstruction();

    @Test
    public void northFacingRobotTurnsLeft() {
        final Robot testRobot = createTestRobot(N);
        turnLeftInstruction.execute(testRobot);
        assertEquals(W, testRobot.getDirection());
        assertThatTestRobotDidChangeItsInitialCoordinates(testRobot);
    }

    @Test
    public void southFacingRobotTurnsLeft() {
        final Robot testRobot = createTestRobot(S);
        turnLeftInstruction.execute(testRobot);
        assertEquals(E, testRobot.getDirection());
        assertThatTestRobotDidChangeItsInitialCoordinates(testRobot);
    }

    @Test
    public void eastFacingRobotTurnsLeft() {
        final Robot testRobot = createTestRobot(E);
        turnLeftInstruction.execute(testRobot);
        assertEquals(N, testRobot.getDirection());
        assertThatTestRobotDidChangeItsInitialCoordinates(testRobot);
    }
    @Test
    public void westFacingRobotTurnsLeft() {
        final Robot testRobot = createTestRobot(W);
        turnLeftInstruction.execute(testRobot);
        assertEquals(S, testRobot.getDirection());
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

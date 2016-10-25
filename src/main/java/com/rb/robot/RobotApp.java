package com.rb.robot;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.rb.robot.instruction.Instruction;
import com.rb.robot.instruction.MoveForwardInstruction;
import com.rb.robot.instruction.TurnLeftInstruction;
import com.rb.robot.instruction.TurnRightInstruction;

public class RobotApp {
    private static final String SPACE = " ";

    public List<String> parseInputAndExecute(final List<String> inputLinesList) {
        final List<String> outputLines = new LinkedList<>();
        final Iterator<String> inputLines = inputLinesList.iterator();
        final Planet planet = initPlanet(getNextInputLine(inputLines));

        final Map<Character, Instruction> supportedInstructions = new HashMap<>();
        supportedInstructions.put('L', new TurnLeftInstruction());
        supportedInstructions.put('R', new TurnRightInstruction());
        supportedInstructions.put('F', new MoveForwardInstruction());
        final RobotController robotController = new RobotController(supportedInstructions);

        String startPosition = getNextInputLine(inputLines);
        String instructions = getNextInputLine(inputLines);

        while (!startPosition.isEmpty() && !instructions.isEmpty()) {
            final String[] startPositionSplitted = startPosition.split(SPACE);
            final int x = Integer.valueOf(startPositionSplitted[0].trim());
            final int y = Integer.valueOf(startPositionSplitted[1].trim());
            final Direction direction = Direction.valueOf(startPositionSplitted[2].trim());
            final Robot robot = new Robot(x, y, direction, planet);

            robotController.executeInstructions(robot, instructions);

            outputLines.add(robot.toString());

            startPosition = getNextInputLine(inputLines);
            instructions = getNextInputLine(inputLines);
        }
        return outputLines;
    }

    private String getNextInputLine(final Iterator<String> inputLines) {
        return inputLines.hasNext() ? inputLines.next().trim() : "";
    }

    private Planet initPlanet(final String planetSizeInput) {
        final String[] planetSizeSplitted = planetSizeInput.split(SPACE);
        if (planetSizeSplitted.length != 2) {
            System.err
                    .println("First parameter is the planet input size. Must be 2 integers with a space between them");
            System.exit(1);
        }

        final int planetWidth = Integer.valueOf(planetSizeSplitted[0]);
        final int planetHeight = Integer.valueOf(planetSizeSplitted[1]);

        final Planet planet = new Planet(planetWidth, planetHeight);
        return planet;
    }
}

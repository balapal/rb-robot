package com.rb.robot;

import java.util.Map;

import com.rb.robot.instruction.Instruction;

public class RobotController {

    private final Map<Character, Instruction> supportedInstructions;

    public RobotController(final Map<Character, Instruction> supportedInstructions) {
        this.supportedInstructions = supportedInstructions;
    }

    public void executeInstructions(final Robot robot, final String instructions) {
        int i = 0;
        while (!robot.isLost() && i < instructions.length()) {
            final char instructionChar = instructions.charAt(i);
            final Instruction instruction = supportedInstructions.get(instructionChar);
            if (instruction != null) {
                instruction.execute(robot);
            }
            ++i;
            // Ignore unknown instructions
        }
    }

}

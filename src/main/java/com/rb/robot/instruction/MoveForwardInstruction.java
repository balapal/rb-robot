package com.rb.robot.instruction;

import com.rb.robot.Robot;

public class MoveForwardInstruction implements Instruction {

    @Override
    public void execute(final Robot robot) {
        switch (robot.getDirection()) {
        case N:
            robot.setY(robot.getY() + 1);
            break;
        case E:
            robot.setX(robot.getX() + 1);
            break;
        case S:
            robot.setY(robot.getY() - 1);
            break;
        case W:
            robot.setX(robot.getX() - 1);
            break;
        }
    }

}

package com.rb.robot.instruction;

import static com.rb.robot.Direction.E;
import static com.rb.robot.Direction.N;
import static com.rb.robot.Direction.S;
import static com.rb.robot.Direction.W;

import com.rb.robot.Robot;

public class TurnRightInstruction implements Instruction {

    @Override
    public void execute(final Robot robot) {
        switch (robot.getDirection()) {
        case N:
            robot.setDirection(E);
            break;
        case E:
            robot.setDirection(S);
            break;
        case S:
            robot.setDirection(W);
            break;
        case W:
            robot.setDirection(N);
            break;
        }
    }

}

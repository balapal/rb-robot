package com.rb.robot;

public class Robot {
    private int x;
    private int y;
    private Direction direction;
    private boolean lost;
    private final Planet planet;

    public Robot(final int x, final int y, final Direction direction, final Planet planet) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.planet = planet;
    }

    public int getX() {
        return x;
    }

    public void setX(final int x) {
        if (!planet.hasRobotDiedSteppingOnThisCoordinate(x, y)) {
            if (planet.addCoordinatesOfRobotDiedIfItSteppedOff(x, y)) {
                lost = true;
            } else {
                this.x = x;
            }
        }
    }

    public int getY() {
        return y;
    }

    public void setY(final int y) {
        if (!planet.hasRobotDiedSteppingOnThisCoordinate(x, y)) {
            if (planet.addCoordinatesOfRobotDiedIfItSteppedOff(x, y)) {
                lost = true;
            } else {
                this.y = y;
            }
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(final Direction direction) {
        this.direction = direction;
    }

    public boolean isLost() {
        return lost;
    }

    @Override
    public String toString() {
        return x + " " + y + " " + direction + (lost ? " LOST" : "");
    }
}

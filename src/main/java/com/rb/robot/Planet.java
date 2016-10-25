package com.rb.robot;

import java.util.HashSet;
import java.util.Set;

public class Planet {

    private class Position {

        private final int x;
        private final int y;

        public Position(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(final Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Position other = (Position) obj;
            if (!getOuterType().equals(other.getOuterType())) {
                return false;
            }
            if (x != other.x) {
                return false;
            }
            if (y != other.y) {
                return false;
            }
            return true;
        }

        private Planet getOuterType() {
            return Planet.this;
        }
    }

    private final int planetWidth;
    private final int planetHeight;

    private final Set<Position> deadRobots = new HashSet<>();

    public Planet(final int planetWidth, final int planetHeight) {
        this.planetWidth = planetWidth;
        this.planetHeight = planetHeight;
    }

    public boolean hasRobotDiedSteppingOnThisCoordinate(final int x, final int y) {
        return deadRobots.contains(new Position(x, y));
    }

    public boolean addCoordinatesOfRobotDiedIfItSteppedOff(final int x, final int y) {
        if (x > planetWidth || y > planetHeight || x < 0 || y < 0) {
            deadRobots.add(new Position(x, y));
            return true;
        } else {
            return false;
        }
    }
}

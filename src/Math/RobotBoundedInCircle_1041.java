package Math;

public class RobotBoundedInCircle_1041 {
    public boolean isRobotBounded(String instructions) {
        // north = 0, east = 1, south = 2, west = 3
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int x = 0, y = 0;// Initial position
        int direc = 0;// Initial facing north

        for (char i : instructions.toCharArray()) {
            if (i == 'L')
                direc = (direc + 3) % 4;
            else if (i == 'R')
                direc = (direc + 1) % 4;
            else { //G
                x += directions[direc][0];
                y += directions[direc][1];
            }
        }

        // 走完一次循环后，如果为以下情况之一，就能走成一个圈
        // robot returns into initial position
        // or robot doesn't face north
        return (x == 0 && y == 0) || (direc != 0);
    }
}

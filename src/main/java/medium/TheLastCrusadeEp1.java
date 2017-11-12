package medium;

import java.util.Scanner;


/**
 *
 ***The Goal***
 *
 * Your objective is to write a program capable of predicting the route Indy will take on his way down a tunnel.
 * Indy is not in danger of getting trapped in this first mission.
 *
 ***Rules***
 *
 * The tunnel consists of a patchwork of square rooms of different types.
 * The rooms can be accessed and activated by computer using an ancient RS232 serial port (because Mayans aren't very technologically advanced, as is to be expected...).
 *
 * There is a total of 14 room types (6 base shapes extended to 14 through rotations).
 *
 * Upon entering a room, depending on the type of the room and Indy's entrance point (TOP,LEFT, or RIGHT) he will either exit the room through a specific exit point, suffer a lethal collision or lose momentum and get stuck:
 *
 * Indy is perpetually drawn downwards: he cannot leave a room through the top.
 *
 * At the start of the game, you are given the map of the tunnel in the form of a rectangular grid of rooms.
 * Each room is represented by its type.
 *
 * For this first mission, you will familiarize yourself with the tunnel system, the rooms have all been arranged in such a way that Indy will have a safe continuous route between his starting point (top of the temple) and the exit area (bottom of the temple).
 *
 * Each game turn:
 * You receive Indy's current position
 * Then you specify what Indy's position will be next turn.
 * Indy will then move from the current room to the next according to the shape of the current room.
 *
 ***Game Input***
 *
 * The program must first read the initialization data from standard input.
 * Then, within an infinite loop, read the data from the standard input related to the current position of Indy and provide to the standard output the expected data.
 *
 ***Initialization input***
 *
 * Line 1: 2 space separated integers W H specifying the width and height of the grid.
 *
 * Next H lines: each line represents a line in the grid and contains W space separated integers T.
 * T specifies the type of the room.
 *
 * Last line: 1 integer EX specifying the coordinate along the X axis of the exit (this data is not useful for this first mission, it will be useful for the second level of this puzzle).
 *
 ***Input for one game turn***
 *
 * Line 1: XI YI POS
 * (XI, YI) two integers to indicate Indy's current position on the grid.
 * POS a single word indicating Indy's entrance point into the current room: TOP if Indy enters from above, LEFT if Indy enters from the left and RIGHT if Indy enters from the right.
 *
 ***Output for one game turn***
 * A single line with 2 integers: X Y representing the (X, Y) coordinates of the room in which you believe Indy will be on the next turn.
 *
 ***Constraints***
 * 0 < W ≤ 20
 * 0 < H ≤ 20
 * 0 ≤ T ≤ 13
 * 0 ≤ EX < W
 * 0 ≤ XI, X < W
 * 0 ≤ YI, Y < H
 *
 * Response time for one game ≤ 150ms
 */
class TheLastCrusadeEp1 {
    private static int width;
    private static int height;
    private static Scanner in;
    private static int[][] grid;
    private static int EX;
    
    public static void main(String args[]) {
        initVariables();
        
        //System.err.println(Arrays.deepToString(grid));
        //System.err.println("W:" + width + " H:" + height);
    
        int XI, YI;
        String POS;
        while (true) {
            XI = in.nextInt();
            YI = in.nextInt();
            POS = in.next(); //TOP,LEFT,RIGHT
            //System.err.println(grid[YI][XI]);
            switch(grid[YI][XI]){
                case 1: case 3: case 7: case 8: case 9: case 12: case 13:
                    down(XI,YI);
                
                    break;
                case 2: case 6:
                    if (POS.equals("LEFT")){
                        System.out.println(++XI + " " + YI);
                    } else if (POS.equals("RIGHT")){
                        System.out.println(--XI + " " + YI);
                    }
                    break;
                case 4:
                    if (POS.equals("TOP")){
                        left(XI,YI);
                    } else if (POS.equals("RIGHT")){
                        down(XI,YI);
                    }
                    break;
                case 5:
                    if (POS.equals("TOP")){
                        right(XI,YI);
                    } else if (POS.equals("LEFT")){
                        down(XI,YI);
                    }
                    break;
                case 10:
                    left(XI,YI);
                    break;
                case 11:
                    right(XI,YI);
                    break;
            }
        }
    }
    public static void initVariables(){
        in = new Scanner(System.in);
        width = in.nextInt(); // number of columns.
        height = in.nextInt(); // number of rows.
        if (in.hasNextLine()) {
            in.nextLine();
        }
        grid = initGrid();
        EX = in.nextInt(); // the coordinate along the X axis of the exit (not useful for this first mission, but must be read).
    }
    public static int[][] initGrid(){
        int[][] map = new int[height][width];
        for (int i = 0; i < height; i++) {
            String[] line = in.nextLine().split(" ");
            for (int j=0; j< width; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
        return map;
    }
    public static void left(int XI, int YI){
        System.out.println(--XI + " " + YI);
    }
    public static void right(int XI, int YI){
        System.out.println(++XI + " " + YI);
    }
    public static void down(int XI, int YI){
        System.out.println(XI + " " + ++YI);
    }
}

package easy;

import java.util.Scanner;

/**
 *
 ***The Goal
 *
 * Your program must allow Thor to reach the light of power.
 *
 ***Rules
 *
 * Thor moves on a map which is 40 wide by 18 high.
 * Note that the coordinates (X and Y) start at the top left!
 * This means the most top left cell has the coordinates "X=0,Y=0" and the most bottom right one has the coordinates "X=39,Y=17".
 *
 * Once the program starts you are given:
 * the variable lightX: the X position of the light of power that Thor must reach.
 * the variable lightY: the Y position of the light of power that Thor must reach.
 * the variable initialTX: the starting X position of Thor.
 * the variable initialTY: the starting Y position of Thor.
 * At the end of the game turn, you must output the direction in which you want Thor to go among:
 * N
 * NE
 * E
 * SE
 * S
 * SW
 * W
 * NW
 * Each movement makes Thor move by 1 cell in the chosen direction.
 *
 ***Game Input
 *
 * The program must first read the initialization data from the standard input, then, in an infinite loop, provides on the standard output the instructions to move Thor.
 *
 * Initialization input
 * Line 1: 4 integers lightX lightY initialTX initialTY. (lightX, lightY) indicates the position of the light. (initialTX, initialTY) indicates the initial position of Thor.
 *
 * Input for a game round
 * Line 1: the number of remaining moves for Thor to reach the light of power: remainingTurns. You can ignore this data but you must read it.
 *
 * Output for a game round
 * A single line providing the move to be made: N NE E SE S SW W ou NW
 *
 ***Constraints
 *
 * 0 ≤ lightX < 40
 * 0 ≤ lightY < 18
 * 0 ≤ initialTX < 40
 * 0 ≤ initialTY < 18
 * Response time for a game round ≤ 100ms
 */
public class PowerOfThorEp1 {
    private static int lightX;
    private static int lightY;
    private static int thorX;
    private static int thorY;
    private static int remainingTurns;
    private static Scanner in = new Scanner(System.in);
    public static void main(String args[]) {
        loadLightOfPowerPosition();
        loadInitPosition();
    
        while (true) {
            remainingTurns = in.nextInt();
            moveThor();
        }
    }
    
    private static void loadInitPosition() {
        thorX = in.nextInt();
        thorY = in.nextInt();
    }
    private static void loadLightOfPowerPosition() {
        lightX = in.nextInt();
        lightY = in.nextInt();
    }
    private static void printDirection(String direction) {
        System.out.println(direction);
    }
    private static void moveThor() {
        if (thorNeedToMoveWest()) {
            moveXW();
        } else if (thorNeedToMoveEast()) {
            moveXE();
        } else { //just N or S
            moveNorthOrSouth();
        }
    }
    private static boolean thorNeedToMoveWest(){
        return thorX > lightX ? true : false;
    }
    private static boolean thorNeedToMoveEast(){
        return thorX < lightX ? true : false;
    }
    private static void moveXW(){
        thorX -= 1;
        if (thorY < lightY) {
            thorY += 1;
            printDirection("SW");
        } else if (thorY > lightY) {
            thorY -= 1;
            printDirection("NW");
        } else {
            printDirection("W");
        }
    }
    private static void moveXE(){
        thorX += 1;
        if (thorY < lightY) {
            thorY += 1;
            printDirection("SE");
        } else if (thorY > lightY) {
            thorY -= 1;
            printDirection("SE");
        } else {
            printDirection("E");
        }
    }
    private static void moveNorthOrSouth(){
        if (thorY < lightY) {
            thorY += 1;
            printDirection("S");
        } else if (thorY > lightY) {
            thorY -= 1;
            printDirection("N");
        } else {
            //its in light
        }
    }
}

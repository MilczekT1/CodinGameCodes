package medium;

/**
 *
 ***The Goal***
 *
 * You need to help Marvin and his clones (or is it the other way round?) reach the exit in order to help them escape the inside of the Infinite Improbability Drive.
 *
 ***Rules***
 *
 * The drive has a rectangular shape of variable size.
 * It is composed of several floors (0 = lower floor) and each floor has several possible positions that the clones can occupy (0 = leftmost position, width - 1 = rightmost position).
 *
 * The goal is to save at least one clone in a limited amount of rounds.
 *
 * The details:
 *
 * Clones appear from a unique generator at regular intervals, every three game turns.
 * The generator is located on floor 0. Clones exit the generator heading towards the right.
 *
 * Clones move one position per turn in a straight line, moving in their current direction.
 * A clone is destroyed by a laser if it is goes below position 0 or beyond position width - 1.
 * Elevators are scattered throughout the drive and can be used to move from one floor to the one above.
 * When a clone arrives on the location of an elevator, it moves up one floor.
 * Moving up one floor takes one game turn.
 * On the next turn, the clone continues to move in the direction it had before moving upward.
 * On each game turn you can either block the leading clone - meaning the one that got out the earliest - or do nothing.
 * Once a clone is blocked, you can no longer act on it. The next clone in line takes the role of "leading clone" and can be blocked at a later time.
 * When a clone moves towards a blocked clone, it changes direction from left to right or right to left.
 * It also changes direction when getting out of the generator directly on a blocked clone or when going up an elevator onto a blocked clone.
 * If a clone is blocked in front of an elevator, the elevator can no longer be used.
 * When a clone reaches the location of the exit, it is saved and disappears from the area.
 *
 * Note: For this puzzle there is at most one elevator per floor.
 *
 ***Victory Conditions***
 *
 * You win if at least one clone reaches the exit location in a limited amount of game rounds
 *
 * Note:
 * Don’t forget to run the tests by launching them from the “Test cases” window.
 * The tests provided are similar to the validation tests used to compute the final score but are slightly different.
 *
 ***Game Input***
 *
 * The program must first read the initialization data from standard input.
 * Then, within an infinite loop, read the contextual data (location of leading clone) from the standard input and provide the next instruction to standard output.
 *
 * Initialization input
 * Line 1: 8 integers:
 * nbFloors : number of floors in the area. A clone can move between floor 0 and floor nbFloors - 1
 * width : the width of the area. The clone can move without being destroyed between position 0 and position width - 1
 * nbRounds : maximum number of rounds before the end of the game
 * exitFloor : the floor on which the exit is located
 * exitPos : the position of the exit on its floor
 * nbTotalClones : the number of clones that will come out of the generator during the game
 * nbAdditionalElevators : not used for this first question, value is always 0
 * nbElevators : number of elevators in the area
 * nbElevators next lines: 2 integers elevatorFloor elevatorPos providing the floor and position of an elevator.
 *
 * Input for one game turn
 * Line 1: 2 integers cloneFloor clonePos and one string direction. cloneFloor and clonePos are the coordinates of the leading unblocked clone. direction indicates the current direction of the leading clone:
 * LEFT the clone is moving towards the left
 * RIGHT the clone moving towards the right
 * If there is no leading clone, the line values are: -1 -1 NONE. This can happen only when the clones which are already outside are all blocked and the next clone is not out yet. In this case, you may output action WAIT.
 *
 * Output for one game turn
 * A single line (including newline character) to indicate which action to take:
 * Either the keyword WAIT to do nothing.
 * or the keyword BLOCK to block the leading clone.
 *
 ***Constraints***
 * 1 ≤ nbFloors ≤ 15
 * 5 ≤ width ≤ 100
 * 10 ≤ nbRounds ≤ 200
 * 0 ≤ exitFloor, elevatorFloor < nbFloors
 * 0 ≤ exitPos , elevatorPos < width
 * -1 ≤ cloneFloor < nbFloors
 * -1 ≤ clonePos < width
 * 2 ≤ nbTotalClones ≤ 50
 * 0 ≤ nbElevators ≤ 100
 * Duration of one game turn: 100 ms
 **/
import java.util.Scanner;

public class DontPanic {
    private static String[][] area = null;
    private static int floorsAmount;
    private static int areaWidth;
    private static int maxNumberOfRounds;
    private static int floorWithExit;
    private static int exitPosition;
    private static int clonesAmount;
    private static int additionalElevators;
    private static int elevatorsAmount;
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        initVariables(in);
        
        int cloneFloor;
        int clonePos;
        String direction;
        
        while (true) {
            cloneFloor = in.nextInt(); // floor of the leading clone
            clonePos = in.nextInt(); // position of the leading clone on its floor
            direction = in.next(); // direction of the leading clone: LEFT or RIGHT
            
            if (clonePos < 0 || cloneFloor <0){
                System.out.println("WAIT");
                continue;
            }
            if (area[cloneFloor][clonePos] == "ELEVATOR"){
                System.out.println("WAIT");
            }
            else if (area[cloneFloor][clonePos] == "ELEVATOR_END"){
                int left = 0, right = 0;
                boolean leftFound = false, rightFound = false;
                
                int clonePosBis = clonePos;
                while (clonePosBis < areaWidth-1 && clonePosBis > 0){
                    clonePosBis--;
                    if (area[cloneFloor][clonePosBis] != "ELEVATOR"
                                && area[cloneFloor][clonePosBis] != "EXIT"){
                        left++;
                    }
                    else{
                        leftFound = true;
                        break;
                    }
                }
                
                clonePosBis = clonePos;
                while (clonePosBis < areaWidth-1 && clonePosBis > 0){
                    clonePosBis++;
                    if (area[cloneFloor][clonePosBis] != "ELEVATOR"
                                && area[cloneFloor][clonePosBis] != "EXIT"){
                        right++;
                    }
                    else{
                        rightFound = true;
                        break;
                    }
                }
                
                String newDirection = direction;
                if (rightFound && !leftFound){
                    newDirection = "RIGHT";
                }
                else if(leftFound && ! rightFound){
                    newDirection = "LEFT";
                }
                else if(leftFound && rightFound){
                    newDirection = left<right? "LEFT":"RIGHT";
                }
                
                if(newDirection.equals(direction))
                    System.out.println("WAIT");
                else
                    System.out.println("BLOCK");
                
            }
            else if (clonePos < areaWidth-1 && clonePos >= 0){
                System.out.println("WAIT");
            }
            else{
                if (clonesAmount >= 1) {
                    System.out.println("BLOCK");
                }
                else{
                    System.out.println("WAIT");
                }
            }
        }
    }
    
    private static void initVariables(Scanner in){
        floorsAmount = in.nextInt();
        areaWidth = in.nextInt();
        
        maxNumberOfRounds = in.nextInt();
        floorWithExit = in.nextInt();
        exitPosition = in.nextInt();
        clonesAmount = in.nextInt();
        additionalElevators = in.nextInt(); // ignore (always zero)
        elevatorsAmount = in.nextInt();
        
        initArea(in);
    }
    private static void initArea(Scanner in){
        area = fillMatrixWithEmpty(floorsAmount,areaWidth);
        area[floorWithExit][exitPosition] = "EXIT";
        area = putElevatorsIntoMatrix(area,in);
    }
    private static String[][] fillMatrixWithEmpty(int floorsAmount, int areaWidth){
        String[][] matrix = new String[floorsAmount][areaWidth]; // ELEVATOR, "", ELEVATOR_END
        for (int i=0; i< floorsAmount; i++){
            for (int j=0; j<areaWidth; j++){
                matrix[i][j] = "";
            }
        }
        return matrix;
    }
    private static String[][] putElevatorsIntoMatrix(String[][] area, Scanner in) {
        int elevFloor;
        int elevPosOnFloor;
        for (int i = 0; i < elevatorsAmount; i++) {
            elevFloor = in.nextInt();
            elevPosOnFloor = in.nextInt();
            area[elevFloor][elevPosOnFloor] = "ELEVATOR";
            if (elevFloor != floorsAmount-1){
                area[elevFloor+1][elevPosOnFloor] = "ELEVATOR_END";
            }
        }
        return area;
    }
}
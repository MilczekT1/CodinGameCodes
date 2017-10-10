package easy;

import java.util.Scanner;

/**
 *
 ***The Goal
 *
 * The goal for your program is to safely land the "Mars Lander" shuttle, the landing ship which contains the Opportunity rover.
 * Mars Lander is guided by a program, and right now the failure rate for landing on the NASA simulator is unacceptable.
 *
 * Note that it may look like a difficult problem, but in reality the problem is easy to solve.
 * This puzzle is the first level among three, therefore, we need to present you some controls you won't need in order to complete this first level.
 */
public class MarsLanderEp1 {
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        // the number of points used to draw the surface of Mars.
        int surfaceLengthInPoints = in.nextInt();
        for (int i = 0; i < surfaceLengthInPoints; i++) {
            int surfacePointX = in.nextInt(); // X coordinate of a surface point. (0 to 6999)
            int surfacePointY = in.nextInt(); // Y coordinate of a surface point. By linking all the points together in a sequential fashion, you form the surface of Mars.
        }
        
        while (true) {
            int X = in.nextInt();
            int Y = in.nextInt();
            int hSpeed = in.nextInt(); // the horizontal speed (in m/s), can be negative.
            int vSpeed = in.nextInt(); // the vertical speed (in m/s), can be negative.
            int fuel = in.nextInt(); // the quantity of remaining fuel in liters.
            int rotate = in.nextInt(); // the rotation angle in degrees (-90 to 90).
            int power = in.nextInt(); // the thrust power (0 to 4).
            
            if (vSpeed <-38){
                power = 4;
            }
            else{
                power = 3;
            }
            
            // 2 integers: rotate power. rotate is the desired rotation angle (should be 0 for level 1), power is the desired thrust power (0 to 4).
            System.out.println("0 " + power);
        }
    }
}

package easy;
/**
 *
 ***The Goal
 *
 * Casablanca’s hippodrome is organizing a new type of horse racing: duals.
 * During a dual, only two horses will participate in the race.
 * In order for the race to be interesting, it is necessary to try to select two horses with similar strength.
 *
 * Write a program which, using a given number of strengths, identifies the two closest strengths and shows their difference with an integer (≥ 0).
 *
 ***Game Input
 *
 * Line 1: Number N of horses
 * The N following lines: the strength Pi of each horse. Pi is an integer.
 *
 ***Output
 *
 * The difference D between the two closest strengths. D is an integer greater than or equal to 0.
 *
 ***Constraints
 *
 * 1 < N  < 100000
 * 0 < Pi ≤ 10000000
 **/
import java.util.Arrays;
import java.util.Scanner;

public class HorseRacingDuals {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        // Load Data
        int horseAmount = in.nextInt();
        int strengths[] = new int[horseAmount];
        for (int i = 0; i < horseAmount; i++) {
            strengths[i] = in.nextInt();
        }
    
        int difference = 10000001;
        int tempDiffHolder;
        // Find the smallest difference
        Arrays.sort(strengths);
        for (int i=0; i<horseAmount-1; i++){
            tempDiffHolder = strengths[i+1]-strengths[i];
            if (tempDiffHolder < difference){
                difference = tempDiffHolder;
            }
        }
        System.out.println(difference);
    }
}

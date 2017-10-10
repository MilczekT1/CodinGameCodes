package easy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 ***The Goal
 *
 * In this exercise, you have to analyze records of temperature to find the closest to zero.
 *
 ***Rules
 *
 * Write a program that prints the temperature closest to 0 among input data.
 * If two numbers are equally close to zero, positive integer has to be considered closest to zero (for instance, if the temperatures are -5 and 5, then display 5).
 *
 ***Game Input
 *
 * Your program must read the data from the standard input and write the result on the standard output.
 * Line 1: N, the number of temperatures to analyze
 * Line 2: A string with the N temperatures expressed as integers ranging from -273 to 5526
 *
 ***Output
 *
 * Display 0 (zero) if no temperatures are provided. Otherwise, display the temperature closest to 0.
 *
 ***Constraints
 *
 * 0 ≤ N < 10000
 **/
public class Temperatures {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int amountOfTemperatures = in.nextInt();
        in.nextLine();
        
        if (amountOfTemperatures == 0){
            System.out.println("0");
        }
        else{
            ArrayList<Integer> temps = new ArrayList<>(amountOfTemperatures);
            ArrayList<Integer> absoleteTemps = new ArrayList<>(amountOfTemperatures);
            
            for (int i=0; i<amountOfTemperatures; i++){
                temps.add(in.nextInt());
                absoleteTemps.add(Math.abs(temps.get(i)));
            }
            
            int tempHolder = absoleteTemps.get(0);
            int indexOfTemperatureToDisplay=0;
            for (int i= 0; i<amountOfTemperatures; i++){
                if (tempHolder >= absoleteTemps.get(i)){// solve sign issue ex. -5 5
                    if (tempHolder == absoleteTemps.get(i)
                                && temps.get(indexOfTemperatureToDisplay) > temps.get(i) ){
                        continue;
                    }
                    tempHolder = absoleteTemps.get(i);
                    indexOfTemperatureToDisplay = i;
                }
            }
            System.out.println(temps.get(indexOfTemperatureToDisplay));
        }
    }
}

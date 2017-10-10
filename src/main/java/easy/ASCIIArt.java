package easy;
/**
 *
 ***Your mission is to write a program that can display a line of text in ASCII art in a style you are given as input.
 *
 ***Game Input
 *
 * Line 1: the width L of a letter represented in ASCII art. All letters are the same width.
 * Line 2: the height H of a letter represented in ASCII art. All letters are the same height.
 * Line 3: The line of text T, composed of N ASCII characters.
 *
 * Following lines: the string of characters ABCDEFGHIJKLMNOPQRSTUVWXYZ? Represented in ASCII art.
 *
 ***Output
 * The text T in ASCII art.
 * The characters a to z are shown in ASCII art by their equivalent in upper case.
 * The characters that are not in the intervals [a-z] or [A-Z] will be shown as a question mark in ASCII art.
 *
 ***Constraints
 *
 * 0 < L < 30
 * 0 < H < 30
 * 0 < N < 200
 **/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ASCIIArt {
    private static int width;
    private static int height;
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        width = in.nextInt();
        height = in.nextInt();
        in.nextLine();
        String textRowToDisplay = in.nextLine().toUpperCase();
        
        int asciiNumbers[] = new int [textRowToDisplay.length()];
        convertAsciiToIndex(textRowToDisplay,asciiNumbers);
        
        int index;
        for (int i = 0; i < height; i++) {
            
            String ROW = in.nextLine();
            
            ArrayList<String> list = new ArrayList(27);
            loadSubstrings(ROW, list);
            
            for (int a=0; a<textRowToDisplay.length(); a++){
                index = asciiNumbers[a];
                System.out.print(list.get(index));
            }
            
            System.out.println();
        }
    }
    private static void loadSubstrings(String row, List<String> list){
        String substring;
        for (int a=0; a<27; a++){
            substring = row.substring(a*width,(a+1)*width);
            list.add(substring);
        }
    }
    
    private static void convertAsciiToIndex(String textRowToDisplay, int[] asciiNumbers){
        //Convert ascii number to index of letter ABCDEF a->0 , b->1 etc
        for(int i=0; i<textRowToDisplay.length(); i++){
            asciiNumbers[i] = (int) textRowToDisplay.charAt(i);
            if (asciiNumbers[i] >=65 && asciiNumbers[i]<=90){
                asciiNumbers[i] -=65;
            }
            else if(asciiNumbers[i] >=97 && asciiNumbers[i]<=122){
                asciiNumbers[i] -=97;
            }
            else{
                asciiNumbers[i] = 26;//question mark
            }
        }
    }
}

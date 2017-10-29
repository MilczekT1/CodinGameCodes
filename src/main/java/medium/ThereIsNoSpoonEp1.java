package medium;

import java.util.Scanner;

/**
 *
 ***The Goal***
 *
 * The game is played on a rectangular grid with a given size.
 * Some cells contain power nodes. The rest of the cells are empty.
 * The goal is to find, when they exist, the horizontal and vertical neighbors of each node.
 *
 ***Rules***
 *
 * To do this, you must find each (x1,y1) coordinates containing a node, and display the (x2,y2) coordinates of the next node to the right, and the (x3,y3) coordinates of the next node to the bottom within the grid.
 *
 * If a neighbor does not exist, you must output the coordinates -1 -1 instead of (x2,y2) and/or (x3,y3).
 *
 * You lose if:
 * You give an incorrect neighbor for a node.
 * You give the neighbors for an empty cell.
 * You compute the same node twice.
 * You forget to compute the neighbors of a node.
 *
 ***Victory Conditions***
 *
 * You win when all nodes have been correctly displayed.
 *
 ***Game Input***
 *
 * The program must first read the initialization data from standard input.
 * Then, provide to the standard output one line per instruction.
 *
 * Initialization input
 * Line 1: one integer width for the number of cells along the x axis.
 * Line 2: one integer height for the number of cells along the y axis.
 * Next height lines: A string  line  containing  width  characters.
 * A dot . represents an empty cell. A zero 0 represents a cell containing a node.
 *
 * Output for one game turn
 * One line per node. Six integers on each line:   x1  y1  x2  y2  x3  y3
 * Where:
 * (x1,y1) the coordinates of a node
 * (x2,y2) the coordinates of the closest neighbor on the right of the node
 * (x3,y3) the coordinates of the closest bottom neighbor
 * If there is no neighbor, the coordinates should be -1 -1.
 *
 ***Constraints***
 *
 * * 0 < width ≤ 30
 * 0 < height ≤ 30
 * 0 ≤ x1 < widt
 * 0 ≤ y1 < heigh
 * -1 ≤ x2, x3 < widt
 * -1 ≤ y2, y3 < heigh
 * Alloted response time to first output line ≤ 1s.
 * Response time between two output lines ≤ 100ms
 **/

public class ThereIsNoSpoonEp1 {
    private static int width;
    private static int height;
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        width = in.nextInt(); // the number of cells on the X axis
        height = in.nextInt(); // the number of cells on the Y axis
        in.nextLine();
        
        String[][] grid = createGrid(in);
        
        int[] x = {-1,-1,-1};
        int[] y = {-1,-1,-1};
        
        for (int i=0; i<height; i++){
            for (int j=0; j<width; j++){
                
                if (grid[i][j].equals("0")){
                    x[0] =j; y[0] = i;
                    findRightNode(i,j,grid,x,y);
                    findDownNode(i,j,grid,x,y);
                    
                    printCoordinates(x,y);
                    clearCoordinates(x,y);
                }
            }
        }
    }
    
    private static void clearCoordinates(int[] x, int[] y){
        for (int i=0; i<x.length; i++){
            x[i] = -1;
            y[i] = -1;
        }
    }
    private static void printCoordinates(int[] x, int[] y){
        System.out.println(x[0] + " " + y[0] + " " + x[1] + " " + y[1] + " " + x[2] + " " + y[2]);
    }
    
    private static void findRightNode(int i, int j, String[][] tab, int[] x, int[] y){
        for (int r=j+1;r<width;r++){
            if (tab[i][r].equals("0")){
                x[1] =r; y[1] = i;
                break;
            }
            else{
                x[1] =-1; y[1] = -1;
            }
        }
    }
    private static void findDownNode(int i, int j, String[][] tab, int[] x, int[] y){
        for (int d=i+1;d<height;d++){
            if (tab[d][j].equals("0")){
                x[2] =j; y[2] = d;
                break;
            }
            else{
                x[2] =-1; y[2] = -1;
            }
        }
    }
    
    private static String[][] createGrid(Scanner in){
        String[][] grid = new String[height][width];
        String line;
        for (int i = 0; i < height; i++) {
            line = in.nextLine();  // 0=>:0 .=>:1
            line = line.replace(".","1:");
            line = line.replace("0","0:");
            String[] substring = line.split(":",0);
        
            for (int a = 0; a<width;a++){
                grid[i][a] = substring[a];
            }
        }
        return grid;
    }
}

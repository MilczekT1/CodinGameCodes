package easy;
/**
 ***The Goal
 *
 * The city of Montpellier has equipped its streets with defibrillators to help save victims of cardiac arrests. The data corresponding to the position of all defibrillators is available online.
 *
 * Based on the data we provide in the tests, write a program that will allow users to find the defibrillator nearest to their location using their mobile phone.
 *
 ***Rules
 *
 * The input data you require for your program is provided in text format.
 * This data is comprised of lines, each of which represents a defibrillator.
 * Each defibrillator is represented by the following fields:
 *
 * A number identifying the defibrillator
 * Name
 * Address
 * Contact Phone number
 * Longitude (degrees)
 * Latitude (degrees)
 * These fields are separated by a semicolon (;).
 *
 * Beware: the decimal numbers use the comma (,) as decimal separator. Remember to turn the comma (,) into dot (.) if necessary in order to use the data in your program.
 *
 * DISTANCE
 * The distance d between two points A and B will be calculated using the following formula:
 * x = (longitudeB-longitudeA) * cos((latitudeA+latitudeB)/2)
 * y = (latitudeB-latitudeA)
 * d = sqrt(x^2 + y^2) *6371
 * Note: In this formula, the latitudes and longitudes are expressed in radians. 6371 corresponds to the radius of the earth in km.
 *
 * The program will display the name of the defibrillator located the closest to the user’s position.
 * This position is given as input to the program.
 *
 ***Game Input
 *
 * Line 1: User's longitude (in degrees)
 * Line 2: User's latitude (in degrees)
 * Line 3: The number N of defibrillators located in the streets of Montpellier
 * N next lines: a description of each defibrillator
 *
 ***Output
 *
 * The name of the defibrillator located the closest to the user’s position.
 *
 *** Constraints
 *
 * 0 < N < 10000
 **/
import java.util.*;

class Defibrillators {
    private static Double userLongitude;
    private static Double userLatitude;
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        setUserLocationInRadians(in);
        
        int defibAmount = in.nextInt();
        in.nextLine();
        
        double defib_long, defib_lat;
        double distance;
        
        String result = null;
        double distanceHolder = 45000; // > 2piR of earth
        for (int i = 0; i < defibAmount; i++) {
            String DEFIB = in.nextLine();
            String[] defibInfo = DEFIB.split(";",0);
            
            defib_long = stringToRadian(defibInfo[4]);
            defib_lat = stringToRadian(defibInfo[5]);
            
            distance = calculateDistance(defib_long, defib_lat);
            
            if ( distance < distanceHolder){
                distanceHolder = distance;
                result = defibInfo[1];
            }
        }
        System.out.println(result);
    }
    
    private static void setUserLocationInRadians(Scanner in){
        String userLongitudeStr = in.next();
        setLongitude(userLongitudeStr);
        
        String userLatitudeStr = in.next();
        setLatitude(userLatitudeStr);
    }
    private static void setLongitude(String userLongitudeStr){
        userLongitude = stringToRadian(userLongitudeStr);
    }
    private static void setLatitude(String userLatitudeStr){
        userLatitude = stringToRadian(userLatitudeStr);
    }
    private static double stringToRadian(String string){
        string = string.replace(",",".");
        return Math.toRadians(Double.parseDouble(string));
    }
    
    private static double calculateDistance(double defib_long, double defib_lat){
        double x = (defib_long - userLongitude) * Math.cos((userLatitude+defib_lat)/2.0);
        double y = defib_lat - userLatitude;
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2)) *6371;
    }
}

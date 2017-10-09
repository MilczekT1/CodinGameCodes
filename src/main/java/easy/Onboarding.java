package easy; /**
 * CodinGame planet is being attacked by slimy insectoid aliens.
 *
 ***The Goal
 *
 *Your program must destroy the enemy ships by shooting the closest enemy on each turn.
 *
 ***Rules
 *
 *On each start of turn (within the game loop), you obtain information on the two closest enemies:
 *enemy1 and dist1: the name and the distance to enemy 1.
 *enemy2 and dist2: the name and the distance to enemy 2.
 *Before your turn is over (end of the loop), output the value of either enemy1 or enemy2 to shoot the closest enemy.
 **/
import java.util.*;

class Onboarding {
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        while (true) {
            String enemy1 = in.next();
            int dist1 = in.nextInt();
            String enemy2 = in.next();
            int dist2 = in.nextInt();
            
            if (dist1 < dist2)
                System.out.println(enemy1);
            else
                System.out.println(enemy2);
        }
    }
}

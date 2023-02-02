package recursive;

import java.util.Scanner;

public class TowerMain {
    public static void main(String[] args) {
        System.out.println("enter number of disk");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        System.out.println("the step of move :");
        moveDisk(number,'A', 'B', 'C');
    }

    private static void moveDisk(int number, char fromTower,
                                 char toTower, char auxTower){
        if(number == 1){
            System.out.println("Move disk " + number + " from " +
                    fromTower + " to " + toTower);
        }else{
            moveDisk(number - 1, fromTower, auxTower, toTower);
            System.out.println("move disk " + number +
                    " from " + fromTower + " to " + toTower);
            moveDisk(number -1, auxTower, toTower, fromTower);
        }
    }
}

package horsealgorithm.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.*;

import horsealgorithm.util.*;
import horsealgorithm.domain.*;

/**
 * User Inteface of the application.
 */
public class UI {

    public void start() {

        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("In this application you can pair horses and riders");
        System.out.println("How many horses there are?");
        String n = reader.nextLine();
        int numberOfHorses = Integer.parseInt(n);
        System.out.println("How many riders there are?");
        int numberOfRiders = Integer.parseInt(reader.nextLine());
        System.out.println("*generating " + numberOfHorses + " horses and " + numberOfRiders + " riders*");
        Horse[] horses = new HorseFactory().makeHorses(numberOfHorses);
        Rider[] riders = new RiderFactory().makeRiders(numberOfRiders);
        Pair[] pairs = new PairFactory().pairAll(horses, riders);
        while (true) {
            System.out.println("Press \n" + "1: show horses \n" + "2: show riders \n"
                    + "3: calculate the compatibility of horses and riders \n4: calculate best horse for rider \n"
                    + "5: run tests \n " + "6: quit");
            int fun = Integer.parseInt(reader.nextLine());

            if (fun == 1) {
                printStuff(horses);
            } else if (fun == 2) {
                printStuff(riders);
            } else if (fun == 3) {
                printHorsesAndRidersCompatibility(pairs);
            } else if (fun == 4) {
                calculateBestPairs(horses, riders);
            } else if (fun == 5) {
                runTests();
            } else if (fun == 6) {
                System.out.println("Thanks, bye.");
                break;
            } else {
                System.out.println("Invalid command");
            }

        }

    }

    public void printStuff(Object[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i].toString());
            System.out.println("");
        }
    }

    public void printHorsesAndRidersCompatibility(Pair[] pairs) {
        Pair[] allScores = new MatchCalculator().calculateAllScores(pairs);
        for (Pair p : allScores) {
            System.out.println(p);
        }

    }

    public void calculateBestPairs(Horse[] horses, Rider[] riders) {
        Pair[] horsesRider = new MatchCalculator().GSAlgorithmForPairing(horses, riders);
        for (int i = 0; i < horsesRider.length; i++) {
            if(horsesRider[i] == null){
                continue;
            }
            System.out.println(horsesRider[i]);
        }
    }

    public void runTests(){
        new Tester().run();
    }

}
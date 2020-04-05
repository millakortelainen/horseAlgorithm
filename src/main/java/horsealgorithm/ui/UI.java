package horsealgorithm.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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
        ArrayList<Horse> horses = new HorseFactory().makeHorses(numberOfHorses);
        ArrayList<Rider> riders = new RiderFactory().makeRiders(numberOfRiders);
        boolean pairsAreCounted = false;
        while (true) {
            System.out.println("Press \n" + "1: show horses \n" + "2: show riders \n"
                    + "3: calculate the compatibility of horses and riders \n4: calculate best horse for rider \n"
                    + "5: quit");
            int fun = Integer.parseInt(reader.nextLine());

            if (fun == 1) {
                for (Horse h : horses) {
                    System.out.println(h);
                }

            } else if (fun == 2) {
                for (Rider r : riders) {
                    System.out.println(r);
                }

            } else if (fun == 3) {
                ArrayList<Pair> pairs = new PairFactory().pairAll(horses, riders);
                HashMap<Double, ArrayList<Pair>> scores = new MatchCalculator().calculateAllScores(pairs);
                for (Double key : scores.keySet()) {
                    System.out.println("Compatibility Level " + key);
                    for (Pair p : scores.get(key)) {
                        System.out.println(p.getHorse().getName() + " and " + p.getRider().getName());
                    }
                    System.out.println("");
                }
                pairsAreCounted = true;

            } else if (fun == 4) {
                if (!pairsAreCounted) {
                    ArrayList<Pair> pairs = new PairFactory().pairAll(horses, riders);
                    new MatchCalculator().calculateAllScores(pairs);
                    pairsAreCounted = true;
                }
                ArrayList<Pair> pairs = new MatchCalculator().GSAlgorithmForPairing(horses, riders);
                for (Pair p : pairs) {
                    System.out.println(p);
                }
                System.out.println("");
            } else if (fun == 5) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid command");
            }

        }

    }

}
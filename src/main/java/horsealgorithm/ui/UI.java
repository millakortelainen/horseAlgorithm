package horsealgorithm.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import horsealgorithm.util.*;
import horsealgorithm.domain.*;

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
        System.out.println("*generating " + numberOfHorses + " horses and" + numberOfRiders + " riders*");
        ArrayList<Horse> horses = new HorseFactory().makeHorses(numberOfHorses);
        ArrayList<Rider> riders = new RiderFactory().makeRiders(numberOfRiders);
        while (true) {
            System.out.println("Press \n" + "1: show horses \n" + "2: show riders \n"
                    + "3: calculate the compatibility of horses and riders\n" + "4: quit");
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
                ArrayList<Pair<Horse, Rider>> pairs = new PairFactory().pairAll(horses, riders);
                HashMap<Double, ArrayList<Pair<Horse, Rider>>> scores = new MatchCalculator().calculateAllScores(pairs);
                for (Double key : scores.keySet()) {
                    System.out.println("Compatibility Level " + key);
                    for (Pair<Horse, Rider> p : scores.get(key)) {
                        System.out.println(p.getKey().getName() + " and " + p.getValue().getName());
                    }
                    System.out.println("");
                }

            } else if (fun == 4) {
                break;
            } else {
                System.out.println("Invalid command");
            }

        }

    }

}
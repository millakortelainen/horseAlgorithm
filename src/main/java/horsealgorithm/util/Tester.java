package horsealgorithm.util;

import horsealgorithm.domain.*;

public class Tester {
    public void run() {
        int n = 50;
        MatchCalculator mc = new MatchCalculator();
        // first one is slow
        Horse[] horses = new HorseFactory().makeHorses(10);
        Rider[] riders = new RiderFactory().makeRiders(10);
        mc.GSAlgorithmForPairing(horses, riders);
        System.out.println("10 riders and horses");
        long sum = 0;
        
        for (int i = 0; i < n; i++) {
            long t = System.nanoTime();
            mc.GSAlgorithmForPairing(horses, riders);
            sum += System.nanoTime() - t;
        }
        long avg = sum / n;
        System.out.println("average " + (avg / 1000000.0) + "ms");

        System.out.println("100 riders and horses");
        sum = 0;
        horses = new HorseFactory().makeHorses(100);
        riders = new RiderFactory().makeRiders(100);
        for (int i = 0; i < n; i++) {
            long t = System.nanoTime();
            mc.GSAlgorithmForPairing(horses, riders);
            sum += System.nanoTime() - t;
        }
        avg = sum / n;
        System.out.println("average " + (avg / 1000000.0) + "ms");

        System.out.println("1000 riders and horses");
        sum = 0;
        horses = new HorseFactory().makeHorses(1000);
        riders = new RiderFactory().makeRiders(1000);
        for (int i = 0; i < n; i++) {
            long t = System.nanoTime();
            mc.GSAlgorithmForPairing(horses, riders);
            sum += System.nanoTime() - t;
        }
        avg = sum / n;
        System.out.println("average " + (avg / 1000000.0) + "ms");

        System.out.println("10000 riders and horses");
        sum = 0;
        horses = new HorseFactory().makeHorses(10000);
        riders = new RiderFactory().makeRiders(10000);
        for (int i = 0; i < n; i++) {
            long t = System.nanoTime();
            mc.GSAlgorithmForPairing(horses, riders);
            sum += System.nanoTime() - t;
        }
        avg = sum / n;
        System.out.println("average " + (avg / 1000000.0) + "ms");

        System.out.println("100000 riders and horses");
        sum = 0;
        horses = new HorseFactory().makeHorses(100000);
        riders = new RiderFactory().makeRiders(100000);
        for (int i = 0; i < n; i++) {
            long t = System.nanoTime();
            mc.GSAlgorithmForPairing(horses, riders);
            sum += System.nanoTime() - t;
        }
        avg = sum / n;
        System.out.println("average " + (avg / 1000000.0) + "ms");

        System.out.println("****");
        horses = new HorseFactory().makeHorses(1000);
        riders = new RiderFactory().makeRiders(1000);
        Pair[] pairs = new PairFactory().pairAll(horses, riders);
        for (int i = 0; i < n; i++) {
            long t = System.nanoTime();
            mc.calculateAllScores(pairs);
            System.out.println(System.nanoTime() - t);
        }

    }
}
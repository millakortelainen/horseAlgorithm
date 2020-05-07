package horsealgorithm.util;

import horsealgorithm.domain.*;

public class Tester {
    public void run() {
        int n = 50;
        MatchCalculator mc = new MatchCalculator();
        SkillLevel sl = new SkillLevel();
        Type t = new Type();
        // first one is slow
        Horse[] horses = new HorseFactory().makeHorses(10, t, sl);
        Rider[] riders = new RiderFactory().makeRiders(10, sl, t);
        mc.gsAlgorithmForPairing(horses, riders);
        System.out.println("10 riders and horses");
        long sum = 0;
        
        for (int i = 0; i < n; i++) {
            long time = System.nanoTime();
            mc.gsAlgorithmForPairing(horses, riders);
            sum += System.nanoTime() - time;
        }
        long avg = sum / n;
        System.out.println("average " + (avg / 1000000.0) + "ms");

        System.out.println("100 riders and horses");
        sum = 0;
        horses = new HorseFactory().makeHorses(100, t, sl);
        riders = new RiderFactory().makeRiders(100, sl, t);
        for (int i = 0; i < n; i++) {
            long time = System.nanoTime();
            mc.gsAlgorithmForPairing(horses, riders);
            sum += System.nanoTime() - time;
        }
        avg = sum / n;
        System.out.println("average " + (avg / 1000000.0) + "ms");

        System.out.println("1000 riders and horses");
        sum = 0;
        horses = new HorseFactory().makeHorses(1000, t, sl);
        riders = new RiderFactory().makeRiders(1000, sl, t);
        for (int i = 0; i < n; i++) {
            long time = System.nanoTime();
            mc.gsAlgorithmForPairing(horses, riders);
            sum += System.nanoTime() - time;
        }
        avg = sum / n;
        System.out.println("average " + (avg / 1000000.0) + "ms");

        System.out.println("10000 riders and horses");
        sum = 0;
        horses = new HorseFactory().makeHorses(10000, t, sl);
        riders = new RiderFactory().makeRiders(10000,sl, t);
        for (int i = 0; i < n; i++) {
            long time = System.nanoTime();
            mc.gsAlgorithmForPairing(horses, riders);
            sum += System.nanoTime() - time;
        }
        avg = sum / n;
        System.out.println("average " + (avg / 1000000.0) + "ms");

        System.out.println("100000 riders and horses");
        sum = 0;
        horses = new HorseFactory().makeHorses(100000, t, sl);
        riders = new RiderFactory().makeRiders(100000, sl, t);
        for (int i = 0; i < n; i++) {
            long time = System.nanoTime();
            mc.gsAlgorithmForPairing(horses, riders);
            sum += System.nanoTime() - time;
        }
        avg = sum / n;
        System.out.println("average " + (avg / 1000000.0) + "ms");

        System.out.println("****");
        horses = new HorseFactory().makeHorses(1000, t, sl);
        riders = new RiderFactory().makeRiders(1000, sl, t);
        Pair[] pairs = new PairFactory().pairAll(horses, riders);
        for (int i = 0; i < n; i++) {
            long time = System.nanoTime();
            mc.calculateAllScores(pairs);
            System.out.println(System.nanoTime() - time);
        }

    }
}
package horsealgorithm.util;

import horsealgorithm.domain.*;

public class Tester {
    MatchCalculator mc = new MatchCalculator();
    SkillLevel sl = new SkillLevel();
    RandomGenerator rg = new RandomGenerator();
    Type t = new Type();
    ScoreCalculator sc = new ScoreCalculator();

    public void run() {
        int n = 50;
        // first one is slow
        Horse[] horses = new HorseFactory().makeHorses(10, t, sl, rg);
        Rider[] riders = new RiderFactory().makeRiders(10, sl, t, rg);
        mc.gsAlgorithmForPairing(horses, riders, sc);

        // real tests
        testGSA(n, 10);
        testGSA(n, 100);
        testGSA(n, 1000);
        testGSA(n, 10000);
        testGSA(n, 100000);
        testGSA(n, 1000000);

        System.out.println("****");
        System.out.println("Testing brute force algorithm");
        Pair[] pairs = new PairFactory().pairAll(horses, riders);
        mc.calculateAllScores(pairs);
        testBrute(n, 1);
        testBrute(n, 10);
        testBrute(n, 100);
        testBrute(n, 1000);
        testBrute(n, 10000);

    }

    public void testGSA(int n, int numberOfHorsesAndRiders) {
        System.out.println(numberOfHorsesAndRiders + " riders and horses");
        long sum = 0;
        Horse[] horses = new HorseFactory().makeHorses(numberOfHorsesAndRiders, t, sl, rg);
        Rider[] riders = new RiderFactory().makeRiders(numberOfHorsesAndRiders, sl, t, rg);
        for (int i = 0; i < n; i++) {
            long time = System.nanoTime();
            mc.gsAlgorithmForPairing(horses, riders, sc);
            sum += System.nanoTime() - time;
        }
        long avg = sum / n;
        System.out.println("average " + (avg / 1000000.0) + "ms");
    }

    public void testBrute(int n, int numberOfHorsesAndRiders) {
        System.out.println(numberOfHorsesAndRiders + "riders and horses");

        long sum = 0;
        Horse[] horses = new HorseFactory().makeHorses(numberOfHorsesAndRiders, t, sl, rg);
        Rider[] riders = new RiderFactory().makeRiders(numberOfHorsesAndRiders, sl, t, rg);
        Pair[] pairs = new PairFactory().pairAll(horses, riders);
        for (int i = 0; i < n; i++) {
            long time = System.nanoTime();
            mc.calculateAllScores(pairs);
            sum += System.nanoTime() - time;
        }
        long avg = sum / n;
        System.out.println("average " + (avg / 1000000.0) + "ms");
    }
}
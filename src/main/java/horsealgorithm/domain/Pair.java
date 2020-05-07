package horsealgorithm.domain;

public class Pair {
    private Horse horse;
    private Rider rider;
    private double score;

    /**
     * Constructor for pair. 
     * Sets pair's score to -1.
     * 
     * @param horse
     * @param rider
     */
    public Pair(Horse horse, Rider rider) {
        this.horse = horse;
        this.rider = rider;
        this.score = -1;
    }

    /**
     * Constructor for pair with score.
     * 
     * @param horse
     * @param rider
     * @param score
     */
    public Pair(Horse horse, Rider rider, double score) {
        this.horse = horse;
        this.rider = rider;
        this.score = score;
    }

    /**
     * @param horse the horse to set
     */
    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    /**
     * @param rider the rider to set
     */
    public void setRider(Rider rider) {
        this.rider = rider;
    }

    /**
     * @return the horse
     */
    public Horse getHorse() {
        return horse;
    }

    /**
     * @return the rider
     */
    public Rider getRider() {
        return rider;
    }

    /**
     * @param score the score to set
     */
    public void setScore(double score) {
        this.score = score;
    }

    /**
     * @return the score
     */
    public double getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }

        if (!(o instanceof Pair)) {
            return false;
        }

        Pair p2 = (Pair) o;

        if (this.rider.equals(p2.getRider()) 
                && this.horse.equals(p2.getHorse()) 
                && this.score == p2.getScore()) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "" + horse.getName() + ", " + rider.getName() + ", " + this.score + "\n";
    }
}
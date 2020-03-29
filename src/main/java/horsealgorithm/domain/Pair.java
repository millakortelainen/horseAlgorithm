package horsealgorithm.domain;

public class Pair {
    private Horse horse;
    private Rider rider;

    public Pair(Horse horse, Rider rider) {
        this.horse = horse;
        this.rider = rider;
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

    @Override
    public String toString() {
        return "" + horse + ", " + rider + "";
    }

    public int compareTo(Pair p) {
        if (p.getHorse().getId() == this.horse.getId() && p.getRider().getId() == this.rider.getId()) {
            return 1;
        }
        return 0;
    }

}
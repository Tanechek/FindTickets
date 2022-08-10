public class Ticket implements Comparable<Ticket>{
    int id;
    int price;
    String fromAirport;
    String toAirport;
    int flyTime;

    public Ticket(int id, int price, String fromAirport,String toAirport , int flyTime) {
        this.id = id;
        this.price = price;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.flyTime = flyTime;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {this.id = id;}
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getToAirport() {
        return toAirport;
    }
    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }
    public String getFromAirport(){return fromAirport;}
    public void setFromAirport (String fromAirport){this.fromAirport = fromAirport;}
    public int getFlyTime(){return flyTime;}
    public void setFlyTime(int flyTime){this.flyTime = flyTime;}

    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price){
            return -1;
        } else if (this.price > o.price){
            return 1;
        } else {
            return 0;
        }
    }
}

package task2;

public class tour {
    private String name;
    private String country;
    private String city;
    private String hotel_name;
    private int stars;
    private int duration;
    private int amount;
    private double cost;
    private String company;

    tour(String n, String c, String ci, String hn, int s, int d, int a, double cos, String com) throws Exception{
        name = n;
        country = c;
        city = ci;
        hotel_name = hn;
        stars = s;
        duration = d;
        amount = a;
        cost = cos;
        company = com;
    }

    tour(String t){
        String[] k = t.split(" ");
        name = k[0];
        country = k[1];
        city = k[2];
        hotel_name = k[3];
        stars = Integer.parseInt(k[4]);
        duration = Integer.parseInt(k[5]);
        amount = Integer.parseInt(k[6]);
        cost = Double.parseDouble(k[7]);
        company = k[8];
    }

    @Override
    public String toString() {
        return name + ' ' + country + ' ' + city + ' ' + hotel_name + ' ' + stars + ' ' + duration + ' ' + amount + ' ' + cost + ' ' + company;
    }

    public String get_c_ci(String n){
        if (n == name){
            return city + " " + country;
        }
        return "";
    }

    public boolean same_cost(tour t){
        return cost == t.cost;
    }

    public void add10 (){
        cost += cost/10;
    }
}

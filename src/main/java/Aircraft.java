import static java.lang.System.exit;


interface Sorting_Interfaces {
    public void sort_flight(int[] a);
}
class Sortings implements Sorting_Interfaces {

    public void sort_flight(int[] a) {
        for(int i = 0; i < a.length; i++) {
            for(int j = i+1; j < a.length; j++) {
                if(a[i] < a[j]) {
                    int buf = a[i];
                    a[i] = a[j];
                    a[j] = buf;
                }
            }
        }
        System.out.println("Sorting plane by length");
        for(int i=0; i<a.length; i++) {
            System.out.print(a[i] + "km" + " ");
        }
    }
}
interface ShowFluels {
    public void show_fluel(int[] a, int num1, int num2);
}
class Fluels implements ShowFluels {

    public void show_fluel(int[] a, int num1, int num2) {
        int size = a.length;
        int [] aa = new int [size];
        for(int i =0; i<size; i++) {
            aa[i] = (int)a[i];
        }
        for(int i = 0; i < a.length; i++) {
            if(aa[i] >= num1 && aa[i] <= num2) {
                System.out.println("Fluel= " + a[i] + " l" + " ");
            }
        }
    }
}

interface Aircraft_Interfaces {
    public String getRegID();
    public int getAltitude();
    public void sendRadioMsg(String msg);
    public boolean takeOff(int alt);
    public int weight_plane(int weight);
    public int place_counter(int places);
}

class Aircrafts2 implements Aircraft_Interfaces {
    //Every craft has a unique registration ID (e.g. TC-ACA)
    public static final int MAX_ALT = 50000;
    private String regID;
    protected int altitude;protected int weight;
    protected int places; protected int flight; protected int fluel;

    public Aircrafts2() { }

    public Aircrafts2(String id) {
        regID = id;
    }

    public String getRegID() {
        return regID;
    }

    public int getAltitude() {
        return altitude;
    }

    public void sendRadioMsg(String msg) {
        System.out.printf("%s to Base: %s%n", regID, msg);
    }

    public boolean takeOff(int alt) {
        if (alt > MAX_ALT) {
            sendRadioMsg("Can’t go to " + alt + " m.");
            return false;
        }
        sendRadioMsg("Taking off!");
        altitude = alt;
        return true;
    }

    public int weight_plane(int weight) {
        this.weight = weight;
        if(this.weight <= 100000) {
            System.out.println("Plane is airy");
            exit(0);
        } else if(this.weight >= 300000){
            System.out.println("Plane is too heavy");
            exit(0);
        }
        System.out.println("Weight of plane is " + this.weight + " kg");
        return this.weight;
    }

    public int place_counter(int places) {
        this.places = places;
        System.out.println("Places in plane are " + this.places);
        return this.places;
    }
    public int flight(int flight) {
        this.flight = flight;
        System.out.println("Flight of plane is " + this.flight + " km");
        return this.flight;
    }
    public int fluel(int fluel) {
        this.fluel = fluel;
        if(this.fluel <= 10000) {
            System.out.println("It's very small count of fluel");
            exit(0);
        }
        else if(this.fluel >= 80000) {
            System.out.println("It's too much fluel");
        }
        System.out.println("Fluels in plane are " + this.fluel + " l");
        return this.fluel;
    }
}

class Helicopters2 extends Aircrafts2 {

    public Helicopters2(String regID) {
        super(regID);
    }
    public boolean takeOff(int alt) {
        System.out.println("Starting rotor...");
        return super.takeOff(alt);
    }
    public int weight_plane(int weight) {
        if(weight <= 100000) {
            System.out.println("Plane is airy");
            exit(0);
        }
        else if(weight >= 300000){
            System.out.println("Plane is too heavy");
            exit(0);
        }
        return super.weight_plane(weight);
    }
    public int place_counter(int places) {
        return super.place_counter(places);
    }
    public int flight(int flight) {
        return super.flight(flight);
    }
    public int fluel(int fluel) {
        if(fluel <= 10000) {
            System.out.println("It's very small count of fluel");
            exit(0);
        }
        else if(fluel >= 80000) {
            System.out.println("It's too much fluel");
        }
        return super.fluel(fluel);
    }
}

class Airports {
    private int runwayLength; private String code;
    public Airports(int rwLen , String code) {
        runwayLength = rwLen;
        this.code = code;
    }
    public int getRunwayLength() {
        return runwayLength;
    }
    public boolean getPermission(Aircrafts2 a) {
        if (a instanceof MilitaryPlanes ) return false;
        return true;
    }
}
class Airplanes2 extends Aircrafts2 {
    private int minRunway; private Airports myAirport;
    public Airplanes2() { }
    public Airplanes2(String regID, int minRunway) {
        super(regID);
        this.minRunway = minRunway;
    }
    public Object setAirport(Airports a) {
        myAirport = a;
        return myAirport;
    }
    public boolean takeOff(int alt) {
        if (myAirport == null) {
            sendRadioMsg("No airport!");
            return false;
        }
        sendRadioMsg("Starting engine.");
        sendRadioMsg("Moving to runway.");
        if (!myAirport.getPermission(this)) {
            sendRadioMsg("No permission to take-off!");
            return false;
        }
        if (myAirport.getRunwayLength() < minRunway) {
            sendRadioMsg("Runway too short!");
            return false;
        }
        return super.takeOff(alt);
    }
    public int weight_plane(int weight) {
        if(weight <= 100000) {
            System.out.println("Plane is airy");
            exit(0);
        }
        else if(weight >= 300000){
            System.out.println("Plane is too heavy");
            exit(0);
        }
        return super.weight_plane(weight);
    }
    public int place_counter(int places) {
        return super.place_counter(places);
    }
    public int flight(int flight) {
        return super.flight(flight);
    }
    public int fluel(int fluel) {
        if(fluel <= 10000) {
            System.out.println("It's very small count of fluel");
            exit(0);
        }
        else if(fluel >= 80000) {
            System.out.println("It's too much fluel");
        }
        return super.fluel(fluel);
    }
}

class MilitaryPlanes extends Airplanes2 {
    public MilitaryPlanes (String regID ,int rl) {
        super(regID , rl); }
}
class Airliners extends Airplanes2 {
    public Airliners() { }
    public Airliners(String id, String Model, int rl) {
        super(Model + "-" + id, rl);
    }
    public Object setAirport(Airports a) {
        return super.setAirport(a);
    }
    public boolean takeOff(int alt) {
        sendRadioMsg("Turning on seatbelt sign.");
        if (super.takeOff(alt))
        {
            sendRadioMsg("Turning off seatbelt sign.");
            return true;
        }
        else
            return false;
    }
    public int weight_plane(int weight) {
        if(weight <= 100000) {
            System.out.println("Plane is airy");
            exit(0);
        }
        else if(weight >= 300000){
            System.out.println("Plane is too heavy");
            exit(0);
        }
        return super.weight_plane(weight);
    }
    public int place_counter(int places) {
        return super.place_counter(places);
    }
    public int flight(int flight) {
        return super.flight(flight);
    }
    public int fluel(int fluel) {
        if(fluel <= 10000) {
            System.out.println("It's very small count of fluel");
            exit(0);
        }
        else if(fluel >= 80000) {
            System.out.println("It's too much fluel");
        }
        return super.fluel(fluel);
    }
    public void sumWeight_Places(int[] placess, int[] weight) {
        int size1 = placess.length;
        int size2 = weight.length;
        int [] p = new int[size1];
        int [] w = new int[size2];
        int sum_w = 0; int sum_p = 0;
        for(int i =0; i<p.length; i++) {
            p[i] = placess[i];
            sum_p = sum_p + p[i];
        }
        for(int i =0; i<w.length; i++) {
            w[i] = weight[i];
            sum_w = sum_w + w[i];
        }
        System.out.println("Sum places of plane " + sum_p + " " + "Sum weigth of planes " + sum_w);
    }
}
class BS747 extends Airliners {
    public BS747(String id) {
        super(id, "BS747", 7000);
    }
    public Object setAirport(Airports a) {
        return super.setAirport(a);
    }
    public boolean takeOff(int alt) {
        return super.takeOff(alt);
    }
    public int weight_plane(int weight) {
        if(weight <= 100000) {
            System.out.println("Plane is airy");
            exit(0);
        }
        else if(weight >= 300000){
            System.out.println("Plane is too heavy");
            exit(0);
        }
        return super.weight_plane(weight);
    }
    public int place_counter(int places) {
        return super.place_counter(places);
    }
    public int flight(int flight) {
        return super.flight(flight);
    }
    public int fluel(int fluel) {
        if(fluel <= 10000) {
            System.out.println("It's very small count of fluel");
            exit(0);
        }
        else if(fluel >= 80000) {
            System.out.println("It's too much fluel");
        }
        return super.fluel(fluel);
    }
}
class BS7471 extends Airliners {

    public BS7471(String id) {
        super(id, "BS7471", 7000);
    }
    public Object setAirport(Airports a) {
        return super.setAirport(a);
    }
    public boolean takeOff(int alt) {
        return super.takeOff(alt);
    }
    public int weight_plane(int weight) {
        if(weight <= 100000) {
            System.out.println("Plane is airy");
            exit(0);
        }
        else if(weight >= 300000){
            System.out.println("Plane is too heavy");
            exit(0);
        }
        return super.weight_plane(weight);
    }
    public int place_counter(int places) {
        return super.place_counter(places);
    }
    public int flight(int flight) {
        return super.flight(flight);
    }
    public int fluel(int fluel) {
        if(fluel <= 10000) {
            System.out.println("It's very small count of fluel");
            exit(0);
        }
        else if(fluel >= 80000) {
            System.out.println("It's too much fluel");
        }
        return super.fluel(fluel);
    }
}

class FS16 extends MilitaryPlanes {

    public FS16(String id) {
        super("F16-" + id, 1000);
    }
    public boolean takeOff(int alt) {
        return super.takeOff(alt);
    }
}
public class Aircraft {
    public static void main(String[] args) {
        // write your code here
        System.out.println("Hello World!");
        Airports a = new Airports(9000,"0956");
        Airports ff = new Airports(9000,"0956");
        //simulator
        BS747 b = new BS747("Airline1");
        b.setAirport(a);
        System.out.println(b.takeOff(7000));
        b.weight_plane(234000);
        b.place_counter(700);
        System.out.println("");
        BS7471 c = new BS7471("Airline1");
        c.setAirport(ff);
        System.out.println(c.takeOff(7000));
        //start sorting
        BS747 d = new BS747("Airline3");
        d.setAirport(a);
        BS747 g = new BS747("Airline4");
        g.setAirport(a);
        BS747 h = new BS747("Airline5");
        h.setAirport(a);
        Sortings srt = new Sortings();
        Fluels fluu = new Fluels();
        int [] flight = {b.flight(800), c.flight(600), d.flight(100), g.flight(900),
                h.flight(200)};
        srt.sort_flight(flight);
        int [] flu = {b.fluel(70000), c.fluel(60000), d.fluel(30000),
                g.fluel(50000), h.fluel(40000)};
        fluu.show_fluel(flu, 30000, 60000);
        int [] gen_weigth = {b.weight_plane(165000), c.weight_plane(145000),
                d.weight_plane(120000), g.weight_plane(135000), h.weight_plane(130000)};
        int [] gen_place = {b.place_counter(700), c.place_counter(400),
                d.place_counter(100), g.place_counter(300), h.place_counter(600)};
        Airliners arit = new Airliners();
        arit.sumWeight_Places(gen_place, gen_weigth);
    }
}
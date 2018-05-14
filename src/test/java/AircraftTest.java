/**
 * Test everything from previous lab #5
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class AircraftTest {
    @BeforeClass
    public static void Before() {
        System.out.println("Before Aircraft.java");
    }
    @Test
    public void Testing() {
        Airports a = new Airports(9000,"0956");
        //simulator
        BS747 b = new BS747("Airplane");
        b.setAirport(a);
        System.out.println(b.takeOff(7000));
        b.weight_plane(126000);
        b.place_counter(700);
    }
    @AfterClass
    public static void AfterClass() {
        System.out.println("After class");
    }
}

/**
 * Testing Reflection class which I did
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class ReflectionTest {
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before ParsingWithJSON.class");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("After ParsingWithJSON.class");
    }
    @Test
    public void Testing() throws Exception {
        Airports a = new Airports(9000, "0956");
        //simulator
        BS747 b = new BS747("Airline1");
        b.setAirport(a);
        System.out.println(b.takeOff(7000));
        b.weight_plane(234000);
        b.place_counter(700);

        System.out.println("Next");
        System.out.print(ObjectUtilss.toString(b, true));
    }
    @Ignore("Message for ignored test")
    @Test
    public void ignoredTest() {
        System.out.println("will not print it");
    }
}

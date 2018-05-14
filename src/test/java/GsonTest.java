/**
 * Testing Gson class which I used
 */

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonTest {
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before ParsingWithJSON.class");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("After ParsingWithJSON.class");
    }
    @Test
    public void TestingGson() {
        Airports a = new Airports(9000, "0956");
        //simulator
        BS747 b = new BS747("Airline1");
        b.setAirport(a);
        System.out.println(b.takeOff(7000));
        b.weight_plane(234000);
        b.place_counter(700);

        List<BS747> list = new ArrayList<BS747>();
        for (int i = 0; i < 1; i++) {
            list.add(b);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<BS747>>() {
        }.getType();
        String json = gson.toJson(list, type);
        System.out.println(json);
    }
}

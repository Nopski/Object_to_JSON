import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.beans.binding.ObjectExpression;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class ObjectUtilss {
    public static String toString(Object object, boolean recursive) {
        if (object == null) return "null";

        Class<?> clazz = object.getClass();
        StringBuilder sb = new StringBuilder(clazz.getSimpleName()).append(" [{");

        while (clazz != null && !clazz.equals(Object.class)) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                if (!Modifier.isStatic(f.getModifiers())) {
                    try {
                        f.setAccessible(true);
                        sb.append(f.getName()).append(":").append(f.get(object)).append(",");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (!recursive) {
                break;
            }
            clazz = clazz.getSuperclass();
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        return sb.append("}]").toString();
    }
}

public class ParsingWithJSON {
    public static void main(String[] args) throws Exception {
        Airports a = new Airports(9000,"0956");
        //simulator
        BS747 b = new BS747("Airline1");
        b.setAirport(a);
        System.out.println(b.takeOff(7000));
        b.weight_plane(234000);
        b.place_counter(700);

        //using JSON
        List<BS747> list = new ArrayList<BS747>();
        for(int i=0; i<1; i++) {
            list.add(b);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<BS747>>(){}.getType();
        String json = gson.toJson(list, type);
        System.out.println(json);
        System.out.println();

        BS7471 c = new BS7471("Airline1");
        c.setAirport(a);
        //System.out.println(c.takeOff(7000));
        //start sorting
        BS747 d = new BS747("Airline3");
        d.setAirport(a);
        BS747 g = new BS747("Airline4");
        g.setAirport(a);
        BS747 h = new BS747("Airline5");
        h.setAirport(a);
        BS747 t = new BS747("Airline3");
        t.setAirport(a);

        //Using Reflection API
        System.out.println("Next");
        System.out.print(ObjectUtilss.toString(b, true));
    }

}

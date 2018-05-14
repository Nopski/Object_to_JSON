/**
 *
 * Here are two methods make a json file to access
 * and get methods of object and values
 * of variables.
 *
 * First method is work with Google's library.
 * Which called Gson. I add it in maven.
 *
 * The next method(second) is using Reflection API.
 * This API is encluded in Java.
 * For getting all methods of objects or
 * getting all values of variables
 * I used classes like Fields and Modifier
 *
 */

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.beans.binding.ObjectExpression;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.*;
import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Accessing to object. Get all his methods and values of variables
 */
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
    //making files
    private static final String FILENAME = "C:\\Users\\UZER\\Documents\\Java\\Java_object_to_JSON\\jsonfile.json";
    private static final String FILENAME1 = "C:\\Users\\UZER\\Documents\\Java\\Java_object_to_JSON\\acr.bin";

    public static void main(String[] args) throws Exception {
        Airports a = new Airports(9000, "0956");
        //simulator
        BS747 b = new BS747("Airline1");
        b.setAirport(a);
        System.out.println(b.takeOff(7000));
        b.weight_plane(234000);
        b.place_counter(700);

        //using JSON
        List<BS747> list = new ArrayList<BS747>();
        for (int i = 0; i < 1; i++) {
            list.add(b);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<BS747>>() {
        }.getType();
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
        BS747 k = new BS747("Airline3");
        k.setAirport(a);
        BS747 l = new BS747("Airline3");
        l.setAirport(a);
        BS747 p = new BS747("Airline3");
        p.setAirport(a);
        BS747 n = new BS747("Airline3");
        n.setAirport(a);

        //Using Reflection API
        System.out.println("Next");
        System.out.print(ObjectUtilss.toString(b, true));

        //write to file
        //making JSON file
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter(FILENAME);
            bw = new BufferedWriter(fw);
            bw.write(ObjectUtilss.toString(b, true));
            System.out.println();
            System.out.println("Done. Everything has written to file");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        //read file
        //read JSON file
        System.out.println("Reading from file");
        BufferedReader br = null;
        FileReader fr = null;
        try {
            //br = new BufferedReader(new FileReader(FILENAME));
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        /**NEXT**/
        //with lab6
        int [] pp = new int[]{b.flight(800), c.flight(600), d.flight(100), g.flight(300), h.flight(400),
                t.flight(500), k.flight(900), l.flight(700), p.flight(200), n.flight(1000)};
        System.out.println();
        System.out.println("Other set");
        Set<Integer> set = new Set<Integer>();
        set.create(pp);

        //using Reflection for lab6
        System.out.println("Reflection");
        Class cls = set.getClass(); //get class. Return a hash code value for this object
        System.out.println("The name of class is " + cls.getSimpleName());//output name of class
        Constructor constructor = cls.getConstructor();// get all constructors
        System.out.println("The name of constructor is " + constructor.getName());//show name of constructor
        System.out.println("Public methods are");
        Method[] methods = cls.getMethods();//get all methods of my class
        for(Method method : methods) {
            System.out.println(method.getName());//show all methods
        }
        System.out.println("Method m");
        Method methodcall = cls.getDeclaredMethod("create", int[].class);
        methodcall.invoke(set, pp);
        System.out.println("Method mm");
        Method methodcall1 = cls.getDeclaredMethod("size");
        methodcall1.invoke(set);
        System.out.println(methodcall1.invoke(set));
        System.out.println("Another");
        System.out.print(ObjectUtilss.toString(set, true));

        //write file
        BufferedWriter bww = null;
        FileWriter fww = null;

        try {
            fww = new FileWriter(FILENAME1);
            bww = new BufferedWriter(fww);
            bww.write(cls.getSimpleName() + "\n");
            for(Method method: methods) {
                bww.write(method.getName() + "\n");
            }
            System.out.println();
            System.out.println("Done. Everything has written to file");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bww != null)
                    bww.close();
                if (fww != null)
                    fww.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        //read file
        System.out.println("Reading from file");
        try {
            FileReader frrr = new FileReader(FILENAME1);
            int i;
            while ((i = frrr.read()) != -1)
                System.out.print((char) i);
            frrr.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

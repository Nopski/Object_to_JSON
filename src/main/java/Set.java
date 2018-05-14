import java.util.ArrayList;
import java.util.Scanner;

public class Set<E> implements SetInterface{
    private int[] s; private int size;private ArrayList<E> ll;
    private Object[] arr;

    public Set() {

    }
    public Set(ArrayList<E> list) {
        ll = new ArrayList<E>();
        size = list.size();
        s = new int [size];
        for(int i=0; i<s.length; i++) {
            ll.add(list.get(i));
        }
    }
    public Set(Object[] obj) {
        size = obj.length;
        arr = new Object[size];
        for(int i=0; i<size; i++) {
            arr[i] = obj[i];
        }
    }

    public void create() {
        Scanner input = new Scanner(System.in);
        size = input.nextInt();
        if(size < 10) {
            System.out.println("Array is small");
            System.exit(0);
        }
        s = new int[size];
        for(int i=0; i<size; i++) {
            //s[i] = input.nextInt();
            s[i] = (int) (Math.random() * 256);
        }
    }

    public void create(Object[] obj) {
        try {
            if (obj.length < 10) {
                System.out.println("Array is small");
                System.exit(0);
            }
            size = obj.length;
            arr = new Object[size];
            for (int i = 0; i < size; i++) {
                arr[i] = obj[i];
            }
        } catch (ArrayStoreException e) {
            e.printStackTrace();
            System.out.println("The stack trace has been printed just for logging.");
            System.out.println("ArrayStoreException is handled.");
        }
    }

    public void create(int[] array) {
        if(array.length < 10) {
            System.out.println("Array is small");
            System.exit(0);
        }
        size = array.length;
        s = new int[size];
        for(int i=0; i<size; i++) {
            s[i] = array[i];
        }
    }

    public void show() {
        for(int i=0; i<s.length; i++) {
            System.out.print(s[i] + " ");
        }
        System.out.println();
    }

    public void show_obj(Object[] obj) {
//        for(int i=0; i<obj.length; i++) {
//            arr[i] = obj[i];
//            //System.out.println(Arrays.toString((Object[]arr)));
//            //System.out.println(System.identityHashCode(obj[i]));
//            System.out.println(obj[i] + " ");
//        }
        for (Object arr : obj) {
            System.out.println("Object = " + arr.toString());
        }
        System.out.println();
    }

    public void add(int elemnt) {
        int [] newArray = new int [s.length + 1];
        for(int i=0; i<s.length; i++) {
            newArray[i] = s[i];
        }
        newArray[newArray.length-1] = elemnt;
        s = newArray;
        for(int i=0; i<s.length; i++) {
            System.out.print(s[i]+" ");
        }
        System.out.println();
    }

    public void add(Object elemnt) {
        Object [] newArray = new Object [arr.length + 1];
        for(int i=0; i<arr.length; i++) {
            newArray[i] = arr[i];
        }
        newArray[newArray.length-1] = elemnt;
        arr = newArray;
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        if(s == null) {
            return true;
        }
        return false;
    }

    public boolean isEmptyObj() {
        if(arr == null) {
            return true;
        }
        return false;
    }

    public void clear() {
        s = null;
    }

    public void clearObj() {
        arr = null;
    }

    public void remove(int index) {
        System.arraycopy(s, index + 1, s, index, s.length - 1 - index);
        for (int i = 0; i < s.length-1; i++) {
            System.out.print(s[i] + " ");
        }
    }

    public void remove_obj(int index) {
        System.arraycopy(arr, index + 1, arr, index, arr.length - 1 - index);
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public int size() {
        int length = s.length;
        return length;
    }

    public int sizeObj() {
        int length = arr.length;
        return length;
    }

    /**
     * expand array
     */
    public void expand_arr() {
        int [] newArray = new int [s.length + 1 * (int)1.5];
        System.arraycopy(s, 0, newArray, 0, s.length);
        s = newArray;
    }

    /**
     * expand array of object
     */
    public void expand_arr_obj() {
        Object [] newArray = new Object [arr.length + 1 * (int)1.5];
        System.arraycopy(arr, 0, newArray, 0, arr.length);
        arr = newArray;
    }

    /**
     * update array of object
     * @param obj
     */
    public void update(Object[] obj) {
        size = obj.length;
        arr = null;
        arr = new Object[size];
        for (int i = 0; i < size; i++) {
            arr[i] = obj[i];
        }
    }

    /**
     * update array
     * @param array
     */
    public void update_arr(int[] array) {
        size = array.length;
        s = null;
        s = new int[size];
        for(int i=0; i<size; i++) {
            s[i] = array[i];
        }
    }
}

class Main {
    public static void main(String[] args) throws NullPointerException {
        //Add plane with new Airline
        Airports a = new Airports(9000,"0956");

        BS747 b = new BS747("Airline");
        BS747 c = new BS747("Airline2");
        BS747 d = new BS747("Airline3");
        BS747 g = new BS747("Airline4");
        BS747 h = new BS747("Airline5");
        BS747 i = new BS747("Airline6");
        BS747 e = new BS747("Airline7");
        BS747 k = new BS747("Airline8");
        BS747 l = new BS747("Airline9");
        BS747 m = new BS747("Airline10");

//        int [] ppp = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        Set<Integer> sett = new Set<Integer>();
//        sett.create(ppp);
//        System.out.println(sett.size());
//        sett.add(11);
        //sett.show();
//        sett.remove(3);
//        System.out.println();
//        sett.update_arr(ppp);
//        System.out.println(sett.size());
//        sett.clear();
//        System.out.println();
//        System.out.println(sett.isEmpty());
//        System.out.println(sett.size());

        //Work with object

        BS747 kl = new BS747("Airline11");

        Set<Object> set = new Set<Object>();
        Object [] aa = new Object[]{b, c, d, g, h, i, e, k, l, m};
        set.create(aa);
        set.show_obj(aa);
        System.out.println(set.isEmptyObj());
        set.add(kl);
        System.out.println(set.sizeObj());
        set.remove_obj(4);
        set.update(aa);
        System.out.println();
        System.out.println(set.sizeObj());
        System.out.println();
        set.clearObj();
        System.out.println(set.isEmptyObj());
        //System.out.println(set.sizeObj());


        //Work with plane's flight
//        int [] pp = new int[]{b.flight(800), c.flight(600), d.flight(100), g.flight(300), h.flight(400),
//                i.flight(500), e.flight(900), k.flight(700), l.flight(200), m.flight(1000)};
//        System.out.println();
//        System.out.println("Other set");
//        Set<Integer> ss = new Set<Integer>();
//        ss.create(pp);
//        ss.show();
//        System.out.println(ss.isEmpty());
//        System.out.println(ss.size());
//        ss.clear();
//        System.out.println(ss.isEmpty());
    }
}
/**
 * Testin Set class (it is from previous lab)
 */

import org.junit.*;
import static org.junit.Assert.*;

public class MainTest {
    private Set<Integer> calculator;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Set.class");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("After Set.class");
    }

    @Before
    public void initTest() {
        calculator = new Set<Integer>();
    }

    @After
    public void afterTest() {
        calculator = null;
    }

    @Test
    public void testRemoveElement() throws Exception {
        System.out.println("Test for removing");
        int [] a = new int []{1,2,3,4,5,6,7,8,9,10};
        calculator.create(a);
        calculator.add(11);
        calculator.show();
        calculator.remove(4);
    }

    @Test
    public void testAddElement() throws Exception {
        System.out.println("Test for add element");
        int [] a = new int []{1,2,3,4,5,6,7,8,9,10};
        calculator.create(a);
        calculator.add(11);
        calculator.show();
    }

    @Test
    public void testClearArray() throws Exception {
        System.out.println("Test for clear everything");
        int [] a = new int []{1,2,3,4,5,6,7,8,9,10};
        calculator.create(a);
        calculator.add(11);
        calculator.show();
        calculator.clear();
        System.out.println(calculator.isEmpty());
    }

//    @Test(expected = ArithmeticException.class)
//    public void divisionWithException() {
//        calculator.show();
//    }

    @Ignore("Message for ignored test")
    @Test
    public void ignoredTest() {
        System.out.println("will not print it");
    }

//    @Test(timeout = 500)
//    public void timeStampTest() {
//        while (true){}
//    }
}

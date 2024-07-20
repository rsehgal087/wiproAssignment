package Day22;
import static org.junit.Assert.assertEquals;
import org.junit.*;

public class Task2Test {
    static Task1 task1;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("BeforeClass: Initializing resources...");
        task1 = new Task1();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("AfterClass: Cleaning up resources...");
        task1 = null;
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Before: Setting up for test...");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("After: Tearing down after test...");
    }

    @Test
    public void testAdd() {
        System.out.println("Running testAdd...");
        assertEquals(5, task1.add(2, 3));
    }

    @Test
    public void testSubtract() {
        System.out.println("Running testSubtract...");
        assertEquals(1, task1.subtract(3, 2));
    }

    @Test
    public void testMultiply() {
        System.out.println("Running testMultiply...");
        assertEquals(6, task1.multiply(2, 3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        System.out.println("Running testDivideByZero...");
        task1.divide(1, 0);
    }

    @Test
    public void testDivide() {
        System.out.println("Running testDivide...");
        assertEquals(2, task1.divide(6, 3));
    }
}

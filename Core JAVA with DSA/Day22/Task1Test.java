package Day22;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Task1Test {
    Task1 task1 = new Task1();

    @Test
    public void testAdd() {
        assertEquals(5, task1.add(2, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(1, task1.subtract(3, 2));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, task1.multiply(2, 3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        task1.divide(1, 0);
    }

    @Test
    public void testDivide() {
        assertEquals(2, task1.divide(6, 3));
    }
}

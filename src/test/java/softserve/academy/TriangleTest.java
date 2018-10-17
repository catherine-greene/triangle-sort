package softserve.academy;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void testCreateTriangleWithCorrectArgs() {
        //GIVEN
        String[] args = {"Name1", "3", "4", "5"};
        //WHEN
        Triangle triangle = Triangle.createTriangle(args);
        //THEN
        assertNotNull(triangle);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTriangleWithArgsThatNotCreateTriangle() {
        Triangle.createTriangle(new String[]{"Name1", "-1", "4", "5"});
    }

    @Test(expected = NumberFormatException.class)
    public void testCreateTriangleWithNotNumberArgs() {
        Triangle.createTriangle(new String[]{"Name1", "a", "4", "5"});
    }

    @Test
    public void testGetSquare() {
        //GIVEN
        String[] args = {"Name1", "3", "4", "5"};
        double expectedSquare = 6;
        //WHEN
        Triangle triangle = Triangle.createTriangle(args);
        double actualSquare = triangle.getSquare();
        //THEN
        assertEquals(expectedSquare, actualSquare, 0.00);
    }

    @Test
    public void testCompareTo() {
        //GIVEN
        String[] args1 = {"Name1", "3", "4", "5"};
        String[] args2 = {"Name2", "4", "5", "6"};
        //WHEN
        Triangle triangle1 = Triangle.createTriangle(args1);
        Triangle triangle2 = Triangle.createTriangle(args2);
        //THEN
        assertTrue(triangle1.compareTo(triangle2) < 0);
    }
}

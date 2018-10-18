package softserve.academy;

//import com.sun.org.apache.xpath.internal.operations.String;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    private static Stream<Arguments> getArgs() {
        return Stream.of(
                Arguments.of((Object) new String[]{"Name1", "a", "4", "5"}),
                Arguments.of((Object) new String[]{"Name2", "3", "o", "5"}),
                Arguments.of((Object) new String[]{"Name3", "3", "4", "d"})
        );
    }

    @Test
    @DisplayName("Should create triangle object when arguments are correct")
    void testCreateTriangleWithCorrectArgs() {
        //GIVEN
        String[] args = {"Name1", "3", "4", "5"};
        //WHEN
        Triangle triangle = new Triangle(args);
        //THEN
        assertNotNull(triangle);
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when given args cannot form a triangle  ")
    void testCreateTriangleWithArgsThatNotCreateTriangle() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(new String[]{"Name1", "-1", "4", "5"}));
    }

    @ParameterizedTest
    @MethodSource("getArgs")
    @DisplayName("Should throw NumberFormatException when size args are not numbers")
    void testCreateTriangleWithNotNumberArgs(String[] args) {
        assertThrows(NumberFormatException.class, () -> new Triangle(args));
    }

    @Test
    @DisplayName("Should return square of a triangle")
    void testGetSquare() {
        //GIVEN
        String[] args = {"Name1", "3", "4", "5"};
        double expectedSquare = 6;
        double delta = 0.0000000001;
        //WHEN
        Triangle triangle = new Triangle(args);
        double actualSquare = triangle.getSquare();
        //THEN
        assertEquals(expectedSquare, actualSquare, delta);
    }

    @Test
    @DisplayName("Should return true if the square of the triangle1 is less then the one of the triangle2")
    void testCompareTo() {
        //GIVEN
        String[] args1 = {"Name1", "3", "4", "5"};
        String[] args2 = {"Name2", "4", "5", "6"};
        //WHEN
        Triangle triangle1 = new Triangle(args1);
        Triangle triangle2 = new Triangle(args2);
        //THEN
        assertTrue(triangle1.compareTo(triangle2) < 0);
    }
}

import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String sex;
    private final boolean expectedMane;

    private Lion lion;
    private Feline felineMock;

    // Конструктор для передачи параметров в тест
    public LionParameterizedTest(String sex, boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
    }

    // Параметры теста (разные значения пола и ожидаемый результат)
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Самец", true },  // Лев-самец должен иметь гриву
                { "Самка", false }  // Львица не должна иметь гриву
        });
    }

    @Before
    public void setUp() throws Exception {
        felineMock = mock(Feline.class);
        lion = new Lion(sex, felineMock);
    }

    @Test
    public void testDoesHaveMane() {
        assertEquals(expectedMane, lion.doesHaveMane());
    }

    @Test
    public void testGetKittens() {
        when(felineMock.getKittens()).thenReturn(2);
        assertEquals(2, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы"));
        assertEquals(List.of("Животные", "Птицы"), lion.getFood());
    }
}

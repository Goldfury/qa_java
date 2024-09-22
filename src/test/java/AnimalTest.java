import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class AnimalTest {

    @Test
    public void getFoodForHerbivoreTest() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood("Травоядное");
        Assert.assertEquals(List.of("Трава", "Различные растения"), food);
    }

    @Test
    public void getFoodForPredatorTest() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood("Хищник");
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test(expected = Exception.class)
    public void getFoodForUnknownTest() throws Exception {
        Animal animal = new Animal();
        animal.getFood("Неизвестный вид");
    }

    @Test
    public void getFamilyTest() {
        Animal animal = new Animal();
        String family = animal.getFamily();
        Assert.assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", family);
    }
}

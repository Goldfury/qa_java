import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline felineSpy = new Feline();

    @Test
    public void testEatMeat() throws Exception {
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), felineSpy.eatMeat());
    }

    @Test
    public void testGetFamily() {
        Assert.assertEquals("Кошачьи", felineSpy.getFamily());
    }

    @Test
    public void testGetKittensWithoutParam() {
        felineSpy.getKittens();
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void testGetKittensWithParam() {
        Assert.assertEquals(5, felineSpy.getKittens(5));
    }
}

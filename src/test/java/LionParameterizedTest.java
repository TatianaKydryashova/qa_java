import com.example.Feline;
import com.example.Lion;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class LionParameterizedTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    Feline feline;

    private final String checkedSex;
    private final boolean expectedSex;

    public LionParameterizedTest(String checkedSex, boolean expectedSex) {
        this.checkedSex = checkedSex;
        this.expectedSex = expectedSex;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void shouldCheckLionSex() throws Exception {
        try {
            Lion lion = new Lion(feline, checkedSex);
            assertEquals(expectedSex,lion.doesHaveMane());
        } catch (Exception thrown){
            assertEquals("Используйте допустимые значения пола животного - самей или самка", thrown.getMessage());
        }


    }
}



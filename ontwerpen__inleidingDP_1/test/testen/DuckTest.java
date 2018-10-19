package testen;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import domein.Duck;
import domein.DuckFactory;
import domein.DuckSpecies;
import static domein.DuckSpecies.*;
import domein.FlyBehavior;
import domein.FlyRocketPowered;

@RunWith(value = Parameterized.class)
public class DuckTest {

    private final static String FLY_NO_WAY = "Ik kan niet vliegen";
    private final static String FLY_WITH_WINGS = "Ik vlieg!!";
    private final static String QUACK = "Ik kwaak";
    private final static String SQUEAK = "Piep";
    private final static String MUTE_QUACK = "<<Stilte>>";

    private Duck duck;
    private DuckSpecies kind;
    private String expectedDisplay, expectedQuack, expectedFly;
    private DuckFactory duckFactory;

    public DuckTest(DuckSpecies kind, String expectedDisplay, String expectedQuack,
            String expectedFly) {
        this.kind = kind;
        this.expectedDisplay = expectedDisplay;
        this.expectedQuack = expectedQuack;
        this.expectedFly = expectedFly;
    }

    @Parameters
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(
                new Object[][]{
                    {MALLARD, "Ik ben een echte wilde eend", QUACK, FLY_WITH_WINGS},
                    {RUBBER, "Ik ben een badeend", SQUEAK, FLY_NO_WAY},
                    {REDHEAD, "Ik lijk op eenroodkuifeend", QUACK, FLY_WITH_WINGS},
                    {DECOY, "Ik ben een lokeend", MUTE_QUACK, FLY_NO_WAY}
                });
    }

    @Before
    public void before() {
            duckFactory = new DuckFactory();
            duck = duckFactory.createDuck(kind);
    }

    @Test
    public void testDuck() {
        Assert.assertEquals(expectedDisplay , duck.display());
        Assert.assertEquals(expectedQuack, duck.performQuack());
        Assert.assertEquals(expectedFly, duck.performFly());
    }

    
    private final String flyRocketPowered = "Ik vlieg met raketaandrijving";

    @Test
    public void wijzigAtRuntime() {
        duck.setFlyBehavior(new FlyRocketPowered());
        Assert.assertEquals(flyRocketPowered, duck.performFly());
    }
}

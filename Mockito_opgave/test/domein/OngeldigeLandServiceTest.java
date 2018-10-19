package domein;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import persistentie.PersistentieController;

import org.mockito.Mockito;

public class OngeldigeLandServiceTest {

    private LandService landService;

    private PersistentieController persistentieControllerDummy;

    @Before
    public void before() {
        persistentieControllerDummy = Mockito.mock(PersistentieController.class);
        landService = new LandService(persistentieControllerDummy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void legeCode() {
        landService.geefLandStatistiek("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void spaties() {
        landService.geefLandStatistiek("      ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullCode() {
        landService.geefLandStatistiek(null);
    }

    @Test
    public void landBestaatNiet() {
        final String CODE_GEEN_LAND = "GEEN_LAND";
        Mockito.when(persistentieControllerDummy.findLand(CODE_GEEN_LAND)).
                thenReturn(null);
        Mockito.when(persistentieControllerDummy.findOppervlakteAlleLanden()).thenReturn(100);

        Assert.assertNull(landService.geefLandStatistiek(CODE_GEEN_LAND));

        Mockito.verify(persistentieControllerDummy).findLand(CODE_GEEN_LAND);
        Mockito.verify(persistentieControllerDummy,
                Mockito.times(0)).findOppervlakteAlleLanden();
    }
}

package domein;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import persistentie.PersistentieController;

@RunWith(value = Parameterized.class)
public class GeldigeLandServiceTest {

    private LandService landService;
    private String landCode;
    private final int landOppervlakte;
    private double verwachteResultaat;
    private static final int oppervlakte = 110;
    
    private PersistentieController persistentieControllerDummy;

    @Parameters
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(
                new Object[][]{
                      {"BE", 10, 0.1} 
                    , {"NL", 22, 0.2} 
                    , {"DE", 78, 0.7}    
                }
        );
    }

    public GeldigeLandServiceTest(String landCode, int landOppervlakte, double verwachteResultaat)
    {
        this.landCode = landCode;
        this.landOppervlakte = landOppervlakte;
        this.verwachteResultaat = verwachteResultaat;
    }

    @Before
    public void before() {
        persistentieControllerDummy = Mockito.mock(PersistentieController.class);
        landService = new LandService(persistentieControllerDummy);
    }

    @Test
    public void testGeefLandStatistiekScenario() {
        Mockito.when(persistentieControllerDummy.findLand(landCode))
                .thenReturn(new Land(landCode, landOppervlakte));
        Mockito.when(persistentieControllerDummy.findOppervlakteAlleLanden())
                .thenReturn(oppervlakte);
        
        LandStatistiek stat = landService.geefLandStatistiek(landCode);
        Assert.assertEquals(landCode, stat.getLandCode());
        Assert.assertEquals(verwachteResultaat, stat.getVerhouding(), 0.01);
        
        Mockito.verify(persistentieControllerDummy).findLand(landCode);
        Mockito.verify(persistentieControllerDummy).findOppervlakteAlleLanden();
    }

}

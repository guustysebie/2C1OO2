package domein;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import persistentie.PersistentieController;

public class ContinentServiceTest {
    @Test
    public void testGeboorteOverschot(){
        dummyTrainen(16405399L, 184634L, 135136L);
        controleGeboorteOverschot(3.01,0.009);
    }
    @Test
    public void testSterfteOverschot(){
        dummyTrainen(18506500L,277597L,333117L);
        controleGeboorteOverschot(-3,0.01);
    }
    private PersistentieController persistentieControllerDummy;
    private ContinentService contintentService;
    @Before
    public void before(){
        persistentieControllerDummy = Mockito.mock(PersistentieController.class);
        contintentService = new ContinentService(persistentieControllerDummy);
    }
    private static final String CODE = "CODE";
    private void dummyTrainen(long bewoners, long geboorten, long sterftes) {
        Mockito.when(persistentieControllerDummy.findAantalBewoners(CODE)).thenReturn(bewoners);
        Mockito.when(persistentieControllerDummy.findGeboortecijfers(CODE)).thenReturn(geboorten);
        Mockito.when(persistentieControllerDummy.findSterfteCijfer(CODE)).thenReturn(sterftes);
    }

    private void controleGeboorteOverschot(double verwachteRes, double Afwijking) {
                Assert.assertEquals(verwachteRes, contintentService.geefGeboorteOverschot(CODE), Afwijking);
                Mockito.verify(persistentieControllerDummy).findAantalBewoners(CODE);
                Mockito.verify(persistentieControllerDummy).findGeboortecijfers(CODE);
                Mockito.verify(persistentieControllerDummy).findSterfteCijfer(CODE);
    }
    @Test(expected = IllegalArgumentException.class)
    public void sterfteCijfer_Nul()
    {
        dummyTrainen(30000L, 15020L, 0);
        controleGeboorteOverschot(500.6, 0.09);
    }
    @Test(expected = IllegalArgumentException.class)
    public void negatieveGeboortes()
    {
        dummyTrainen(30000L, 0L, 15020L);
        controleGeboorteOverschot(-500.6, 0.09);
    }
    
    @Test
    public void allesGrensWaarden(){
        dummyTrainen(1L, 0L, 0L);
        controleGeboorteOverschot(0, 0);
    }
    
    
}

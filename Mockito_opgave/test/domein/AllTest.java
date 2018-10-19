package domein;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {domein.GeldigeLandServiceTest.class,
            domein.OngeldigeLandServiceTest.class
    //   ,domein.ContinentServiceTest.class
    })
public class AllTest {

}

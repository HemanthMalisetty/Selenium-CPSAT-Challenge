package JunitRun;

import Cii.Pages.OnlineRegistrationTest;
import Hometown.pages.HometownTest;
import Premierleague.Pages.Premierleague_HomeTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        OnlineRegistrationTest.class,
        HometownTest.class,
        Premierleague_HomeTest.class,
})
public class JunitSuite {

}

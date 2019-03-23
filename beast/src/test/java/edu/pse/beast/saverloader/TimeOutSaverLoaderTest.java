package edu.pse.beast.saverloader;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;

import edu.pse.beast.datatypes.electioncheckparameter.TimeOut;
import edu.pse.beast.saverloader.staticsaverloaders.TimeOutSaverLoader;

/**
 * JUnit Testclass for saverloader.StaticSaverLoaders.TimeOutSaverLoader.
 *
 * @author Nikolai Schnell
 */
public class TimeOutSaverLoaderTest {
    private static TimeOut timeOut;

    @BeforeClass
    public static void setUpClass() {
        timeOut = new TimeOut(TimeUnit.HOURS, (long) 3.2);
    }

    /**
     * Tests the TimeOutSaverLoader by creating a saveString from a TimeOut object,
     * then recreating that object from the saveString and checking its integrity.
     */
    @Test
    public void testSaverLoader() {
        String saveString = TimeOutSaverLoader.createSaveString(timeOut);
        TimeOut recreatedTimeOut = TimeOutSaverLoader.createFromSaveString(saveString);
        assert (recreatedTimeOut.getDuration() == 10800000);
        assert (recreatedTimeOut.getOrigUnit().equals(TimeUnit.HOURS));
    }
}
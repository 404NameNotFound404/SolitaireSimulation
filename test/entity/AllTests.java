package entity;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CardCollectionTest.class, CardStackTest.class, CardTest.class, DeckTest.class })
public class AllTests {

}

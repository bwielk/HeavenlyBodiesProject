package planets;

import static org.junit.Assert.*;

import org.junit.*;

public class SolarSystemTest {

	private HeavenlyBody solarSystem1;
	private HeavenlyBody planet1;
	private HeavenlyBody asteroid1;
	private HeavenlyBody asteroid2;
	private HeavenlyBody star1;
	
	@Before
	public void before(){
		solarSystem1 = new SolarSystem("SolarSystem", 0);
		planet1 = new Planet("Ganimedes", 21);
		asteroid1 = new Asteroid("Ganimedes", 0);
		asteroid2 = new Asteroid("Ganimedes", 2);
		star1 = new Asteroid("Jason", 0);
	}
	
	@Test
	public void solarSystemAcceptsObjectWithTheSameNameButDifferentTypes() {
		assertEquals(true, solarSystem1.addBody(planet1));
		assertEquals(true, solarSystem1.addBody(asteroid1));
		assertEquals(true, solarSystem1.addBody(asteroid2));
		assertEquals(2, solarSystem1.getBodies().size());
	}
	
	@Test
	public void solarSystemDoesntAcceptOtherSolarSystems(){
		assertEquals(true, solarSystem1.addBody(planet1));
		assertEquals(false, solarSystem1.addBody(new SolarSystem("SolarSystem2", 0)));
		assertEquals(1, solarSystem1.getBodies().size());
	}
}

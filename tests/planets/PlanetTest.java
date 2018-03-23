package planets;

import static org.junit.Assert.*;

import org.junit.*;

public class PlanetTest {
	
	private HeavenlyBody earth;
	private HeavenlyBody mars;
	private HeavenlyBody phobos;
	private HeavenlyBody deimos;
	private HeavenlyBody moon;
	private HeavenlyBody star1;
	private HeavenlyBody star2;
	
	@Before
	public void before(){
		earth = new Planet("Earth", 365);
		mars = new Planet("Mars", 687);
		moon = new Satellite("Moon", 27);
		phobos = new Satellite("Phobos", 0.3);
		deimos = new Satellite("Deimos", 1.1);
		star1 = new Star("star1", 0);
		star2 = new Star("star2", 0);
	}

	@Test
	public void planetsAcceptSatellites() {
		assertEquals(true, earth.addMoon(moon));
		assertEquals(true, mars.addMoon(deimos));
		assertEquals(true, mars.addMoon(phobos));
		assertEquals(2, mars.getMoons().size());
	}
	
	@Test
	public void planetsDontAcceptOtherHeavenlyBodiesThanSatellites(){
		assertEquals(true, earth.addMoon(moon));
		assertEquals(false, earth.addMoon(mars));
		assertEquals(false, earth.addMoon(star1));
		assertEquals(false, earth.addMoon(star2));
		assertEquals(1, earth.getMoons().size());
	}
}

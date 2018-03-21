package planets;

import static org.junit.Assert.*;

import org.junit.*;

public class HeavenlyBodyTest {
	
	private HeavenlyBody planetEarth;
	private HeavenlyBody planetMars;
	private HeavenlyBody planetMercury;

	@Before
	public void before() {
		planetEarth = new HeavenlyBody("Earth", 365);
		planetMars = new HeavenlyBody("Mars", 687);
		planetMercury = new HeavenlyBody("Mercury", 88);
	}
	
	@Test
	public void bodyHasName() {
		assertEquals("Mars", planetMars.getName());
		assertEquals("Earth", planetEarth.getName());
		assertEquals("Mercury", planetMercury.getName());
	}
	
	@Test
	public void bodyHasOrbitalPeriod() {
		assertEquals(687, planetMars.getOrbitalPeriod());
		assertEquals(365, planetEarth.getOrbitalPeriod());
		assertEquals(88, planetMercury.getOrbitalPeriod());
	}

}

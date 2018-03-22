package planets;

import static org.junit.Assert.*;

import org.junit.*;

public class HeavenlyBodyTest {
	
	//Planets
	private HeavenlyBody planetEarth;
	private HeavenlyBody planetMars;
	private HeavenlyBody planetUranus;
	//Moons
	private HeavenlyBody earthSatelliteMoon;
	private HeavenlyBody marsSatellitePhobos;
	private HeavenlyBody marsSatelliteDeimos;
	private HeavenlyBody uranusSatelliteTitania;
	private HeavenlyBody uranusSatelliteMiranda;
	private HeavenlyBody uranusSatelliteAriel;
	private HeavenlyBody uranusSatelliteUmbriel;

	@Before
	public void before() {
		//Planets
		planetEarth = new HeavenlyBody("Earth", 365);
		planetMars = new HeavenlyBody("Mars", 687);
		planetUranus = new HeavenlyBody("Uranus", 30660);
		//Moons
		//--Earth
		earthSatelliteMoon = new HeavenlyBody("Moon", 27);
		//--Mars
		marsSatellitePhobos = new HeavenlyBody("Phobos", 0.3);
		marsSatelliteDeimos = new HeavenlyBody("Deimos", 1.1);
		//--Uranus
		uranusSatelliteTitania = new HeavenlyBody("Titania", 8.7);
		uranusSatelliteMiranda = new HeavenlyBody("Miranda", 1.4);
		uranusSatelliteAriel = new HeavenlyBody("Ariel", 2.5);
		uranusSatelliteUmbriel = new HeavenlyBody("Umbriel", 3.6);
	}
	
	@Test
	public void bodyHasName() {
		assertEquals("Mars", planetMars.getName());
		assertEquals("Earth", planetEarth.getName());
		assertEquals("Uranus", planetUranus.getName());
	}
	
	@Test
	public void bodyHasOrbitalPeriod() {
		assertEquals(687, planetMars.getOrbitalPeriod(), 0.1);
		assertEquals(365, planetEarth.getOrbitalPeriod(), 0.1);
		assertEquals(30660, planetUranus.getOrbitalPeriod(), 0.1);
	}
	
	@Test
	public void planetsCanStoreMoons(){
		assertEquals(true, planetEarth.addMoon(earthSatelliteMoon));
		assertEquals(1, planetEarth.getMoons().size());
		assertEquals(true, planetMars.addMoon(marsSatellitePhobos));
		assertEquals(true, planetMars.addMoon(marsSatelliteDeimos));
		assertEquals(2, planetMars.getMoons().size());
		assertEquals(true, planetUranus.addMoon(uranusSatelliteTitania));
		assertEquals(true, planetUranus.addMoon(uranusSatelliteUmbriel));
		assertEquals(true, planetUranus.addMoon(uranusSatelliteAriel));
		assertEquals(true, planetUranus.addMoon(uranusSatelliteMiranda));
		assertEquals(4, planetUranus.getMoons().size());
	}
	
	@Test
	public void theSameSatellitesCannotBeStoredByTheSamePlanet(){
		assertEquals(true, planetEarth.addMoon(earthSatelliteMoon));
		earthSatelliteMoon = new HeavenlyBody("Moon", 23);
		assertEquals(false, planetEarth.addMoon(earthSatelliteMoon));
		for(HeavenlyBody moon : planetEarth.getMoons()){
			System.out.println(moon.getName() + " PERIOD : " + moon.getOrbitalPeriod());
		}
		assertEquals(1, planetEarth.getMoons().size());
	}
}

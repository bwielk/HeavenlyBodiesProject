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
		planetEarth = new Planet("Earth", 365);
		planetMars = new Planet("Mars", 687);
		planetUranus = new Planet("Uranus", 30660);
		//Moons
		//--Earth
		earthSatelliteMoon = new Satellite("Moon", 27);
		//--Mars
		marsSatellitePhobos = new Satellite("Phobos", 0.3);
		marsSatelliteDeimos = new Satellite("Deimos", 1.1);
		//--Uranus
		uranusSatelliteTitania = new Satellite("Titania", 8.7);
		uranusSatelliteMiranda = new Satellite("Miranda", 1.4);
		uranusSatelliteAriel = new Satellite("Ariel", 2.5);
		uranusSatelliteUmbriel = new Satellite("Umbriel", 3.6);
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
	public void theSameSatellitesCannotBeStoredByTheSamePlanetEarthExample(){
		assertEquals(true, planetEarth.addMoon(earthSatelliteMoon));
		earthSatelliteMoon = new HeavenlyBody("Moon", 23);
		assertEquals(false, planetEarth.addMoon(earthSatelliteMoon));
		for(HeavenlyBody moon : planetEarth.getMoons()){
			System.out.println(moon.getName() + " PERIOD : " + moon.getOrbitalPeriod());
		}
		assertEquals(1, planetEarth.getMoons().size());
	}
	
	@Test
	public void theSameSatellitesCannotBeStoredByTheSamePlanetUranusExample(){
		System.out.println("Test1");
		assertEquals(true, planetUranus.addMoon(uranusSatelliteTitania));
		assertEquals(true, planetUranus.addMoon(uranusSatelliteUmbriel));
		//Adding the same moon to the planet
		System.out.println("Test2");
		assertEquals(false, planetUranus.addMoon(uranusSatelliteUmbriel));
		//Adding a new HeavenlyBody instance with a name similar to the name of an already added moon
		HeavenlyBody moonTitania = new Satellite("Titania", 23444);
		System.out.println("Test3");
		assertEquals(false, planetUranus.addMoon(moonTitania));
		//Adding a moon with the name of an already added moon
		uranusSatelliteUmbriel = new Satellite("Umbriel", 3453);
		System.out.println("Test4");
		assertEquals(false, planetUranus.addMoon(uranusSatelliteUmbriel));
		for(HeavenlyBody moon : planetUranus.getMoons()){
			System.out.println(moon.getName() + " PERIOD : " + moon.getOrbitalPeriod());
		}
		assertEquals(2, planetUranus.getMoons().size());
	}
}

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
		assertEquals(true, planetEarth.addBody(earthSatelliteMoon));
		assertEquals(1, planetEarth.getBodies().size());
		assertEquals(true, planetMars.addBody(marsSatellitePhobos));
		assertEquals(true, planetMars.addBody(marsSatelliteDeimos));
		assertEquals(2, planetMars.getBodies().size());
		assertEquals(true, planetUranus.addBody(uranusSatelliteTitania));
		assertEquals(true, planetUranus.addBody(uranusSatelliteUmbriel));
		assertEquals(true, planetUranus.addBody(uranusSatelliteAriel));
		assertEquals(true, planetUranus.addBody(uranusSatelliteMiranda));
		assertEquals(4, planetUranus.getBodies().size());
	}
	
	@Test
	public void theSameSatellitesCannotBeStoredByTheSamePlanetEarthExample(){
		assertEquals(true, planetEarth.addBody(earthSatelliteMoon));
		earthSatelliteMoon = new Satellite("Moon", 23);
		assertEquals(false, planetEarth.addBody(earthSatelliteMoon));
		for(HeavenlyBody moon : planetEarth.getBodies()){
			System.out.println(moon.getName() + " PERIOD : " + moon.getOrbitalPeriod());
		}
		assertEquals(1, planetEarth.getBodies().size());
	}
	
	@Test
	public void theSameSatellitesCannotBeStoredByTheSamePlanetUranusExample(){
		assertEquals(true, planetUranus.addBody(uranusSatelliteTitania));
		assertEquals(true, planetUranus.addBody(uranusSatelliteUmbriel));
		//Adding the same moon to the planet
		assertEquals(false, planetUranus.addBody(uranusSatelliteUmbriel));
		//Adding a new HeavenlyBody instance with a name similar to the name of an already added moon
		HeavenlyBody moonTitania = new Satellite("Titania", 23444);
		assertEquals(false, planetUranus.addBody(moonTitania));
		//Adding a moon with the name of an already added moon
		uranusSatelliteUmbriel = new Satellite("Umbriel", 3453);
		assertEquals(false, planetUranus.addBody(uranusSatelliteUmbriel));
		for(HeavenlyBody moon : planetUranus.getBodies()){
			System.out.println(moon.getName() + " PERIOD : " + moon.getOrbitalPeriod());
		}
		assertEquals(2, planetUranus.getBodies().size());
	}
}

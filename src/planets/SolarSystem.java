package planets;

public class SolarSystem extends HeavenlyBody {

	public SolarSystem(String name, double period) {
		super(name, period);
		this.bodyType = BodyType.SOLAR_SYSTEM;
	}

}

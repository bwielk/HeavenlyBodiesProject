package planets;

public class Planet extends HeavenlyBody {

	public Planet(String name, double period) {
		super(name, period);
		this.bodyType = BodyType.PLANET;
	}

}

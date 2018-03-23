package planets;

public class Asteroid extends HeavenlyBody {

	public Asteroid(String name, double period) {
		super(name, period);
		this.bodyType = BodyType.ASTEROID;
	}

}

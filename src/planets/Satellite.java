package planets;

public class Satellite extends HeavenlyBody {

	public Satellite(String name, double period) {
		super(name, period);
		this.bodyType = BodyType.SATELLITE;
	}

}

package planets;

public class Star extends HeavenlyBody {

	public Star(String name, double period) {
		super(name, period);
		this.bodyType = BodyType.STAR;
	}

}

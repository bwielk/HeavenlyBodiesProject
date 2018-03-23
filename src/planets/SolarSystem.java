package planets;

public class SolarSystem extends HeavenlyBody {

	public SolarSystem(String name, double period) {
		super(name, period);
		this.bodyType = BodyType.SOLAR_SYSTEM;
	}
	
	@Override
	public boolean addBody(HeavenlyBody body){
		if(body.getBodyType() != BodyType.SOLAR_SYSTEM){
			return super.addBody(body);
		}
		return false;
	}
}

package planets;

public class Planet extends HeavenlyBody {

	public Planet(String name, double period) {
		super(name, period);
		this.bodyType = BodyType.PLANET;
	}
	
	@Override
	public boolean addBody(HeavenlyBody moon){
		if(moon.getBodyType() == BodyType.SATELLITE){
			return super.addBody(moon);
		}
		return false;
	}
	
}

package planets;

import java.util.HashSet;

public abstract class HeavenlyBody {
	
	private final String name;
	private final double orbitalPeriod;
	private final HashSet<HeavenlyBody> bodies;
	protected BodyType bodyType;
	
	public HeavenlyBody(String name, double period){
		this.name = name;
		this.orbitalPeriod = period;
		this.bodies = new HashSet<>();
		this.bodyType = null;
	}

	public String getName() {
		return name;
	}
	
	public double getOrbitalPeriod(){
		return orbitalPeriod;
	}

	public boolean addBody(HeavenlyBody body) {
		return bodies.add(body);
	}

	public BodyType getBodyType() {
		return this.bodyType;
	}

	public HashSet<HeavenlyBody> getBodies() {
		return new HashSet<HeavenlyBody>(bodies);
	}
	
	@Override
	public final boolean equals(Object body){
		if(this == body){
			System.out.println("(this == body)");
			return true;
		}
		
		if(body instanceof HeavenlyBody){
			HeavenlyBody theBody = (HeavenlyBody) body;
			if(this.name == theBody.getName()){
				return this.bodyType == theBody.getBodyType();
			}
		}
		return false;
	}
	
	@Override
	public final int hashCode(){
		return this.name.hashCode() + 12 + this.bodyType.hashCode();
	}
}

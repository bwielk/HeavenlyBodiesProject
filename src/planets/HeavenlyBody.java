package planets;

import java.util.HashSet;

public class HeavenlyBody {
	
	private final String name;
	private final double orbitalPeriod;
	private final HashSet<HeavenlyBody> satellites;
	protected BodyType bodyType;
	
	public HeavenlyBody(String name, double period){
		this.name = name;
		this.orbitalPeriod = period;
		this.satellites = new HashSet<>();
		this.bodyType = null;
	}

	public String getName() {
		return name;
	}
	
	public double getOrbitalPeriod(){
		return orbitalPeriod;
	}

	public boolean addSatellite(HeavenlyBody moon) {
		if(moon.getBodyType() == BodyType.SATELLITE){
			return satellites.add(moon);
		}
		return false;
	}

	public BodyType getBodyType() {
		return this.bodyType;
	}

	public HashSet<HeavenlyBody> getMoons() {
		return new HashSet<HeavenlyBody>(satellites);
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

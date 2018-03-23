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

	public boolean addMoon(HeavenlyBody moon) {
		if(moon.getBodyType() == BodyType.SATELLITE){
			return satellites.add(moon);
		}
		return false;
	}

	private BodyType getBodyType() {
		return this.bodyType;
	}

	public HashSet<HeavenlyBody> getMoons() {
		return new HashSet<HeavenlyBody>(satellites);
	}
	
	@Override
	public boolean equals(Object body){
		if(this == body){
			System.out.println("(this == body)");
			return true;
		}
		if(body == null || this.getClass() != body.getClass()){
			System.out.println("(body == null || this.getClass() != body.getClass())");
			return false;
		}
		System.out.println("this.name.equals(((HeavenlyBody)body).getName())");
		return this.name.equals(((HeavenlyBody)body).getName());
	}
	
	@Override
	public int hashCode(){
		return this.name.hashCode() + 12;
	}
}

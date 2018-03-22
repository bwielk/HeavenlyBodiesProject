package planets;

import java.util.HashSet;

public class HeavenlyBody {
	
	private String name;
	private double orbitalPeriod;
	private HashSet<HeavenlyBody> satellites;
	
	public HeavenlyBody(String name, double period){
		this.name = name;
		this.orbitalPeriod = period;
		this.satellites = new HashSet<>();
	}

	public String getName() {
		return name;
	}
	
	public double getOrbitalPeriod(){
		return orbitalPeriod;
	}

	public boolean addMoon(HeavenlyBody moon) {
		return satellites.add(moon);
	}

	public HashSet<HeavenlyBody> getMoons() {
		return new HashSet<HeavenlyBody>(satellites);
	}
}

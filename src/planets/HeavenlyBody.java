package planets;

public class HeavenlyBody {
	
	private String name;
	private double orbitalPeriod;
	
	public HeavenlyBody(String name, double period){
		this.name = name;
		this.orbitalPeriod = period;
	}

	public String getName() {
		return name;
	}
	
	public double getOrbitalPeriod(){
		return orbitalPeriod;
	}
}

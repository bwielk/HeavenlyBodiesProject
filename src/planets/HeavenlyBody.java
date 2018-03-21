package planets;

public class HeavenlyBody {
	
	private String name;
	private int orbitalPeriod;
	
	public HeavenlyBody(String name, int period){
		this.name = name;
		this.orbitalPeriod = period;
	}

	public String getName() {
		return name;
	}
	
	public int getOrbitalPeriod(){
		return orbitalPeriod;
	}
}

import java.util.ArrayList;
import java.util.HashMap;

/*Name - Satyam Kumar Singh
 * Roll - 33200119059
 * College Name - Techno International Batanagar
 * Year Of Passing - 2022
 * Phone Number - 6205143846
 * Email address - satyamsksingh0096@gmail.com
*/

class Planet {

	private String name;
	private ArrayList<String> surfaceGsses;
	private int numberOfMoons;
	private String rings;
	
	public Planet(String name, ArrayList<String> surfaceGsses, int numberOfMoons, String rings) {
		super();
		this.name = name;
		this.surfaceGsses = surfaceGsses;
		this.numberOfMoons = numberOfMoons;
		this.rings = rings;
	}

	public String getName() {
		return name;
	}

	public ArrayList<String> getSurfaceGsses() {
		return surfaceGsses;
	}

	public int getNumberOfMoons() {
		return numberOfMoons;
	}

	public String getRings() {
		return rings;
	}
	
}

public class Main {
	
	public static int countOfMoons(ArrayList<Planet> planets)
	{
		int sum = 0;
		for(Planet planet:planets)
		{
			if(planet.getRings().equals("Yes"))
				sum += planet.getNumberOfMoons();
		}
		return sum;
	}
	
	public static String gasInMaximumPlanets(ArrayList<Planet> planets)
	{
		HashMap<String, Integer> frequencyOfGas = new HashMap<>();
		String maxGas = null;
		int maxCount = 0;
		for(Planet planet : planets)
		{
			for(String gas : planet.getSurfaceGsses())
			{
				if(frequencyOfGas.get(gas)==null)
				{
					frequencyOfGas.put(gas, 1);
				}
				else
				{
					frequencyOfGas.put(gas, frequencyOfGas.get(gas)+1);
				}
				
				if(frequencyOfGas.get(gas)>maxCount)
				{
					maxGas = gas;
					maxCount = frequencyOfGas.get(gas);
				}
			}
		}
		return maxGas;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Planet> planets = new ArrayList<>();
		ArrayList<String> atmosphericGases = new ArrayList<>();
		planets.add(new Planet("Mercury",atmosphericGases,0,"No"));
		atmosphericGases.clear();
		atmosphericGases.add("Carbon Dioxide");
		atmosphericGases.add("Nitrogen");
		planets.add(new Planet("Venus",new ArrayList<>(atmosphericGases),0,"No"));
		atmosphericGases.clear();
		
		atmosphericGases.add("Nitrogen");
		atmosphericGases.add("Oxygen");
		planets.add(new Planet("Earth",new ArrayList<>(atmosphericGases),1,"No"));
		atmosphericGases.clear();
		
		atmosphericGases.add("Hydrogen");
		atmosphericGases.add("Helium");
		planets.add(new Planet("Jupitor",new ArrayList<>(atmosphericGases),79,"Yes"));
		atmosphericGases.clear();
		
		atmosphericGases.add("Hydrogen");
		atmosphericGases.add("Helium");
		planets.add(new Planet("Saturn",new ArrayList<>(atmosphericGases),83,"Yes"));
		atmosphericGases.clear();
		
		atmosphericGases.add("Hydrogen");
		atmosphericGases.add("Helium");
		atmosphericGases.add("Methane");
		planets.add(new Planet("Uranus",new ArrayList<>(atmosphericGases),27,"Yes"));
		atmosphericGases.clear();
		
		System.out.println("Count of moons of all planets having rings = " + countOfMoons(planets));
		System.out.println("The gas that is found on maximum planets = " + gasInMaximumPlanets(planets));

	}

}

import java.util.Random;

public class GreatPokeball extends Pokeball implements Iinitializable {
	
	Random rand = new Random();

	public GreatPokeball() {
		super("Great", 0);
		setSuccessRate(initialize());
	}
	
	public double initialize() {
		double[] chances = {50, 70, 90};
		
		return chances[rand.nextInt(3)];
	}

	@Override
	public boolean catchPokemon(Pokemon pokemon) {
		double catchRate = (rand.nextDouble() * 100);
		
		if ((catchRate) <= this.getSuccessRate()) {
			return true;
		}
		
		return false;
	}

}

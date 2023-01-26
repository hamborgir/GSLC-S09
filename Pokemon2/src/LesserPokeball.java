import java.util.Random;

public class LesserPokeball extends Pokeball implements Iinitializable {
	
	Random rand = new Random();

	public LesserPokeball() {
		super("Lesser", 0);
		setSuccessRate(initialize());
	}

	public double initialize() {
		double[] chances = {30, 40, 55};
		
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

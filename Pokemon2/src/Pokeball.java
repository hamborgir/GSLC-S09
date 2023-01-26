
public abstract class Pokeball {
	protected String ballType;
	protected double successRate;
	
	public abstract boolean catchPokemon(Pokemon pokemon);
	
	public Pokeball(String ballType, double successRate) {
		super();
		this.ballType = ballType;
		this.successRate = successRate;
	}
	

	
	public String getBallType() {
		return ballType;
	}

	public void setBallType(String ballType) {
		this.ballType = ballType;
	}

	public double getSuccessRate() {
		return successRate;
	}

	public void setSuccessRate(double successRate) {
		this.successRate = successRate;
	}
	

}

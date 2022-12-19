
public abstract class CharacterObject {
	protected int hp, level, power;
	protected String name;

	public CharacterObject(String name, int hp, int level, int power) {
		this.name = name;
		this.level = level;
		this.hp = hp;
		this.power = power;
	}
	
	public void receiveDmg(int dmg) {
		hp -= dmg;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

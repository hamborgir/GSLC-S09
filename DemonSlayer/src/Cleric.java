
public class Cleric extends Hero implements IHealAlly {

	public Cleric(String name, int hp, int level, int power) {
		super(name, hp, level, power);
	}
	
	public void showAction() {
		System.out.println("1. Heal All");
		System.out.println("2. Defense");
	}
	
	public void heal(Hero hero) {
		System.out.println("Healing " + hero.getName());
		hero.setHp(hero.getHp() + power);
	}

}

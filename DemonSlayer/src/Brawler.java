
public class Brawler extends Hero implements IHealSelf, Iattack {

	public Brawler(String name, int hp, int level, int power) {
		super(name, hp, level, power);
	}

	public void showAction() {
		System.out.println("1. Attack");
		System.out.println("2. Self Heal");
		System.out.println("3. Defense");
	}
	
	public void attack(Demon demon) {
		System.out.println("Attacking " + demon.getName());
		demon.receiveDmg(power);
	}

	public void heal() {
		this.setHp(getHp()+(power/2));
	}
	
}

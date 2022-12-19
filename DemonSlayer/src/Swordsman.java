
public class Swordsman extends Hero implements Iattack{

	public Swordsman(String name, int hp, int level, int power) {
		super(name, hp, level, power);
	}

	public void showAction() {
		System.out.println("1. Attack");
		System.out.println("2. Defense");
	}

	public void attack(Demon demon) {
		System.out.println("Attacking " + demon.getName());
		demon.receiveDmg((int) (power * 1.3));
	}


}

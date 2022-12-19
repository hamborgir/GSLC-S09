import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	Vector<Hero> heroes = new Vector<>();
	Vector<Demon> demons = new Vector<>();
	Scanner scan = new Scanner(System.in);
	int turn = 1;

	public Main() {
		//String name, int hp, int level, int power
		
		// Character Creation
		Swordsman heroA = new Swordsman("Corrin", 600, 24, 150);
		Brawler heroB = new Brawler("Beth", 800, 18, 100);
		Cleric heroC = new Cleric("Frieren", 500, 13, 70);
		Demon demonA = new Demon("Sullivan", 2000, 38, 100, "Demon King");
		
		heroes.add(heroA);
		heroes.add(heroB);
		heroes.add(heroC);
		
		demons.add(demonA);
		
		//
		do {
			System.out.println("Turn " + turn++);
			
			for (Hero x : heroes) {
				showCharacters();
				System.out.println("\n");
				
				int ch = 0;
				
				System.out.println(x.getName() + "'s move");
				if (x instanceof Swordsman) {
					
					System.out.println("1. Attack");
					System.out.println("2. Defense");
					
				} else if (x instanceof Brawler) {
					
					System.out.println("1. Attack");
					System.out.println("2. Heal");
					System.out.println("3. Defense");
					
				} else if (x instanceof Cleric) {
					
					System.out.println("1. Heal");
					System.out.println("2. Defense");
					
				} System.out.println("");
				
				System.out.print(">>");
				ch = scan.nextInt();
				
				if (x instanceof Swordsman) {
					if (ch == 1) {
						Demon demon;
						
						System.out.println("Choose demon to attack:");
						demon = chooseDemon();
						
						((Swordsman)x).attack(demon);
					} else {
						continue;
					}
				}
				else if (x instanceof Brawler) {
					if (ch == 1) {
						Demon demon;
						
						System.out.println("Choose demon to attack:");
						demon = chooseDemon();
						
						((Brawler)x).attack(demon);
					} else if (ch == 2) {
						((Brawler)x).heal();
					} else {
						continue;
					}
				}
				else if (x instanceof Cleric) {
					if (ch == 1) {
						Hero hero;
						
						System.out.println("Choose ally to heal:");
						hero = chooseHero();
						
						((Cleric)x).heal(hero);
					}
					else {
						continue;
					}
				}
			}
			
		} while (!demons.isEmpty());
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	public void showHeroes() {
		for (int i = 0; i < heroes.size(); i++) {
			System.out.printf("%-20s ", (i+1));
		}
		System.out.println("");
		for (Hero x : heroes) {
			System.out.printf("%-20s ", "Name: "+x.getName());
		}
		System.out.println("");
		
		for (Hero x : heroes) {
			System.out.printf("%-20s ", "HP: "+x.getHp());
		}
		System.out.println("");
		
		for (Hero x : heroes) {
			System.out.printf("%-20s ", "Power: "+x.getPower());
		}
		System.out.println("");	
	}
	
	public void showDemons() {
		for (int i = 0; i < demons.size(); i++) {
			System.out.printf("%-20s ", (i+1));
		}
		System.out.println("");
		
		for (Demon x : demons) {
			System.out.printf("%-20s ", "Name: "+x.getName());
		}
		System.out.println("");
		
		for (Demon x : demons) {
			System.out.printf("%-20s ", "Title: "+x.getTitle());
		}
		System.out.println("");
		
		for (Demon x : demons) {
			System.out.printf("%-20s ", "Hp: "+x.getHp());
		}
		System.out.println("");	
	}

	public void showCharacters() {
		System.out.println("Demons");
		System.out.println("=========");
		
		showDemons();
		
		System.out.println("\n");
		
		System.out.println("Heroes");
		System.out.println("=========");
		
		showHeroes();
	}
	
	public Demon chooseDemon() {
		int choice;
		
		showDemons();
		do {
			System.out.print(">> ");
			choice = scan.nextInt()-1; scan.nextLine();
		} while (choice < 0 || choice > demons.size()-1);
		
		return demons.get(choice);
	}
	
	public Hero chooseHero() {
		int choice;
		
		showHeroes();
		do {
			System.out.print(">> ");
			choice = scan.nextInt()-1; scan.nextLine();
		} while (choice < 0 || choice > heroes.size()-1);
		
		return heroes.get(choice);
	}
}

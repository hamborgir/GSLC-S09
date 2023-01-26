import java.util.Scanner;
import java.util.Vector;
import java.util.Random;

public class Main {
	Vector<Pokemon> field = new Vector<>();
	Vector<Pokemon> pokedex = new Vector<>();
	Vector<Pokeball> inventory = new Vector<>();
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	
	public Main() {
		int choice = 0;
		
		do {
			showField();
			
			System.out.println("Pokemon: The Game");
			System.out.println("=================");
			System.out.println("1. Spawn Pokemon");
			System.out.println("2. Spawn Pokeball");
			System.out.println("3. Catch Pokemon");
			System.out.println("4. Show Pokedex");
			System.out.println("4. Exit");
			
			System.out.print(">> ");
			choice = scan.nextInt(); scan.nextLine();
			
			switch (choice) {
			
			case 1: // make Pokemon object
				spawnPokemon();
				break;
				
			case 2:
				spawnPokeball();
				
				break;
				
			case 3:
				catchMenu();
				
				break;
			case 4:
				showPokedex();
				break;
			case 5:
				System.out.println("Exitting the game...");
				
				break;
			default:
				
				break;
			}
			
		} while (choice != 5);
		
	}
	
	public void catchMenu() {
		// TODO Auto-generated method stub
		if (!showPokeball()) {
			return;
		}
		
		System.out.println("Choose pokeball");
		System.out.print("\n>>");
		int pickBall = scan.nextInt(); scan.nextLine();
		
		if (!showField()) {
			return;
		}
		
		System.out.println("Choose pokemon in field to catch");
		System.out.print("\n>>");
		int pickPokemon = scan.nextInt(); scan.nextLine();
		
		pickBall--; pickPokemon--;
		
		if (inventory.get(pickBall).catchPokemon(field.get(pickPokemon))) {
			
			System.out.println("Successfully catched " + field.get(pickPokemon).getName());
			
			pokedex.add(field.get(pickPokemon));
			
			field.remove(pickPokemon);
			inventory.remove(pickBall);
		}
		
		else {
			System.out.println("Failed to catch " + field.get(pickPokemon).getName());
		}
	}

	public void spawnPokeball() {
		// TODO Auto-generated method stub
		Pokeball pokeball;
		
		if (rand.nextInt(2) == 1) {
			pokeball = new GreatPokeball();
		}
		else {
			pokeball = new LesserPokeball();
		}
		
		inventory.add(pokeball);
		
		if (pokeball instanceof GreatPokeball) {
			System.out.println("Great Pokeball spawned.");
		}
		else {
			System.out.println("Lesser Pokeball spawned.");
		}
		
		System.out.println("Pokeball added to inventory.\n");
		
	}

	public void spawnPokemon() {
		String name, type;
		
		System.out.print("Input pokemon name :");
		name = scan.nextLine();
		System.out.print("Input pokemon type :");
		type = scan.nextLine();
		
		Pokemon spawn = new Pokemon(name, type);
		
		field.add(spawn);
		System.out.println("Pokemon spawned to field\n");
		
	}

	public boolean showField(){
		System.out.println("Pokemon in field:");
		
		if (field.isEmpty()) {
			System.out.println("-- field is empty --\n");
			return false;
		}
		
		int n = 1;
		for (Pokemon x : field) {
			System.out.println((n++) + ". " + x.getName());
		}
		System.out.println("\n");
		
		return true;
	}
	
	public void showPokedex() {
		if (pokedex.isEmpty()) {
			System.out.println("You havent caught any pokemon yet!\n");
			return;
		}
		
		System.out.println("The pokemon you've caught:");
		int n = 1;
		for (Pokemon x : pokedex) {
			System.out.printf("%d. %s\n", n++, x.getName());
		}
		
		System.out.println("");
	}
	
	public boolean showPokeball() {
		if (inventory.isEmpty()) {
			System.out.println("You have no pokeball!\n");
			return false;
		}
		
		System.out.println("Pokeball list:");
		int n = 1;
		for (Pokeball x : inventory) {
			System.out.println((n++) + ". " + x.getBallType() + " (" + x.getSuccessRate() + "%)");
		}
		
		System.out.println("");
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}

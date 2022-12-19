
public class Demon extends CharacterObject {
	protected String title;

	public Demon(String name, int hp, int level, int power, String title) {
		super(name, hp, level, power);
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}

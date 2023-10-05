package elev.tec.dk;

public class HairColor {
	
	int Id;
	String Color;
	
	
	public HairColor() {}
	
	public HairColor(String color) {
		super();
		Color = color;
	}

	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}
}

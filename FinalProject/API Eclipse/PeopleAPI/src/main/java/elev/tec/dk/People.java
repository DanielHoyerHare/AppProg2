package elev.tec.dk;

public class People {
	
	int Id;
	String Name;
	String Tel;
	String Address;
	String Note;
	Boolean Fav;
	int HairColor;
	int ProgLang;
	
	
	public People() {}
	
	public People(String name, String tel, String address, String note, Boolean fav, int hairColor,
			int progLang) {
		super();
		Name = name;
		Tel = tel;
		Address = address;
		Note = note;
		Fav = fav;
		HairColor = hairColor;
		ProgLang = progLang;
	}

	public People(int id, String name, String tel, String address, String note, Boolean fav, int hairColor,
			int progLang) {
		super();
		Id = id;
		Name = name;
		Tel = tel;
		Address = address;
		Note = note;
		Fav = fav;
		HairColor = hairColor;
		ProgLang = progLang;
	}
	

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getTel() {
		return Tel;
	}

	public void setTel(String tel) {
		this.Tel = tel;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		this.Note = note;
	}

	public Boolean getFav() {
		return Fav;
	}

	public void setFav(Boolean fav) {
		this.Fav = fav;
	}

	public int getHairColor() {
		return HairColor;
	}

	public void setHairColor(int hairColor) {
		HairColor = hairColor;
	}

	public int getProgLang() {
		return ProgLang;
	}

	public void setProgLang(int progLang) {
		ProgLang = progLang;
	}
}

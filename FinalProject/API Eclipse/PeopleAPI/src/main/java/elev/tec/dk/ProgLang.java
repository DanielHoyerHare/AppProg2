package elev.tec.dk;

public class ProgLang {
	
	int Id;
	String Lang;
	
	
	public ProgLang() {}
	
	public ProgLang(String lang) {
		super();
		Lang = lang;
	}

	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getLang() {
		return Lang;
	}

	public void setLang(String lang) {
		Lang = lang;
	}
}

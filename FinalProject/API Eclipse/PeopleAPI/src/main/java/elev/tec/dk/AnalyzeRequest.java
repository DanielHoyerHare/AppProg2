package elev.tec.dk;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalyzeRequest {
	
	MatchEnum match;
	int id;
	
	public MatchEnum getMatch() {
		return match;
	}


	public int getId() {
		return id;
	}


	public AnalyzeRequest(String pathInfo) {
		Analyze(pathInfo);		
	}
	
	public void Analyze(String pathInfo) {
		
		// People get and getall
		Matcher matcher = Pattern.compile("/People/([0-9]+)").matcher(pathInfo);
		
		if (matcher.find()) {
			match = MatchEnum.MatchPeopleId;
			id = Integer.parseInt(matcher.group(1));
			return;
		}
			
		matcher = Pattern.compile("/People").matcher(pathInfo);
			
		if (matcher.find()) {
			match = MatchEnum.MatchPeople;
			return;
		}
		
		// HairColor get and getall
		matcher = Pattern.compile("/HairColor/([0-9]+)").matcher(pathInfo);
		
		if (matcher.find()) {
			match = MatchEnum.MatchHairColorId;
			id = Integer.parseInt(matcher.group(1));
			return;
		}
		
		matcher = Pattern.compile("/HairColor").matcher(pathInfo);
		
		if (matcher.find()) {
			match = MatchEnum.MatchHairColor;
			return;
		}
		
		// ProgLang get and getall
		matcher = Pattern.compile("/ProgLang/([0-9]+)").matcher(pathInfo);
		
		if (matcher.find()) {
			match = MatchEnum.MatchProgLangId;
			id = Integer.parseInt(matcher.group(1));
			return;
		}
		
		matcher = Pattern.compile("/ProgLang").matcher(pathInfo);
		
		if (matcher.find()) {
			match = MatchEnum.MatchProgLang;
			return;
		}
		
		match = MatchEnum.MatchNo;
	}
}

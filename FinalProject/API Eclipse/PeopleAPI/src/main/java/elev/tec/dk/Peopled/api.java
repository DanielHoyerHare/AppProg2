package elev.tec.dk.Peopled;

import elev.tec.dk.AnalyzeRequest;
import elev.tec.dk.DBTools;
import elev.tec.dk.People;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

//@WebServlet("/api")
public class api extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		AnalyzeRequest analyze = new AnalyzeRequest(request.getPathInfo());
		
		ObjectMapper mapper = new ObjectMapper();
		
		DBTools db = new DBTools();
		
		switch(analyze.getMatch()) {
		case MatchPeopleId:
			People p = db.getPeopleById(analyze.getId());
			out.write(mapper.writeValueAsString(p));
			break;
		case MatchPeople:
			break;
		case MatchNo:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestJSON = request.getReader().readLine();
		
		ObjectMapper mapper = new ObjectMapper();
		
		People p = mapper.readValue(requestJSON, People.class);
		
		System.out.println(p.getName());
		
	}
}

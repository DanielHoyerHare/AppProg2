package com.example.api.example1;

import com.example.api.AnalyzeRequest;
import com.example.api.Frugt;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		//out.println("Context path: " + request.getContextPath());
		//out.println("Servlet path: " + request.getServletPath());
		//out.println("Path info: " + request.getPathInfo());
		
		AnalyzeRequest analyze = new AnalyzeRequest(request.getPathInfo());
		
		ArrayList<Frugt> frugter = new ArrayList<Frugt>();
		frugter.add(new Frugt(1, "Appelsin", "Den er meget sur", 12300, "Orange County"));
		frugter.add(new Frugt(2, "Æble", "Rød og flot", 10031, "Æblemand land"));
		frugter.add(new Frugt(3, "Tomat", "Det en grøntsag", 1, "Spanien"));
		frugter.add(new Frugt(4, "Solbær", "Sort og sød", 320, "Himlen"));
		
		ObjectMapper mapper = new ObjectMapper();
		
		switch(analyze.getMatch()) {
		case MatchFrugtId:
			//out.write("Match på Frugt id: " + analyze.getId());
			out.write(mapper.writeValueAsString(frugter.get(analyze.getId())));
			break;
		case MatchFrugt:
			//out.write("Match på Frugt");
			out.write(mapper.writeValueAsString(frugter));
			break;
		case MatchNo:
			out.write("Intet match");
			break;
		}
	}
}

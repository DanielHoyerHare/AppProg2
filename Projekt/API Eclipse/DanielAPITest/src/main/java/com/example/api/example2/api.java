package com.example.api.example2;

import com.example.api.AnalyzeRequest;
import com.example.api.DBTools;
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

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		AnalyzeRequest analyze = new AnalyzeRequest(request.getPathInfo());
		
		ObjectMapper mapper = new ObjectMapper();
		
		DBTools db = new DBTools();
		
		switch(analyze.getMatch()) {
		case MatchFrugtId:
			Frugt f = db.getFrugtById(analyze.getId());
			out.write(mapper.writeValueAsString(f));
			break;
		case MatchFrugt:
			break;
		case MatchNo:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestJSON = request.getReader().readLine();
		
		ObjectMapper mapper = new ObjectMapper();
		
		Frugt f = mapper.readValue(requestJSON, Frugt.class);
		
		System.out.println(f.getName());
		
	}
}

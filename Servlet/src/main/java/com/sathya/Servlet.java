package com.sathya;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet {


public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
    System.out.println("in Service");

    res.setContentType("text/html");

    PrintWriter out = res.getWriter();
    out.println("<h2><b>Hello World</b></h2>");
}
}

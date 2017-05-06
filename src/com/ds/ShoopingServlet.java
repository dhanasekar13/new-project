package com.ds;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@SuppressWarnings("serial")
public class ShoopingServlet extends HttpServlet {
	ArrayList<String> a1=new ArrayList<String>();
	ArrayList<String> a2=new ArrayList<String>();
	ArrayList<String> a3=new ArrayList<String>();
	ArrayList<String> a4=new ArrayList<String>();
	ArrayList<String> a5=new ArrayList<String>();
	String z1,z2,z3,z4;
	int i=0;
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		String customername=req.getParameter("var1");
		String customeraddress=req.getParameter("var2");
		String details=req.getParameter("var3");
		String status=req.getParameter("var4");
	z1=customername;
	z2=customeraddress;
	z3=details;
	z4=status;	
	
		if(customername.isEmpty()||customeraddress.isEmpty()||details.isEmpty()||status.isEmpty())
		{
		//here i need to send to one more html	
			RequestDispatcher r1=req.getRequestDispatcher("a1.html");
			r1.forward(req,resp);
		
		}
		else
		{
			a1.add(i,customername);
			a2.add(i,customeraddress);
			a3.add(i,details);
			a4.add(i,status);
i++;
			RequestDispatcher r2=req.getRequestDispatcher("a2.html");
			r2.forward(req,resp);	 
		}
		
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		//resp.getOutputStream();
		String z=req.getParameter("s1");
		PrintWriter o=resp.getWriter();
		int result = Integer.parseInt(z);
		if(result==1)
		{
			o.println("<stylebackground=w_hd1.jpg>");
		//	o.println("body background=w_hd1.jpg");
			o.println("<br><br><h1>the detailes of the purchase is</h1>");	 
			o.println(a1);o.println(a2);o.println(a3);o.println(a4);
		}
		if(result==2)
		{int a=a1.indexOf(z1);
		a1.remove(a);
		a2.remove(a);
		a3.remove(a);
		a4.remove(a);
		o.println("<style>background=w_hd1.jpg</style>");
		o.println("body background=w_hd1.jpg");
			o.println(" <br><br> <br><h1>the respective data are deleted</h1>"); 
		}
		if(result==3)
		{int a=a1.indexOf(z1);
		o.println("<style>background=w_hd1.jpg</style>");
		//o.println("body background=w_hd1.jpg");
		o.println("background-im<br>the details of the info is ");
		o.println("<br><center> the user name is "+a1.get(a)+"</center>");
		o.println("<br><center> the user address is "+a2.get(a)+"</center>");
		o.println("<br><center> the user details is "+a3.get(a)+"</center>");
		o.println("<br><center> the user status is "+a4.get(a)+"</center>");
		}
		if(result==4)
		{int a=a1.indexOf(z1);
		o.println("<style>background=w_hd1.jpg</style>");
		//o.println("body background=w_hd1.jpg");
		o.println("<br><br> The current status of the purchase is"+a4.get(a));
			
		}
				
		
	}
	
}

package com.pratik.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pratik.domain.student;
import com.pratik.service.StudentService;

public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//doPost Method
		protected void doPost(HttpServletRequest request,HttpServletResponse response)
				throws ServletException,IOException {
			//set the content type		
			response.setContentType("text/html");
			//get the writer
				PrintWriter out = response.getWriter();
					//get vlaues from html page
						String id = request.getParameter("sid");
						int sid=Integer.parseInt(id);
							String sname = request.getParameter("sname");
									String sresult = request.getParameter("sresult");
										//call the service method
							StudentService std_Service = new StudentService();
								//call the add method and send parameters 
								std_Service.add(sid, sname, sresult);
								//call the add getAllStudents method and convet into list of domain class 
									ArrayList<student> std_List =std_Service.ShowStudents();
			//write the html display part	
			out.println("<html>");
				out.println("<body>");
					out.println("<h2>Pratik Softwares</h2>");
						out.println("<h3>Student Information</h3>");
							out.println("<table border='1'>");
								out.println("<tr><th>ID</th><th>NAME</th><th>RESULT</th></tr>");
								//convert object list into iterator
									Iterator<student> it = std_List.iterator();
									//display one by one row
										while(it.hasNext()) {
											//use iterator to display the row by row
												student std = (student) it.next();
													out.println("<tr>");
														out.println("<td>"+std.getId()+"</td>");
														out.println("<td>"+std.getName()+"</td>");
														out.println("<td>"+std.getResult()+"</td>");
													out.println("</tr>");
											}//while close
										out.println("</table><hr></body></html>");
				//request dispatcher for calling another html file i.e include into our app
						RequestDispatcher req_Dispatcher =request.getRequestDispatcher("/addForm.html");
							//include method 
						req_Dispatcher.forward(request, response);
			}//doPost() close
	}//class close

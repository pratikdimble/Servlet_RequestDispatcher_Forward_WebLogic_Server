package com.pratik.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.pratik.connection.connectionFactory;
import com.pratik.domain.student;

	public class StudentService {
		Connection con=null;
		//create the dufault constructor
			public StudentService(){
				//get the connection factory
				con=connectionFactory.getConnection();
			}
		// create the list of domain class
			ArrayList<student> list;
			//create method for insertion
				public void add(int sid, String sname, String sresult) {
				try {
					
						//create the statement
									Statement st = con.createStatement();
									//execute the insertion query
										st.executeUpdate("insert into student values('"+sid+"','"+sname+"','"+sresult+"')");
				} catch (Exception e) {
						e.printStackTrace();
			}
		}
//create method for display the list of students
			public ArrayList<student> ShowStudents(){
					try {
							//create the statement
								Statement st = con.createStatement();
								//execute the select query
									ResultSet rs = st.executeQuery("select * from student");
									//create the list
							list = new ArrayList<student>();
							//copy the data of resultset into list
								while(rs.next()) {
									//add row by row into list
										student std = new student();
											std.setId(rs.getInt("ID"));
											std.setName(rs.getString("NAME"));
											std.setResult(rs.getString("RESULT"));
												list.add(std);
								}
						} catch (Exception e) {
							e.printStackTrace();
					}
					//return the list
						return list;
			}
	}

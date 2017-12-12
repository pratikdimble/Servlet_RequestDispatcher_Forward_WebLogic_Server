# Servlet_RequestDispatcher_Forward
To forward the client request to another Servlet to honour (that is, client calls a Servlet but response to client is given by another Servlet). 

# RequestDispatcher forward() Method
# When to use RequestDispatcher forward() method? 
Client calls a Servlet for some information. But the Servlet cannot honour the request because it is incapable. 
But it knows that another Servlet exists which can do the job of the client. Then how the first Servlet (called by the client) can send (forward) the request to another Servlet. Here, forward() method of RequestDispatcher is used.  

# void forward(ServletRequest request, ServletResponse response) throws ServletException, IOException: 

Forwards a request from a Servlet to another resource (Servlet, JSP file, or HTML file) on the server. This method allows one Servlet to do preliminary processing of a request and another resource to generate the response.

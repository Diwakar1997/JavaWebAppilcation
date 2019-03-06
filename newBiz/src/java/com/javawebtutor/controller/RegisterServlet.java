package com.javawebtutor.controller;
import com.javawebtutor.hibernate.util.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javawebtutor.model.User;
import com.javawebtutor.service.RegisterService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class RegisterServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	 response.setContentType("text/html;charset=UTF-8");
	 PrintWriter out = response.getWriter();
	 String firstName = request.getParameter("firstName");
	 String middleName = request.getParameter("middleName");
	 String lastName = request.getParameter("lastName");
         String fatherName = request.getParameter("fatherName");
         String motherName = request.getParameter("motherName");
	 String email = request.getParameter("email");
	 String userId = request.getParameter("userId");
	 String password = request.getParameter("password");
         String address = request.getParameter("address");
         String aadhar1 = request.getParameter("aadhar");
         String RegisterId = request.getParameter("sponseId");
         Long aadhar= new Long(aadhar1);
         Integer i1=0;
         GetUser get=new GetUser();
         User tempUser= get.getUserByUserId(RegisterId);
         if(tempUser!=null){
	 User user = new User(firstName,middleName,lastName,fatherName,motherName,email,userId, password,address,aadhar,i1,RegisterId);	
	 try {	
                 
		 RegisterService registerService = new RegisterService();
		 boolean result = registerService.register(user);
                   User u1=get.getUserByUserId(RegisterId);
                   if(u1==null)
                   {  
                   }
                   Integer i2= u1.getaddedUsers();
                   u1.setaddedUsers(i2+1);
                   Session session = HibernateUtil.getSession();
	     Transaction tx = null;
                 try {
		 tx = session.getTransaction();
		 tx.begin();
                 u1.setEarnings(u1.getEarnings()+180);
                 session.saveOrUpdate(u1);
                 User p2=get.getUserByUserId(u1.getRegisterId());
                  if(p2!=null)
                  { p2.setEarnings(p2.getEarnings()+50);
                 session.saveOrUpdate(p2);
                  User p3=get.getUserByUserId(p2.getRegisterId());
                   if(p3!=null)
                   {
                   p3.setEarnings(p3.getEarnings()+30);
                 session.saveOrUpdate(p3);
                 User p4=get.getUserByUserId(p3.getRegisterId());
                   if(p4!=null)
                   {
                   p4.setEarnings(p4.getEarnings()+30);
                 session.saveOrUpdate(p4);
                 User p5=get.getUserByUserId(p4.getRegisterId());
                  if(p5!=null)
                  {
                      p5.setEarnings(p5.getEarnings()+30);
                       session.saveOrUpdate(p5);
                  }
                   }
                   }    
                  }
                 
		 tx.commit();
	 } catch (Exception e) {
		 if (tx != null) {
			 tx.rollback();
		 }
		 e.printStackTrace();
	 } finally {
		 session.close();
                 
	 }
                   	
	
        
             
		 		
		 out.println("<html>");
		 out.println("<head>");		
		 out.println("<title>Registration Successful</title>");
                 out.println("<style>\n" +
"             #rcorners3 {\n" +
"                   border-radius: 15px 50px;\n" +
"                   background: lightgreen;\n" +
"                   text-align: center;\n" +
"                   padding: 20px;\n" +
"                   margin:0 auto;\n" +
"                   width: inherit;\n" +
"                   height: inherit;\n" +
"            \n" +
"                         }             \n" +
"         </style>");
		 out.println("</head>");
		 out.println("<body background='images/backplace.jpg'>");
		 out.println("<center>");
                 
		 if(result){
                         out.println("<div id=\"rcorners3\" >");
			 out.println("<h1>Thanks for Registering with us :</h1>");
			 out.println("To login with new UserId and Password<a href=login.jsp>  Click here</a>");
                         out.println("</div>");
		 }else{
                         out.println("<div id=\"rcorners3\" >");
			 out.println("<h1>Registration Failed</h1>");
			 out.println("To try again<a href=register.jsp> Click here</a>");
                         out.println("</div>");
		 }
		 out.println("</center>");
		 out.println("</body>");
		 out.println("</html>");
	 } finally {		
		 out.close();
	 }
}
         else
          {
           response.sendRedirect("error2.jsp");
          }
        }
}
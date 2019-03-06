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


public class newRegisterServlet extends HttpServlet {
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
         String registerId = request.getParameter("registerId");
         Long aadhar= new Long(aadhar1);
         Integer i1=0;
	 User user = new User(firstName,middleName,lastName,fatherName,motherName,email,userId, password,address,aadhar,i1,registerId);		
	 try {	GetUser get=new GetUser();
		 RegisterService registerService = new RegisterService();
		 boolean result = registerService.register(user);
                 User p1=get.getUserByUserId(registerId);
                
                
                   Integer i2= p1.getaddedUsers();
                   p1.setaddedUsers(i2+1);
                   Session session = HibernateUtil.getSession();
	     Transaction tx = null;
                 try {
                    
                  
		 tx = session.getTransaction();
		 tx.begin();
                 p1.setEarnings(p1.getEarnings()+180);
                 session.saveOrUpdate(p1);
                 User p2=get.getUserByUserId(p1.getRegisterId());
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
		 out.println("</head>");
		 out.println("<style>");
                 out.println( "#rcorners3 {border-radius: 15px 50px; background: #808080; text-align: center;padding: 20px;margin:0 auto;width:inherit; height:inherit;}  ");
                 out.println("</style>");
		 out.println("<body background=\"images/watchit.jpg\">");
		 out.println("<center>");
		 if(result){
                     
			 out.println("<div id=\"rcorners3\" >");
			 out.println("<h1>Thanks for Registering with us :</h1>");
			 out.println("To login with new UserId and Password<a href=login.jsp> Click here </a>");
                         out.println("</div>");
		 }else{
                         out.println("<div id=\"rcorners3\" >");
			 out.println("<h1>Registration Failed</h1>");
			 out.println("To try again<a href=register2.jsp>Click here</a>");
                         out.println("</div>");
		 }
		 out.println("</center>");
		 out.println("</body>");
		 out.println("</html>");
	 }
         finally {		
		 out.close();
	 }
         
}

}
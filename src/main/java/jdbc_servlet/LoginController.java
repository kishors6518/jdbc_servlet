package jdbc_servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/login")
public class LoginController extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		
		try {
			PersonCrud crud=new PersonCrud();
			String dbpass=crud.getPassword(email);
			if(dbpass!=null)
			{
				if(dbpass.equals(pass))
				{
					res.getWriter().print("Login Successful");
				}
				else
				{
					res.getWriter().print("Please check credentials");
				}
			}
			else
			{
				res.getWriter().print(email+" is not registered");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

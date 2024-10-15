package jdbc_servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/signup")
public class SignUpController extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Person person=new Person();
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		long phone=Long.parseLong(req.getParameter("phone"));
		String address=req.getParameter("add");
		String email=req.getParameter("email");
		String password=req.getParameter("pass");
		
		person.setId(id);
		person.setName(name);
		person.setPhone(phone);
		person.setAddress(address);
		person.setEmail(email);
		person.setPassword(password);

		PersonCrud crud=new PersonCrud();
		int result = 0;
		try {
			result = crud.singUp(person);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result != 0) {
			res.getWriter().print("SignUp Successful");
		} else {
			res.getWriter().print("SignUp failed plese re-enter data");
		}
	}

}

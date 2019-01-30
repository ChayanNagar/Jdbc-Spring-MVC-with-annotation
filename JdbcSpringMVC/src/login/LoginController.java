package login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import beans.EmpBean;
import dao.MyDao;

@Controller
public class LoginController {
	@RequestMapping("/")
	public ModelAndView Welcome()
	{
		ModelAndView mv=new ModelAndView("Login");
		mv.addObject("msg","Welcome Spring Mvc Login");
		return mv;
		
	}
	@RequestMapping("/check")
	public ModelAndView adminCheck(HttpServletRequest request)
	{
		String u=request.getParameter("uid");
		String p=request.getParameter("pwd");
		ModelAndView mv=null;
		MyDao m=new MyDao();
		   int x=m.loginCheck(u, p);
		   if(x==1)
		   {
			mv=new ModelAndView("Home","msg","Login Success,Welcome At Admin Home") ;  
		   }
		   else {
			   mv=new ModelAndView("Login","msg","Login Fail..Try Again") ;
		   }
		   return mv;
	}
	@RequestMapping("/create")
	public ModelAndView employeeDetails()
	{
		ModelAndView mv=new ModelAndView("AddEmployee");
		mv.addObject("msg","Welcome Spring Mvc Login");
		return mv;
		
	}

	@RequestMapping("/empinsert")
	public ModelAndView empinsert(HttpServletRequest request)
	{
		String empname=request.getParameter("ename");
		String esalary=request.getParameter("salary");
		double eesalary=Double.parseDouble(esalary);
		String empaddress=request.getParameter("address");
		
		ModelAndView mv=null;
		MyDao m=new MyDao();
		
		EmpBean e=new EmpBean();
		e.setEname(empname);
		e.setSalary(eesalary);
		e.setAddress(empaddress);
		
		int x= m.insertCustomer(e);
		   if(x==1)
		   {
			mv=new ModelAndView("AddEmployee","msg","Data Inserted Succesfully") ;  
		   }
		   else {
			   mv=new ModelAndView("AddEmployee","msg","Data not inserted") ;
		   }
		   return mv;
	}
	
}

package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.entity.Employee;
import com.nt.service.EmployeeMgmtServiceImpl;
import com.nt.service.IEmployeeMgmtService;

@WebServlet("/controller")
public class MainContollerServlet extends HttpServlet {
	 private   IEmployeeMgmtService service;
	@Override
	public void init() throws ServletException {
             service=new EmployeeMgmtServiceImpl();	
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //create /Locate SEssion
		HttpSession ses=req.getSession();
		//for Page Size
		int pageSize=0;
		if(req.getParameter("size")!=null) {
			//read form data
		   pageSize=Integer.parseInt(req.getParameter("size"));
		   ses.setAttribute("pageSize", pageSize);
		}
		else {
			pageSize=(int)ses.getAttribute("pageSize");
		}
		//for page No
		int pageNo=0;
		if(req.getParameter("pageNo")!=null) {
			pageNo=Integer.parseInt(req.getParameter("pageNo"));
		}
		else {
			pageNo=1;
		}
		//use service
		  try {
			  List<Employee> list=service.fetchEmployeesByPagination(pageNo, pageSize);
			  long count=service.getPagesCount(pageSize);
			  //keep results in request scope
			  req.setAttribute("listEmps", list);
			  req.setAttribute("pagesCount",count);
			  //forward to report.jsp
			  RequestDispatcher rd=req.getRequestDispatcher("/report.jsp");
			  rd.forward(req, res);
		  }
		  catch(Exception e) {
			  e.printStackTrace();
			  RequestDispatcher rd=req.getRequestDispatcher("/error.jsp");
			  rd.forward(req, res);
		  }
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       doGet(req,res);
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}

}

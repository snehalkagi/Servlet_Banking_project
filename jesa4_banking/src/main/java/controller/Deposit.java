package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankDao;
import dto.BankAccount;
import dto.Customer;
import dto.banktransaction;

@WebServlet("/deposit")
public class Deposit extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Customer customer=(Customer)req.getSession().getAttribute("customer");
		

		if(customer==null)
		{
			resp.getWriter().print("<h1>Session Expired Login Again</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
		else{
		double amt=Double.parseDouble(req.getParameter("amt"));
		long acno=(long)req.getSession().getAttribute("acno");
		BankDao bankDao=new BankDao();
		BankAccount account=bankDao.find(acno);
		account.setAmount(account.getAmount()+amt);
		
		banktransaction banktransaction=new banktransaction();
		banktransaction.setDeposit(amt);
		banktransaction.setWithdraw(0);
		banktransaction.setBalance(account.getAmount());
		banktransaction.setDate(LocalDateTime.now());
		
		List<banktransaction> list1=account.getBanktransactions();
        list1.add(banktransaction);
        account.setBanktransactions(list1);
		
		bankDao.update(account);
		resp.getWriter().print("<h1>Amount added successfully</h1>");
		req.getRequestDispatcher("AccountHome.jsp").include(req, resp);
		
	}
	}
}

<%@page import="dto.banktransaction"%>
<%@page import="java.util.List"%>
<%@page import="dto.BankAccount"%>
<%@page import="dao.BankDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>viewtransaction</title>
</head>
<body>

<%long acno=(long)request.getSession().getAttribute("acno");
BankDao bankDao=new BankDao();
BankAccount account=bankDao.find(acno); 
List<banktransaction> banktransactions=account.getBanktransactions();
%>

<h1>Account number:<%=acno %></h1><br>
<h1>Account Type:<%=account.getType() %></h1>

<table border="1">

<tr>
<th>Id</th>
<th>Deposit</th>
<th>Withdraw</th>
<th>Balance</th>
<th>Date</th>

</tr>

<%for(banktransaction banktransaction:banktransactions){ %>
<tr>
<th><%=banktransaction.getId()%></th>
<th><%=banktransaction.getDeposit()%></th>
<th><%=banktransaction.getWithdraw() %></th>
<th><%=banktransaction.getBalance()%></th>
<th><%=banktransaction.getDate()%></th>

</tr>
<%} %>
</table>

</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'js.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>

		<script type="text/javascript">
	     // alert("arg");//弹出对话框
	      
	      function xx(){
	     // var x= confirm("确定删除");//确认对话框
	     // alert("x");
	     // return x;
	     // var a=new Number(2);
	     // alert(a);
	      var a=new Date();
	       alert(a.toLocaleString());
	      }
	      var xx=new Array();
	      xx[0]="a";
	      xx[1]=123123;
	     // alert(xx[0]);
	      function add(a,b){
	   
	      alert(a+b);
	      }
	      function jia(){
	      var n1=parseInt(document.getElementById("num1").value);//文档 获取元素by id
	      var n2=parseInt(document.getElementById("num2").value);      	     
	      var n3=n1+n2;
	      //alert(n3);
	      document.getElementById("num3").value=n3;
	      }
	      function jian(){
	      var n1=parseInt(document.getElementById("num1").value);//文档 获取元素by id
	      var n2=parseInt(document.getElementById("num2").value);      	     
	      var n3=n1-n2;
	      //alert(n3);
	      document.getElementById("num3").value=n3;
	      }
	      function mul(){
	      var n1=parseInt(document.getElementById("num1").value);//文档 获取元素by id
	      var n2=parseInt(document.getElementById("num2").value);      	     
	      var n3=n1*n2;
	      //alert(n3);
	      document.getElementById("num3").value=n3;
	      }
	      function div(){
	      var n1=parseInt(document.getElementById("num1").value);//文档 获取元素by id
	      var n2=parseInt(document.getElementById("num2").value);      	     
	      var n3=n1/n2;
	      //alert(n3);
	      document.getElementById("num3").value=n3;
	      }	      
        </script>
        aaaa
        <a href="javascript:void(0)" onclick="add(3,4)">删除</a>
         <input type ="text" id ="num1" />
         <input type ="text" id ="num2"/>
         <input type="button" value="+" onclick="jia()">        
         <input type="button" value="-" onclick="jian()">
         <input type="button" value="*" onclick="mul()">
         <input type="button" value="/" onclick="div()">
         <input type ="text" id ="num3" />
	</body>
</html>

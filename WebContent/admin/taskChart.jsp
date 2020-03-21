<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JS Chart</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/admin/js/jscharts.js"></script>
</head>
<body>
	<%
		Integer studentCount = (Integer) session
				.getAttribute("studentCountList");
		Integer teacherCount = (Integer) session
				.getAttribute("teacherCountList");
		Integer demoLectureCount = (Integer) session
			.getAttribute("demoCountList");
		Integer appliedStudentCount = (Integer) session
				.getAttribute("appliedCountList");

		System.out.println("Counts in chart.jsp" + studentCount
				+ teacherCount + demoLectureCount + appliedStudentCount);

		List ls = new ArrayList();
		Object[] obj = new Object[2];
		obj[0] = "Student";
		obj[1] = studentCount;
		ls.add(obj);
		obj = new Object[2];
		obj[0] = "Teacher";
		obj[1] = teacherCount;
		ls.add(obj);
		obj = new Object[2];
		obj[0] = "Demo Lecture";
		obj[1] = demoLectureCount;
		ls.add(obj);
		obj = new Object[2];
		obj[0] = "Applied Student";
		obj[1] = appliedStudentCount;
		ls.add(obj);
		session.setAttribute("lschart", ls);
	%>

	<c:forEach items="${sessionScope.lschart}" var="list1">

		<input type="hidden" name="status" value="${list1[0]}" />

		<input type="hidden" name="task" value="${list1[1]}" />
	</c:forEach>


	<div id="graph">Loading graph...</div>


	<script type="text/javascript">
		var statusname = document.getElementsByName("status");
		var tasks = document.getElementsByName("task");

		var myData = new Array(statusname.length);
		for (var i = 0; i < statusname.length; i++) {
			myData[i] = new Array(2);
			//myData[0][0] = "marketing"; //emp[0]+""+depl[0];

			myData[i][0] = statusname[i].value;
			myData[i][1] = parseInt(tasks[i].value);//emp[1]+""+depl[1];

			/* 		myData[1] = new Array(2);
			 myData[1][0] = "xyz"; //emp[0]+""+depl[0];
			 myData[1][1] = 456;//emp[1]+""+depl[1];
			 */
			//alert(myData);
		}

		//new Array([emp[0], depl[0]], [emp[1], depl[1]], ['Mar06-Mar07', 12], ['Mar07-Mar08', 17]);

		var colors = [ '#AF0202', '#EC7A00' ];
		var myChart = new JSChart('graph', 'line');
		myChart.setDataArray(myData);
		myChart.setLineColor('#8D9386');
		myChart.setLineWidth(4);
		myChart.setTitleColor('#7D7D7D');
		myChart.setAxisColor('#9F0505');
		myChart.setGridColor('#a4a4a4');
		myChart.setAxisValuesColor('#333639');
		myChart.setAxisNameColor('#333639');
		myChart.setTextPaddingLeft(0);
		myChart.draw();
		/* myChart.setDataArray(myData);
		myChart.colorizeBars(colors);
		myChart.setTitle('Task Status Graph');
		myChart.setTitleColor('#8C8382');
		myChart.setAxisNameX('');
		myChart.setAxisNameY('%');
		myChart.setAxisColor('#9D9F9D');
		myChart.setAxisNameFontSize(16);
		myChart.setAxisNameColor('#999');
		myChart.setAxisValuesColor('#7E7E7E');
		myChart.setBarValuesColor('#7E7E7E');
		myChart.setAxisPaddingTop(100);
		myChart.setAxisPaddingRight(140);
		myChart.setAxisPaddingLeft(150);
		myChart.setAxisPaddingBottom(40);
		myChart.setTextPaddingLeft(105);
		myChart.setTitleFontSize(20);
		myChart.setBarBorderWidth(5);
		myChart.setBarBorderColor('#DC143C');
		myChart.setBarSpacingRatio(50);
		myChart.setGrid(false);
		myChart.setSize(616, 321);
		myChart.setBackgroundImage('/images/chart_bg.jpg');
		myChart.draw();
 */	</script>

	<input type="hidden" name="flag" value="taskchart">
</body>
</html>
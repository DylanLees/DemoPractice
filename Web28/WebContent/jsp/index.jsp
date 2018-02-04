<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>1到100的所有素数之和</title>
</head>
<body>
	<%!public int getSum(int start, int end) {
		//定义一个变量用于接收和
		int sum = 0;
		for (int i = start; i <= end; i++) {
			boolean re = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					re = false;
					break;
				}
			}
			if (re && i != 1) {
				sum += i;
			}
		}

		return sum;
	}%>
	1到100所求的和的值为：<%=getSum(1, 100)%>
</body>
</html>
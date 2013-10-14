<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<title>Redmine辅助系统</title>
<%
	String path = request.getContextPath();
%>
<link href="<%=path%>/resources/css/base.css" media="all"
	rel="stylesheet" type="text/css">
<style type="text/css">
table td {
	padding: 2px 5px;
}
</style>
</head>
<body style="padding: 2em;">
	<h2>您好，${hourinfo.year}年${hourinfo.month}月份的工作信息如下:</h2>
	<div>
		<ul>
			<li>已分配任务的总工时: ${hourinfo.planingTime} 小时。</li>
			<li>已关闭的任务总工时: ${hourinfo.finishedTime} 小时。</li>
		</ul>
	</div>
	<c:if test="${issues!=null}">
		<div style="margin-top: 1em;">
			<div>未关闭的任务如下：</div>
			<div>
				<table border="1">
					<thead>
						<tr>
							<td align="center">#</td>
							<td>项目</td>
							<td>状态</td>
							<td>标题</td>
							<td>指派人</td>
							<td>预期工时</td>
							<!-- <td>更新时间</td> -->
						</tr>
					</thead>
					<c:forEach var="issue" items="${issues}">
						<tr>
							<td><a
								href="http://timekey.8866.org:3000/issues/${issue.id}"
								target="_blank">${issue.id}</a></td>
							<td><a
								href="http://timekey.8866.org:3000/projects/${issue.project.identifier}"
								target="_blank">${issue.project.name}</a></td>
							<td>${issue.issueStatus.name}</td>
							<td><a
								href="http://timekey.8866.org:3000/issues/${issue.id}"
								target="_blank">${issue.subject}</a></td>
							<td>${issue.assignedUser.firstname}${issue.assignedUser.lastname}</td>
							<td>${issue.estimatedHours}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</c:if>
	<div style="margin-top: 1em;color: gray;font-size: 10px;">
		注：本页面数据试运行，可能会不准确(希望可以反馈)，目前仅作参考，一切根据徐晋军统计为准。</div>
</body>
</html>
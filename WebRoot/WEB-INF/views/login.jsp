<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script src="${ctx}/static/js/jquery-1.11.1.js" type="text/javascript"></script>
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/css/bootstrap-grid.css">
<link rel="stylesheet" href="${ctx}/static/css/bootstrap-grid.min.css">
<link rel="stylesheet" href="${ctx}/static/css/bootstrap-reboot.css">
<link rel="stylesheet" href="${ctx}/static/css/bootstrap-reboot.min.css">
  <!-- 引入 echarts.js -->
<script src="${ctx}/static/js/echarts.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
<h1>登录成功
所有的美女们</h1>
<a href="${ctx }/getecharts.shtml" >查看美女年龄折线图</a>
<c:if test="${list ne null }">
<table class="table table-striped">
<tr>
 <td class="active">编号</td>
  <td class="success">宫女名称</td>
  <td class="warning">年龄</td>
  <td class="danger">创建时间</td>
   <td class="active" colspan="2">操作</td>
</tr>
<c:forEach items="${list }" var="gongnv"> 
<tr>
  <td class="active">${gongnv.id}</td>
  <td class="success">${gongnv.sname}</td>
  <td class="warning">${gongnv.age}</td>
  <td class="danger">${gongnv.createtime}</td>
  <td class="active" colspan="2"><a class="btn btn-default" href="${ctx }/update.shtml?id=${gongnv.id}" role="button">编辑</a><a class="btn btn-default" href="javascript:;" onclick="deleteGongnv(${gongnv.id})" role="button">删除</a></td>
</tr>
</c:forEach>
</table>
</c:if>
当前的页数：${pageInfo.pageNum}|
每页一共显示${pageInfo.size}列|
一共${pageInfo.total}条数据|
一共${pageInfo.pages}页|
显示的启始行：${pageInfo.startRow}|
结束的启始行：${pageInfo.endRow}
<script type="text/javascript">
function deleteGongnv(id){
	alert(id);
	$.post("${ctx}/delete.shtml",
			{id:id}, function(data) {
				alert(data.msg);
				 window.location.reload();//刷新当前页面.
			}).error(function() {
				alert(data.msg);
				 window.location.reload();//刷新当前页面.
	});
}
</script>
</body>
</html>
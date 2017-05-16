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
<script type="text/javascript" src="${ctx }/static/js/validation/jquery.validate.min.js"></script>
<script type="text/javascript" src="${ctx }/static/js/validation/additional-methods.js"></script>
<script type="text/javascript" src="${ctx }/static/js/validation/jquery.validate.defult.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改页面</title>
</head>
<body>
<form class="form-horizontal" role="form" action="${ctx}/gongnvupdate.shtml" method="post">
<input type="hidden" id="id" name="id" value="${gongnv.id }">
  <div class="form-group">
    <label for="firstname" class="col-sm-2 control-label">名字</label>
    <div class="col-sm-10">
      <input type="text" validate="{required: true,messages:{required:'必填'} }" class="form-control" id="sname"  name="sname" placeholder="请输入名字" value="${gongnv.sname }">
    </div>
  </div>
  <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">年龄</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄" value="${gongnv.age }">
    </div>
  </div>
   <div class="form-group">
    <label for="firstname" class="col-sm-2 control-label">入宫时间</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="createtime" name="createtime" placeholder="请输入入宫时间" value="${gongnv.createtime }">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default" id="submit" >修改</button>
    </div>
  </div>
</form>
<script>
	$(function() {
		$("#submit").click(function() {
			$("form").submit();
		});
		var v = $("form").validate(
				{
					submitHandler : function(form) {
						$.post("${ctx}/gongnvupdate.shtml",
								$("form").serialize(), function(data) {
									alert(data.msg);
								}).error(function() {
									alert(data.msg);
						});
					}
				});
	})
</script>
</body>
</html>
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
<title>美女年龄折线图页面</title>
</head>
<body>
<h1>美女年龄折线图</h1>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 600px;height:400px;"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart1 = echarts.init(document.getElementById('main'));
        var dataxAxis;
        $.post("${ctx }/echarts.shtml",function(result){
          // 指定图表的配置项和数据
          var option1 = {
              title: {
                  text: '美女年龄折线图'
              },
              tooltip: {},
              legend: {
                  data:['年龄']
              },
              xAxis: {
                  data: result.xAxisData
              },
              yAxis: {},
              series:result.seriesList
          };
          // 使用刚指定的配置项和数据显示图表。
          myChart1.setOption(option1);
          }, "json");
 /*  var myChart = echarts.init(document.getElementById('main1'));
 var  option= {
    series : [
        {
            name: '访问来源',
            type: 'pie',
            radius: '55%',
            data:[
                {value:235, name:'视频广告'},
                {value:274, name:'联盟广告'},
                {value:310, name:'邮件营销'},
                {value:335, name:'直接访问'},
                {value:400, name:'搜索引擎'}
            ],
            roseType: 'angle',
            itemStyle: {
                normal: {
                    shadowBlur: 200,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
  myChart.setOption(option); */
    </script>
</body>
</html>
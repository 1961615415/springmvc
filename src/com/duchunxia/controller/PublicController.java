package com.duchunxia.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.tools.ant.taskdefs.condition.Http;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duchunxia.domain.Gongnv;
import com.duchunxia.domain.GongnvExample;
import com.duchunxia.enu.SeriesType;
import com.duchunxia.repository.GongnvMapper;
import com.duchunxia.vo.ResultBean;
import com.duchunxia.vo.SeriesBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class PublicController {
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private GongnvMapper gongnvMapper;

	@RequestMapping(value = { "/index.shtml" }, method = { RequestMethod.POST,
			RequestMethod.GET })
	public String login(Model model) {
		System.out.println("登录成功");
		/*List<Map<String, Object>> list = jdbcTemplate
				.queryForList("select * from gongnv");
		for (Map<String, Object> map : list) {
			System.out.println(map.get("sname"));
		}*/
		PageHelper.startPage(1, 10);
		GongnvExample example = new GongnvExample();
		example.createCriteria().andAgeIsNotNull();
		List<Gongnv> list2 = gongnvMapper.selectByExample(example);
		PageInfo<Gongnv> pageInfo = new PageInfo<Gongnv>(list2);
		System.out.println(pageInfo);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("list", list2);
		return "/login";
	}
	@RequestMapping(value={"/getecharts.shtml"})
	public String getEcharts(){
		return "/echarts/index";
	}
	@RequestMapping(value = { "/echarts.shtml" }, method = {
			RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public JSONObject getAllAge() {
		List<String> xAxisData = new ArrayList<String>();
		List<String> seriesData = new ArrayList<String>();
		for (int i = 18; i < 28; i++) {
			xAxisData.add(i + "岁");
			GongnvExample example2 = new GongnvExample();
			example2.createCriteria().andAgeEqualTo(i);
			int count = gongnvMapper.countByExample(example2);
			System.out.println(count);
			seriesData.add(count + "");
		}
		JSONObject jsonObject1 = new JSONObject();
		jsonObject1.put("xAxisData", xAxisData);
		jsonObject1.put("seriesData", seriesData);
		List<JSONObject> seriesList = new ArrayList<JSONObject>();
		SeriesBean series = new SeriesBean("年龄", SeriesType.BAR.getValue(),
				seriesData);
		jsonObject1.put("name", series.getName());
		jsonObject1.put("type", series.getType());
		jsonObject1.put("data", series.getData());
		seriesList.add(jsonObject1);
		jsonObject1.put("seriesList", seriesList);
		return jsonObject1;
	}
@RequestMapping(value={"update.shtml"},method={RequestMethod.GET,RequestMethod.POST})
public String update(HttpServletRequest request,String id,Model model){
	if(StringUtils.isNotBlank(id)){
		Gongnv  gongnv=gongnvMapper.selectByPrimaryKey(Integer.valueOf(id));
		model.addAttribute("gongnv", gongnv);
	}
	return "/update";
}
@RequestMapping(value={"gongnvupdate.shtml"},method={RequestMethod.POST})
@ResponseBody
public ResultBean gongnvupdate(Gongnv gongnv){
	ResultBean resultBean=new ResultBean();
	if(gongnv!=null){
		GongnvExample example=new GongnvExample();
		example.createCriteria().andIdEqualTo(gongnv.getId());
		int i=gongnvMapper.updateByExampleSelective(gongnv, example);
		if(i>0){
			resultBean.isFlag();
			resultBean.setMsg("修改成功");
		}else{
			resultBean.setMsg("修改失败");
		}
	}else{
		resultBean.setMsg("宫女的数据不能为空");
	}
	return resultBean;
}
@RequestMapping(value={"delete.shtml"},method={RequestMethod.POST})
@ResponseBody
public ResultBean delete(HttpServletRequest request,String id){
	ResultBean resultBean=new ResultBean();
	if(StringUtils.isNotBlank(id)){
		int i=gongnvMapper.deleteByPrimaryKey(Integer.valueOf(id));
		if(i>0){
			resultBean.isFlag();
			resultBean.setMsg("删除成功");
		}else{
			resultBean.setMsg("删除失败");
		}
	}
	return resultBean;
}
}

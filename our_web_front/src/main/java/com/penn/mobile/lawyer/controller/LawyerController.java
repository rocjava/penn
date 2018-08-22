package com.penn.mobile.lawyer.controller;
import com.lawyer.common.Constant;
import com.lawyer.core.entity.Lawyer;
import com.lawyer.service.LawyerService;
import com.penn.memcached.ApaMemcachedClient;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RequestMapping("/lawyer/")
@Controller
public class LawyerController {

	private static Logger logger = Logger.getLogger(LawyerController.class);

	@Autowired
	private LawyerService lawyerService;

	@Autowired
	private ApaMemcachedClient tntMemcachedClient;
	
	//http://localhost:8080/lawymvc/lawyer/10015136/preDetail.do
	@RequestMapping("/{id}/preDetail")
	public String preDetail(@PathVariable String id, ModelMap modelMap ,HttpServletRequest request) {
		try{
			Lawyer lawyer = null;
			if(StringUtils.isBlank(id)){
				logger.info("查询lawyer id为空!");
				return null;
			}
			lawyer = tntMemcachedClient.get(Constant.ZHH_LAWYER+id);
			if(lawyer == null ){
				lawyer = lawyerService.findById(Integer.parseInt(id));
				tntMemcachedClient.set(Constant.ZHH_LAWYER+id, lawyer, Constant.INFO_CACHE_TIMELIMIT);
			}
			modelMap.put("lawyer", lawyer);
			
		}catch(Exception e){
			logger.info("!!!Exception happened when get lawyer detail by id:" + id +"  e:"+e);
		}
		return "showUser";
	}

	//http://localhost:8080/lawymvc/lawyer/detail.do?id=10015136
	@RequestMapping("/detail")
	public String detail(String id, ModelMap modelMap,HttpServletRequest request) {
		try{
			Lawyer lawyer = null;
			if(StringUtils.isBlank(id)){
				logger.info("查询lawyer id为空!");
				return null;
			}
			lawyer = tntMemcachedClient.get(Constant.ZHH_LAWYER+id);
			if(lawyer == null ){
				lawyer = lawyerService.findById(Integer.parseInt(id));
				tntMemcachedClient.set(Constant.ZHH_LAWYER+id, lawyer, Constant.INFO_CACHE_TIMELIMIT);
			}
			modelMap.put("lawyer", lawyer);
			
		}catch(Exception e){
			logger.info("!!!Exception happened when get lawyer detail by id:" + id +"  e:"+e);
		}
		return "layer/detail";
	}
	
	@RequestMapping("/redirect")
	public String redirect(Model model){
		return "redirect:/lawyer/10015136/preDetail.do";
	}
	
	//http://localhost:8080/lawymvc/lawyer/list.do
    @RequestMapping("/list")
    public String list(ModelMap model) {
    	logger.info("list lawyers limit 0-100");
    	List<Lawyer> list = null;
    	long start = System.currentTimeMillis();
		try{
			list = tntMemcachedClient.get(Constant.ZHH_LAWYERS);
			if(list == null ){
				list = lawyerService.findAll();
				tntMemcachedClient.set(Constant.ZHH_LAWYERS, list, Constant.INFO_CACHE_TIMELIMIT);
			}
		}catch(Exception e){
			logger.info("Exception happened when list lawyers! e:"+e);
		}
		long end = System.currentTimeMillis();
		logger.info("total time:"+(end-start));
        model.put("lawyers", list);
        return "lawyer";
    }
    
    @RequestMapping("/cop")
    public String test(ModelMap model) {
        return "cop";
    }
    
    @RequestMapping("/index")
    public String testb(ModelMap model) {
        return "index";
    }
    
    @RequestMapping("/insert")
    public String insert(ModelMap model) {
    	Lawyer lawyer = null;
    	Random rd = new Random();
    	logger.info("insert start");
    	long starTime=System.currentTimeMillis();
    	for(int i=0;i<1000;i++){
    		for(int j=0;j<10000;j++){
    			lawyer = new Lawyer();
    			lawyer.setName("penn"+i+j);
    			lawyer.setAge(rd.nextInt(35)+25);
    			lawyer.setDegree("1");
    			lawyer.setMobile("15600008888");
    			lawyer.setEmail("test12345@qq.com");
    			lawyer.setCreateDate(new Date());
    			lawyer.setLastModifyDate(new Date());
    			lawyer.setUniversity("复旦大学");
    			lawyer.setLevel("9");
    			lawyerService.insert(lawyer);
    		}
    	}
    	long endTime=System.currentTimeMillis();
    	logger.info("insert end");
    	logger.info("执行总时间:"+(endTime-starTime));
        return "index";
    }
    
    @RequestMapping("/insertBatch")
    public String insertBatch(ModelMap model) {
    	Lawyer lawyer = null;
    	Random rd = new Random();
    	List<Lawyer> list = new ArrayList<Lawyer>();
    	logger.info("insert start");
    	long starTime=System.currentTimeMillis();
    	for(int i=0;i<1000;i++){
    		for(int j=0;j<10000;j++){
    			lawyer = new Lawyer();
    			lawyer.setName("penn_"+i+j);
    			lawyer.setAge(rd.nextInt(35)+25);
    			lawyer.setDegree("1");
    			lawyer.setMobile("15600008888");
    			lawyer.setEmail("123456@qq.com");
    			lawyer.setCreateDate(new Date());
    			lawyer.setLastModifyDate(new Date());
    			lawyer.setUniversity("同济大学");
    			lawyer.setLevel("1");
    			list.add(lawyer);
    		}
    		logger.info("第"+(i+1)+"次");
    		lawyerService.insertForBatch(list);
    		list.clear();
    	}
    	long endTime=System.currentTimeMillis();
    	logger.info("insert end");
    	logger.info("执行总时间:"+(endTime-starTime));
        return "index";
    }
}
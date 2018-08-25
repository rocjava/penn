package our.lawyer.back.lawyer.controller;
import com.lawyer.common.Constant;
import com.lawyer.core.entity.Lawyer;
import com.lawyer.service.LawyerService;
import com.penn.jqgrid.DataResponse;
import com.penn.memcached.ApaMemcachedClient;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@RequestMapping("back/lawyer")
@Controller
public class LawyerController {

	private static Logger logger = Logger.getLogger(LawyerController.class);

	@Autowired
	private LawyerService lawyerService;

	@Autowired
	private ApaMemcachedClient tntMemcachedClient;

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


	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
    public DataResponse list(Lawyer lawyer,
							 @RequestParam(defaultValue="1",value="page") String page,
							 @RequestParam(defaultValue="10",value="rows") String rows) {
		int records;     //总记录数
		int totalPages;  //总页数
		int pageSize = StringUtils.isEmpty(rows) ? 10 : Integer.valueOf(rows);  //每页显示记录数
		int currPage = StringUtils.isEmpty(page) ? 1 : Integer.valueOf(page); //当前页码

		records = lawyerService.totalCounts(lawyer);
		totalPages = (records + pageSize -1) / pageSize;

		int startRow = pageSize * (currPage - 1);
		startRow = (startRow < 0) ? 0 : startRow;
		int endRow = currPage * pageSize ;
		List<Lawyer> list = new ArrayList<>();
		try{
			//list = tntMemcachedClient.get(Constant.ZHH_LAWYERS);
//			if(list == null ){

			list = lawyerService.findByPage(lawyer, startRow, endRow);
			//tntMemcachedClient.set(Constant.ZHH_LAWYERS, list, Constant.INFO_CACHE_TIMELIMIT);
//			}
		}catch(Exception e){
			logger.info("Exception happened when list lawyers! e:"+e);
		}

		DataResponse<Lawyer> response = new DataResponse<Lawyer>();
		response.setRecords(String.valueOf(records));
		response.setTotal(String.valueOf(totalPages));
		response.setPage(String.valueOf(currPage));
		response.setRows(list);


		return response;
    }


	@RequestMapping(value = "/createOrUpdateOrDelete", method = RequestMethod.PUT)
	@ResponseBody
	public String update(Lawyer lawyer, HttpServletRequest request){
		String oper = request.getParameter("oper");
		if(oper != null && oper.equalsIgnoreCase("del")){
			//TOTO
			//DELETE DATA
			logger.info("[DELETES] id:"+lawyer.getId());
		}else{
			logger.info("[UPDATE]:"+lawyer.toString());
		}
		return "SUCCESS";
	}

	@RequestMapping(value = "/createOrUpdateOrDelete", method = RequestMethod.POST)
	@ResponseBody
	public void add(Lawyer lawyer, HttpServletRequest request){
		logger.info("[ADD]:"+lawyer.toString());
	}
    
    @RequestMapping("/insert")
    public String insert(ModelMap model) {
    	Lawyer lawyer = null;
    	Random rd = new Random();
    	logger.info("insert start");
    	long starTime=System.currentTimeMillis();
    	for(int i=0;i<12;i++){
    		for(int j=0;j<7;j++){
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
    	for(int i=0;i<12;i++){
    		for(int j=0;j<3;j++){
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
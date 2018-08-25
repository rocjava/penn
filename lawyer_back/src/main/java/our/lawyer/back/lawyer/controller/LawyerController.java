package our.lawyer.back.lawyer.controller;
import com.lawyer.common.Constant;
import com.lawyer.core.entity.Lawyer;
import com.lawyer.service.LawyerService;
import com.penn.jqgrid.DataResponse;
import com.penn.memcached.CommMemcachedClient;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RequestMapping("back/lawyer")
@Controller
public class LawyerController {

	private static Logger logger = Logger.getLogger(LawyerController.class);

	@Autowired
	private LawyerService lawyerService;

	@Autowired
	private CommMemcachedClient commMemcachedClient;

	@RequestMapping("/detail")
	public String detail(String id, ModelMap modelMap,HttpServletRequest request) {
		try{
			Lawyer lawyer = null;
			if(StringUtils.isBlank(id)){
				logger.info("查询lawyer id为空!");
				return null;
			}
			lawyer = commMemcachedClient.get(Constant.ZHH_LAWYER+id);
			if(lawyer == null ){
				lawyer = lawyerService.findById(Integer.parseInt(id));
				commMemcachedClient.set(Constant.ZHH_LAWYER+id, lawyer, Constant.INFO_CACHE_TIMELIMIT);
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
			//list = commMemcachedClient.get(Constant.ZHH_LAWYERS);
//			if(list == null ){

			list = lawyerService.findByPage(lawyer, startRow, endRow);
			//commMemcachedClient.set(Constant.ZHH_LAWYERS, list, Constant.INFO_CACHE_TIMELIMIT);
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
	public String create(Lawyer lawyer, HttpServletRequest request){
		lawyerService.insert(lawyer);
		logger.info("[ADD]:"+lawyer.toString());
		return "index";
	}


	//生成随机数据
    @RequestMapping("/insertBatch")
    public String insertBatch(ModelMap model) {
    	Lawyer lawyer = null;
    	Random rd = new Random();
    	List<Lawyer> list = new ArrayList<Lawyer>();
    	logger.info("insert start");
    	long starTime=System.currentTimeMillis();
    	for(int i=0;i<8;i++){
    		for(int j=0;j<4;j++){
    			lawyer = new Lawyer();

    			lawyer.setName("penn_"+i+j);
    			lawyer.setAge(rd.nextInt(35)+25);
    			lawyer.setDegree("1");
				lawyer.setGender("男");
    			lawyer.setMobile("15600008888");
    			lawyer.setEmail("123456@qq.com");
    			lawyer.setCreateDate(new Date());
    			lawyer.setLastModifyDate(new Date());
    			lawyer.setUniversity("同济大学");
    			lawyer.setLevel("1");
				lawyer.setStatus("有效");
    			lawyer.setWorkingYears(5);
    			list.add(lawyer);
    		}
    		lawyerService.insertForBatch(list);
    		list.clear();
    	}
    	long endTime=System.currentTimeMillis();
    	logger.info("insertBatch执行总时间:"+(endTime-starTime));
        return "index";
    }
}
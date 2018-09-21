package our.lawyer.back.user.controller;

import com.lawyer.core.entity.Role;
import com.lawyer.service.RoleService;
import com.penn.jqgrid.DataResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/21.
 */

@RequestMapping("back/role")
@Controller
public class RoleController {
    private static Logger logger = Logger.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse list(Role role,
                             @RequestParam(defaultValue="1",value="page") String page,
                             @RequestParam(defaultValue="10",value="rows") String rows) {
        int records;     //总记录数
        int totalPages;  //总页数
        int pageSize = StringUtils.isEmpty(rows) ? 10 : Integer.valueOf(rows);  //每页显示记录数
        int currPage = StringUtils.isEmpty(page) ? 1 : Integer.valueOf(page); //当前页码

        records = roleService.totalCounts(role);
        totalPages = (records + pageSize -1) / pageSize;

        int startRow = pageSize * (currPage - 1);
        startRow = (startRow < 0) ? 0 : startRow;
        int endRow = currPage * pageSize ;
        List<Role> list = new ArrayList<>();
        try{
            list = roleService.findByPage(role, startRow, endRow);
        }catch(Exception e){
            logger.info("Exception happened when list lawyers! e:"+e);
        }

        DataResponse<Role> response = new DataResponse<Role>();
        response.setRecords(String.valueOf(records));
        response.setTotal(String.valueOf(totalPages));
        response.setPage(String.valueOf(currPage));
        response.setRows(list);


        return response;
    }
}

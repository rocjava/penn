package our.lawyer.back.user.controller;

import com.lawyer.core.entity.User;
import com.lawyer.service.UserService;
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

@RequestMapping("back/user")
@Controller
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/detail")
    public void detail(int id) {
        User user = userService.findById(id);
        System.err.println("100");
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse list(User user,
                             @RequestParam(defaultValue="1",value="page") String page,
                             @RequestParam(defaultValue="10",value="rows") String rows) {
        int records;     //总记录数
        int totalPages;  //总页数
        int pageSize = StringUtils.isEmpty(rows) ? 10 : Integer.valueOf(rows);  //每页显示记录数
        int currPage = StringUtils.isEmpty(page) ? 1 : Integer.valueOf(page); //当前页码

        records = userService.totalCounts(user);
        totalPages = (records + pageSize -1) / pageSize;

        int startRow = pageSize * (currPage - 1);
        startRow = (startRow < 0) ? 0 : startRow;
        int endRow = currPage * pageSize ;
        List<User> list = new ArrayList<>();
        try{
            list = userService.findByPage(user, startRow, endRow);
        }catch(Exception e){
            logger.info("Exception happened when list lawyers! e:"+e);
        }

        DataResponse<User> response = new DataResponse<User>();
        response.setRecords(String.valueOf(records));
        response.setTotal(String.valueOf(totalPages));
        response.setPage(String.valueOf(currPage));
        response.setRows(list);


        return response;
    }
}

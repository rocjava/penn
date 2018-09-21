package our.lawyer.back.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2018/8/14.
 */
@RequestMapping("/")
@Controller
public class CommonController {

    @RequestMapping("/index")
    @ResponseBody
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("index");
        return model;
    }

    @RequestMapping("/welcome")
    @ResponseBody
    public ModelAndView welcome() {
        ModelAndView model = new ModelAndView("welcome");
        return model;
    }

    @RequestMapping("/lawyer/lawyerList")
    @ResponseBody
    public ModelAndView lawyerList() {
        ModelAndView model = new ModelAndView("lawyerList");
        return model;
    }


    @RequestMapping("/user/userList")
    @ResponseBody
    public ModelAndView userList() {
        ModelAndView model = new ModelAndView("userList");
        return model;
    }
    @RequestMapping("/role/roleList")
    @ResponseBody
    public ModelAndView roleList() {
        ModelAndView model = new ModelAndView("roleList");
        return model;
    }
}

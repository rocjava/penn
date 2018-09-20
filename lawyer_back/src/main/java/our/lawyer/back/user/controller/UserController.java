package our.lawyer.back.user.controller;

import com.lawyer.core.entity.User;
import com.lawyer.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
}

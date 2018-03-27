package ac.daffodil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Uzzal on 3/27/2018.
 */
@Controller
@RequestMapping("/user")
public class loginController {

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mv=new ModelAndView("login");
        return mv;
    }

    @GetMapping("/register")
    public ModelAndView register(){
        ModelAndView mv=new ModelAndView("register");
        return mv;
    }

}

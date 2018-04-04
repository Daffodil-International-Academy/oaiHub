package ac.daffodil.controller;

import ac.daffodil.dao.RoleDao;
import ac.daffodil.dao.UserDao;
import ac.daffodil.model.Role;
import ac.daffodil.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Muiduzzaman Lipu on 03-Apr-18.
 */
@Controller
public class signupController {

    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;


    @GetMapping("/login")

    public ModelAndView login(){
        ModelAndView mv=new ModelAndView("fragments/layout");
        return mv;
    }



    @RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
    public ModelAndView signup(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("newUser", new User());
        modelAndView.addObject("roles", roleDao.getAll());
        modelAndView.setViewName("fragments/signup");
        return modelAndView;
    }



    @RequestMapping(value="/saveUser", method = RequestMethod.POST)
    public String saveUser(User user, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        try {
            user.setActive(1);
            List<Role> roles= roleDao.getAll();
            for (Role role : roles)
            {
                if(role.getRoleName().equals("user")){
                    user.setRoleId(role.getId());
                    Set<Role> roleSet= new HashSet<Role>();
                    roleSet.add(role);
                    user.setRoles(roleSet);
                }
            }
            userDao.save(user);
            redirectAttributes.addFlashAttribute("message", "User Saved SuccessFully...");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
            return "redirect:/signup";
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message", "Please Cheack and input Correct Data.");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/signup";

        }
    }



}

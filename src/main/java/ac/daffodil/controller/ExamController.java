package ac.daffodil.controller;

import ac.daffodil.dao.ExamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by Bithi on 3/24/2018.
 */
@Controller

public class ExamController {

    @Autowired
    ExamDao examDao;

    @RequestMapping(value = { "/exam" }, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("exam");
        return modelAndView;
    }

@RequestMapping(value = { "/save" }, method = RequestMethod.GET)
    public ModelAndView saveIndex() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("exam");
        return modelAndView;
    }





}

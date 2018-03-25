package ac.daffodil.controller;

import ac.daffodil.dao.FileDao;
import ac.daffodil.model.File;
import ac.daffodil.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * Created by Bithi on 3/25/2018.
 */
@Controller
public class FileController {

    @Autowired
    FileDao fileDao;

    @RequestMapping("/file")
    public ModelAndView showFilePage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("file");
        return modelAndView;
    }


    @RequestMapping("/file/save")
    public String saveFile(File newFile) {
        ModelAndView modelAndView = new ModelAndView();
        fileDao.save(newFile);
        modelAndView.addObject("message", " Data Has Been Saved...");
        return "redirect:/file";
    }


}

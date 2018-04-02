package ac.daffodil.controller;

import ac.daffodil.dao.CommentDao;
import ac.daffodil.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Bithi on 4/2/2018.
 */
@Controller
public class CommentController {

    @Autowired
    CommentDao commentDao;

    @RequestMapping(value = { "/comment" }, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        Comments newComment=new Comments();
        modelAndView.addObject("newComment", newComment);
        //modelAndView.addObject("exams", examDao.getAll());
        modelAndView.setViewName("comment");
        return modelAndView;
    }

    @RequestMapping(value = { "/comment/saveComment" }, method = RequestMethod.POST)
    public String saveComment(Comments comments) {
        commentDao.save(comments);
        return "redirect:/comment";
    }

}

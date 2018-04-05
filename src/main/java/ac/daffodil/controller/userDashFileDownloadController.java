package ac.daffodil.controller;

import ac.daffodil.dao.FileDao;
import ac.daffodil.model.Comments;
import ac.daffodil.model.File;
import ac.daffodil.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * Created by Muiduzzaman Lipu on 04-Apr-18.
 */
@Controller
@RequestMapping("/user")
public class userDashFileDownloadController {

    @Autowired
    FileDao fileDao;

    @Autowired
    FileUploadService fileUploadService;

    @RequestMapping(value = { "/userDashFileDownloadPage" }, method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("newFile", new File());
        modelAndView.addObject("files", fileDao.getAll());
        modelAndView.setViewName("user/userDashFileDownload");
        return modelAndView;
    }

    @GetMapping("/files/{filename}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = fileUploadService.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    //get file id for report problem
    @RequestMapping(value={"/findForFile/{file_id}"}, method = RequestMethod.GET)
    public ModelAndView findForSetFileId(@PathVariable(required = true, name = "file_id") Long file_id) {
        ModelAndView modelAndView = new ModelAndView();

        Optional<File> file=fileDao.find(file_id);
        Comments comments= new Comments();
        comments.setFile(file.get());

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof User) {
            String email = ((User)principal).getEmail();
            comments.setUser_email(email);
        }

        modelAndView.addObject("newComment", comments);
        modelAndView.setViewName("comment");
        return modelAndView;
    }

}

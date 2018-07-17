package ac.daffodil.controller;

import ac.daffodil.dao.DepartmentDao;
import ac.daffodil.dao.UniversityDao;
import ac.daffodil.model.Department;
import ac.daffodil.model.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Muiduzzaman Lipu on 04-Apr-18.
 */
@Controller
@RequestMapping("/user")
public class userDashUniversityController {

    @Autowired
    UniversityDao universityDao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping(value = { "/userDashUniversityPage" }, method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("universities", universityDao.getAll());
        modelAndView.addObject("departments", departmentDao.getAll());
        modelAndView.setViewName("user/userDashUniversity");
        return modelAndView;
    }

    @RequestMapping(value={"/findForDepartment/{universityId}"}, method = RequestMethod.GET)
    public ModelAndView findForDepartment(@PathVariable(required = true, name = "universityId") Long universityId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("universities", universityDao.getAll());

        List<Department> departments1 = new LinkedList<>();
        for (Department dept : departmentDao.getAll()) {
            if (dept.getUniversityId() == universityId){
                departments1.add(dept);
            }
        }

        modelAndView.addObject("departmentList", departments1);
        modelAndView.setViewName("user/userDashDepartment");
        return modelAndView;
    }

    Optional<University> university= Optional.of(new University());

    @RequestMapping(value={"/findForUniversity/{id}"}, method = RequestMethod.GET)
    public ModelAndView findForUniversity(@PathVariable(required = true, name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        university= universityDao.find(id);
        modelAndView.addObject("university", university.get());

        List<University> universities = new LinkedList<>();
        for (University uni : universityDao.getAll()) {
            if (uni.getUniversityId() != university.get().getUniversityId()){
                universities.add(uni);
            }
        }
        modelAndView.addObject("universities", universities);
        modelAndView.addObject("compareUni", new University());
        modelAndView.setViewName("user/userDashUniversityDetails");
        return modelAndView;
    }

    @RequestMapping(value="/compareUniversity", method = RequestMethod.POST)
    public ModelAndView compareUniversity(University compareUni) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<University> university1= universityDao.find(university.get().getUniversityId());
        modelAndView.addObject("university1", university1.get());
        Optional<University> university2= universityDao.find(compareUni.getUniversityId());
        modelAndView.addObject("university2", university2.get());

        modelAndView.setViewName("user/userDashUniversityCompare");
        return modelAndView;
    }
}

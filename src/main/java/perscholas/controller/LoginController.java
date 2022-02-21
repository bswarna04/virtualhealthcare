package perscholas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import perscholas.database.dao.UserDAO;
import perscholas.database.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = "/login/login", method = RequestMethod.GET)
//    @RequestMapping("/login/login")
    public ModelAndView login(HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/login");
        return response;
    }

    @RequestMapping("/loginSubmit")
    public ModelAndView loginSubmit(@RequestParam String username, @RequestParam String password){

        User user = userDao.findByUsernameIgnoreCase(username);
        ModelAndView response = new ModelAndView();
        response.setViewName("signup/registerSubmit");
        if(user != null && user.getPassword().equals(password)){
            response.addObject("signin_response","Login Successful!!");
        }
        else {
            response.addObject("signin_response","Patient Doesn't Exist!! Please Signup!!");
        }

        return response;
    }

    @RequestMapping(value = {"/login/logoutSuccess"}, method = RequestMethod.GET)
    public ModelAndView logoutSuccess(HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/logoutSuccess");
        return response;
    }
}




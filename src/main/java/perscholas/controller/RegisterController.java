package perscholas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import perscholas.database.dao.UserDAO;
import perscholas.database.entity.User;
import perscholas.form.RegisterFormBean;

import javax.validation.Valid;

@Controller
public class RegisterController {

    public static final Logger LOG = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private UserDAO userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(@RequestParam(required = false) Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("/signup/register");
        if (id != null) {
            User user = userDao.findById(id);
            RegisterFormBean form = new RegisterFormBean();

            form.setId(user.getId());
            form.setUsername(user.getUsername());
            form.setFirstName(user.getFirstName());
            form.setLastName(user.getLastName());
            form.setDateOfBirth(user.getDateOfBirth());
            form.setPhoneNumber(user.getPhoneNumber());
            form.setEmail(user.getEmail());
            form.setPassword(user.getPassword());

            response.addObject("formBeanKey", form);

        } else {

            RegisterFormBean form = new RegisterFormBean();
            response.addObject("formBeanKey", form);
        }

        return response;
    }

    @RequestMapping(value = "/registerSubmit", method = RequestMethod.GET)
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult errors) throws Exception {

        ModelAndView response = new ModelAndView();


        if (errors.hasErrors()) {

            for (FieldError error : errors.getFieldErrors()) {
                form.getErrorMessages().add(error.getDefaultMessage());
//                System.out.println("error field = " + error.getField() + " message = " + error.getDefaultMessage());
            }

            response.addObject("formBeanKey", form);
            response.setViewName("/signup/register");

        } else {

            User user = userDao.findByUserName(form.getUsername());

            if (user == null) {
                user = new User();

                user.setId(form.getId());
                user.setUsername(form.getUsername());
                user.setFirstName(form.getFirstName());
                user.setLastName(form.getLastName());
                user.setDateOfBirth(form.getDateOfBirth());
                user.setPhoneNumber(form.getPhoneNumber());
                user.setEmail(form.getEmail());

                String encryptedPassword = passwordEncoder.encode(form.getPassword());
                user.setPassword(encryptedPassword);

                userDao.save(user);

                response.addObject("reg_response", "Successfully registered");

            } else {

                response.addObject("reg_response", "User already exists.");
            }

            response.setViewName("/signup/registerSubmit");

        }

        return response;
    }

}
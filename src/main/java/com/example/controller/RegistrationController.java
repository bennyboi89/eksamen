package com.example.controller;

import com.example.dto.UserDto;
import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by benny on 23.11.15.
 */
@Controller
public class RegistrationController {

    @Autowired
    MongoRepository mongoRepository;

    @RequestMapping(value = "/registrer", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registrer";
    }


    @RequestMapping(value = "/registrer", method = RequestMethod.POST)
    public String saveUser(User user) {
        mongoRepository.save(user);
        return "redirect:/index/";
    }

    @RequestMapping(value = "/registrer/ny")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "registrer";
    }



}

package com.project.gos_autoinspection.controller;

import com.project.gos_autoinspection.domain.Role;
import com.project.gos_autoinspection.domain.Usr;
import com.project.gos_autoinspection.repo.UsrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.GeneratedValue;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UsrRepo usrRepo;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(Usr user, Map<String, Object> model){
        Usr userFromDb = usrRepo.findByUsername(user.getUsername());

        if(userFromDb != null){
            model.put("message", "User exists!");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        usrRepo.save(user);
        return "redirect:/login";
    }

}

package com.project.gos_autoinspection.controller;

import com.project.gos_autoinspection.domain.Usr;
import com.project.gos_autoinspection.repo.FineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {
    private final FineRepo fineRepo;
    @Autowired
    public MainController(FineRepo fineRepo) {
        this.fineRepo = fineRepo;
    }

    @Value("${spring.profiles.active}")
    private String profile;

    @GetMapping
    public String main(Model model){
        HashMap<Object, Object> data = new HashMap<>();

        data.put("fines", fineRepo.findAll());

        model.addAttribute("frontendData", data);
        model.addAttribute("isDevMode", "dev".equals(profile));

        return "index";
    }
}

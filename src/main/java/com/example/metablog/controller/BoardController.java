package com.example.metablog.controller;

import com.example.metablog.config.auth.PrincipalDetail;
import com.example.metablog.service.BoardrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardrService boardrService;

    @GetMapping({"","/"})
    public String index(Model model){
        model.addAttribute("board",boardrService.글목록());
        return "index";
    }

    @GetMapping("/board/saveForm")
    public String saveForm(){
        return "board/saveForm";
    }
}

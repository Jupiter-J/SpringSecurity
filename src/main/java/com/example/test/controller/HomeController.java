package com.example.test.controller;


import com.example.test.infra.AuthenticationFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private final AuthenticationFacade authenticationFacade; //로그인한 유저 확인

    public HomeController(
            @Autowired AuthenticationFacade authenticationFacade) {
        this.authenticationFacade = authenticationFacade;
    }

    @GetMapping             //principal : 로그인한 대상을 확인
    public String home(){      //Authentication : null 부분이 anonymousUser라고 나온다
        try {
            logger.info("로그인한 유저: {}", authenticationFacade.getUserName());
        }catch (NullPointerException e){
            logger.info("no user logged in");
        }

        return "index";
    }


}

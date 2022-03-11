package com.keygenie.calendercrud.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PageController {

    @GetMapping("/")
    public String home() { return "home";}

    @GetMapping("/glance")
    public void glance() {}

    @GetMapping("/calendar/main")
    public void calendarMain() {}

    @GetMapping("/calendar/table")
    public void calendarList() {}

    @GetMapping("/member/join")
    public void join() {}

}

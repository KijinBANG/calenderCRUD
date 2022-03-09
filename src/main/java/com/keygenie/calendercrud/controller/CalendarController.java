package com.keygenie.calendercrud.controller;

import com.keygenie.calendercrud.dto.CalendarDTO;
import com.keygenie.calendercrud.service.CalendarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calendar")
@Log4j2
@RequiredArgsConstructor
public class CalendarController {
    private final CalendarService calendarService;

    @GetMapping("/list")
    public ResponseEntity<List<CalendarDTO>> getlist() {
        List<CalendarDTO> plans = calendarService.getAll();
        log.info("plans: " + plans);
        return new ResponseEntity<List<CalendarDTO>>(plans, HttpStatus.OK);
    }

}

package com.keygenie.calendercrud.controller;

import com.keygenie.calendercrud.dto.CalendarDTO;
import com.keygenie.calendercrud.service.CalendarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/register")
    public ResponseEntity<Long> registerPlan(@RequestBody CalendarDTO calendarDTO) {
        log.info("here is CalendarController. calendarDTO: " + calendarDTO);
        Long id = calendarService.register(calendarDTO);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping("/modify")
    public ResponseEntity<Long> modifyPlan(@RequestBody CalendarDTO calendarDTO) {
        log.info("let\'s modify plan. calendarDTO: " + calendarDTO);
        Long id = calendarService.modify(calendarDTO);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Long> removePlan(@PathVariable Long id) {
        log.info("let\' delete plan. id: " + id);
        calendarService.remove(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}

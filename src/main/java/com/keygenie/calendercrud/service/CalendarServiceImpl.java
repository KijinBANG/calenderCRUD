package com.keygenie.calendercrud.service;

import com.keygenie.calendercrud.dto.CalendarDTO;
import com.keygenie.calendercrud.entity.Plan;
import com.keygenie.calendercrud.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class CalendarServiceImpl implements CalendarService {
    private final PlanRepository planRepository;

    @Override
    public List<CalendarDTO> getAll() {
        List<Plan> plans = planRepository.findAll();
        log.info("here is CalendarServiceImpl. plans: " + plans);
        return plans.stream().map(plan -> entityToDTO(plan)).collect(Collectors.toList());
    }
}

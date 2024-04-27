package com.example.luckySystem.controller;


import com.example.luckySystem.dto.AdvanceDto;
import com.example.luckySystem.dto.AllowanceDto;
import com.example.luckySystem.dto.BasicSalaryDto;
import com.example.luckySystem.service.AdvanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/api")
public class AdvanceController {

    @Autowired
    public AdvanceService advanceService;

    @GetMapping("/getAdvance")
    public List<AdvanceDto> getAdvance(){
        System.out.println("Received request to save data.");
        return advanceService.getAdvance();
    }

    @PostMapping("/addAdvance")
    public AdvanceDto addAdvance(@RequestBody AdvanceDto advanceDto) {
        System.out.println("Received request to xx  data.");
        return advanceService.addAdvanceDetails(advanceDto);
    }

    @PutMapping("/updateAdvance")
    public AdvanceDto updateAdvance(@RequestBody AdvanceDto advanceDto) {
        return advanceService.updateAdvanceDetails(advanceDto);
    }

    @DeleteMapping("/deleteAdvance")
    public boolean deleteAdvance(@RequestBody AdvanceDto advanceDto) {
        return  advanceService.deleteAdvanceDetails(advanceDto);
    }

    @GetMapping("/getAdvanceByID/{advanceID}")
    public AdvanceDto getAdvanceById(@PathVariable String advanceID) {
        return advanceService.getAdvanceByID(advanceID);
    }



}

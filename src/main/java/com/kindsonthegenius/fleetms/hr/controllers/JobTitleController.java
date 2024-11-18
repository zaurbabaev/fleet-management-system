package com.kindsonthegenius.fleetms.hr.controllers;

import com.kindsonthegenius.fleetms.hr.models.JobTitle;
import com.kindsonthegenius.fleetms.hr.services.JobTitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hr/jobTitles")
@RequiredArgsConstructor
public class JobTitleController {

    private final JobTitleService jobTitleService;

    public String getAll(Model model) {
        List<JobTitle> jobTitles = jobTitleService.getAllJobs();
        model.addAttribute("jobTitles", jobTitles);
        return "hr/jobTitles";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public JobTitle getById(@PathVariable("id") Integer id) {
        return jobTitleService.getById(id);
    }

    @PostMapping
    public String save(JobTitle jobTitle) {
        jobTitleService.saveJob(jobTitle);
        return "redirect:/hr?jobTitles";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        jobTitleService.delete(id);
        return "redirect:/hr?jobTitles";
    }
}

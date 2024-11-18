package com.kindsonthegenius.fleetms.hr.services;

import com.kindsonthegenius.fleetms.exceptions.ResourceNotFoundException;
import com.kindsonthegenius.fleetms.hr.models.JobTitle;
import com.kindsonthegenius.fleetms.hr.repositories.JobTitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobTitleService {

    private final JobTitleRepository repository;

    public List<JobTitle> getAllJobs() {
        return repository.findAll();
    }

    public JobTitle getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("JobTitle", "id", id));
    }

    public void saveJob(JobTitle jobTitle) {
        repository.save(jobTitle);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }


}

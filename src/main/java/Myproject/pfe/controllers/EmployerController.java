package Myproject.pfe.controllers;

import Myproject.pfe.models.Employer;
import Myproject.pfe.services.EmployerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {
    private final EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }
    @GetMapping
    public List<Employer> getAllEmployer() {
        return employerService.findAll();
    }
    @PostMapping
    public Employer addEmployer(@RequestBody Employer employer) {
        return employerService.addEmployer(employer);
    }

    @GetMapping("/{id}")
    public Employer getEmployerById(@PathVariable Long id) {
        return employerService.findEmployerById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployer(@PathVariable Long id) {
        employerService.deleteEmployerById(id);
    }
    @PutMapping("/{id}")
    public Employer updateEmployer(@PathVariable Long id, @RequestBody Employer updatedEmployer) {
        return employerService.updateEmployer(id, updatedEmployer);
    }


}

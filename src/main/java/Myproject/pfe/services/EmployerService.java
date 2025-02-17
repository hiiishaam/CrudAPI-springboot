package Myproject.pfe.services;

import Myproject.pfe.models.Employer;
import Myproject.pfe.repositories.EmployerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class EmployerService {
    private final EmployerRepository employerRepository;

    public EmployerService(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    public List<Employer> findAll() {
        return employerRepository.findAll();
    }
    public Employer addEmployer(Employer employer) {
        return employerRepository.save(employer);
    }
    public Employer findEmployerById(long id) {
        return employerRepository.findById(id).orElse(null);
    }
    public void deleteEmployerById(long id) {
       Employer employer = findEmployerById(id);
       if (employer != null) {
           try {
               employerRepository.delete(employer);
           } catch (Exception e) {
               throw new RuntimeException(e);
           }
       }

    }

    public Employer updateEmployer(Long id, Employer updatedEmployer) {
        Employer existingEmployer = employerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employer not found"));

        existingEmployer.setName(updatedEmployer.getName());
        existingEmployer.setEmail(updatedEmployer.getEmail());
        existingEmployer.setPhone(updatedEmployer.getPhone());
        existingEmployer.setGrade(updatedEmployer.getGrade());

        return employerRepository.save(existingEmployer);
    }




}

package com.vinaylogics.springbasictraining.controllers;

import com.vinaylogics.springbasictraining.domains.Employee;
import com.vinaylogics.springbasictraining.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;


    @GetMapping({"","/","/index","/index.html"})
    public String listEmployee(Model model){
        model.addAttribute("employees",service.getAll());
        return "employees/index";
    }

    @GetMapping({"/create","/create.html"})
    public String createEmployee(Model model){
        model.addAttribute("employee",new Employee());
        return "employees/create";
    }

    @PostMapping({"/save","/save.html"})
    public String saveEmployee(@ModelAttribute Employee employee){
        service.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/{id}")
    public String getEmployee(Model model,@PathVariable("id") Long id){
        model.addAttribute("employee", service.get(id));
        return "employees/detail";
    }

    @GetMapping("/{id}/edit")
    public String  editEmployee(Model model, @PathVariable("id")Long id){
        model.addAttribute("employee", service.get(id));
        return "employees/edit";
    }

    @PostMapping("/{id}/update")
    public String updateEmployee(@ModelAttribute Employee employee, @PathVariable("id") Long id){
        employee.setId(id);
        service.update(employee);
        return "redirect:/employees/"+id;
    }


    @GetMapping("{id}/delete")
    public String deleteEmployee(@PathVariable("id") Long id){
        Employee employee = service.get(id);
        service.delete(employee);
        return "redirect:/employees";
    }

}

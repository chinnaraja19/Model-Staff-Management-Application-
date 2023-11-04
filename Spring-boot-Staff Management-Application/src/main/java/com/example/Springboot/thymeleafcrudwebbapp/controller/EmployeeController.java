package com.example.Springboot.thymeleafcrudwebbapp.controller;

//import ch.qos.logback.core.model.Model;
import com.example.Springboot.thymeleafcrudwebbapp.model.Employee;
import org.springframework.ui.Model;
import com.example.Springboot.thymeleafcrudwebbapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

//import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String ViewHomePage(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployee());
        return "index";
    }


    @GetMapping("/showNewEmployeeForm")
        public String showNewEmployeeForm(Model model){
            Employee employee=new Employee();
            model.addAttribute("employee" , employee);
            return "new_employee";
        }

    @PostMapping("/saveEmployee")
        public String saveEmployee(@ModelAttribute("employee") Employee employee){
            //save employee to data base
            employeeService.saveEmployee(employee);
            return "redirect:/";
        }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
        Employee employee = employeeService.getEmployeeById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")

    public String deleteEmployeeById(@PathVariable(value = "id") long id){
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }



}

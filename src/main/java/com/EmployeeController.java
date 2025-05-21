package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {
	
	

	@Autowired
	EmployeeDAO dao;
	
	@RequestMapping(method=RequestMethod.GET, value="/getemp")
	@ResponseBody
	public Employee getEmployee() {

		return new Employee(101,"VIVEk","AA");	
	}
	
	@GetMapping(value="/hello", produces="text/html")
	@ResponseBody
	public String getHello() {
		return "<body bgcolor='cyan'>Hello!!!!</body>";
	}

	
	@GetMapping("/hellojsp")
	public String getHellojsp() {
		return "hello";
	}
	
	@PostMapping("/addemp")
	@ResponseBody
	public Employee addEmployee(@RequestBody Employee emp) {
		return dao.addEmployee(emp);
	}
/*----------------------- */	
	@RequestMapping("/empform")
	public String showform(Model m) {
		m.addAttribute("command", new Employee());
		return "empform";
	}

	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute("emp") Employee e) {
		dao.save(e);
		return "redirect:/viewemp";
	}
	
	@RequestMapping("/viewemp")
	public String viewemp(Model m) {
		
		List<Employee> list=dao.getEmployees();
		m.addAttribute("list",list);
		return "viewemp";
	}
	
	@RequestMapping(value="/editemp/{eid}")
	public String edit(@PathVariable int eid, Model m) {
		Employee e=dao.getEmpById(eid);
		m.addAttribute("command", e);
		return "empeditform";
	}
	
	@RequestMapping(value="/editsave", method=RequestMethod.POST)
		public String editsave(@ModelAttribute("emp") Employee e) {
			dao.update(e);
			return "redirect:/viewemp";
		}
	
	@RequestMapping(value="/deleteemp/{eid}", method=RequestMethod.GET)
	public String delete(@PathVariable int eid) {
		dao.delete(eid);
		return "redirect:/viewemp";
	}
	
}

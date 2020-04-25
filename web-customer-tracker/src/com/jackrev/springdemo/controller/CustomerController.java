package com.jackrev.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jackrev.springdemo.entity.Customer;
import com.jackrev.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// inject service
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {

		// get customers from the DAO
		List<Customer> customers = customerService.getCustomers();

		// add the customers to the model
		theModel.addAttribute("customers", customers);

		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Customer theCustomer = new Customer();

		theModel.addAttribute("customer", theCustomer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

		customerService.saveCustomer(theCustomer);

		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {

		// get the customer from database
		Customer theCustomer = customerService.getCustomer(theId);

		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);

		// send over to form
		return "customer-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId, Model theModel) {

		customerService.deleteCustomer(theId);

		// send over to form
		return "redirect:/customer/list";
	}

	@GetMapping("/search")
	public String searchCustomers(@RequestParam("theSearchName") String theSearchName, Model theModel) {

		// search customers from the service
		List<Customer> theCustomers = customerService.searchCustomers(theSearchName);

		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);

		return "list-customers";
	}

}

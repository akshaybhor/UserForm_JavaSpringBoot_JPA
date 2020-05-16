package com.example.demo.contro;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Alien;
import com.example.demo.dao.AlienRepo;

import antlr.collections.List;

@RestController
public class Controller {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return("welcome.jsp");
	}
	

	@PostMapping("/alien")
	public Alien addAlien(Alien alien) {
			repo.save(alien);
			return(alien);
		}
	
	@GetMapping("/alien")
	public java.util.List<Alien> getAlien() {
		
		return repo.findAll();
		
		}
	
	@DeleteMapping("/alien/{aid}")
	public String deleteAlien(@PathVariable int aid){
		Alien a= repo.getOne(aid);
		repo.delete(a);
		return "delete";
		
	}
	
	@PutMapping("/alien/")
	public Alien updateAlien(Alien alien) {
		repo.save(alien);
		return(alien);
	}
	
	
	@GetMapping("/alien/{aid}")
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
		
		return repo.findById(aid);
		
		}
	
}
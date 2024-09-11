package com.peralta.apidaora.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.peralta.apidaora.model.Teacher;
import com.peralta.apidaora.service.TeacherService;

@RestController
public class TeacherController {
	
	private final TeacherService _teacherService;
	
	public TeacherController(TeacherService teacherService) {
		_teacherService = teacherService;
	}
	
	@GetMapping
	public List<Teacher> getAll(){
		return _teacherService.getAll();
	}
	@GetMapping("/{id}")
	public Teacher getById(@PathVariable int id) {
		return _teacherService.getById(id);
	}
	@PostMapping
	public Teacher insert(@RequestBody Teacher teacher) {
		return _teacherService.insert(teacher);
	}
	@PutMapping
	public Teacher update(@RequestBody Teacher teacher) {
		return _teacherService.update(teacher);
	}
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		_teacherService.delete(id);
		return "Deleted";
	}
}

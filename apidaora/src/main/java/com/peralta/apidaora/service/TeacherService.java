package com.peralta.apidaora.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.peralta.apidaora.model.Teacher;
import com.peralta.apidaora.repository.TeacherRepository;

@Service
public class TeacherService {
	
	private final TeacherRepository _teacherRepository;

	public TeacherService(TeacherRepository teacherRepository){
		_teacherRepository = teacherRepository;
	}
	
	public List<Teacher> getAll(){
		return _teacherRepository.findAll();
	}
	public Teacher getById(int id) {
		return _teacherRepository.findById(id).orElse(new Teacher());
	}
	public Teacher insert(Teacher teacher) {
		return _teacherRepository.save(teacher);
	}
	public Teacher update(Teacher teacher) {
		if(_teacherRepository.existsById(teacher.getId()))
			return _teacherRepository.save(teacher);
		return new Teacher();
	}
	public void delete(int id) {
		_teacherRepository.deleteById(id);
	}
}

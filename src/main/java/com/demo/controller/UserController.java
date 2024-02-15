package com.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.StudentMst;
import com.demo.model.UserMst;
import com.demo.repository.StudentMstDaoImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController()
public class UserController {

	@Autowired
	StudentMstDaoImpl studentMstDao;
	
	@Autowired
	Environment env;

	List<UserMst> userList = new ArrayList<>();
	ObjectMapper mapper = new ObjectMapper();

	@PostMapping("/addStudent")
	public String addUser(@RequestBody String studentMst) throws JsonMappingException, JsonProcessingException {
		System.out.println(studentMst);
		System.out.println(env.getProperty("db.driver"));
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode requestNode = (ObjectNode) mapper.readTree(studentMst);
		StudentMst student = new StudentMst();
		student.setStudName(requestNode.get("studentName").asText());
		student.setStudCode(requestNode.get("studentCode").asText());
		studentMstDao.saveStudentMst(student);
		return "User Added Successfully";
	}

	@GetMapping(value = "/getStudent", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getUser(@RequestParam(name = "id") String id) throws JsonProcessingException {

		if (id == null || id.isEmpty()) {
			return "Id cannot be empty";
		}
		StudentMst student = studentMstDao.getStudentMstById(Integer.valueOf(id));
		if (student != null) {
			return mapper.writeValueAsString(student);
		}
		return "No User Found!";
	}

}

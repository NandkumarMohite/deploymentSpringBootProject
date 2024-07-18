package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AttendenceDto;
import com.example.demo.dto.AttendenceResp;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResp;
import com.example.demo.dto.Converterdto;
import com.example.demo.dto.Response;
import com.example.demo.dto.UserDto;
import com.example.demo.pojo.Attendence;
import com.example.demo.pojo.User;
import com.example.demo.service.AttendenceService;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/attendence")
// @CrossOrigin("https://3.91.203.60:8080")
// @CrossOrigin("http://localhost:3000")
public class AttendenceController {

	@Autowired
	public AttendenceService attendenceService;
	
	@Autowired
	public ModelMapper mapper;
	
	Converterdto con;
	
	@GetMapping("/signin/{id}")
	public AttendenceResp signup(@PathVariable("id") int id) throws ParseException 
	{    System.out.print("in SignIn");
		AttendenceResp resp=new AttendenceResp();
		
	    Attendence at  = attendenceService.addAttendenceSignInTime(id);
        if(at != null) {
		    resp.setMsg("User SigIn succesfully ");
			return  resp;	
		  }else {
		    resp.setMsg("User SignIn failded ");
		    return resp;
		  }	
	}
	
	@GetMapping("/signout/{id}")
	public AttendenceResp signout(@PathVariable("id") int id) throws ParseException {
		System.out.print("in SignOUT");
		AttendenceResp resp=new AttendenceResp();
		    Attendence at = attendenceService.addAttendenceSignOutInTime(id);
		    if(at != null) {
		   	
		    resp.setMsg("User SignOUT succesfully ");
			return  resp;	
		  }else {
		    resp.setMsg("User SignOUT failded ");
		    return resp;
		  }
	}

	@GetMapping("/allAttendence/{id}")
	public ResponseEntity<?> getAllUser(@PathVariable("id") int id){
		  List<Attendence> list = attendenceService.findAllAtendenceById(id);
		  System.out.println("inside Attendences Controller : "+list.toString());
		  return Response.success(list);
	}
	
	 @GetMapping("/lastRecord/{id}")
	    public Attendence getLastRecordByUserId(@PathVariable("id") int  id) {
	        return attendenceService.getLastRecordByUserId(id);
	    }
	
	
}

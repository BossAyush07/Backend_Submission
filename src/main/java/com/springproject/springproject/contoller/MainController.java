package com.springproject.springproject.contoller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.springproject.entities.Users;
import com.springproject.springproject.mongorepo.RepoformongoDB;

//import com.springproject.springproject.entities.Users;

@RestController
public class MainController {
	
	@Autowired
	private RepoformongoDB MyRepo;

	@GetMapping("/home")
	public String disp() 
	{
	
		return "Welcome to the first web project";
		
	}
	
//CREATING GET MAPPING TO GET USERS
	
//	@GetMapping("/users")
//	public ResponseEntity<?> getUsers()
//	{
//		List<Users> users = new ArrayList<>(MyRepo.findAll());
//		return ResponseEntity.ok(users);
//	}
	@GetMapping("/users")
	//public ResponseEntity<List<Users>> getUsers()
	public ResponseEntity<?> getUsers()
	{
		try {
		return new ResponseEntity<>(MyRepo.findAll(), HttpStatus.OK);}
		catch (Exception e)
		{
			return ResponseEntity.ok("Unable to fetch users");
		}
	}
	
	// CREATING POST MAPPING TO CREATE USERS
	
	@PostMapping("/users")
	public Users getuserdetails(@RequestBody Users newuser) 
	{
		MyRepo.save(newuser);
		return newuser;
		
	}
	
//	@GetMapping("/users/{id}")
//	public java.util.Optional<Users> selectbyID(@PathVariable String id)
//	{
//		return MyRepo.findById(id);
//	}
		
	// SELECT USERS BY ID
	@GetMapping("/users/{id}")
	public ResponseEntity<?> selectbyID(@PathVariable String id)
	{
		Optional<Users> newuser = MyRepo.findById(id);
		try 
		{
			return new ResponseEntity<>(newuser.get(), HttpStatus.OK);
		}
		catch (Exception e)
		{
			return ResponseEntity.ok("User Not Found");
		}
	}
	
	// DELETE MAPPING TO DELETE USER BY ID
	@DeleteMapping("/users/{id}")
	public String deleteuserbyid(@PathVariable String id) 
	{
		 MyRepo.deleteById(id);
		 return "Deleted";
	}
	
	
//PATCH MAPPING TO PARTIALLY UPDATE USER DETAILS
	
	@PatchMapping("/users/{id}")
	public ResponseEntity<?> patchupdate(@PathVariable String id, @RequestBody Users newuser) 
	{
		//System.out.println("REceived");
		Optional<Users> olduser = MyRepo.findById(id);
		Users user = olduser.get();
		
		user.setName(newuser.getName());
		
		//System.out.println(newuser);
		user.setEmail(newuser.getEmail());
		user.setPhone(newuser.getPhone());
		MyRepo.save(user);
		return ResponseEntity.ok(user);
	}
	
	//PAGING AND SORTING
	
	
	
	
	
	
}

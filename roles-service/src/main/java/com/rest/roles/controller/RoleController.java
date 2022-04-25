package com.rest.roles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.roles.entity.Role;
import com.rest.roles.service.RoleService;
import java.util.List;


@RestController
@RequestMapping("/roles")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/")
	public Role saveRole(@RequestBody Role role) {
		return roleService.saveRole(role);
	}
	
	@GetMapping("/")
    public List<Role> fetchroleList() {
        
        return roleService.fetchroleList();
    }
	
	@GetMapping("/{id}")
	public Role findRoleById(@PathVariable("id") Long roleId) {
		return roleService.findRoleById(roleId);
	}
	
	 

}

package com.rest.roles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.roles.entity.Role;
import com.rest.roles.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}
	
	public List<Role> fetchroleList(){
		return roleRepository.findAll();
	}
	
	public Role findRoleById(Long roleId) {
		return roleRepository.findByRoleId(roleId);
		
	}

}

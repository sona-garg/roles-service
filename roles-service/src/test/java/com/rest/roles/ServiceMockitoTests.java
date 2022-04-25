package com.rest.roles;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rest.roles.ServiceMockitoTests;
import com.rest.roles.entity.Role;
import com.rest.roles.repository.RoleRepository;
import com.rest.roles.service.RoleService;


@SpringBootTest(classes= {ServiceMockitoTests.class})
public class ServiceMockitoTests {
	
	@Mock
	RoleRepository roleRepository;
	
	@InjectMocks
	RoleService roleService;
	
	public List<Role> myRole;
	
	@Test
	@Order(1)
	public void test_fetchroleList() {
		List<Role> myRole = new ArrayList<Role>();
		myRole.add(new Role(1L,"Manager","001"));
		myRole.add(new Role(2L,"Teller","002"));
		when(roleRepository.findAll()).thenReturn(myRole);
		assertEquals(roleService.fetchroleList().size(),2);
	}
	
	@Test
	@Order(2)
	public void test_findRoleById() {
		Role role = new Role();
		Long roleId=1L;
		role.setRoleId(roleId);
		role.setRoleName("Manager");
		role.setRoleCode("002");
		
		
		when(roleRepository.findByRoleId(roleId)).thenReturn(role);
		
		assertEquals(roleService.findRoleById(roleId).getRoleId(),roleId);
		
		}
	@Test
	@Order(3)
	public void test_saveRole() {
		Role role=new Role(3L,"clerk","003");
		when(roleRepository.save(role)).thenReturn(role);
		assertEquals(roleService.saveRole(role),role);
	}
	

}

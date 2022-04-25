package com.rest.roles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.roles.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByRoleId(Long roleId);
	

}

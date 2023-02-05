package sn.atos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import sn.atos.dto.RoleDto;
import sn.atos.dto.UserDto;
import sn.atos.entity.RoleUserForm;
import sn.atos.service.RoleService;
import sn.atos.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Repository
@RequestMapping("/api/roles")
public class RoleController {

    private RoleService roleService;
    private UserService userService;


    public RoleController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<RoleDto>> getRoles(){
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<RoleDto> addRole(@Valid @RequestBody RoleDto roleDto){
        RoleDto roleCreated = roleService.save(roleDto);
        return new ResponseEntity<>(roleCreated, HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<RoleDto> getRoleById(@PathVariable("id") Integer id){
        return new ResponseEntity(roleService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/libelle/{libelle}")
    public ResponseEntity<RoleDto> getRoleByLibelle(@PathVariable("libelle") String libelle){
        return new ResponseEntity(roleService.findByLibelle(libelle), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDto> updateRole(@Valid @RequestBody() RoleDto roleDto, @PathVariable("id") Integer id){
        RoleDto updatedRole = roleService.update(roleDto, id);
        return new ResponseEntity(updatedRole, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RoleDto> deleteUser(@PathVariable("id") Integer id){
        roleService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/add_role_to_user")
    public void addRoleToUser(@Valid @RequestBody RoleUserForm roleUserForm){
        roleService.addRoleToUser(roleUserForm.getEmail(), roleUserForm.getLibelle());
    }

}
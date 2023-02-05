package sn.atos.service;


import sn.atos.dto.RoleDto;
import sn.atos.dto.UserDto;
import sn.atos.entity.RoleEntity;
import sn.atos.entity.UserEntity;

import java.util.List;

public interface RoleService {

    List<RoleDto> findAll();

    RoleDto save(RoleDto roleDto);

    RoleDto findById(Integer id);

    RoleDto findByLibelle(String libelle);

    RoleDto delete(Integer id);

    RoleDto update(RoleDto roleDto, Integer id);

    void addRoleToUser(String email, String libelle);
}

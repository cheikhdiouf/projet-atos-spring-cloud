package sn.atos.service.impl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import sn.atos.dto.RoleDto;
import sn.atos.entity.RoleEntity;
import sn.atos.entity.UserEntity;
import sn.atos.exception.EntityNotFoundException;
import sn.atos.repository.RoleRepository;
import sn.atos.repository.UserRepository;
import sn.atos.service.RoleService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private  final  UserRepository userRepository;



    private final ModelMapper modelMapper;

    public RoleServiceImpl(RoleRepository roleRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;

        this.modelMapper = modelMapper;
    }

    @Override
    public List<RoleDto> findAll() {
        return roleRepository.findAll()
                .stream().map(el -> modelMapper.map(el, RoleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RoleDto save(RoleDto roleDto) {
        RoleEntity roleEntity = modelMapper.map(roleDto, RoleEntity.class);
        RoleEntity savedRole = roleRepository.save(roleEntity);
        return modelMapper.map(savedRole, RoleDto.class);

    }

    @Override
    public RoleDto findById(Integer id) {
        RoleEntity roleEntity = roleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Role ID not found"));
        return modelMapper.map(roleEntity, RoleDto.class);
    }

    @Override
    public RoleDto findByLibelle(String libelle) {
        RoleEntity roleEntity = roleRepository.findByLibelle(libelle);
        return modelMapper.map(roleEntity, RoleDto.class);
    }


    @Override
    public RoleDto delete(Integer id) {
        roleRepository.deleteById(id);
        return null;
    }

    @Override
    public RoleDto update(RoleDto roleDto, Integer id) {
        Optional <RoleEntity> role = roleRepository.findById(id);
        if(role.isPresent()){
            RoleEntity roleEntity = modelMapper.map(role, RoleEntity.class);
            roleDto.setId(id);
            RoleEntity updatedRole = roleRepository.save(roleEntity);
            return modelMapper.map(updatedRole, RoleDto.class);
        } else{
            throw new EntityNotFoundException("Role not found");
        }
    }

    @Override
    public void addRoleToUser(String email, String libelle) {
        UserEntity user = userRepository.findByEmail(email);
        RoleEntity role = roleRepository.findByLibelle(libelle);
        user.getRoles().add(role);
    }

}

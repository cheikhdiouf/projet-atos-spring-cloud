package sn.atos.service.impl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import sn.atos.dto.UserDto;
import sn.atos.entity.UserEntity;
import sn.atos.exception.EntityNotFoundException;
import sn.atos.repository.UserRepository;
import sn.atos.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    //private final UserMapper userMapper;
    
	//private RestTemplate restTemplate;

    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;

        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll()
                .stream().map(el -> modelMapper.map(el, UserEntity.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto save(UserDto userDto) {
       /* UserEntity userEntity = userMapper.toEntity(userDto);
        UserEntity user = userRepository.save(userEntity);
        UserDto userCreated = userMapper.toDto(user);
        return (userCreated);*/
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        UserEntity savedUser = userRepository.save(userEntity);
        return modelMapper.map(savedUser, UserDto.class);

    }

    @Override
    public UserDto findById(Integer id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User ID not found"));
        return modelMapper.map(userEntity, UserDto.class);
    }

    @Override
    public UserDto findUserByFirstNameAndLastName(String firstName, String lastName) {
        UserEntity userEntity = userRepository.findUserByFirstNameAndLastName(firstName, lastName).orElseThrow(() -> new RuntimeException("User firstname or lastname not found"));
        return  modelMapper.map(userEntity, UserDto.class);
    }

    @Override
    public UserDto findByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("User email not found"));
        return  modelMapper.map(userEntity, UserDto.class);
    }

    @Override
    public void delete(Integer id) {
    userRepository.deleteById(id);
    }

    @Override
    public UserDto update(UserDto userDto, Integer id) {
        Optional <UserEntity> user = userRepository.findById(id);
        if(user.isPresent()){
            UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
            userEntity.setId(id);
            UserEntity updatedUser = userRepository.save(userEntity);
            return modelMapper.map(updatedUser, UserDto.class);
        } else{
            throw new EntityNotFoundException("Produit not found");
        }
    }

	/*
	 //communication des microservice via restte
	@Override
	public List<AccountDto> getAccountDto(Long userId) {
	List <AccountDto> accountDto =restTemplate.getForObject("http://localhost:8090/api/byUser/"+ userId,List.class);
		return accountDto;
	}*/
    
}

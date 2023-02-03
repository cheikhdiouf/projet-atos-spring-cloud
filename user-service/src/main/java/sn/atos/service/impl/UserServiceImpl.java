package sn.atos.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import sn.atos.dto.AccountDto;
import sn.atos.dto.UserDto;
import sn.atos.entity.UserEntity;
import sn.atos.mapper.UserMapper;
import sn.atos.repository.UserRepository;
import sn.atos.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;
    
	private RestTemplate restTemplate;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper,RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.restTemplate =restTemplate;
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserDto save(UserDto userDto) {
        UserEntity userEntity = userMapper.toEntity(userDto);
        UserEntity user = userRepository.save(userEntity);
        UserDto userCreated = userMapper.toDto(user);
        return (userCreated);
    }

    @Override
    public UserDto findById(Integer id) {
        return null;
    }

	/*
	 * @Override public List<UserDto> findUserByFirstNameAndLastName(String
	 * firstName, String lastName) { return null; }
	 * 
	 * @Override public List<UserDto> findByEmail(String firstName, String lastName)
	 * { return null; }
	 */
    @Override
    public void delete(Integer id) {

    }

    @Override
    public UserDto update(UserDto userDto, Integer id) {
        return null;
    }

	@Override
	public List<AccountDto> getAccountDto(Long userId) {
	List <AccountDto> accountDto =restTemplate.getForObject("http://localhost:8090/api/byUser/"+ userId,List.class);
		return accountDto;
	}
    
    //communication des microservice via restte
}

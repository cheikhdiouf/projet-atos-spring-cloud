package sn.atos.mapper;

import org.mapstruct.Mapper;
import sn.atos.dto.UserDto;
import sn.atos.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toEntity(UserDto userDto);
    UserDto toDto(UserEntity userEntity);
}

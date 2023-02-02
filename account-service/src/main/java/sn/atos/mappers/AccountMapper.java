package sn.atos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sn.atos.dto.AccountDTO;
import sn.atos.entity.AccountEntity;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountEntity toEntity(AccountDTO accounttDTO);
    AccountDTO toDto(AccountEntity accountEntity);
}

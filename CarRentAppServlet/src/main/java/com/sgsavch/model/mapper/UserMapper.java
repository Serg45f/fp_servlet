package com.sgsavch.model.mapper;

import com.sgsavch.model.entity.User;
import com.sgsavch.model.dto.UserDTO;
import com.sgsavch.model.service.UserService;
import org.modelmapper.ModelMapper;

import java.util.Objects;

public class UserMapper extends AbstractMapper<User, UserDTO> {

    private final ModelMapper mapper;
    private final UserService userService;


    public UserMapper(ModelMapper mapper, UserService userService) {
        super(User.class, UserDTO.class);
        this.mapper = mapper;
        this.userService = userService;
    }

    public void setupMapper() {
//        mapper.createTypeMap(User.class, UserDTO.class)
//                .addMappings(m -> m.skip(UserDTO::setDroidId)).setPostConverter(toDtoConverter());
//        mapper.createTypeMap(UserDTO.class, User.class)
//                .addMappings(m -> m.skip(User::setDroid)).setPostConverter(toEntityConverter());
    }

//    @Override
//    void mapSpecificFields(User source, UserDTO destination) {
//        destination.setDroidId(getId(source));
//    }
//
//    private Long getId(User source) {
//        return Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getDroid().getId();
//    }
//
//    @Override
//    void mapSpecificFields(UserDTO source, User destination) {
//        destination.setDroid(droidRepository.findById(source.getDroidId()).orElse(null));
//    }
}

package com.sgsavch.model.mapper;

import com.sgsavch.model.dto.CarModelDTO;
import com.sgsavch.model.dto.UserDTO;
import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.User;
import com.sgsavch.model.service.UserService;
import org.modelmapper.ModelMapper;

import java.util.Objects;

public class CarModelMapper extends AbstractMapper<CarModel, CarModelDTO> {

    private final ModelMapper mapper;
    //private final UserService userService;


    public CarModelMapper(ModelMapper mapper) {
        super(CarModel.class, CarModelDTO.class);
        this.mapper = mapper;
        //this.userService = userService;
    }

    public void setupMapper() {
//        mapper.createTypeMap(CarModel.class, CarModelDTO.class)
//                .addMappings(m -> m.skip(CarModelDTO::setDroidId)).setPostConverter(toDtoConverter());
//        mapper.createTypeMap(CarModelDTO.class, CarModel.class)
//                .addMappings(m -> m.skip(CarModel::setDroid)).setPostConverter(toEntityConverter());
    }

//    @Override
//    void mapSpecificFields(CarModel source, CarModelDTO destination) {
//        destination.setDroidId(getId(source));
//    }
//
//    private Long getId(CarModel source) {
//        return Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getDroid().getId();
//    }
//
//    @Override
//    void mapSpecificFields(CarModelDTO source, CarModel destination) {
//        destination.setDroid(droidRepository.findById(source.getDroidId()).orElse(null));
//    }
}

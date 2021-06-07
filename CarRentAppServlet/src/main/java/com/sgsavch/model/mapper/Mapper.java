package com.sgsavch.model.mapper;

import com.sgsavch.model.dto.AbstractDto;
import com.sgsavch.model.entity.AbstractEntity;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 04.02.19
 * Time: 21:53
 * e-mail: 2262288@gmail.com
 */
public interface Mapper<E extends AbstractEntity, D extends AbstractDto> {

    E toEntity(D dto);

    D toDto(E entity);
}

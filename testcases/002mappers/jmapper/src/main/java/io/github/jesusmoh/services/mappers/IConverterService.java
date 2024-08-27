package io.github.jesusmoh.services.mappers;

import io.github.jesusmoh.dto.MyDto;
import io.github.jesusmoh.entity.MyEntity;

public interface IConverterService {
    MyDto convert(MyEntity sourceOrder);
}

package io.github.jesusmoh.services.mappers;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;
import static com.googlecode.jmapper.api.JMapperAPI.attribute;

import io.github.jesusmoh.dto.MyDto;
import io.github.jesusmoh.entity.MyEntity;

public class ConverterServiceImp implements IConverterService {

    @Override
    public MyDto convert(MyEntity source) {

        JMapperAPI api = new JMapperAPI()
                .add(attribute("name").value("name"));

        var jmapper = new JMapper<MyDto, MyEntity>(MyDto.class, MyEntity.class);

        // new instance
        var destination = jmapper.getDestination(source);
        // enrichment
        return jmapper.getDestination(destination, source);
    }

}

package com.example.mapper;

import java.util.List;
import java.util.Optional;

public abstract class BaseConverter<Entity,Request,Response> {
    public abstract Entity requestToEntity(Request request);
    public abstract Response entityToResponse(Entity entity);
    public abstract List<Response> entityToResponse(List<Entity> entity);

}

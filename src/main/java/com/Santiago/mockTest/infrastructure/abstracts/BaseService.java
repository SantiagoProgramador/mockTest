package com.Santiago.mockTest.infrastructure.abstracts;

import java.util.List;

public interface BaseService<Request, Response, Id> {

  public Response create(Request request);

  public Response update(Request request, Id id);

  public boolean delete(Id id);

  public Response findById(Id id);

  public List<Response> getAll();
}

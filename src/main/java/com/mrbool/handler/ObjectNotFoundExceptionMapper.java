package com.mrbool.handler;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.mrbool.exception.ObjectNotFoundException;

@Provider
public class ObjectNotFoundExceptionMapper implements ExceptionMapper<ObjectNotFoundException> {

	@Override
	public Response toResponse(ObjectNotFoundException exception) {
		return Response
				.status(Status.BAD_REQUEST)
				.entity("/WEB-INF/jsp/erro.jsp")
				.build();
	}

}

package com.mrbool.controller;

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.View;
import javax.mvc.Viewable;
import javax.mvc.validation.ValidationResult;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.mrbool.model.Product;
import com.oracle.ozark.core.Models;

@Path("products")
public class ProductController {

	@Inject
	private ValidationResult validationResult;

	@Inject
	private Models models;

	@Controller
	@GET
	@View("/WEB-INF/jsp/list.jsp")
	public void list() {
		models.put("products", Product.list());
	}

	@Path("new")
	@Controller
	@GET
	@View("/WEB-INF/jsp/edit.jsp")
	public void preAdd() {
	}

	@Path("new")
	@Controller
	@POST
	@ValidateOnExecution(type = ExecutableType.NONE)
	public Viewable add(@BeanParam @Valid Product product) {
		String result = "/WEB-INF/jsp/list.jsp";

		if (validationResult.isFailed()) {
			models.put("errors", validationResult.getAllViolations());
			models.put("product", product);
			result = "/WEB-INF/jsp/edit.jsp";
		} else {
			Product.add(product);
			models.put("products", Product.list());
		}

		return new Viewable(result);
	}

	@Path("{code}")
	@Controller
	@GET
	@View("/WEB-INF/jsp/edit.jsp")
	public void preEdit(@PathParam("code") String code) {
		models.put("product", Product.get(code));
	}

	@Path("{code}")
	@Controller
	@POST
	@ValidateOnExecution(type = ExecutableType.NONE)
	public Response edit(@PathParam("code") String code, @BeanParam @Valid Product product) {
		String result = "/WEB-INF/jsp/list.jsp";

		if (validationResult.isFailed()) {
			models.put("errors", validationResult.getAllViolations());
			models.put("product", product);
			result = "/WEB-INF/jsp/edit.jsp";
		} else {
			Product.edit(product);
			models.put("products", Product.list());
		}

		return Response.status(Status.OK).entity(result).build();
	}

}

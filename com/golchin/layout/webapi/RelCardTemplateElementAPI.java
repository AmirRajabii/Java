package com.golchin.layout.webapi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.golchin.layout.business.servise.repository.RelCardTemplateElementRepo;
import com.golchin.layout.model.RelCardTemplateElementEntity;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@RequestScoped
@Path("/rel-card-template-element")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Rel Card Template Element Api", description = "")
public class RelCardTemplateElementAPI implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private RelCardTemplateElementRepo repo;

	@RolesAllowed("customer")
	@Path("/count")
	@GET
	@Operation(summary = "Number Rel Card Template Element records")
	public Response getCompaniesCount() {
		try {
			long result = repo.getCount();
			return Response.status(Status.OK).entity(result).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@RolesAllowed("customer")
	@Path("/")
	@GET
	@Operation(summary = "All records")
	public Response getAllCompanies() {
		try {
			List<RelCardTemplateElementEntity> result = repo.select();
			return Response.status(Status.OK).entity(result).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@RolesAllowed("customer")
	@Path("/")
	@GET
	@Operation(summary = "Get for pagenation.")
	public Response getAllCompanies(@QueryParam("first") int first, @QueryParam("max") int max) {
		try {
			List<RelCardTemplateElementEntity> result = new ArrayList<RelCardTemplateElementEntity>();
			Iterable<RelCardTemplateElementEntity> iterable = repo.select(first, max);
			if (iterable != null)
				iterable.forEach(result::add);
			return Response.status(Status.OK).entity(result).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@RolesAllowed("customer")
	@Path("/{id}")
	@GET
	@Operation(summary = "Get by ID")
	public Response getCompanyByID(@PathParam("id") long id) {
		try {
			Optional<RelCardTemplateElementEntity> opt = repo.select(id);
			if (opt.isPresent())
				return Response.status(Status.OK).entity(opt.get()).build();
			else
				return Response.status(Status.NOT_FOUND).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@RolesAllowed("customer")
	@Path("/")
	@POST
	@Operation(summary = "Save Rel Card Template Element")
	public Response saveCompany(RelCardTemplateElementEntity entity) {
		try {
			RelCardTemplateElementEntity result = repo.save(entity);
			return Response.status(Status.OK).entity(result).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@RolesAllowed("customer")
	@Path("/")
	@DELETE
	@Operation(summary = "Remove Rel Card Template Element")
	public Response deleteCompany(@QueryParam("id") long id) {
		try {
			RelCardTemplateElementEntity entity = repo.select(id).get();
			RelCardTemplateElementEntity result = repo.delete(entity);
			return Response.status(Status.OK).entity(result).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@RolesAllowed("customer")
	@Path("/")
	@PUT
	@Operation(summary = "Update Rel Card Template Element")
	public Response updateCompany(RelCardTemplateElementEntity entity) {
		try {
			entity.setVersion(entity.getVersion() + 1);
			RelCardTemplateElementEntity result = repo.update(entity);
			return Response.status(Status.OK).entity(result).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

}

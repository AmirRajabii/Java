package com.golchin.layout.webapi;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.annotation.security.PermitAll;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import ws.safa.standardproject.business.service.repository.CreateUserRepo;
import ws.safa.standardproject.business.service.repository.GroupRepo;
import ws.safa.standardproject.model.GroupEntity;

@RequestScoped
@Path("/setup")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Startup for first time", description = "")
public class Setup implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(Setup.class.getName());

	@Inject
	private GroupRepo groupRepo;

	@Inject
	private CreateUserRepo createUser;

	@Path("/count")
	@GET
	@PermitAll()
	@Operation(summary = "Check is a first time => count == 0")
	public Response isFirstTime() {
		try {
			long c = groupRepo.getCount();
			return Response.status(Status.OK).entity(c).build();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new String[] { "Error in registratin." })
					.build();
		}
	}

	@Path("/")
	@POST
	@PermitAll()
	@Operation(summary = "Setup program for first time")
	public Response setupLaserApplication() {
		try {
			createAllGroups();
			createUser.create("Admin", "Golchin", "admin@gcportal.ir", false, "+982156537495", false,
					"This user created by system at first time", null, true, "adm!nadm!n", "admin");
			createUser.create("Customer", "Golchin", "mailer@gcportal.ir", false, "02156537495", false,
					"This user created by system at first time", null, true, "customer", "customer");
			return Response.status(Status.OK).build();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new String[] { "Error in registratin." })
					.build();
		}
	}

	// =================================================
	private void createAllGroups() {
		final String message = "This error is not important: %s";
		GroupEntity groupEntity;
		try {
			groupEntity = new GroupEntity();
			groupEntity.setName("admin");
			groupRepo.save(groupEntity);
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, String.format(message, e.getMessage()));
		}

		try {
			groupEntity = new GroupEntity();
			groupEntity.setName("customer");
			groupRepo.save(groupEntity);
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, String.format(message, e.getMessage()));
		}

	}

}

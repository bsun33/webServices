package org.bs.ws.messager.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bs.ws.messager.model.Profile;
import org.bs.ws.messager.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	private ProfileService profileService = new ProfileService();
	
	@GET
	public List<Profile> getProfiles() {
		return profileService.getAllProfiles();
	}
	
	
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String pname) {
		
		return profileService.getProfile(pname);
	}
	
	@POST
	public Profile addProfile(Profile p) {
		return profileService.addProfile(p);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String pname, Profile p) {
		p.setProfileName(pname);
		return profileService.updateProfile(p);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteMessage(@PathParam("profileName") String pname) {
		profileService.removeProfie(pname);
	}
	
}

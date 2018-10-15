package org.bs.ws.messager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bs.ws.messager.database.DatabaseClass;
import org.bs.ws.messager.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("td", new Profile(1L, "td", "tsuyoshi", "Domoto"));
		profiles.put("kd", new Profile(2L, "kd", "koichi", "Domoto"));
	}
	public List<Profile> getAllProfiles(){
		
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size()+ 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfie(String profileName) {
		return profiles.remove(profileName);
	}
}

package com.dermenji.service;

import com.dermenji.database.DatabaseClass;
import com.dermenji.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by fns02 on 9/9/2016.
 */
public class ProfileService {

    private Map<String, Profile> profiles = DatabaseClass.getProfiles();

    public ProfileService() {
    }

    public List<Profile> getAllProfiles (){
        return new ArrayList<Profile>(profiles.values());
    }

    public Profile getProfile(String prfileName){
        return profiles.get(prfileName);
    }

    public Profile addProfile(Profile profile){
        profile.setId(profiles.size()+1);
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile updateProfile (Profile profile){
        if (profile.getProfileName().isEmpty()){
            return null;
        }
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile removeProfile(String profileName) {
        return profiles.remove(profileName);
    }

}

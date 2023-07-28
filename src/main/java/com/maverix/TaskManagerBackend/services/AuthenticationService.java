package com.maverix.TaskManagerBackend.services;

import com.maverix.TaskManagerBackend.models.Authentication;

import java.util.ArrayList;
import java.util.List;

public interface AuthenticationService {

    List<Authentication> authenticationList = new ArrayList<>();

    default List<Authentication> getAllAuthentications() {
        return authenticationList;
    }

    default Authentication getAuthenticationById(long id) {
        for (Authentication authentication : authenticationList) {
            if (authentication.getU_id() == id) {
                return authentication;
            }
        }
        return null;
    }

    default Authentication createAuthentication(Authentication authentication) {
        authentication.setU_id(generateNextId());
        authenticationList.add(authentication);
        return authentication;
    }

    default Authentication updateAuthentication(long id, Authentication updatedAuthentication) {
        for (Authentication authentication : authenticationList) {
            if (authentication.getU_id() == id) {
                authentication.setU_name(updatedAuthentication.getU_name());
                authentication.setEmail_id(updatedAuthentication.getEmail_id());
                authentication.setPassword(updatedAuthentication.getPassword());
                return authentication;
            }
        }
        return null;
    }

    default void deleteAuthentication(long id) {
        authenticationList.removeIf(authentication -> authentication.getU_id() == id);
    }

    private static long generateNextId() {
        return authenticationList.size() + 1;
    }
}

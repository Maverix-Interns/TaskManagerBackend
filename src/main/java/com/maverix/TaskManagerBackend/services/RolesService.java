package com.maverix.TaskManagerBackend.services;

import com.maverix.TaskManagerBackend.models.Roles;

import java.util.List;

public interface RolesService {

    List<Roles> getAllRoles();

    Roles getRolesById(long id);

    Roles createRoles(Roles roles);

    Roles updateRoles(long id, Roles updatedRoles);

    void deleteRoles(long id);
}

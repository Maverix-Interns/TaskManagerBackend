package com.maverix.TaskManagerBackend.services;

import com.maverix.TaskManagerBackend.models.Roles;
import com.maverix.TaskManagerBackend.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesServiceImpl implements RolesService {

    private final RolesRepository rolesRepository;

    @Autowired
    public RolesServiceImpl(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    @Override
    public Roles getRolesById(long id) {
        Optional<Roles> optionalRoles = rolesRepository.findById(id);
        return optionalRoles.orElse(null);
    }

    @Override
    public Roles createRoles(Roles roles) {
        return rolesRepository.save(roles);
    }

    @Override
    public Roles updateRoles(long id, Roles updatedRoles) {
        Optional<Roles> optionalRoles = rolesRepository.findById(id);
        if (optionalRoles.isPresent()) {
            Roles roles = optionalRoles.get();
            roles.setU_type(updatedRoles.getU_type());
            // If you want to update the associated User, you can do it here:
            // roles.setUser(updatedRoles.getUser());
            return rolesRepository.save(roles);
        }
        return null;
    }

    @Override
    public void deleteRoles(long id) {
        rolesRepository.deleteById(id);
    }
}

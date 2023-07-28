package com.maverix.TaskManagerBackend.controllers;

import com.maverix.TaskManagerBackend.models.Roles;
import com.maverix.TaskManagerBackend.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolesController {

    private final RolesService rolesService;

    @Autowired
    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @GetMapping
    public List<Roles> getAllRoles() {
        return rolesService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Roles getRolesById(@PathVariable("id") long id) {
        return rolesService.getRolesById(id);
    }

    @PostMapping
    public Roles createRoles(@RequestBody Roles roles) {
        return rolesService.createRoles(roles);
    }

    @PutMapping("/{id}")
    public Roles updateRoles(@PathVariable("id") long id, @RequestBody Roles roles) {
        return rolesService.updateRoles(id, roles);
    }

    @DeleteMapping("/{id}")
    public void deleteRoles(@PathVariable("id") long id) {
        rolesService.deleteRoles(id);
    }
}

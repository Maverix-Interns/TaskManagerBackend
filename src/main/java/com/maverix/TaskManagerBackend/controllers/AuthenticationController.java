package com.maverix.TaskManagerBackend.controllers;

import com.maverix.TaskManagerBackend.models.Authentication;
import com.maverix.TaskManagerBackend.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @GetMapping
    public List<Authentication> getAllAuthentications() {
        return authenticationService.getAllAuthentications();
    }

    @GetMapping("/{id}")
    public Authentication getAuthenticationById(@PathVariable("id") long id) {
        return authenticationService.getAuthenticationById(id);
    }

    @PostMapping
    public Authentication createAuthentication(@RequestBody Authentication authentication) {
        return authenticationService.createAuthentication(authentication);
    }

    @PutMapping("/{id}")
    public Authentication updateAuthentication(@PathVariable("id") long id, @RequestBody Authentication authentication) {
        return authenticationService.updateAuthentication(id, authentication);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthentication(@PathVariable("id") long id) {
        authenticationService.deleteAuthentication(id);
    }
}

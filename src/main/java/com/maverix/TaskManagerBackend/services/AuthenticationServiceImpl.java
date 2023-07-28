package com.maverix.TaskManagerBackend.services;

import com.maverix.TaskManagerBackend.models.Authentication;
import com.maverix.TaskManagerBackend.repositories.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationRepository authenticationRepository;

    @Autowired
    public AuthenticationServiceImpl(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    @Override
    public List<Authentication> getAllAuthentications() {
        return authenticationRepository.findAll();
    }

    @Override
    public Authentication getAuthenticationById(long id) {
        Optional<Authentication> optionalAuthentication = authenticationRepository.findById(id);
        return optionalAuthentication.orElse(null);
    }

    @Override
    public Authentication createAuthentication(Authentication authentication) {
        return authenticationRepository.save(authentication);
    }

    @Override
    public Authentication updateAuthentication(long id, Authentication updatedAuthentication) {
        Optional<Authentication> optionalAuthentication = authenticationRepository.findById(id);
        if (optionalAuthentication.isPresent()) {
            Authentication authentication = optionalAuthentication.get();
            authentication.setU_name(updatedAuthentication.getU_name());
            authentication.setEmail_id(updatedAuthentication.getEmail_id());
            authentication.setPassword(updatedAuthentication.getPassword());
            return authenticationRepository.save(authentication);
        }
        return null;
    }

    @Override
    public void deleteAuthentication(long id) {
        authenticationRepository.deleteById(id);
    }
}

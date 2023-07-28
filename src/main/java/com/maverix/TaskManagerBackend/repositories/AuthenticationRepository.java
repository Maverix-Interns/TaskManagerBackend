package com.maverix.TaskManagerBackend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.maverix.TaskManagerBackend.models.Authentication;

public interface AuthenticationRepository extends JpaRepository<Authentication, Long> {

}

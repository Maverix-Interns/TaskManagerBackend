package com.maverix.TaskManagerBackend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.maverix.TaskManagerBackend.models.*;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
package com.task.core_task_service.repo;

import com.task.core_task_service.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {


}

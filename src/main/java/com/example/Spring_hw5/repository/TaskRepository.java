package com.example.Spring_hw5.repository;

import com.example.Spring_hw5.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
//создаем интерфейс  репозитария с наследованием от JPA
@Repository
public interface TaskRepository extends JpaRepository<Task,  Long> {
    List<Task> findByStatus(Task.TaskStatus status);


}

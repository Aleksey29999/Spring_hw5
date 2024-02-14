package com.example.Spring_hw5.Controller;

import com.example.Spring_hw5.domain.Task;
import com.example.Spring_hw5.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // аннотация  указывающая на контроллер спринг

@AllArgsConstructor //генерирует параметризованный конструктор, который принимает один параметр для каждого поля
// и инициализирует их с его помощью. Аннотация необходима, если нужно создать объект класса, передав начальные
// значения полей в конструктор

@RequestMapping("/tasks") //аннотация в среде Spring, которая позволяет нам сопоставлять HTTP-запросы с методами,
// которые мы хотели бы запустить

public class TaskController {

    private TaskRepository taskRepository;
    
    //реализация добавления элемента  в таск  (POST http://localhost:8080/tasks/ )
    // {
    //"description":"Ivan",
    //"status":"COMPLETED"
    //}
    @PostMapping()
    public Task addTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }
    //реализация выводаа  на экран списка таск  (GET http://localhost:8080/tasks/ )
    @GetMapping()
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }
    //реализация вывода статуса (GET http://localhost:8080/tasks/status/COMPLETED
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable() Task.TaskStatus status) {
        return taskRepository.findByStatus(status);
    }
    //реализация изменение статуса эемента по id  (PUT http://localhost:8080/2)
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        Task exitTask = taskRepository.findById(id).orElse(null);
        if (exitTask != null) {
            int exitTaskStatusNumber = exitTask.getStatus().ordinal();
            if (exitTask.getStatus() != Task.TaskStatus.COMPLETED) {
                exitTaskStatusNumber++;
                exitTask.setStatus(Task.TaskStatus.values()[exitTaskStatusNumber]);
            }
        }
        return taskRepository.save(exitTask);
    }
//реализация удаление эемента по id  (Delete http://localhost:8080/2)
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}

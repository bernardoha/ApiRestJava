package net.bernardoha.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.bernardoha.app.rest.model.Task;
import net.bernardoha.app.rest.repository.TodoRepository;


@RestController
public class TodoController {
	@Autowired
	private TodoRepository todoRepository;
	@GetMapping(value="/")
	public String holaMundo() {
		return "Hola Mundo..";
	}
	
	@GetMapping(value="/tasks")
	public List <Task> getTasks(){
		return todoRepository.findAll();
	}
	@PostMapping(value="/savetask")
	public String saveTask(@RequestBody Task task) {
		todoRepository.save(task);
		return "Saved task";
	}
	@PutMapping(value="/update/{id}")
	public String updateTask(@PathVariable long id, @RequestBody Task task) {
		Task updatedTask=todoRepository.findById(id).get();
		updatedTask.setTitle(task.getTitle());
		updatedTask.setDescription(task.getDescription());
		todoRepository.save(updatedTask);
		return "Updated task";
	}
	@DeleteMapping(value="delete/{id}")
	public String deleteTask(@PathVariable long id) {
		Task deletedTask = todoRepository.findById(id).get();
		todoRepository.delete(deletedTask);
		return "Deleted Task";
	}
}

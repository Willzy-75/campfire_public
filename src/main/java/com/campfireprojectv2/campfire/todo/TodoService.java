package com.campfireprojectv2.campfire.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList();
	private static int todosCount = 0;
	
	static {
		todos.add(new Todo(todosCount++, "Will", "Graduate", LocalDate.now().plusMonths(4), false));
		todos.add(new Todo(todosCount++, "Will", "Cisco Cert", LocalDate.now().plusMonths(3), false));
		todos.add(new Todo(todosCount++, "Will", "Capstone", LocalDate.now().plusMonths(4), false));
		todos.add(new Todo(todosCount++, "Will", "Get Hired", LocalDate.now().plusMonths(6), false));
	}
	
	public List<Todo> findByUsername(String username) {
		Predicate<? super Todo> predicate = todo -> 
			todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(todosCount++, username, description, targetDate, done);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
		
	}
}

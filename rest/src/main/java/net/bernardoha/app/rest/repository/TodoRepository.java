package net.bernardoha.app.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.bernardoha.app.rest.model.Task;

public interface TodoRepository extends JpaRepository <Task, Long> {

}

package todolist.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todolist.todolist.entity.Tarefa;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, UUID> {

    Optional<Tarefa> findByTitulo(String titulo);

}

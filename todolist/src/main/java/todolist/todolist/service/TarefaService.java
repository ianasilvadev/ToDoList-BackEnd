package todolist.todolist.service;

import org.springframework.stereotype.Service;
import todolist.todolist.controller.CriarTarefaDTO;
import todolist.todolist.entity.Tarefa;
import todolist.todolist.repository.TarefaRepository;

import java.util.List;
import java.util.UUID;

@Service
public class TarefaService {

    private TarefaRepository tarefaRepository;

    // Construtor com a injeção de dependência do repositorio contendo as tarefas.
    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    // Metodo criação de nova tarefa: Recebe DTO criado com dados da tarefa e converte para uma entidade.
    public Tarefa criarTarefa(CriarTarefaDTO criarTarefaDTO) {

        // Conversão de DTO para Entity

        var entity = new Tarefa(
                criarTarefaDTO.titulo(),
                criarTarefaDTO.descricao(),
                criarTarefaDTO.status()
        );

        return tarefaRepository.save(entity);
    }

//   Metodo para retorno de todas as tarefas do banco: List utilizado para retornar tarefas de forma que
//    possa ser iterado ou fazer operacoes

    public List<Tarefa> obterTodasTarefas() {
        return tarefaRepository.findAll();
    }

    // Metodo para obter tarefa especifica: Metodo obtém tarefa especifica pelo titulo

    public Tarefa obterTarefaPorTitulo(String titulo) {
        // Procura tarefa pelo título, lançando exceção caso não encontre
        return tarefaRepository.findByTitulo(titulo)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com o título: " + titulo));
    }

    // Metodo adicional: Deletar tarefa

    public void deletarTarefa(UUID tarefaId) {
        Tarefa tarefa = tarefaRepository.findById(tarefaId)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com o ID: " + tarefaId));
        tarefaRepository.delete(tarefa);
    }


}

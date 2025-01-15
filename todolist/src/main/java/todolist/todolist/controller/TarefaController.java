package todolist.todolist.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import todolist.todolist.entity.Tarefa;
import todolist.todolist.repository.TarefaRepository;
import todolist.todolist.service.TarefaService;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/tarefas")
public class TarefaController {

    private TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    // Metodo para criação de tarefa: Mapeia a URL /v1/tarefas para criação de nova tarefa
    @Transactional
    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody CriarTarefaDTO criarTarefaDTO) {
        System.out.println("Dados recebidos: " + criarTarefaDTO);
        Tarefa tarefa = tarefaService.criarTarefa(criarTarefaDTO);
        return ResponseEntity.created(URI.create("/v1/tarefas/" + tarefa.getTarefaId().toString()))
                .body(tarefa);
    }

    // Metodo para obter todas as tarefas: "/v1/tarefas" para retornar a lista de tarefas
    @GetMapping
    public ResponseEntity<List<Tarefa>> obterTodasTarefas() {
        List<Tarefa> tarefas = tarefaService.obterTodasTarefas();
        return ResponseEntity.ok(tarefas);
    }

    // Metodo para obter uma tarefa específica pelo título: "/v1/tarefas/buscar" para buscar uma tarefa pelo título
    @GetMapping("/buscar")
    public ResponseEntity<Tarefa> obterTarefaPorTitulo(@RequestParam String titulo) {
        Tarefa tarefa = tarefaService.obterTarefaPorTitulo(titulo);
        return ResponseEntity.ok(tarefa);
    }

    // Metodo para deletar tarefa a partir do ID: "/v1/tarefas/{tarefaId}" para deletar uma tarefa pelo ID
    @DeleteMapping("/{tarefaId}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable UUID tarefaId) {
        tarefaService.deletarTarefa(tarefaId);
        return ResponseEntity.noContent().build();
    }


}

package todolist.todolist.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_tarefas")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID tarefaId;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "status")
    private String status;

    @CreationTimestamp
    private Instant creationTimestamp;

    @UpdateTimestamp
    private Instant updateTimestamp;
    

    public Tarefa(UUID tarefaId, String titulo, String descricao, String status, Instant creationTimestamp, Instant updateTimestamp) {
        this.tarefaId = tarefaId;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.creationTimestamp = creationTimestamp;
        this.updateTimestamp = updateTimestamp;
    }

    public Tarefa() {
        
    }

    public Tarefa( String titulo, String descricao, String status) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.creationTimestamp = Instant.now();
        this.updateTimestamp = Instant.now();
    }


    public UUID getTarefaId() {
        return tarefaId;
    }

    public void setTarefaId(UUID tarefaId) {
        this.tarefaId = tarefaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Instant creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public Instant getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Instant updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }
}

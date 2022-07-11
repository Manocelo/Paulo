package br.senai.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    @Size(max = 100)
    @NotNull
    private String nome;

    @Size(max = 60)
    private String status;

    private double premiacao;
    @Size(max = 100)
    private String email;;

    @ManyToMany(mappedBy = "funcionarioss")
    private List<Projeto> projetos;
    @ManyToMany(mappedBy = "funcionarios")
    private List<Resultado> resultados;

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public double getPremiacao() {
        return premiacao;
    }
    public void setPremiacao(double premiacao) {
        this.premiacao = premiacao;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }
    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
    public List<Resultado> getResultados() {
        return resultados;
    }
    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", status='" + status + '\'' +
                ", premiacao=" + premiacao +
                ", email='" + email + '\'' +
                ", projetos=" + projetos +
                ", resultados=" + resultados +
                '}';
    }
}

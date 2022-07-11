package br.senai.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity(name = "resultado")
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    @Size(max = 100)
    @NotNull
    private String nome;
    private double premiacao;

    private double colocacao;

    @ManyToMany
    @JoinTable(
            name = "resultado_funcionario",
            joinColumns = @JoinColumn(name = "resultado_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = {@JoinColumn(name = "funcionario_id",
                    referencedColumnName = "id"
            )}
    )
    private List<Funcionario> funcionarios;

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
    public double getPremiacao() {
        return premiacao;
    }
    public void setPremiacao(double premiacao) {
        this.premiacao = premiacao;
    }
    public double getColocacao() {
        return colocacao;
    }
    public void setColocacao(double colocacao) {
        this.colocacao = colocacao;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public String toString() {
        return "Resultado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", premiacao=" + premiacao +
                ", colocacao=" + colocacao +
                ", funcionarios=" + funcionarios +
                '}';
    }
}


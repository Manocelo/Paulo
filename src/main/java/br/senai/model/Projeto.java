package br.senai.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;


@Entity(name = "projeto")
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max=100)
    @NotNull
    private String nome;
    @Size(max=100)
    private String email;

    @Column(name="data_nascimento")
    private Date dataNascimento;

    @Size(max = 15)
    private String cpf;

    @ManyToMany
    @JoinTable(
            name = "projeto_funcionario",
            joinColumns = @JoinColumn(name = "projeto_id",
                referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(name = "funcionario_id",
                referencedColumnName = "id"
            )
    )
    private List<Funcionario> funcionarioss;

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Funcionario> getFuncionarioss() {
        return funcionarioss;
    }
    public void setFuncionarioss(List<Funcionario> funcionarioss) {
        this.funcionarioss = funcionarioss;
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cpf='" + cpf + '\'' +
                ", funcionarioss=" + funcionarioss +
                '}';
    }
}

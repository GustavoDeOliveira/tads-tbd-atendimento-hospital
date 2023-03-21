package negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "setores")
public class Setor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;
    @Column
    private String descricao;
    @OneToMany(mappedBy = "setor")
    private Collection<Funcionario> funcionarios = new ArrayList<Funcionario>();

    public Setor() {
    }

    public Setor(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Collection<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Collection<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
}

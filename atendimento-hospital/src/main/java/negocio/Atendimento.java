package negocio;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "atendimentos")
public class Atendimento extends Entidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dataAtendimento;
    @Column
    private String diagnostico;
    @Column(length = 512)
    private String observacoes;
    @ManyToOne
    private Funcionario funcionario;
    @ManyToOne
    private Paciente paciente;

    public Atendimento() {
        dataAtendimento = new Date();
    }
    
    public Atendimento(String diagnostico) {
        dataAtendimento = new Date();
        this.diagnostico = diagnostico;
    }
    
    public Atendimento(Date data) {
        this.dataAtendimento = data;
    }

    @Override
    public int getId() {
        return id;
    }

    public Date getData() {
        return dataAtendimento;
    }

    public void setData(Date data) {
        this.dataAtendimento = data;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    @Override
    public String toString() {
        return getId() > 0
                ? getId() + " - " + getFuncionario().getNome() + " atendeu "
                    + getPaciente().getNome() + " em " + getData().toString()
                    + ", com um diagnóstico de " + getDiagnostico()
                : getId() + " - " + getDiagnostico();
    }
}

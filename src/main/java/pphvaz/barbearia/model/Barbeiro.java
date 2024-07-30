package pphvaz.barbearia.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="barbeiro")
@PrimaryKeyJoinColumn(name = "id")
public class Barbeiro extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	private Integer anosDeExperiencia;
	
	@OneToOne
	@JoinColumn(name = "agenda_id", nullable = true, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "agenda_fk"))
	private Agenda agenda;
	
	@ManyToMany
    @JoinTable(
        name = "barbeiro_servico",
		uniqueConstraints = @UniqueConstraint (columnNames = {"barbeiro_id", "servico_id"}, name = "unique_barbeiro_servico"),
        joinColumns = @JoinColumn(name = "barbeiro_id", referencedColumnName = "id", table = "barbeiro", unique = false, foreignKey = @ForeignKey(name = "barbeiro_fk", value = ConstraintMode.CONSTRAINT)),
        inverseJoinColumns = @JoinColumn(name = "servico_id", unique = false, referencedColumnName = "id", table = "servico", foreignKey = @ForeignKey(name = "servico_fk", value = ConstraintMode.CONSTRAINT))
    )
    private Set<Servico> servicos = new HashSet<>();

	public Integer getAnosDeExperiencia() {
		return anosDeExperiencia;
	}

	public void setAnosDeExperiencia(Integer anosDeExperiencia) {
		this.anosDeExperiencia = anosDeExperiencia;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

}
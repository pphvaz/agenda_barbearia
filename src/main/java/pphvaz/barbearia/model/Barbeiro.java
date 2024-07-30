package pphvaz.barbearia.model;

import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="barbeiro")
@PrimaryKeyJoinColumn(name = "id")
public class Barbeiro extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	private Integer anosDeExperiencia;
	
	@OneToOne
	@JoinColumn(name = "agenda_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "agenda_fk"))
	private Agenda agenda;

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
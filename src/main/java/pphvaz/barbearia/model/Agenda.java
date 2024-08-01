package pphvaz.barbearia.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "agenda")
@SequenceGenerator(name = "seq_agenda", sequenceName = "seq_agenda", allocationSize = 1, initialValue = 1)
public class Agenda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_agenda")
	private Long id;

	@OneToOne
	@JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
	private Pessoa barbeiro;

	@ElementCollection
    @CollectionTable(
        name = "agenda_dias_semana",
        joinColumns = @JoinColumn(name = "agenda_id"),
        uniqueConstraints = @UniqueConstraint(columnNames = {"agenda_id", "dia_semana"})
    )
    @Column(name = "dia_semana", nullable = false)
    private List<Integer> diasAtendimento;
	
	@Column(nullable = false)
	private LocalTime horarioInicioExpediente;
	
	@Column(nullable = false)
	private LocalTime horarioFimExpediente;
	
	@Column(nullable = false)
	private LocalTime horarioAlmoco;
	
	@Column(nullable = false)
	private LocalTime duracaoAlmoco;
	
	@OneToMany(mappedBy = "agenda")
	private List<MarcacaoDeServico> agendamentos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getBarbeiro() {
		return barbeiro;
	}

	public void setBarbeiro(Pessoa barbeiro) {
		this.barbeiro = barbeiro;
	}

	public List<Integer> getDiasAtendimento() {
		return diasAtendimento;
	}

	public void setDiasAtendimento(List<Integer> diasAtendimento) {
		this.diasAtendimento = diasAtendimento;
	}

	public LocalTime getHorarioInicioExpediente() {
		return horarioInicioExpediente;
	}

	public void setHorarioInicioExpediente(LocalTime horarioInicioExpediente) {
		this.horarioInicioExpediente = horarioInicioExpediente;
	}

	public LocalTime getHorarioFimExpediente() {
		return horarioFimExpediente;
	}

	public void setHorarioFimExpediente(LocalTime horarioFimExpediente) {
		this.horarioFimExpediente = horarioFimExpediente;
	}

	public LocalTime getHorarioAlmoco() {
		return horarioAlmoco;
	}

	public void setHorarioAlmoco(LocalTime horarioAlmoco) {
		this.horarioAlmoco = horarioAlmoco;
	}

	public LocalTime getDuracaoAlmoco() {
		return duracaoAlmoco;
	}

	public void setDuracaoAlmoco(LocalTime duracaoAlmoco) {
		this.duracaoAlmoco = duracaoAlmoco;
	}

	public List<MarcacaoDeServico> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<MarcacaoDeServico> agendamentos) {
		this.agendamentos = agendamentos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		return Objects.equals(id, other.id);
	}
	
	
}

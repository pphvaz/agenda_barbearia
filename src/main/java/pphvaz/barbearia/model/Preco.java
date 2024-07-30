package pphvaz.barbearia.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "preco")
@SequenceGenerator(name = "seq_preco", sequenceName = "seq_preco", allocationSize = 1, initialValue = 1)
public class Preco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_preco")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "barbeiro_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "barbeiro_fk"))
	private Barbeiro barbeiro;

	@ManyToOne
	@JoinColumn(name = "servico_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "servico_fk"))
	private Servico servico;

	@Column(nullable = false)
	private BigDecimal preco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Barbeiro getBarbeiro() {
		return barbeiro;
	}

	public void setBarbeiro(Barbeiro barbeiro) {
		this.barbeiro = barbeiro;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
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
		Preco other = (Preco) obj;
		return Objects.equals(id, other.id);
	}

}

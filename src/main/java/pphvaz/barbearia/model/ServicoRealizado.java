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
@Table(name = "servico_realizado")
@SequenceGenerator(name = "seq_servico_realizado", sequenceName = "seq_servico_realizado", allocationSize = 1, initialValue = 1)
public class ServicoRealizado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_agenda")
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "marcacao_servico_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "marcacao_servico_fk"))
    private MarcacaoDeServico marcacaoDeServico;
	
	
	@ManyToOne
    @JoinColumn(name = "servico_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "servico_fk"))
    private Servico servico;
	
	@Column(nullable = false)
    private BigDecimal valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MarcacaoDeServico getMarcacaoDeServico() {
		return marcacaoDeServico;
	}

	public void setMarcacaoDeServico(MarcacaoDeServico marcacaoDeServico) {
		this.marcacaoDeServico = marcacaoDeServico;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
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
		ServicoRealizado other = (ServicoRealizado) obj;
		return Objects.equals(id, other.id);
	}

}

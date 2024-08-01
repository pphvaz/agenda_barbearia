package pphvaz.barbearia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "nota_fiscal")
@SequenceGenerator(name = "seq_nota_fiscal", sequenceName = "seq_nota_fiscal", initialValue = 1, allocationSize = 1)
public class NotaFiscalServico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_nota_fiscal")
	private Long id;
	
	@Column(nullable = false)
	private String numero;
	
	@Column(nullable = false)
	private String serie;
	
	@Column(nullable = false)
	private String tipo;
	
	@Column(columnDefinition = "text", nullable = false)
	private String xml;
	
	@Column(columnDefinition = "text", nullable = false)
	private String pdf;
	
	@OneToOne
	@JoinColumn(name = "servico_concluido_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "servico_concluido_fk"))
	private MarcacaoDeServico servicoConcluido;
}

package pphvaz.barbearia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "servico")
@SequenceGenerator(name = "seq_servico", sequenceName = "seq_servico", allocationSize = 1, initialValue = 1)
public class Servico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_servico")
	private Long id;
	
	@Column(nullable = false)
	private String descricao;
	
	// duracao em MINUTOS do servico
	@Column(nullable = false)
	private Integer duracao;
	
}

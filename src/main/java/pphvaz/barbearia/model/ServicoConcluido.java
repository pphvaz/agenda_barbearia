package pphvaz.barbearia.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "servico_concluido")
@SequenceGenerator(name = "seq_servico_concluido", sequenceName = "seq_servico_concluido", initialValue = 1, allocationSize = 1)
public class ServicoConcluido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_servico_concluido")
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataDoAgendamento;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataDoServico;

	@Column(nullable = false)
	private LocalDateTime horarioDoServico;

	@Column(nullable = false)
	private BigDecimal valorTotal;

	@OneToOne
	@JoinColumn(name = "endereco_cobranca_id", nullable = true, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "endereco_cobranca_fk"))
	private Endereco enderecoCobranca;

	@OneToOne
	@JoinColumn(name = "endereco_servico_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "endereco_servico_fk"))
	private Endereco enderecoServico;

	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "cliente_fk"))
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "barbeiro_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "barbeiro_fk"))
	private Barbeiro barbeiro;

	@ManyToOne
	@JoinColumn(name = "cupom_de_desconto_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "cupom_de_desconto_fk"))
	private CupomDeDesconto cupomDeDesconto;

	@OneToOne
	@JoinColumn(name = "nota_fiscal_servico_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "nota_fiscal_servico_fk"))
	private NotaFiscalServico notaFiscalServico;

	@OneToOne
	@JoinColumn(name = "forma_de_pagamento_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "forma_de_pagamento_fk"))
	private FormaDePagamento formaDePagamento;

	@ManyToMany
	@JoinTable(
			name = "servico_concluido_servico", 
			joinColumns = @JoinColumn(name = "servico_concluido_id", foreignKey = @ForeignKey(name = "servico_concluido_fk")), 
			inverseJoinColumns = @JoinColumn(name = "servico_id", foreignKey = @ForeignKey(name = "servico_fk")))
	private List<Servico> servicos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataDoAgendamento() {
		return dataDoAgendamento;
	}

	public void setDataDoAgendamento(Date dataDoAgendamento) {
		this.dataDoAgendamento = dataDoAgendamento;
	}

	public Date getDataDoServico() {
		return dataDoServico;
	}

	public void setDataDoServico(Date dataDoServico) {
		this.dataDoServico = dataDoServico;
	}

	public LocalDateTime getHorarioDoServico() {
		return horarioDoServico;
	}

	public void setHorarioDoServico(LocalDateTime horarioDoServico) {
		this.horarioDoServico = horarioDoServico;
	}

	public Endereco getEnderecoCobranca() {
		return enderecoCobranca;
	}

	public void setEnderecoCobranca(Endereco enderecoCobranca) {
		this.enderecoCobranca = enderecoCobranca;
	}

	public Endereco getEnderecoServico() {
		return enderecoServico;
	}

	public void setEnderecoServico(Endereco enderecoServico) {
		this.enderecoServico = enderecoServico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Barbeiro getBarbeiro() {
		return barbeiro;
	}

	public void setBarbeiro(Barbeiro barbeiro) {
		this.barbeiro = barbeiro;
	}

	public CupomDeDesconto getCupomDeDesconto() {
		return cupomDeDesconto;
	}

	public void setCupomDeDesconto(CupomDeDesconto cupomDeDesconto) {
		this.cupomDeDesconto = cupomDeDesconto;
	}

	public NotaFiscalServico getNotaFiscalServico() {
		return notaFiscalServico;
	}

	public void setNotaFiscalServico(NotaFiscalServico notaFiscalServico) {
		this.notaFiscalServico = notaFiscalServico;
	}

	public FormaDePagamento getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
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
		ServicoConcluido other = (ServicoConcluido) obj;
		return Objects.equals(id, other.id);
	}

}

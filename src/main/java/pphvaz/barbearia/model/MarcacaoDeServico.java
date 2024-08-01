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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

import pphvaz.barbearia.enums.StatusDeServico;

@Entity
@Table(name = "marcacao_de_servico")
@SequenceGenerator(name = "seq_marcacao_de_servico", sequenceName = "seq_marcacao_de_servico", initialValue = 1, allocationSize = 1)
public class MarcacaoDeServico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_marcacao_de_servico")
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataDeAgendamento;

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
	@JoinColumn(name = "cupom_de_desconto_id", nullable = true, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "cupom_de_desconto_fk"))
	private CupomDeDesconto cupomDeDesconto;

	@OneToOne
	@JoinColumn(name = "nota_fiscal_servico_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "nota_fiscal_servico_fk"))
	private NotaFiscalServico notaFiscalServico;

	@OneToOne
	@JoinColumn(name = "forma_de_pagamento_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "forma_de_pagamento_fk"))
	private FormaDePagamento formaDePagamento;
	
	@ManyToOne
    @JoinColumn(name = "agenda_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "agenda_fk"))
    private Agenda agenda;
	
	
	/* CRIAÇÃO DE TABELA AUXILIAR PARA INCLUIR QUANTOS SERVIÇOS FOREM NECESSÁRIOS NUMA MARCAÇÃO E ARMAZENAR */ 
	@ManyToMany
	@JoinTable(
			name = "marcacao_de_servico_servico", 
			joinColumns = @JoinColumn(name = "marcacao_de_servico_id", foreignKey = @ForeignKey(name = "marcacao_de_servico_fk")), 
			inverseJoinColumns = @JoinColumn(name = "servico_id", foreignKey = @ForeignKey(name = "servico_fk")))
	private List<Servico> servicos;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private StatusDeServico statusDeServico;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataDeAgendamento() {
		return dataDeAgendamento;
	}

	public void setDataDeAgendamento(Date dataDoAgendamento) {
		this.dataDeAgendamento = dataDoAgendamento;
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
		MarcacaoDeServico other = (MarcacaoDeServico) obj;
		return Objects.equals(id, other.id);
	}

}

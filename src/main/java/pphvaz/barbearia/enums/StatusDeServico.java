package pphvaz.barbearia.enums;

public enum StatusDeServico {
	
	AGENDAMENTO_PENDENTE("Agendamento Pendente"),
	AGENDAMENTO_CONFIRMADO("Agendamento Confirmado"),
	SERVICO_CANCELADO("Servico Cancelado"),
	SERVICO_CONCLUIDO("Servico Concluido");
	
	private String descricao;
	
	private StatusDeServico (String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public String toString() {
		return this.descricao;
	}
	
}

package pphvaz.barbearia.enums;

public enum TipoEndereco {
	
	COMERCIAL("Comercial"),
	RESIDENCIAL("Residencial");
	
	private String descricao;
	
	private TipoEndereco (String descricao) {
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

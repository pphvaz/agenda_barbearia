package pphvaz.barbearia.enums;

public enum DiaSemana {
	
	DOMINGO(0),
    SEGUNDA(1),
    TERCA(2),
    QUARTA(3),
    QUINTA(4),
    SEXTA(5),
    SABADO(6);
	
	private int valor;
	
	private DiaSemana (int valor) {
		this.valor = valor;
	}
	
	public int getDescricao() {
		return valor;
	}
	
}

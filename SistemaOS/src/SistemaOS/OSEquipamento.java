package SistemaOS;

public class OSEquipamento {
	
	private static int contador = 1;
    private int id;
    private OrdemServico ordemServico;
    private Equipamento equipamento;
    
	public OSEquipamento(OrdemServico ordemServico, Equipamento equipamento) {
		this.id = ++contador;
		setOrdemServico(ordemServico);
		setEquipamento(equipamento);
	}

	public int getId() {
		return this.id;
	}

	public OrdemServico getOrdemServico() {
		return this.ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		if(ordemServico != null){
            this.ordemServico = ordemServico;
        } else {
        	throw new IllegalArgumentException("Ordem de Serviço inválida!");
        }
	}

	public Equipamento getEquipamento() {
		return this.equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		if(equipamento != null){
            this.equipamento = equipamento;
        } else {
        	throw new IllegalArgumentException("Equipamento inválido!");
        }
	}
    
}

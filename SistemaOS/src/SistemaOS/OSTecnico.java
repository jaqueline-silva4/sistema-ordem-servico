package SistemaOS;

public class OSTecnico {

	private static int contador = 1;
    private int id;
    private OrdemServico ordemServico;
    private Tecnico tecnico;
    
	public OSTecnico(OrdemServico ordemServico, Tecnico tecnico) {
		this.id = ++contador;
		setOrdemServico(ordemServico);
		setTecnico(tecnico);
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

	public Tecnico getTecnico() {
		return this.tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		if(tecnico != null){
            this.tecnico = tecnico;
        } else {
        	throw new IllegalArgumentException("Técnico inválido!");
        }
	}
    
}

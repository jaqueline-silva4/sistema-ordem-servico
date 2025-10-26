package SistemaOS;

import java.time.LocalDate;

public class Servico implements Listavel{
    
	public enum StatusAtual { PENDENTE, ENCAMINHADO, CONCLUIDO, CANCELADO }
	private static int contador = 1;
    private int id;
    private double custo;
    private String descricao;
    private StatusAtual status;
    private LocalDate  dataInicio;
    private LocalDate  dataEncerramento;
    private OrdemServico ordemServico;
    private Relatorio relatorio;
    private Avaliacao avaliacao;

    public Servico(double custo, String descricao, StatusAtual status, LocalDate dataInicio, OrdemServico ordemServico) {
    	this.id = contador++;
    	setCusto(custo);
    	setDescricao(descricao);
    	atualizarStatus(status);
    	setDataInicio(dataInicio);
    	setOrdemServico(ordemServico);
    }
    
    public int getId() {
		return this.id;
	}

	public double getCusto() {
		return this.custo;
	}

	public void setCusto(double custo) {
		if(custo > 0){
			this.custo = custo;
		} else {
			throw new IllegalArgumentException("Custo inválido!");
		}
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		if(descricao != null && !descricao.isEmpty()){
			this.descricao = descricao;
		} else {
			throw new IllegalArgumentException("Descrição inválida!");
		}
	}

	public StatusAtual getStatus() {
		return this.status;
	}

	//Em Java, um enum é fechado. 
	//Ou seja, não é possível criar ou passar valores diferentes dos que foram definidos dentro dele
	public void atualizarStatus(StatusAtual status) {
		if(status != null){
			this.status = status;
			if(status == StatusAtual.CONCLUIDO) {
				dataEncerramento = LocalDate.now();
			}
		} else {
			throw new IllegalArgumentException("Status inválido!");
		}
	}

	public LocalDate getDataInicio() {
		return this.dataInicio;
	}


	public void setDataInicio(LocalDate dataInicio) {
		if(dataInicio != null){
			this.dataInicio = dataInicio;
		} else {
			throw new IllegalArgumentException("Data de início inválida!");
		}
	}

	public LocalDate getDataEncerramento() {
		return this.dataEncerramento;
	}
	
	public void setDataEncerramento(LocalDate dataEncerramento) {
	    if (dataEncerramento == null) {
	        throw new IllegalArgumentException("Data de encerramento inválida!");
	    }
	    if (this.dataInicio != null && dataEncerramento.isBefore(this.dataInicio)) {
	        throw new IllegalArgumentException(
	            "Data de encerramento não pode ser anterior à data de início (" + this.dataInicio + ")."
	        );
	    }
	    this.dataEncerramento = dataEncerramento;
	    atualizarStatus(StatusAtual.CONCLUIDO);
	}

	public OrdemServico getOrdemServico() {
		return this.ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		if(ordemServico != null){
			this.ordemServico = ordemServico;
		} else {
			throw new IllegalArgumentException("Ordem de serviço inválida!");
		}
	}

	public Relatorio getRelatorio() {
		return this.relatorio;
	}

	public void setRelatorio(Relatorio relatorio) {
		if(relatorio != null){
			this.relatorio = relatorio;
		} else {
			throw new IllegalArgumentException("Relatório inválido!");
		}
	}

	public Avaliacao getAvaliacao() {
		return this.avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
        if (avaliacao != null) {
        	this.avaliacao = avaliacao;
        } else {
        	throw new IllegalArgumentException("Avaliação inválida!");
        }
	}
	
	@Override
    public void listarDados() {
    	System.out.println("\n-- Serviço --");
    	System.out.println("Ordem de Servico: " + ordemServico.getId());
        System.out.println("Custo: " + getCusto());
        System.out.println("Descricao: " + getDescricao());
        System.out.println("Status: " + getStatus());
        System.out.println("Data de início: " + getDataInicio());
        System.out.println("Data de encerramento: " + getDataEncerramento());
    }
      
}
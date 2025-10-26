package SistemaOS;

import java.time.LocalDate;
import java.util.ArrayList;

public class OrdemServico implements Registravel, Listavel{
    
	private static int contador = 1;
    private int id;
    private String prioridade;
    private LocalDate dataEstimada;
    private boolean registrado;
    private Cliente cliente;
    private ArrayList<Servico> servico = new ArrayList<>();
    private ArrayList<OSTecnico> oSTecnico = new ArrayList<>();
    private ArrayList<OSEquipamento> oSEquipamento = new ArrayList<>();
    
    public OrdemServico(String prioridade, LocalDate dataEstimada, Cliente cliente) {
    	this.id = contador++;
		setPrioridade(prioridade);
		setDataEstimada(dataEstimada);
		setCliente(cliente);
    }
    
    public int getId() {
		return this.id;
	}

	public String getPrioridade() {
		return this.prioridade;
	}

	public void setPrioridade(String prioridade) {
		if(prioridade != null && !prioridade.isEmpty()){
            this.prioridade = prioridade;
       } else {
       	throw new IllegalArgumentException("Prioridade inválida!");
       }
	}

	public LocalDate getDataEstimada() {
		return this.dataEstimada;
	}

	//Se dataEstimada for nula, o throw já interrompe a execução
	//→ nunca chegará na linha this.dataEstimada = dataEstimada;.
	public void setDataEstimada(LocalDate dataEstimada) {
	    if (dataEstimada == null) {
	        throw new IllegalArgumentException("Data estimada inválida!");
	    }

	    // se existir algum serviço vinculado, validar contra as datas de início
	    if (this.servico != null && !this.servico.isEmpty()) {
	        for (Servico servico : this.servico) {
	            if (servico.getDataInicio() != null && dataEstimada.isBefore(servico.getDataInicio())) {
	                throw new IllegalArgumentException(
	                    "A data estimada não pode ser anterior à data de início do serviço (" 
	                    + servico.getDataInicio() + ")."
	                );
	            }
	        }
	    }

	    this.dataEstimada = dataEstimada;
	}


	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		if(cliente != null){
            this.cliente = cliente;
       } else {
       	throw new IllegalArgumentException("Cliente inválido!");
       }
	}

	public ArrayList<Servico> getServico() {
		return this.servico;
	}

	public void setServico(ArrayList<Servico> servico) {
		if(servico != null){
            this.servico = servico;
       } else {
       	throw new IllegalArgumentException("Servico inválido!");
       }
	}


	public void adicionarServico(Servico s) {
    	if(s != null){
    		if(registrado == true) {
    			servico.add(s);
         	} else {
         		System.out.println("Ordem de Serviço não registrada, não é possível adicionar serviço!");
         	}
         } else {
             throw new IllegalArgumentException("Relação Ordem de Serviço e Técnico inválida!");
         }
    }

    public void removerServico(Servico s) {
    	if(s != null){
            servico.remove(s);
        } 
    }


	public ArrayList<OSTecnico> getOSTecnico() {
        return this.oSTecnico;
    }

    public void setOSTecnico(ArrayList<OSTecnico> oSTecnico) {
    	if(oSTecnico != null){
            this.oSTecnico = oSTecnico;
       } else {
       	throw new IllegalArgumentException("Relação Ordem de Serviço e Técnico inválida!");
       }
    }

    public void adicionarOSTecnico(OSTecnico ost) {
    	if(ost != null){
    		if(registrado == true) {
    			oSTecnico.add(ost);
         	} else {
         		System.out.println("Ordem de Serviço não registrada, não é possível adicionar técnico!");
         	}
         } else {
             throw new IllegalArgumentException("Relação Ordem de Serviço e Técnico inválida!");
         }
    }

    public void removerOSTecnico(OSTecnico ost) {
    	if(ost != null){
            oSTecnico.remove(ost);
        } 
    }
    
    public ArrayList<OSEquipamento> getOSEquipamento() {
        return this.oSEquipamento;
    }

    public void setOSEquipamento(ArrayList<OSEquipamento> oSEquipamento) {
    	if(oSEquipamento != null){
            this.oSEquipamento = oSEquipamento;
       } else {
       	throw new IllegalArgumentException("Relação Ordem de Serviço e Equipamento inválida!");
       }
    }

    public void adicionarOSEquipamento(OSEquipamento ose) {
    	if(ose != null){
    		if(registrado == true) {
    			oSEquipamento.add(ose);
         	} else {
         		System.out.println("Ordem de Serviço não registrada, não é possível adicionar equipamento!");
         	}
         } else {
             throw new IllegalArgumentException("Relação Ordem de Serviço e Equipamento inválida!");
         }
    }

    public void removerOSEquipamento(OSEquipamento ose) {
    	if(ose != null){
    		oSEquipamento.remove(ose);
        } 
    }
    
    public double calcularCustoTotal() {
    	double custoTotal = 0.0;
    	for(Servico servicoOS : servico) {
    		custoTotal += servicoOS.getCusto();
    	}
    	return custoTotal;
    }
    
    @Override
	public void listarDados(){
		System.out.println("\n-- Ordem de Serviço --");
        System.out.println("ID: " + getId());
        System.out.println("Prioridade: " + getPrioridade());
        System.out.println("Data Estimada: " + getDataEstimada());
        System.out.println("Serviços:");
        for (Servico s : getServico()) {
            System.out.println("  - " + s.getDescricao() + " | Custo: " + s.getCusto() + " | Status: " + s.getStatus());
            if (s.getAvaliacao() != null) {
                s.getAvaliacao().mostrarAvaliacao(s);
            }
        }
        System.out.println("Custo Total: " + calcularCustoTotal());
	}
    
    @Override
    public void registrar() {
        if (id > 0) {
        	if(registrado != true) {
        		System.out.println("Ordem de Serviço registrada!");
                this.registrado = true;
        	} else {
        		System.out.println("Ordem de Serviço já registrada!");
        	}
        } else {
        	System.out.println("Ordem de Serviço inválida! Registro não realizado!");
            this.registrado = false;
        }
    }

}

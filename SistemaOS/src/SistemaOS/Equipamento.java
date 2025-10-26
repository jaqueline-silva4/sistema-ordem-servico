package SistemaOS;

import java.util.ArrayList;

public class Equipamento implements Listavel {
    
	private static int contador = 1;
    private int id;
    private String nome;
    private String modelo;
    private String descricao;
    private ArrayList<OSEquipamento> oSEquipamento = new ArrayList<>();

    public Equipamento(String nome, String modelo, String descricao) {
    	this.id = contador++;
    	setNome(nome);
    	setModelo(modelo);
    	setDescricao(descricao);
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if(nome != null && !nome.isEmpty()) {
        	this.nome = nome;
        } else {
        	throw new IllegalArgumentException("Nome inválido!");
        }
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        if(modelo != null && !modelo.isEmpty()) {
        	this.modelo = modelo;
        } else {
        	throw new IllegalArgumentException("Modelo inválido!");
        }
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        if(descricao != null && !descricao.isEmpty()) {
        	this.descricao = descricao;
        } else {
        	throw new IllegalArgumentException("Descrição inválida!");
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
    		oSEquipamento.add(ose);
         } else {
             throw new IllegalArgumentException("Relação Ordem de Serviço e Equipamento inválida!");
         }
    }

    public void removerOSEquipamento(OSEquipamento ose) {
    	if(ose != null){
    		oSEquipamento.remove(ose);
        } 
    }
    
    public void listarDados() {
    	System.out.println("\n-- Equipamento --");
        System.out.println("Nome: " + getNome());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Descrição: " + getDescricao());
    }
    
}

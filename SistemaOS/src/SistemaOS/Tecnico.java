package SistemaOS;

import java.util.ArrayList;

public class Tecnico implements Registravel, Listavel{
    
	private static int contador = 1;
    private int id;
    private String nome;
    private String especialidade;
    private boolean registrado;
    private ArrayList<OSTecnico> oSTecnico = new ArrayList<>();

    public Tecnico(String nome, String especialidade) {
    	this.id = contador++;
    	setNome(nome);
    	setEspecialidade(especialidade);
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if(nome != null && !nome.isEmpty()){
             this.nome = nome;
        } else {
        	throw new IllegalArgumentException("Nome inválido!");
        }
    }

    public String getEspecialidade() {
        return this.especialidade;
    }

    public void setEspecialidade(String especialidade) {
        if(especialidade != null && !especialidade.isEmpty()){
             this.especialidade = especialidade;
        } else {
        	throw new IllegalArgumentException("Especialidade inválida!");
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
            if(registrado == true){
                oSTecnico.add(ost);
            } else {
                System.out.println("Técnico não registrado, não é possível realizar uma ordem de serviço");
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

    @Override
    public void listarDados(){
        System.out.println("\n-- Técnico --");
        System.out.println("Nome: " + getNome());
        System.out.println("Especialidade: " + getEspecialidade());
    }

    @Override
    public void registrar() {
        if(nome != null && !nome.isEmpty()){
            if(registrado != true){
                System.out.println("Técnico registrado: " + nome);
                this.registrado = true;
            } else {
                System.out.println("Técnico já resgitrado: " + nome);
            } 
        } else {
            System.out.println("Técnico inválido! Registro não realizado!");
            this.registrado = false;
        }
    }

    
}

package SistemaOS;

import java.util.ArrayList;

public class Cliente implements Registravel, Listavel{
    
	private static int contador = 1;
    private int id;
    private String nome;
    private String email;
    private boolean registrado;
    private ArrayList<Contato> contatos = new ArrayList<>();
    private ArrayList<Avaliacao> avaliacao = new ArrayList<>();
    private ArrayList<OrdemServico> ordemServico = new ArrayList<>();
    
    public Cliente(String nome, String email, ArrayList<Contato> contatos) {
    	this.id = contador++;
        setNome(nome);
        setEmail(email);
        setContatos(contatos);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome != null && !nome.isEmpty()){
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Nome inválido!");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email != null && !email.isEmpty()){
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email inválido!");
        }
    }

    public ArrayList<Contato> getContatos() {
        return this.contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        if(contatos != null){
            this.contatos = contatos;
        } else {
            throw new IllegalArgumentException("Contato inválido!");
        }
    }

    public void adicionarContato(Contato c) {
        if(c != null){
             contatos.add(c);
        } else {
            throw new IllegalArgumentException("Contato inválido!");
        }
    }

    public void removerContato(Contato c) {
        if(c != null){
            contatos.remove(c);
         } 
         // O método remove não lança erro se o objeto não estiver na lista, ele apenas retorna false. 
         // Então, esse método é seguro mesmo se a avaliação não existir na lista.
    }

    public ArrayList<Avaliacao> getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(ArrayList<Avaliacao> avaliacao) {
		if(avaliacao != null){
              this.avaliacao = avaliacao;
        } else {
            throw new IllegalArgumentException("Avaliação inválida!");
        }
	}

    public void adicionarAvaliacao(Avaliacao a){
        if(a != null){
        	if(registrado == true) {
        		avaliacao.add(a);
        	} else {
        		System.out.println("Cliente não registrado, não é possível avaliar!");
        	}
        } else {
            throw new IllegalArgumentException("Avaliação inválida!");
        }
    }

    public void removerAvaliacao(Avaliacao a){
         if(a != null){
             avaliacao.remove(a);
         } 
     }

	public ArrayList<OrdemServico> getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(ArrayList<OrdemServico> ordemServico) {
		if(ordemServico != null){
             this.ordemServico = ordemServico;
        } else {
            throw new IllegalArgumentException("Ordem de serviço inválida!");
        }
       
	}

    public void adicionarOrdemServico(OrdemServico os){
         if(os != null){
        	 if(registrado == true) {
         		ordemServico.add(os);
         	} else {
         		System.out.println("Cliente não registrado, não é possível adicionar uma ordem de serviço!");
         	}
        } else {
            throw new IllegalArgumentException("Ordem de serviço inválida!");
        }
    }

    public void removerOrdemServico(OrdemServico os){
        if(os != null){
             ordemServico.remove(os);
         } 
    }


    @Override
    public void listarDados() {
    	System.out.println("\n-- Cliente --");
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("Contatos:");
        for (Contato c : getContatos()) {
            System.out.println("  - " + c.getTipo() + ": (" + c.getDdd() + ") " + c.getNumero());
        }
    }
    
    @Override
    public void registrar() {
        if (nome != null && !nome.isEmpty()) {
        	if(registrado != true) {
        		System.out.println("Cliente registrado: " + nome);
                this.registrado = true;
        	} else {
        		System.out.println("Cliente já registrado: " + nome);
        	}
        } else {
        	System.out.println("Cliente inválido! Registro não realizado!");
            this.registrado = false;
        }
    }

}

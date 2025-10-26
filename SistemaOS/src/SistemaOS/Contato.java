package SistemaOS;

public class Contato {
    
	private static int contador = 1;
    private int id;
    private String tipo;
    private String ddd;
    private String numero;

    public Contato(String tipo, String ddd, String numero) {
        this.id = ++contador;
        setTipo(tipo);
        setDdd(ddd);
        setNumero(numero); 
    }

    public int getId() {
        return this.id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        if(tipo != null && !tipo.isEmpty()) {
        	this.tipo = tipo;
        } else {
        	throw new IllegalArgumentException("Tipo inválido!");
        }
    }

    public String getDdd() {
        return this.ddd;
    }

    public void setDdd(String ddd) {
        if(ddd != null && !ddd.isEmpty()) {
        	this.ddd = ddd;
        } else {
        	throw new IllegalArgumentException("DDD inválido!");
        }
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
    	if(numero != null && !numero.isEmpty()) {
    		 this.numero = numero;
    	} else {
    		throw new IllegalArgumentException("Número inválido!");
    	}
    } 
}
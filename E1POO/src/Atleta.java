import java.util.ArrayList;


public class Atleta {

	private int numero;

	private String nome;

	private String pais;

	private ArrayList<Medalha> medalha;

	public Atleta(int numero, String nome, String pais) {
		this.numero = numero;
		this.nome = nome;
		this.pais = pais;
		this.medalha = new ArrayList<>();
	}

	public void adicionaMedalha(Medalha medalhas) {
		this.medalha.add(medalhas);
	}

	public int consultaQuantidadeMedalhas() {
		return medalha.size();
	}



	public int getNumero() {
		return numero;
	}

	public String getNome() {
		return nome;
	}

	public String getPais() {
		return pais;
	}

	public ArrayList<Medalha> getMedalha() {
		return medalha;
	}



	@Override
	public String toString() {
		return
				    numero  +
				", " + nome +
				", " + pais;
				};
	}


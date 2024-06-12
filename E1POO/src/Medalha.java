import java.util.ArrayList;


public class Medalha {

	private int codigo;

	private int tipo;

	private boolean individual;

	private String modalidade;

	private ArrayList<Atleta> atleta;

	public Medalha(int codigo, int tipo, boolean individual, String modalidade) {
		this.codigo = codigo;
		this.tipo = tipo;
		this.individual = individual;
		this.modalidade = modalidade;
		this.atleta = new ArrayList<>();
	}

	public void adicionaAtleta(Atleta atletas) {
		this.atleta.add(atletas);
	}



	public int getCodigo() {
		return codigo;
	}

	public String getModalidade() {
		return modalidade;
	}

	public int getTipo() {
		return tipo;
	}

	public ArrayList<Atleta> getAtleta() {
		return atleta;
	}

	@Override
	public String toString() {
		return
				  codigo +
				", " + tipo +
				", " + individual +
				", " + modalidade;

	}
}

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;


public class Plantel {

	private ArrayList<Atleta> atleta;

	public Plantel() {
		this.atleta = new ArrayList<>();
	}

	public boolean cadastraAtleta(Atleta atletas) {
		for (int i = 0; i < atleta.size(); i++) {
			Atleta a = atleta.get(i);
			if (a.getNumero() == atletas.getNumero()) {
				return false;
			}
		}
		return this.atleta.add(atletas);

	}

	public Atleta consultaAtleta(String nome) {
		for (Atleta atleta : atleta) {
			if (atleta.getNome().equals(nome)) {
				return atleta;
			}
		}
		return null;
	}

	public Atleta consultaAtleta(int numero) {
		for (Atleta a : atleta) {
			if (a.getNumero() == numero) {
				return a;
			}
		}
		return null;
	}

	public ArrayList<Atleta> consultaPais(String pais) {
		ArrayList<Atleta> paisConsulta = new ArrayList<>();
		for (Atleta a : atleta) {
			if (a.getPais().equals(pais)) {
				paisConsulta.add(a);
			}
		}
		return paisConsulta;
	}

	public ArrayList<Atleta> getAtleta() {
		return atleta;
	}

	public boolean atletaGanhouModalidade(Atleta atleta, String modalidade) {
		for (Medalha m : atleta.getMedalha()) {
			if (m.getModalidade().equalsIgnoreCase(modalidade)) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Atleta> consultarPorTipoDeMedalha(int tipo) {
		ArrayList<Atleta> atletasMedalha = new ArrayList<>();
		for (Atleta a : atleta) {
			for (Medalha m : a.getMedalha()) {
				if (m.getTipo() == tipo) {
					atletasMedalha.add(a);
					break;
				}
			}
		}
		return atletasMedalha;
	}

	public Atleta encontrarAtletaMaisMedalha() {
		if (atleta.isEmpty()) {
			return null;
		}

		Atleta atletaMaisMedalha = null;
		int maxMedalhas = -1; //Garante que nenhum tenha menos de 0

		for (Atleta a : atleta) {
			int totalMedalhas = 0;

			for (Medalha m : a.getMedalha()) {
				switch (m.getTipo()) {
					case 1:
						totalMedalhas++;
						break;
					case 2:
						totalMedalhas++;
						break;
					case 3:
						totalMedalhas++;
						break;
				}
			}

			if (totalMedalhas > maxMedalhas) {
				maxMedalhas = totalMedalhas;
				atletaMaisMedalha = a;
			}
		}
		return atletaMaisMedalha;
	}

		public int contarMedalhaPorTipo(Atleta atleta, int tipoM) {
			int totalMedalhas = 0;
			for (Medalha m : atleta.getMedalha()) {
				if (m.getTipo() == tipoM) {
					totalMedalhas++;
				}
			}
			return totalMedalhas;
		}
	}


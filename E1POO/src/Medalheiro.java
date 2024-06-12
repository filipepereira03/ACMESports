
import java.util.ArrayList;

public class Medalheiro {

	private ArrayList<Medalha> medalha;

	public Medalheiro() {
		this.medalha = new ArrayList<>();
	}

	public ArrayList<Medalha> getMedalha() {
		return medalha;
	}

	public boolean cadastraMedalha(Medalha m) {
		 if (consultaMedalha(m.getCodigo()) != null)
			 return false;
		 return medalha.add(m);
	}
	public Medalha consultaMedalha(int codigo) {
		for (Medalha m : medalha) {
			if (m.getCodigo() == codigo) {
				return m;
			}
		}
		return null;
	}

	public ArrayList<Medalha> consultaMedalhas(String modalidade) {
			ArrayList<Medalha> medalhasPorModalidade = new ArrayList<>();
        for (Medalha m : medalha) {
            if (m.getModalidade().equals(modalidade)) {
                medalhasPorModalidade.add(m);
			}
        }
		return medalhasPorModalidade;
	}



	public int contarMedalhas(Atleta atleta) {
		int totalMedalhas = 0;
		for (Medalha m : atleta.getMedalha()) {
			totalMedalhas++;
		}
		return totalMedalhas;
	}

	public int contarMedalhasTipo(Atleta atleta, int tipoMedalha) {
		int totalMedalhas = 0;
		for (Medalha m : atleta.getMedalha()) {
			if (m.getTipo() == tipoMedalha) {
				totalMedalhas++;
			}
		}
		return totalMedalhas;
	}




}



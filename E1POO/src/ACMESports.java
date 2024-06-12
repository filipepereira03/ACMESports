

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ACMESports {
    private Scanner entrada;  // Atributo para entrada de dados
    private PrintStream saidaPadrao = System.out;   // Guarda a saída padrão - tela (console)

    private Plantel plantel;

    private Medalheiro medalheiro;


    // Construtor da classe ACMESports
    public ACMESports() {
        plantel = new Plantel();
        medalheiro = new Medalheiro();

        redirecionaES();    // Redireciona E/S para arquivos
    }

    // Redireciona E/S para arquivos
    private void redirecionaES() {
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader("dadosin.txt"));
            entrada = new Scanner(streamEntrada);   // Usa como entrada um arquivo
            PrintStream streamSaida = new PrintStream(new File("dadosout.txt"), Charset.forName("UTF-8"));
            System.setOut(streamSaida);             // Usa como saída um arquivo
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH);   // Ajusta para ponto decimal
        entrada.useLocale(Locale.ENGLISH);   // Ajusta para leitura para ponto decimal
    }

    // Restaura E/S padrão de tela(console)/teclado
    private void restauraES() {
        System.setOut(saidaPadrao);
        entrada.close(); // Fecha o scanner de entrada do arquivo
    }

    public void executa() {
        cadastrarAtleta();
        cadastrarMedalha();
        medalhaAtleta();
        dadosAtletaNumero();
        dadosAtletaNome();
        dadosMedalha();
        dadosPorPais();
        dadosAtletasMedalha();
        atletasDeterminadaModalidade();
        exibirAtletaMaisMedalha();
    }

    private void cadastrarAtleta() {
        while (true) {
            int numero = entrada.nextInt();
            entrada.nextLine();
            if (numero == -1) {
                break;
            }

            String nome = entrada.nextLine();

            String pais = entrada.nextLine();


            Atleta novoAtleta = new Atleta(numero, nome, pais);
            plantel.cadastraAtleta(novoAtleta);
            System.out.println("1: " + novoAtleta);

        }
    }

    private void cadastrarMedalha() {
        while (true) {
            int codigo = entrada.nextInt();
            entrada.nextLine();
            if (codigo == -1) {
                break;
            }


            int tipo = entrada.nextInt();
            entrada.nextLine();
            boolean individual = entrada.nextBoolean();
            entrada.nextLine();
            String modalidade = entrada.nextLine();

            Medalha novaMedalha = new Medalha(codigo, tipo, individual, modalidade);
            medalheiro.cadastraMedalha(novaMedalha);
            System.out.println("2: " + novaMedalha);
        }
    }

    private void medalhaAtleta() {
        while (true) {
            int codigo = entrada.nextInt();
            entrada.nextLine();
            if (codigo == -1) {
                break;
            }

            int numero = entrada.nextInt();

            Atleta atleta = plantel.consultaAtleta(numero);
            Medalha medalha = medalheiro.consultaMedalha(codigo);
            medalha.adicionaAtleta(atleta);
            atleta.adicionaMedalha(medalha);
            System.out.println("3: " + medalha.getCodigo() + "," + atleta.getNumero());

        }
    }

    private void dadosAtletaNumero() {
        int numero = entrada.nextInt();
        if (plantel.consultaAtleta(numero) == null) {
            System.out.println("4: Nenhum atleta não encontrado");
        } else {
            System.out.println("4: " + plantel.consultaAtleta(numero));
        }
    }

    private void dadosAtletaNome() {
        entrada.nextLine();
        String nome = entrada.nextLine();
        if (plantel.consultaAtleta(nome) == null) {
            System.out.println("5: Nenhum atleta encontrado");
        } else {
            System.out.println("5: " + plantel.consultaAtleta(nome));
        }
    }

    private void dadosMedalha() {
        int codigo = entrada.nextInt();
        if (medalheiro.consultaMedalha(codigo) == null) {
            System.out.println("6: Nenhuma medalha encontrada");
        } else {
            System.out.println("6: " + medalheiro.consultaMedalha(codigo));
        }
    }

    private void dadosPorPais() {
        entrada.nextLine();
        String pais = entrada.nextLine();
        if (plantel.consultaPais(pais) == null) {
            System.out.println("7: Pais não encontrado");
        } else {
            ArrayList<Atleta> novoArray = plantel.consultaPais(pais);
            System.out.println("7: " + novoArray);
        }
    }

    private void dadosAtletasMedalha() {
        int tipoMedalha = entrada.nextInt();
        ArrayList<Atleta> atletasMedalha = plantel.consultarPorTipoDeMedalha(tipoMedalha);
        if (atletasMedalha.isEmpty()) {
            System.out.println("8. Nenhum atleta encontrado");
        } else {
            for (Atleta a : atletasMedalha) {
                System.out.println("8. " + a.getNumero() + "," + a.getNome() + "," + a.getPais());
            }
        }
    }

    private void atletasDeterminadaModalidade() {
        entrada.nextLine(); // Limpando o buffer pq ele estava bugando e recebia o arraylist vazio
        String modalidade = entrada.nextLine();
        ArrayList<Medalha> medalhaModalidadeS = medalheiro.consultaMedalhas(modalidade);
        if (medalhaModalidadeS.isEmpty()) {
            System.out.println("9. Modalidade não encontrada");
        } else {
            for (Medalha m : medalhaModalidadeS) {
                if (m.getAtleta().isEmpty()) {
                    System.out.println("9: " +m.getModalidade() + ","
                    +m.getTipo() + ",Sem atletas com medalhas");
                } else {
                    for (Atleta a : m.getAtleta()) {
                        System.out.println("9: " +modalidade + ","
                        +m.getTipo() + "," +a.getNumero() + "," +
                                a.getNome() + "," +a.getPais());
                    }
                }
            }
        }
    }

    private void exibirAtletaMaisMedalha() {
        Atleta atletaMaisMedalha = plantel.encontrarAtletaMaisMedalha();

        if (atletaMaisMedalha != null) {
            int totalOuro = plantel.contarMedalhaPorTipo(atletaMaisMedalha, 1);
            int totalPrata = plantel.contarMedalhaPorTipo(atletaMaisMedalha, 2);
            int totalBronze = plantel.contarMedalhaPorTipo(atletaMaisMedalha, 3);

            System.out.println("10: " +atletaMaisMedalha.getNumero() + "," +
                    atletaMaisMedalha.getNome() + "," +
                    atletaMaisMedalha.getPais() + "," +
                    "Ouro: " +totalOuro + ",Prata: " +totalPrata  + ",Bronze: " +totalBronze);

        } else {
            System.out.println("10: Nenhum atleta com medalha.");
        }
    }
}






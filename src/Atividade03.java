
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Atividade03 {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Animal n = new Animal(0, "", "", 0, "", 0);
        ArrayList<Animal> gatos = new ArrayList();

        Scanner s = new Scanner(System.in);
        String nome = "";
        String raca = "";
        int idade = 0;
        String doenca = "";
        double valor = 0.00;

        for (int i = 0; i < 2; i++) {
            //id
            n.random();

            System.out.println("\n ==== NOVO GATO ==== \n");
            //nome
            System.out.println("Digite o Nome do gato: ");
            nome = s.next();

            //raca
            System.out.println("Digite a raca do gato: ");
            raca = s.next();

            //idade
            System.out.println("Digite a idade do gato: ");
            idade = s.nextInt();

            //doenca
            System.out.println("Digite a doenca do gato: ");
            doenca = s.next();

            //valor
            System.out.println("Digite o valor do servico: ");
            valor = s.nextDouble();

            gatos.add(new Animal(n.random(), nome, raca, idade, doenca, valor));
        }

        for (Animal gato : gatos) {
            System.out.println(gato);
        }
        System.out.println("===========================");
        System.out.println("[1] Buscador");
        System.out.println("[2] Ordenar");
        System.out.println("[3] Apagar gato");
        System.out.println("[4] Listagem");
        System.out.println("[5] Levantar idade");
        System.out.println("[6] Valor dos atendimentos");
        System.out.println("===========================\n");

        System.out.println("Digite uma opção acima: ");
        int opc = s.nextInt();

        switch (opc) {
            case 1:
                System.out.println("=====================BUSCADOR=====================");
                System.out.println("Qual valor você quer buscar (ID/NOME): ");
                String escolha = s.next();

                if (escolha.equalsIgnoreCase("ID")) {
                    System.out.println("Digite o ID: ");
                    int chave = s.nextInt();
                    Animal resultado = Animal.buscaPorNomeOuId(gatos, chave);
                    if (resultado != null) {
                        System.out.println("Dados obtidos: " + resultado);
                    }
                    // Faça algo com o ID
                } else if (escolha.equalsIgnoreCase("NOME")) {
                    System.out.println("Digite o NOME: ");
                    String chave = s.next();
                    Animal resultado = Animal.buscaPorNomeOuId(gatos, chave);
                    if (resultado != null) {
                        System.out.println("Dados obtidos: " + resultado);
                    }
                    // Faça algo com o NOME
                } else {
                    System.out.println("Escolha inválida. Por favor, digite ID ou NOME.");
                }
                break;
            case 2:
                Animal.ordenarAlf(gatos);
                for (Animal gato : gatos) {
                    System.out.println(gato.getNome());
                }
                break;
            case 3:
                System.out.println("Qual gato apagar? (ID): ");
                int id = s.nextInt();
                Animal remover = null;
                for (Animal gato : gatos) {
                    if (gato.getId() == id) {
                        remover = gato;
                    }
                }
                if (remover != null) {
                    gatos.remove(remover);
                    System.out.println(gatos.size());
                }
                System.out.println("Imprimindo Lista:");
                for (Animal gato : gatos) {
                    System.out.println(gato);
                }
                System.out.println("===========================");
                break;
            case 4:
                int i = 1;
                for (Animal gato : gatos) {
                    System.out.print("[" + i + "]" + gato.getNome() + "\n");
                    i++;
                }
                break;
            case 5:
                System.out.println("Digite a idade a ser pesquisada: ");
                int val = s.nextInt();
                i = 0;
                for (Animal gato : gatos) {
                    if (gato.getIdade() == val) {
                        i++;
                    }
                }
                if (i > 0) {
                    System.out.println("Ha " + i + " gatos com " + val + " anos.");
                } else {
                    System.out.println("Não há gatos com essa idade!");
                }
            case 6: 
                 double tot = 0;
                 for (Animal gato : gatos) {
                     tot = tot + gato.getValor();
                 }
                 System.out.println("O valor total dos atendimentos é : " + tot);
                 break; 
                 
        } 
    }

}

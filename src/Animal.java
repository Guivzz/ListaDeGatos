
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import static java.util.Spliterators.iterator;

public class Animal {

    private int id;
    private String raca;
    private String doenca;
    private String nome;
    private double valor;
    private int idade;

    public Animal(int id, String nome, String raca, int idade, String doenca, double valor) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.doenca = doenca;
        this.valor = valor;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int random() {
        int rand = (int) (Math.random() * 9999);
        setId(rand);
        return rand;
    }

    public static Animal buscaPorNomeOuId(ArrayList<Animal> gatos, Object busca) {
        for (Animal gato : gatos) {
            if (busca instanceof Integer) {
                if ((int) busca == gato.getId()) {
                    return gato;
                }
            }
            if (busca instanceof String) {
                if (gato.getNome().equals((String) busca)) {
                    return gato;
                }
            }
        }
        return null;
    }

    public static Animal ordenarAlf(ArrayList<Animal> gatos) {
        for (Animal gato : gatos) {
            Comparator<Animal> comparator = Comparator.comparing(Animal::getNome);
            Collections.sort(gatos, comparator);
            return gato;
        }
        return null;
    }
    
    

    @Override
    public String toString() {
        return "Id: " + getId() + "\nNome:" + getNome() + "\nDoenca: " + getDoenca()
                + "\nRaca: " + getRaca() + "\nValor: $" + getValor() + "\nIdade: " + getIdade() + "\n";
    }

}

import java.util.*;

// Interface para cálculo de média
interface ICalcMedia {
    double calcularMedia();
    String situacao();
}

// Classe para cálculo de média aritmética
class Aritmetica implements ICalcMedia {
    private double p1;
    private double p2;

    public Aritmetica(double p1, double p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double calcularMedia() {
        return (p1 + p2) / 2;
    }

    public String situacao() {
        if (calcularMedia() > 5.0) {
            return "Aprovado";
        } else {
            return "Reprovado";
        }
    }
}

// Classe para cálculo de média geométrica
class Geometrica implements ICalcMedia {
    private double p1;
    private double p2;

    public Geometrica(double p1, double p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double calcularMedia() {
        return Math.sqrt(p1 * p2);
    }

    public String situacao() {
        if (calcularMedia() > 7.0) {
            return "Aprovado";
        } else {
            return "Reprovado";
        }
    }
}

// Classe Disciplina
class Disciplina {
    private ICalcMedia calcMedia;
    private double p1;
    private double p2;
    private double media;
    private String nome;

    public Disciplina(ICalcMedia calcMedia) {
        this.calcMedia = calcMedia;
    }

    public void calcularMedia() {
        media = calcMedia.calcularMedia();
    }

    public String situacao() {
        return calcMedia.situacao();
    }

    public void setP1(double p1) {
        this.p1 = p1;
    }

    public void setP2(double p2) {
        this.p2 = p2;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getP1() {
        return p1;
    }

    public double getP2() {
        return p2;
    }

    public double getMedia() {
        return media;
    }

    public String getNome() {
        return nome;
    }
}

public class Main {
    public static void main(String[] args) {
        // Crie as estratégias aritmética e geométrica
        ICalcMedia calculoAritmetico = new Aritmetica(10, 8.0); // Forneça as notas
        ICalcMedia calculoGeometrico = new Geometrica(8.0, 9.0); // Forneça as notas

        // Crie as disciplinas com as respectivas estratégias
        Disciplina d1 = new Disciplina(calculoAritmetico);
        Disciplina d2 = new Disciplina(calculoGeometrico);

        // Defina as notas para cada disciplina
        d1.setNome("Padrões de Desenvolvimento");
        d1.calcularMedia();

        d2.setNome("Padrões de Desenvolvimento");
        d2.calcularMedia();

        // Exiba os resultados
        System.out.println(String.format("P1: %.2f, P2: %.2f, Média: %.2f, Situação: %s", d1.getP1(), d1.getP2(), d1.getMedia(), d1.situacao()));
        System.out.println(String.format("P1: %.2f, P2: %.2f, Média: %.2f, Situação: %s", d2.getP1(), d2.getP2(), d2.getMedia(), d2.situacao()));
    }
}

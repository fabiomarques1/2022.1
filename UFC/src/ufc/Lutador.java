
package ufc;


public class Lutador {
    private String nome;
    private String nacionalidade;
    private int idade;
    private float altura;
    private float peso;
    private String categoria;
    private int vitoria;
    private int derrota;
    private int empate;
    
    public String apresentar(){
        return "Lutador{" + "nome=" + nome + ", nacionalidade=" + nacionalidade + ", categoria=" + categoria + "}";
    }
    
    public String status() {
        return "Lutador{" + "nome=" + nome + ", nacionalidade=" + nacionalidade + ", idade=" + idade + ", altura=" + altura + ", peso=" + peso + ", categoria=" + categoria + ", vitoria=" + vitoria + ", derrota=" + derrota + ", empate=" + empate + '}';
    }
    
    public void ganharLuta() {
        this.vitoria++;
    }
    
    public void perderLuta(){
        this.derrota++;
    }
    
    public void empatarLuta(){
        this.empate++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade >= 21 && idade < 150) {
            this.idade = idade;
        } else {
            this.idade = 0;
        }
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        if (altura > 1 && altura < 3) {
            this.altura = altura;
        } else {
            this.altura = 0;
        }
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        if (peso > 30 && peso < 150) {
            this.peso = peso;
        } else {
            this.peso = 0;
        }
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria() {
        if (this.peso < 70) { 
            this.categoria = "Leve";
        } else if (this.peso < 85) {
            this.categoria = "Médio";
        } else {
            this.categoria = "Pesado";
        }
    }

    public int getVitoria() {
        return vitoria;
    }

    public void setVitoria(int vitoria) {
        this.vitoria = vitoria;
    }

    public int getDerrota() {
        return derrota;
    }

    public void setDerrota(int derrota) {
        this.derrota = derrota;
    }

    public int getEmpate() {
        return empate;
    }

    public void setEmpate(int empate) {
        this.empate = empate;
    }
    
    
    
}

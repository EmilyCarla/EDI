/*Faça uma fila para atendimento num posto de saúde utilizando a estrutura de DEQUE. cada pessoa possui um ID, sexo, idade, gestante (s/n), lactante(s/n), necessidade 
especial(s/n). O atendimento do posto deve seguir uma ordem de prioridade, sendo:
Prioridade    tipo
0                    Normal
1                    acima de 60 anos
2                    Necessidades especiais
3                    Gestante / lactante
A menor prioridade é a 0 e a maior prioridade é a 3, que devem ser atendido primeiramente. O posto atende cerca de 100 pessoas por dia. Sabe-se que as pessoas chegam 
grupos de 10 para serem atendidos, no grupo é atendido 1 pessoa, no segundo grupo 2 pessoas, no terceiro grupo 3 pessoas, e assim por diante até completar 100 pessoas 
atendidas. Os dados das pessoas podem ser criados aleatoriamente. Mostrar um fila dos atendimentos realizados naquele dia no posto e as pessoas que não foram atendidas. 
Por Exemplo: Para cada grupo de 10 pessoas que chegam no posto de saúde, chegam na seguinte proporção:  1 Necessidade Especiais, 1 Gestante, 1 Lactante, 3 acima de 60, 
5 Prioridade Normal.  */ 

import java.util.Random;

class Pessoa{
    private int id;
    private String sexo;
    private int idade;
    private boolean gestante;
    private boolean lactante;
    private boolean necessidadeEspecial;

    public Pessoa(int id, String sexo, int idade, boolean gestante, boolean lactante, boolean necessidadeEspecial){
        this.id = id;
        this.sexo = sexo;
        this.idade = idade;
        this.gestante = gestante;
        this.lactante = lactante;
        this.necessidadeEspecial = necessidadeEspecial;
    }

    public int getId() {
        return id;
    }

    public String getSexo() {
        return sexo;
    }

    public int getIdade() {
        return idade;
    }

    public boolean isGestante() {
        return gestante;
    }

    public boolean isLactante() {
        return lactante;
    }

    public boolean isNecessidadeEspecial() {
        return necessidadeEspecial;
    }

    public String toString(){
        return "Pessoa{" + 
                "id: " + id + 
                ", sexo: " + sexo +
                ", idade: " + idade +
                ", gestante: " + gestante +
                ", lactante: " + lactante +
                ", necessidade especial: " + necessidadeEspecial +
                "}";
    }
}

public class FilaAtendimentoPostoSaude{
    public static void main(String[] args) {
        Random gerar = new Random();
        Deque<Pessoa> filaAtendimento = new Deque<>();
        Deque<Pessoa> pessoasNaoAtendidas = new Deque<>();

        for(int i=0; i<=100; i++){
            int idade = gerar.nextInt(100);
            String sexo = gerar.nextBoolean() ? "M" : "F";
            boolean gestante = gerar.nextBoolean();
            boolean lactante = gerar.nextBoolean();
            boolean necessidadeEspecial = gerar.nextBoolean();

            Pessoa pessoa = new Pessoa(i, sexo, idade, gestante, lactante, necessidadeEspecial);
            inserirPessoaNaFilaDeAtendimento(filaAtendimento, pessoa);
        }

        int pessoasAtendidas = 0;
        int grupoSize = 1;
        while (pessoasAtendidas < 100) {
            for (int i = 0; i < grupoSize; i++) {
                Pessoa pessoa = removerPessoaDaFilaDeAtendimento(filaAtendimento);

                if (pessoa != null) {
                    System.out.println("Atendendo pessoa: " + pessoa);
                    pessoasAtendidas++;
                } else {
                    System.out.println("Pessoa não atendida ");
                    pessoasNaoAtendidas.imprimir();
                }
            }

            grupoSize++;
        }

       
        
    }
    
    
    //
    private static void inserirPessoaNaFilaDeAtendimento(Deque<Pessoa> fila, Pessoa pessoa) {
        int prioridade = verPrioridade(pessoa);
        int tamanhoFila = fila.size();

        for (int i = 0; i < tamanhoFila; i++) {
            Pessoa p = fila.getInicio();
            int pPrioridade = verPrioridade(p);

            if (prioridade < pPrioridade) {
                fila.adicionaNoFinal(fila.removeDoInicio());
            } else {
                break;
            }
        }

        fila.adicionaNoInicio(pessoa);
    }

    private static Pessoa removerPessoaDaFilaDeAtendimento(Deque<Pessoa> fila){
        if(!fila.isEmpty()){
        return fila.removeDoInicio();
    }
    return null;
}

    private static int verPrioridade(Pessoa pessoa){
        if(pessoa.getIdade() >= 60){
            return 1;
        }else if(pessoa.isNecessidadeEspecial()){
            return 2;
        }else if(pessoa.isGestante() || pessoa.isLactante()){
            return 3;
        }else{
            return 0;
        }
    }
}



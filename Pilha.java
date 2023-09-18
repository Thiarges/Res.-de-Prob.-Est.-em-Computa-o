package com.poo;

public class Pilha {

    // Nó no topo da pilha
    protected Node topo;
    
    // Nome da pilha
    protected String nomeDaPilha;
    
    // Tamanho da pilha
    protected int tamanho;

    public Pilha(String nome) {
        this.topo = null;
        this.nomeDaPilha = nome;
        this.tamanho = 0;
    }

    // Método para inserir um novo nó na pilha
    public void empilhar(Node novoNo) {
        if (novoNo != null) {
            novoNo.setAnterior(null);
            System.out.println("\nEmpilhado " + novoNo.getValor() + " em " + this.nomeDaPilha);

            if (this.topo != null) {
                novoNo.setAnterior(topo);
            }

            this.topo = novoNo;
            this.tamanho += 1;
        } else {
            System.out.println("\nSem Discos Para Empilhar!!");
        }
    }

    // Método para remover o nó do topo da pilha
    public Node desempilhar() {
        Node topoAntigo = this.topo;

        if (this.topo != null) {
            System.out.println("\nDesempilhado " + this.topo.getValor() + " de " + this.nomeDaPilha);

            if (this.topo.getAnterior() != null) {
                this.topo = this.topo.getAnterior();
            } else {
                this.topo = null;
            }

            this.tamanho -= 1;
        } else {
            System.out.println("\nSem Discos Para Desempilhar de " + this.nomeDaPilha);
        }

        return topoAntigo;
    }

    // Método para mostrar todos os nós da pilha
    public void exibir() {
        if (this.topo != null) {
            System.out.println("\nDiscos na " + this.nomeDaPilha + ":");

            Node noAtual = this.topo;
            
            while (noAtual != null) {
                System.out.println(noAtual.getValor());
                noAtual = noAtual.getAnterior();
                
                if (noAtual == null) {
                    System.out.println("NULL");
                    break;
                }
            }
        } else {
            System.out.println("\nSem Discos em " + this.nomeDaPilha);
        }
    }
}

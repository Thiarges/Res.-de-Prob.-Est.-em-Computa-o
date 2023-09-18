package com.poo;

public class Node {

    // Valor armazenado no nó, do tipo Integer para permitir null
    protected Integer valor;
    
    // Referência ao nó anterior na pilha ou lista encadeada
    protected Node anterior;

    // Construtor que inicializa o nó com valores nulos
    public Node() {
        this.valor = null;
        this.anterior = null;
    }

    // Método para obter o valor armazenado no nó
    public Integer getValor() {
        return this.valor;
    }

    // Método para definir o valor armazenado no nó
    public void setValor(Integer valor) {
        this.valor = valor;
    }
    
    // Método para obter a referência ao nó anterior na lista encadeada
    public Node getAnterior() {
        return this.anterior;
    }

    // Método para definir a referência ao nó anterior na lista encadeada
    public void setAnterior(Node anterior) {
        this.anterior = anterior;
    }
}

package com.poo;

import java.util.Scanner;
import java.util.Random;

public class Jogo {

    public static void solucao(int quantidade, Integer escolha, Pilha P1, Pilha P3, Pilha P2) {
        
        // Inicializando uma variável para guardar o disco que será movido entre as pilhas
        Node disco_movido = null;

        if (escolha == 1) {
            
            // Loop para mover discos até que a pilha P3  esteja completa
            while (P3.tamanho < quantidade) {
                // Cada bloco de condicional move um disco com base em regras
                // A ideia é mover o disco menor permitido para o topo da pilha de destino
                // Alguns dos condicionais checam o topo de cada pilha antes de mover
            
                // Movendo discos de P1 para P3 se o topo de P1 é menor ou igual ao topo de P3
                if (P1.topo != null && (P3.topo == null || P1.topo.valor <= P3.topo.valor)) {
                    disco_movido = P1.desempilhar();
                    P3.empilhar(disco_movido);
                    
                // Movendo discos de P1 para P2 e de P3 para P1 se o topo de P1 é maior que o topo de P3
                } else if (P1.topo != null && (P3.topo.valor < P1.topo.valor)) {
                    disco_movido = P1.desempilhar();
                    P2.empilhar(disco_movido);
                    disco_movido = P3.desempilhar();
                    P1.empilhar(disco_movido);
                        
                // Movendo discos de P2 para P3 se o topo de P2 é menor ou igual ao topo de P3
                } else if (P2.topo != null && (P3.topo == null || P2.topo.valor <= P3.topo.valor)) {
                    disco_movido = P2.desempilhar();
                    P3.empilhar(disco_movido);
                
                // Movendo discos de P2 para P1 e de P3 para P2 se o topo de P2 é maior que o topo de P3
                } else if (P2.topo != null && (P2.topo.valor > P3.topo.valor)) {
                    disco_movido = P2.desempilhar();
                    P1.empilhar(disco_movido);
                    disco_movido = P3.desempilhar();
                    P2.empilhar(disco_movido);   
                }
                
                // Os dois blocos de condicionais abaixo tratam de casos em que é mais complexo decidir para onde mover o disco
                // Eles tomam decisões com base no valor mais alto entre P1, P2 e P3
                else if (P1.topo.valor > P2.topo.valor && P1.topo.valor > P3.topo.valor) {

                    // Se o topo da pilha P2 é maior que o topo da pilha P3
                    if (P2.topo.valor > P3.topo.valor) {
                        // Então movemos o disco do topo de P3 para o topo de P2
                        disco_movido = P3.desempilhar();
                        P2.empilhar(disco_movido);

                    } else {
                        // Senão, movemos o disco do topo de P2 para o topo de P3
                        disco_movido = P2.desempilhar();
                        P3.empilhar(disco_movido);
                        
                    }
                    
                } else if (P2.topo.valor > P3.topo.valor && P2.topo.valor > P1.topo.valor) {

                    // Se o topo da pilha P1 é maior que o topo da pilha P3
                    if (P1.topo.valor > P3.topo.valor) {
                        // Então movemos o disco do topo de P3 para o topo de P1
                        disco_movido = P3.desempilhar();
                        P1.empilhar(disco_movido);

                    } else {
                        // Senão, movemos o disco do topo de P1 para o topo de P3
                        disco_movido = P1.desempilhar();
                        P3.empilhar(disco_movido);
                        
                    }
                }
            }
            
            
        } else {
            // A lógica aqui é semelhante ao bloco anterior, mas os discos são movidos em ordem decrescente

            while (P3.tamanho < quantidade) {

                // Verifica se um disco pode ser movido de P1 para P3
                if (P1.topo != null && (P3.topo == null || P1.topo.valor >= P3.topo.valor)) {
                    disco_movido = P1.desempilhar();
                    P3.empilhar(disco_movido);
                    
                // Move o disco de P1 para P2 e, em seguida, de P3 para P1 para abrir espaço para um disco maior em P3
                } else if (P1.topo != null && (P3.topo.valor > P1.topo.valor)) {
                    disco_movido = P1.desempilhar();
                    P2.empilhar(disco_movido);
                    disco_movido = P3.desempilhar();
                    P1.empilhar(disco_movido);
                    
                // Verifica se um disco pode ser movido de P2 para P3
                } else if (P2.topo != null && (P3.topo == null || P2.topo.valor >= P3.topo.valor)) {
                    disco_movido = P2.desempilhar();
                    P3.empilhar(disco_movido);
                 
                // Move o disco de P2 para P1 e, em seguida, de P3 para P2 para abrir espaço para um disco maior em P3
                } else if (P2.topo != null && (P2.topo.valor < P3.topo.valor)) {
                    disco_movido = P2.desempilhar();
                    P1.empilhar(disco_movido);
                    disco_movido = P3.desempilhar();
                    P2.empilhar(disco_movido);
                    
                }
                
                // Casos especiais onde o disco no topo da P1 é maior que os discos nos topos das outras duas pilhas
                else if (P1.topo.valor > P2.topo.valor && P1.topo.valor > P3.topo.valor) {

                    // Se o disco no topo de P2 é maior que o disco no topo de P3
                    if (P2.topo.valor > P3.topo.valor) {
                        // Move o disco menor do topo de P3 para o topo de P2
                        disco_movido = P3.desempilhar();
                        P2.empilhar(disco_movido);

                    } else {
                        // Move o disco menor do topo de P2 para o topo de P3
                        disco_movido = P2.desempilhar();
                        P3.empilhar(disco_movido);
                        
                    }
                 
                // Casos especiais onde o disco no topo da P2 é maior que os discos nos topos das outras duas pilhas (P1 e P3)
                } else if (P2.topo.valor < P3.topo.valor && P2.topo.valor < P1.topo.valor) {
                    
                    // Se o disco no topo de P1 é maior que o disco no topo de P3
                    if (P1.topo.valor < P3.topo.valor) {
                        // Move o disco menor do topo de P3 para o topo de P1
                        disco_movido = P3.desempilhar();
                        P1.empilhar(disco_movido);
                        
                    } else {
                        // Move o disco menor do topo de P1 para o topo de P3
                        disco_movido = P1.desempilhar();
                        P3.empilhar(disco_movido);
                    }
                }
            }
        }
        
        // Se a pilha P3 contém todos os discos, o jogo foi resolvido
        if (P3.tamanho == quantidade) {
            P3.exibir();
            return;
        }
    }

    
    public static void main(String[] args) {

        int jogadas_numero = 0;
        boolean continuar = true;

        Scanner sc = new Scanner(System.in);

        Pilha Pilha_1 = new Pilha("Pilha_1");
        Pilha Pilha_2 = new Pilha("Pilha_2");
        Pilha Pilha_3 = new Pilha("Pilha_3");

        Pilha[] Pilhas = new Pilha[3];

        // Array para armazenar as pilhas e facilitar o acesso a elas
        Pilhas[0] = Pilha_1;
        Pilhas[1] = Pilha_2;
        Pilhas[2] = Pilha_3;
        

        System.out.println("\nCOMECANDO");

        System.out.println("\nEscolha:\n1 - Ordem Crescende\n2 - Ordem Decrescente");

        Integer escolha = sc.nextInt();

        System.out.println("\nEscolha a Quantidade de Discos:");

        Integer discos_quantidade = sc.nextInt();
        
        
        // Preenche a Pilha_1 com discos de valores aleatórios
        for (int i = 0; i < discos_quantidade; i++) {

            Node disco_novo = new Node();
            Random random = new Random();

            int valor_aleatorio = random.nextInt(100) + 1;

            disco_novo.setValor(valor_aleatorio);
            Pilha_1.empilhar(disco_novo);
        }

        while (continuar) {

            System.out.println("\nDigite:\n0 - SAIR\n1 - JOGAR\n2 - Resolver Automaticamente");

            Integer decisao = sc.nextInt();

            
            // Exibe o estado atual das pilhas
            Pilha_1.exibir();

            Pilha_2.exibir();

            Pilha_3.exibir();
            

            switch (decisao) {

                case 0:
                    System.out.println("\nSAINDO...");
                    continuar = false;
                    break;

                case 1:
                    System.out.println("\nEscolha da ORIGEM: Pilha_1 (1), Pilha_2 (2), Pilha_3 (3)");
                    Integer desempilhar = sc.nextInt();

                    System.out.println("\nEscolha do DESTINO: Pilha_1 (1), Pilha_2 (2), Pilha_3 (3)");
                    Integer empilhar = sc.nextInt();
                       
                    
                    // Verifica a validade do movimento de acordo com a escolha do usuário (crescente ou decrescente)
                    // e faz o movimento se for válido
                    
                    
                    // Verifica se a pilha de destino já possui discos
                    if (Pilhas[empilhar-1].topo != null) {
                        
                        // Caso o usuário tenha escolhido ordem crescente
                        if (escolha == 1) {
                            
                            // Verifica se o movimento é válido (disco menor sobre disco maior)
                            if (Pilhas[desempilhar-1].topo.valor <= Pilhas[empilhar-1].topo.valor) {

                                // Realiza o movimento do disco
                                Node disco_movido = Pilhas[desempilhar-1].desempilhar();
                                Pilhas[empilhar-1].empilhar(disco_movido);
                                jogadas_numero += 1;

                            } else {
                                // Mensagem de erro para movimento inválido
                                System.out.println("Erro de jogada: " + Pilhas[desempilhar-1].topo.valor + " MAIOR " + Pilhas[empilhar-1].topo.valor);
                            }
                            
                        } else {
                            // Caso o usuário tenha escolhido ordem decrescente
                            
                            // Verifica se o movimento é válido (disco maior sobre disco menor)
                            if (Pilhas[desempilhar-1].topo.valor >= Pilhas[empilhar-1].topo.valor) {
                                
                                // Realiza o movimento do disco
                                Node disco_movido = Pilhas[desempilhar-1].desempilhar();
                                Pilhas[empilhar-1].empilhar(disco_movido);
                                jogadas_numero += 1;

                            } else {
                                // Mensagem de erro para movimento inválido
                                System.out.println("Erro de jogada: " + Pilhas[desempilhar-1].topo.valor + " MENOR " + Pilhas[empilhar-1].topo.valor);
                            }
                            
                        }
                        
                    } else {
                        
                        // Se a pilha de destino está vazia, o movimento é sempre válido
                        Node disco_movido = Pilhas[desempilhar-1].desempilhar();
                        Pilhas[empilhar-1].empilhar(disco_movido);
                        jogadas_numero += 1;
                    }

                    // Verifica se o jogo foi resolvido (todas as peças estão em Pilha_2 ou Pilha_3)
                    if (Pilha_2.tamanho == discos_quantidade || Pilha_3.tamanho == discos_quantidade) {

                        System.out.println("\nJogo finalizado em " + jogadas_numero + " movimentos!");
                        continuar = false;
                    }

                    break;

                case 2:
                    solucao(discos_quantidade, escolha, Pilha_1, Pilha_3, Pilha_2);
                    continuar = false;
                    break;

                default:
                    System.out.println("\nVocê digitou errado!");
                    break;
            }
        }
    }
}

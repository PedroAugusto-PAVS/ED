/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pedro
 */
public class LISTA {

    //indices da lista
    NO primeiro = null;
    NO ultimo = null;

    void inseriNoFinal(NO novoNo) {
        if (primeiro == null) {
            primeiro = novoNo;
        } else {
            ultimo.prox = novoNo;
        }
        ultimo = novoNo;
    }

    void inserir(NO novoNo) {
        if (primeiro == null) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            if (novoNo.cor == 'V') {
                inseriNoFinal(novoNo);
            } else {
                inserirPrioridade(novoNo);
            }
        }
    }

    public void inserirPrioridade(NO novoNo) {
        NO aux = primeiro;

        if (aux.cor == 'V') {
            novoNo.prox = aux; 
            primeiro = novoNo;
            return;
        }

        while (aux.prox.cor != 'V') {
            aux = aux.prox; 
        }

        novoNo.prox = aux.prox;
        aux.prox = novoNo;
    }

    public void imprimirLista() {
        NO aux = primeiro;
        System.out.print("Fila: ");
        while (aux != null) {
            System.out.print(aux.valor + "-" + aux.cor + " ");
            aux = aux.prox;
        }
        if (primeiro==null){
            System.out.println("Lista Vazia");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LISTA lista = new LISTA();

        lista.inserir(new NO(10, 'V'));
        lista.inserir(new NO(11, 'V'));
        lista.inserir(new NO(5, 'A'));
        lista.inserir(new NO(12, 'V'));
        lista.inserir(new NO(6, 'A'));

        lista.imprimirLista();
    }
}

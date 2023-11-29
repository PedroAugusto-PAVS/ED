/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 20221050100070
 */
public class LISTA {

    NO primeiro = null, ultimo = null;

    public void InserirNoFinal(NO novoNo) {
        if (primeiro == null) {
            primeiro = novoNo;
        } else {
            ultimo.prox = novoNo;
        }
        ultimo = novoNo;
    }

    public void InserirNoInicio(NO novoNo) {
        if (primeiro == null) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            novoNo.prox = primeiro;
            primeiro = novoNo;
        }
    }

    private NO obterNoNaPosicao(int posicao) {
        if (posicao < 0 || primeiro == null) {
            return null;
        }

        NO aux = primeiro;
        //pecorre a lista até chegar na posição passada.
        for (int i = 0; i < posicao; i++) {
            if (aux == null) {
                return null;
            }
            aux = aux.prox;
        }

        return aux;
    }

    public void adicionarPorPosicao(int numero, int posicao) {
        NO novoNo = new NO(numero);

        if (posicao == 0) {
            novoNo.prox = primeiro;
            primeiro = novoNo;
        } else {
            NO anterior = obterNoNaPosicao(posicao - 1);

            if (anterior == null) {
                System.out.println("Posição inválida.");
                return;
            }

            novoNo.prox = anterior.prox;
            anterior.prox = novoNo;
        }

        System.out.println("Número " + numero + " adicionado na posição " + posicao + ".");
    }

    public void removerPorPosicao(int posicao) {
        if (primeiro == null) {
            System.out.println("Lista vazia.");
            return;
        }

        if (posicao == 0) {
            NO removido = primeiro;
            primeiro = primeiro.prox;
            System.out.println("Número " + removido.num + " removido da posição " + posicao + ".");
        } else {
            NO anterior = obterNoNaPosicao(posicao - 1);

            if (anterior == null || anterior.prox == null) {
                System.out.println("Posição inválida.");
                return;
            }

            NO removido = anterior.prox;
            anterior.prox = removido.prox;
            System.out.println("Número " + removido.num + " removido da posição " + posicao + ".");
        }
    }

    public void imprimirLista() {
        System.out.println("");
        NO aux = primeiro;
        int pos = 1;
        while (aux != null) {
            System.out.println(aux.num + " ");
            pos++;
            aux = aux.prox;
        }
        if (primeiro==null){
            System.out.println("Lista Vazia");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        LISTA lista = new LISTA();

        lista.adicionarPorPosicao(10, 0);
        lista.adicionarPorPosicao(20, 1);
        lista.adicionarPorPosicao(30, 2);
        lista.imprimirLista();

        lista.removerPorPosicao(0);
        lista.imprimirLista();
    }
}

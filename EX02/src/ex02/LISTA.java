/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex02;

/**
 *
 * @author pedro
 */
public class LISTA {
   NO cabeca;

    public void adicionarItem(String nome, String categoria, double preco) {
        NO novoItem = new NO(nome, categoria, preco);
        if (cabeca == null) {
            cabeca = novoItem;
        } else {
            NO atual = cabeca;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoItem;
        }
    }

    public double valorFinalCompra() {
        NO atual = cabeca;
        double total = 0.0;
        while (atual != null) {
            total += atual.preco;
            atual = atual.proximo;
        }
        return total;
    }

    public boolean buscaItemLista(String nome) {
        NO atual = cabeca;
        while (atual != null) {
            if (atual.nome.equals(nome)) {
                return true; // Item encontrado na lista
            }
            atual = atual.proximo;
        }
        return false; // Item não encontrado na lista
    }

    public NO maiorValorItemLista() {
        if (cabeca == null) {
            return null; // Lista vazia
        }

        NO atual = cabeca;
        NO itemMaiorValor = cabeca;

        while (atual != null) {
            if (atual.preco > itemMaiorValor.preco) {
                itemMaiorValor = atual;
            }
            atual = atual.proximo;
        }

        return itemMaiorValor;
    }

    public void listaItensCategoria(String categoria) {
        NO atual = cabeca;
        boolean encontrou = false;

        while (atual != null) {
            if (atual.categoria.equals(categoria)) {
                System.out.println("Nome: " + atual.nome + ", Preço: " + atual.preco);
                encontrou = true;
            }
            atual = atual.proximo;
        }

        if (!encontrou) {
            System.out.println("Nenhum item encontrado na categoria " + categoria);
        }
    }
     public static void main(String[] args) {
        LISTA lista = new LISTA();

        lista.adicionarItem("Arroz", "Alimentos", 3.5);
        lista.adicionarItem("Sabão em Pó", "Limpeza", 5.0);
        lista.adicionarItem("Leite", "Alimentos", 2.0);
        lista.adicionarItem("Detergente", "Limpeza", 1.5);
        lista.adicionarItem("Papel Higienico", "Necessidades", 2.0);
        lista.adicionarItem("Carne", "Alimentos", 20.0);
       

        System.out.println("Valor Final da Compra: " + lista.valorFinalCompra());

        String itemProcurado = "Arroz";
        if (lista.buscaItemLista(itemProcurado)) {
            System.out.println(itemProcurado + " está na lista.");
        } else {
            System.out.println(itemProcurado + " não está na lista.");
        }

        NO maiorValor = lista.maiorValorItemLista();
        if (maiorValor != null) {
            System.out.println("Item com Maior Valor: " + maiorValor.nome);
        }

        String categoriaProcurada = "Alimentos";
        System.out.println("Itens na Categoria " + categoriaProcurada + ":");
        lista.listaItensCategoria(categoriaProcurada);
    }
}


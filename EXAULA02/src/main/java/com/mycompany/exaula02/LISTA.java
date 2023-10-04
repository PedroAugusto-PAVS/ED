/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exaula02;

/**
 *
 * @author 20221050100070
 */
public class LISTA {
    NO primeiro=null, ultimo=null;

    public void InserirNoFinal(NO novoNo){
        if(primeiro==null){
            primeiro=novoNo;
        }else{
            ultimo.prox=novoNo;
        }
        ultimo=novoNo;  
    }
    public void InserirNoInicio(NO novoNo){
    if(primeiro==null){
        primeiro=novoNo;
        ultimo=novoNo;
    }else{
        novoNo.prox=primeiro;
        primeiro=novoNo;
    }
}
    public void tamanhoLista(){
        if(primeiro==null){
            System.out.println("\nLista vazia!");
        }else{
            int cont=0;
            NO aux=primeiro;
            while(aux!=null){
                cont++;
                aux=aux.prox;
            }
            System.out.println("\nTamanho: "+cont);
        }
    }
    public void imprimirLista(){
        System.out.println("");
        NO aux=primeiro;
        int pos=1;
        while(aux!=null){
            System.out.println("Professor "+pos+":"+aux.nome);
            pos++;
            aux=aux.prox;
        }
    }
    
    public void removerUltimo(){
        if(primeiro==null || primeiro.prox==null){
            primeiro=null;
            System.out.println("\nLista Atualmente Vazia");
        }else{
            NO aux=primeiro;
            while(aux.prox.prox!=null){
                aux=aux.prox;
            }
            aux.prox=null;
            ultimo=aux;
            System.out.println("\nUltimo professor removido com sucesso!");
        }
    }
    
    public void removerPrimeiro(){
        if(primeiro!=null){
            primeiro=primeiro.prox;
            System.out.println("\nPrimeiro Professor removido com sucesso!");
        }else{
            System.out.println("\nLista Vazia!");
        }
    }
    public void informarPosicaoPorNome(String nome){
        NO aux = primeiro;
        int pos=1;
        Boolean encontrado = false;
        while(aux!=null){
            if(aux.nome.equals(nome)){
                System.out.println("\nProfessor "+nome+" na posição "+pos);
                encontrado = true;
            }
                pos++;
                aux=aux.prox; 
        }
        if(!encontrado){
            System.out.println("\nNome não existe na lista!");
        }
    }
    public void atualizarNome(String nome,String nomeNovo){
        NO aux = primeiro;
        Boolean encontrado = false;
        while(aux!=null){
            if(aux.nome.equals(nome)){
                aux.nome=nomeNovo;
                System.out.println("\nNome Atualizado!");
                encontrado = true;
            }
            aux = aux.prox;
        }
        if(!encontrado){
            System.out.println("\nNome Não encontrado na Lista!");
        }
    }
    public void acharNomePorPosicao(int posicao){
        NO aux = primeiro;
        int pos=posicao;
        for (int i = 1; i < pos ; i++) {
            if(aux!=null){
                aux=aux.prox;
            }
        }
        System.out.println("\nO nome da posição "+pos+" é "+ aux.nome);
    }
    public void acharPorLetra(char letra){
         NO aux = primeiro;
         Boolean encontrado = false;
         
         while(aux!=null){
             if(aux.nome.charAt(0) == letra){
                 System.out.println("\n"+aux.nome);
                 encontrado=true;
             }
             aux=aux.prox;
         }
         if(!encontrado){
             System.out.println("\nLista não possui professores que iniciam com a letra informada!");
         }
   
    }
    
    public static void main(String[] args) {
        LISTA lista = new LISTA();
        
        NO no1 = new NO("Lynwood");
        NO no2 = new NO("Thiane");
        NO no3 = new NO("Maurilio");
        NO no4 = new NO("Davi");
        NO no5 = new NO("Ricardo");
        NO no6 = new NO("Alessandro");
        NO no7 = new NO("Viviane");
        NO no8 = new NO("Alexandre");
        // letra a)
        lista.InserirNoInicio(no1);
        lista.InserirNoInicio(no2);
        lista.InserirNoInicio(no3);
        lista.InserirNoFinal(no4);
        lista.InserirNoFinal(no5);
        lista.InserirNoFinal(no6);
        lista.InserirNoFinal(no7);
        lista.InserirNoFinal(no8);
        // letra b)
        lista.tamanhoLista();
        //imprimindo lista inicial
        lista.imprimirLista();
        // letra c)
        lista.removerUltimo();
        // letra d)
        lista.removerPrimeiro();
        //imprimindo lista depois das remoções:
        lista.imprimirLista();
        // letra e)
        lista.informarPosicaoPorNome("Alessandro");
        // letra f)
        lista.atualizarNome("Davi", "Davi Taveira");
        // letra g)
        lista.imprimirLista();
        // letra h)
        lista.informarPosicaoPorNome("Alexandre");
        // letra i)
        lista.acharNomePorPosicao(3);
        //letra j)
        lista.acharPorLetra('D');
    }
    
}

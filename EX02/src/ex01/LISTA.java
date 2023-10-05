/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex01;

import java.awt.BorderLayout;

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
    
    public void calcularMedia() {
        NO aux = primeiro;
        int soma = 0;
        int contador = 0;
        
        if(aux==null){
            System.out.println("Lista Vazia");
        }else {
            while(aux!=null){
                soma+=aux.valor;
                contador++;
                aux=aux.prox;
            }
            if(soma>0){
                double media = soma / contador;
            System.out.println("\nMedia Aritmetica: " + media);
            }else{
                System.out.println("Não foi possivel realizar o calculo da media");
            } 
        }
}
/*Antecessor e sucessor de um nó escolhido pelo usuário. Caso não exista antecessor e/ou sucessor, informar na tela 
a inexistência.NOME DO MÉTODO DEVERÁ SER antecessorSucessor.*/
    public void antecessorSucessor(int value){
        NO aux = primeiro;
        if(aux==null){
            System.out.println("Lista Vazia");
            return;
        }
        
        NO antecessor = null;
        NO sucessor = null;
        
        while(aux!=null){
            if(aux.valor==value){
                if(antecessor!=null){
                    System.out.println("\nAntecessor:"+antecessor.valor);
                }else{
                    System.out.println("\nNão Tem Antecessor");
                }
                if(aux.prox!=null){
                    System.out.println("\nSucessor:"+aux.prox.valor);
                }else{
                    System.out.println("\nNão Tem Sucessor");
                }
                return;
            }
            antecessor = aux;
            aux = aux.prox;
            if(aux!=null){
                sucessor=aux;
            }
            
            
        }
        System.out.println("NÓ não encontrado na lista");
}
  
    public static void main(String[] args) {
        LISTA lista = new LISTA();
     
        NO no1 = new NO(1);
        NO no2 = new NO(2);
        NO no3 = new NO(3);
        NO no4 = new NO(4);
        NO no5 = new NO(5);
        
        lista.InserirNoFinal(no1);
        lista.InserirNoFinal(no2);
        lista.InserirNoFinal(no3);
        lista.InserirNoFinal(no4);
        lista.InserirNoFinal(no5);
        lista.calcularMedia();
        lista.antecessorSucessor(5);
    }
    
}

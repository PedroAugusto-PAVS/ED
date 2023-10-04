/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex01;

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
    //Antecessor e sucessor de um nó escolhido pelo usuário. Caso não exista antecessor e/ou sucessor, informar na tela a inexistência.NOME DO MÉTODO DEVERÁ SER antecessorSucessor
    public static void main(String[] args) {
        LISTA lista = new LISTA();
        
        NO no1 = new NO(10);
        NO no2 = new NO(8);
        
        lista.InserirNoFinal(no1);
        lista.InserirNoFinal(no2);
        lista.calcularMedia();
    }
    
}

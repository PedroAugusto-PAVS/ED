/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex03;

/**
 *
 * @author pedro
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NO {
    String nomeDespesa;
    double valorDespesa;
    Date prazoEncerramento;
    int situacao; // 0 para pago, 1 para não pago
    NO proximo=null;

    public NO(String nomeDespesa, double valorDespesa, String prazoEncerramento, int situacao) {
        this.nomeDespesa = nomeDespesa;
        this.valorDespesa = valorDespesa;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.prazoEncerramento = dateFormat.parse(prazoEncerramento);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.situacao = situacao;
    }
}

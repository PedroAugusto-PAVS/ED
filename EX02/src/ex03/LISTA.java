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

public class LISTA {
    private NO cabeca;

    public void adicionarBoleto(String nomeDespesa, double valorDespesa, String prazoEncerramento, int situacao) {
        NO novoBoleto = new NO(nomeDespesa, valorDespesa, prazoEncerramento, situacao);
        if (cabeca == null) {
            cabeca = novoBoleto;
        } else {
            NO atual = cabeca;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoBoleto;
        }
    }

    public double calcularDespesasCadastradasAteData(String dataLimite) {
        NO atual = cabeca;
        double totalDespesas = 0.0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataLimiteDate = null;
        try {
            dataLimiteDate = dateFormat.parse(dataLimite);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0.0;
        }
        while (atual != null) {
            if (atual.prazoEncerramento.before(dataLimiteDate) || atual.prazoEncerramento.equals(dataLimiteDate)) {
                totalDespesas += atual.valorDespesa;
            }
            atual = atual.proximo;
        }
        return totalDespesas;
    }

    public double calcularDespesasPagasAteData(String dataLimite) {
        NO atual = cabeca;
        double totalDespesasPagas = 0.0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataLimiteDate = null;
        try {
            dataLimiteDate = dateFormat.parse(dataLimite);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0.0;
        }
        while (atual != null) {
            if (atual.situacao == 0 && (atual.prazoEncerramento.before(dataLimiteDate) || atual.prazoEncerramento.equals(dataLimiteDate))) {
                totalDespesasPagas += atual.valorDespesa;
            }
            atual = atual.proximo;
        }
        return totalDespesasPagas;
    }

    public int calcularTotalDespesasCadastradas() {
        NO atual = cabeca;
        int total = 0;
        while (atual != null) {
            total++;
            atual = atual.proximo;
        }
        return total;
    }

    public NO despesaNaoPagaProximaData(String dataLimite) {
        NO atual = cabeca;
        NO despesaProxima = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataLimiteDate = null;
        try {
            dataLimiteDate = dateFormat.parse(dataLimite);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        while (atual != null) {
            if (atual.situacao == 1 && (atual.prazoEncerramento.after(dataLimiteDate) || atual.prazoEncerramento.equals(dataLimiteDate))) {
                if (despesaProxima == null || atual.prazoEncerramento.before(despesaProxima.prazoEncerramento)) {
                    despesaProxima = atual;
                }
            }
            atual = atual.proximo;
        }
        return despesaProxima;
    }
    public static void main(String[] args) {
        LISTA lista = new LISTA();

        // Adicionar boletos
        lista.adicionarBoleto("Conta de Luz", 100.0, "10/11/2023", 0);
        lista.adicionarBoleto("Aluguel", 1500.0, "30/10/2023", 1);
        lista.adicionarBoleto("Supermercado", 200.0, "25/10/2023", 0);
        lista.adicionarBoleto("Internet", 80.0, "15/11/2023", 1);

        // Calcular despesas cadastradas até uma determinada data
        String dataLimiteCadastradas = "31/10/2023";
        double despesasCadastradas = lista.calcularDespesasCadastradasAteData(dataLimiteCadastradas);
        System.out.println("Despesas cadastradas até " + dataLimiteCadastradas + ": R$" + despesasCadastradas);

        // Calcular despesas pagas até uma determinada data
        String dataLimitePagas = "31/10/2023";
        double despesasPagas = lista.calcularDespesasPagasAteData(dataLimitePagas);
        System.out.println("Despesas pagas até " + dataLimitePagas + ": R$" + despesasPagas);

        // Calcular o total de despesas cadastradas
        int totalDespesas = lista.calcularTotalDespesasCadastradas();
        System.out.println("Total de despesas cadastradas: " + totalDespesas);

        // Encontrar a despesa não paga mais próxima de uma determinada data
        String dataLimiteProximaNaoPaga = "01/11/2023";
        NO despesaNaoPagaProxima = lista.despesaNaoPagaProximaData(dataLimiteProximaNaoPaga);
        if (despesaNaoPagaProxima != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String prazoEncerramento = dateFormat.format(despesaNaoPagaProxima.prazoEncerramento);
            System.out.println("Despesa não paga mais próxima de " + dataLimiteProximaNaoPaga + ": " + despesaNaoPagaProxima.nomeDespesa + " (Prazo: " + prazoEncerramento + ")");
        } else {
            System.out.println("Nenhuma despesa não paga encontrada próxima de " + dataLimiteProximaNaoPaga);
        }
    }
}


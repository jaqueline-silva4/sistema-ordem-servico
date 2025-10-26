package SistemaOS;

import java.time.YearMonth;
import java.util.List; //import para armazenar coleções ordenadas de elementos 

public class Relatorio {

    private static int contador = 1;
    private int id;
    private String periodo;
    private YearMonth mesAno;

    public Relatorio(String periodo, YearMonth mesAno) {
        this.id = contador++;
        setPeriodo(periodo);
        setMesAno(mesAno);
    }

    public int getId() {
        return id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        if (periodo == null || periodo.isEmpty()) {
            throw new IllegalArgumentException("Período inválido!");
        }
        this.periodo = periodo;
    }

    public YearMonth getMesAno() {
        return mesAno;
    }

    public void setMesAno(YearMonth mesAno) {
        if (mesAno == null) {
            throw new IllegalArgumentException("Mês/ano não podem ser nulos.");
        }
        if (mesAno.isAfter(YearMonth.now())) {
            throw new IllegalArgumentException("Mês/ano não podem ser no futuro.");
        }
        this.mesAno = mesAno;
    }

    // Método simples de geração de relatório
    public void gerarRelatorioMensal(List<OrdemServico> ordensServicos) {
        int pendentes = 0, encaminhados = 0, concluidos = 0, cancelados = 0;

        for (OrdemServico os : ordensServicos) {
            if (os.getServico() == null) continue;

            for (Servico servico : os.getServico()) {

                YearMonth encerramentoMes = null;
                if (servico.getDataEncerramento() != null) {
                    encerramentoMes = YearMonth.from(servico.getDataEncerramento());
                }

                // Conta se o serviço foi encerrado ou está ativo neste mês
                if (encerramentoMes == null || encerramentoMes.equals(this.mesAno)) {
                    switch (servico.getStatus()) {
                        case PENDENTE -> pendentes++;
                        case ENCAMINHADO -> encaminhados++;
                        case CONCLUIDO -> concluidos++;
                        case CANCELADO -> cancelados++;
                    }
                }
            }
        }

        System.out.println("---------- RELATÓRIO MENSAL ----------");
        System.out.println("ID: " + id);
        System.out.println("Período: " + periodo + " (" + mesAno + ")");
        System.out.println("--------------------------------------");
        System.out.println("Pendentes:   " + pendentes);
        System.out.println("Encaminhados:" + encaminhados);
        System.out.println("Concluídos:  " + concluidos);
        System.out.println("Cancelados:  " + cancelados);
        System.out.println("--------------------------------------");
    }

}

package SistemaOS;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Criar contatos do cliente
        Contato contato1 = new Contato("Celular", "85", "99999-1111");
        Contato contato2 = new Contato("Residencial", "85", "3333-4444");
        Contato contato3 = new Contato("Residencial", "85", "2222-4444");
        
        //
        ArrayList<Contato> listaContatos = new ArrayList<>();
        listaContatos.add(contato1);
        listaContatos.add(contato2);
        ArrayList<Contato> listaContatos2 = new ArrayList<>();
        listaContatos2.add(contato3);

        // Criar cliente
        Cliente cliente1 = new Cliente("Mariana Rafaela", "mariana@gmail.com", listaContatos);
        Cliente cliente2 = new Cliente("Jaqueline Miranda", "jaqueline@gmail.com", listaContatos2);
        
        // Registrar clientes
        cliente1.registrar();
        cliente2.registrar();

        // Criar equipamentos
        Equipamento equipamento1 = new Equipamento("Notebook", "Dell XPS", "Notebook corporativo");
        Equipamento equipamento2 = new Equipamento("Impressora", "HP LaserJet", "Impressora a laser");

        // Criar técnicos
        Tecnico tecnico1 = new Tecnico("João Silva", "Manutenção");
        Tecnico tecnico2 = new Tecnico("Ana Souza", "Redes");
        
        // Registrar técnicos
        tecnico1.registrar();
        tecnico2.registrar();

        // Criar ordem de serviço 
        OrdemServico ordem1 = new OrdemServico("Alta", LocalDate.of(2025, 10, 20), cliente1);
        
        // Registrar ordem de serviço
        ordem1.registrar();

        // Criar serviços
        Servico servico1 = new Servico(150.0, "Troca de HD", Servico.StatusAtual.PENDENTE, LocalDate.of(2025, 10, 16), ordem1);
        Servico servico2 = new Servico(200.0, "Instalação de software", Servico.StatusAtual.ENCAMINHADO, LocalDate.of(2025, 10, 17), ordem1);

        // Atualiza o status e a data automaticamente
        servico2.atualizarStatus(Servico.StatusAtual.CONCLUIDO);
        //servico2.setDataEncerramento(LocalDate.of(2025, 10, 18));
        
        // Adicionar serviços à ordem
        ordem1.adicionarServico(servico1);
        ordem1.adicionarServico(servico2);

        // Criar OSTecnico (associação técnico-ordem) 
        OSTecnico osTec1 = new OSTecnico(ordem1, tecnico1);
        OSTecnico osTec2 = new OSTecnico(ordem1, tecnico2);

        ordem1.adicionarOSTecnico(osTec1);
        ordem1.adicionarOSTecnico(osTec2);

        // Criar OSEquipamento (associação equipamento-ordem)
        OSEquipamento osEq1 = new OSEquipamento(ordem1, equipamento1);
        OSEquipamento osEq2 = new OSEquipamento(ordem1, equipamento2);

        ordem1.adicionarOSEquipamento(osEq1);
        ordem1.adicionarOSEquipamento(osEq2);

        // Associar ordem ao cliente
        cliente1.adicionarOrdemServico(ordem1);

        // Criar avaliação para um serviço 
        Avaliacao avaliacao1 = new Avaliacao(10, "Serviço excelente!");
        servico1.setAvaliacao(avaliacao1);
        cliente1.adicionarAvaliacao(avaliacao1);
        
        // Exibir informações 
        
        tecnico1.listarDados();
        
        tecnico2.listarDados();
        
        equipamento1.listarDados();
        
        equipamento2.listarDados();
        
        cliente1.listarDados();
        
        cliente2.listarDados();

        ordem1.listarDados();
        
        servico1.listarDados();
        
        servico2.listarDados();

        // Criar e gerar relatório 
        Relatorio relatorio = new Relatorio("Outubro/2025", YearMonth.of(2025, 10));
        ArrayList<OrdemServico> listaOrdens = new ArrayList<>();
        listaOrdens.add(ordem1);

        System.out.println("\n=== Relatório Mensal ===");
        relatorio.gerarRelatorioMensal(listaOrdens);

    }
}

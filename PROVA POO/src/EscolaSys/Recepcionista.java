/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EscolaSys;

import javax.swing.JOptionPane;

/**
 *
 * @author 1171139648
 */
public class Recepcionista extends Pessoa{
    
    protected double salario_recep = 1300;
    protected String departamento; // Departamento ao qual ela atende: se é para cursos ou chamados com diretores, professores...
    protected boolean validar_dep;
    private boolean cadastrada = false;
    
    private double Calculo_salario()
    {
        double inss = 0.08; // Valor do Inss para esta faixa salarial (pra ser sincero não me recordo se são exatamente 8%, mas com base no meu salário calculei que sim)
        double salario_real =  salario_recep - (salario_recep * inss);
        return salario_real;
    }
    
    public void Cadastrar_Recepcionista()
    {
        super.cadastrarPessoa();
        
        departamento = JOptionPane.showInputDialog("Departamento da Recepcionista");
        validar_dep = validarNumero(departamento);
        
        while(departamento.length() < 2 || validar_dep == true)
        {
            JOptionPane.showMessageDialog(null, "Entradada de departamento inválida");
            departamento = JOptionPane.showInputDialog("Departamento da Recepcionista");
            validar_dep = validarNumero(departamento);
        }
        
        JOptionPane.showMessageDialog(null,"Recepcionista cadastrada com sucesso");
        cadastrada = true;
    }
    
    public void Exibir_Recepcionista()
    {
      if(cadastrada == true)
      {
           String mensagem_titulo = "Recepcionista Cadastrada";
            String mensagem_corpo = super.exibirPessoa()
            +"<br><strong>Departamento Recepcionista: </strong>"+departamento
            +"<br><strong>Salário Líquido: </strong> R$"+salario_recep
            +"<br><strong>Salário Real: </strong> R$"+this.Calculo_salario()
            +"</font>";
            ShowPainel(mensagem_corpo, mensagem_titulo);
      }
      else
      {
          JOptionPane.showMessageDialog(null, "Recepcionista não cadastrada aidna");
      }
    }
    
}

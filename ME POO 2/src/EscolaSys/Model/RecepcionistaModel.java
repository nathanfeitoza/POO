/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EscolaSys.Model;

import EscolaSys.View.RecepcionistaView;

/**
 *
 * @author 1171139648
 */
public class RecepcionistaModel extends Pessoa{
    
    protected double salario_recep = 1300;
    protected String departamento; // Departamento ao qual ela atende: se é para cursos ou chamados com diretores, professores...
    protected boolean validar_dep;
    
    public void setDepartamento(String departamento)
    {
        this.departamento = departamento;
    }
    public String getDepartamento()
    {
        return this.departamento;
    }
    
    private double Calculo_salario()
    {
        double inss = 0.08; // Valor do Inss para esta faixa salarial (pra ser sincero não me recordo se são exatamente 8%, mas com base no meu salário calculei que sim)
        double salario_real =  salario_recep - (salario_recep * inss);
        return salario_real;
    }
    
    public void Cadastrar_Recepcionista(String pessoa) throws Exception
    {
        departamento = this.getDepartamento();
        validar_dep = validarNumero(departamento);
        
        if(departamento.length() < 2 || validar_dep == true)
        {
            throw new Exception("Entradada de departamento inválida");
        }
        
        String add_recep = pessoa
        +"<br><strong>Departamento Recepcionista: </strong>"+departamento
        +"<br><strong>Salário Líquido: </strong> R$"+salario_recep
        +"<br><strong>Salário Real: </strong> R$"+this.Calculo_salario()
        +"</font>";
        
                try
        {
            
            new RecepcionistaView().SalvarRecep(add_recep);
        } catch(Exception e)
        {
            throw new Exception(e.getMessage());
        }
        
    }
    
    
}

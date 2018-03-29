/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EscolaSys.Model;

import EscolaSys.View.ProfessorView;
/**
 *
 * @author 1171139648
 */
public class ProfessorModel extends Pessoa{
    
    protected String lattes;
    protected String email;
    protected String formacao;
    protected String especialidade;
    protected String tipo_entrada;
    protected int tipo;
    protected boolean validar_lattes, validar_email, validar_formacao, validar_especialidade, validar_tipo;
    public double salario_professor;
    
    public void setLattes(String lattes)
    {
        this.lattes = lattes;
    }
    public String getLattes()
    {
        return this.lattes;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getEmail()
    {
        return this.email;
    }
    public void setFormacao(String formacao)
    {
        this.formacao = formacao;
    }
    public String getFormacao()
    {
        return this.formacao;
    }
    public void setEspecialidade(String especialidade)
    {
        this.especialidade = especialidade;
    }
    public String getEspecialidade()
    {
        return this.especialidade;
    }
    public void setTipo(String tipo)
    {
        this.tipo_entrada = tipo;
    }
    public String getTipo()
    {
        return this.tipo_entrada;
    }
    
    public double calcularSalario(int tipo)
    {
        switch (tipo){
            case 1:
                salario_professor = 3200;
                break;
            case 2:
                salario_professor = 5000;
                break;
            case 3: 
                salario_professor = 7000;
                break;
            default:
                salario_professor = 0;
                break;
        }

        return salario_professor;
    }
    
    public void cadastrarProfessor(String pessoa) throws Exception
    {
        
        
        lattes = this.getLattes();
        validar_lattes = validarNumero(lattes);
        
        if(lattes.length() < 2 || validar_lattes == true)
        {
            throw new Exception("Lattes do professor é inválido");
        }
        
        email = this.getEmail();
        validar_email = validarNumero(email);
        boolean validar_tipoEmail = validarEmail(email);
        
        if(email.length() < 2 || validar_email == true || validar_tipoEmail == false)
        {
            throw new Exception("Email Inválido");
        }
        
        formacao = this.getFormacao();
        validar_formacao = validarNumero(formacao);
        
        if(formacao.length() < 2 || validar_formacao == true)
        {
            throw new Exception("Formação Inválida");
           
        }
        
        especialidade = this.getEspecialidade();
        validar_especialidade = validarNumero(especialidade);
        
        while(especialidade.length() < 2 || validar_especialidade == true)
        {
            throw new Exception("Especialidade Inválida");
            
        }
        
        tipo_entrada = this.getTipo();
        validar_tipo = validarNumero(tipo_entrada);
        
        boolean verificar_valid = (validar_tipo == false) ? false : Integer.parseInt(tipo_entrada) <= 3;
        
        if(tipo_entrada.length() != 0 && verificar_valid == false)
        {
            throw new Exception("Nível do professor inválido");
            
        }
        
        tipo = Integer.parseInt(tipo_entrada);
        
        double salario_prof = calcularSalario(tipo);
        String salario_prof_save = ""+salario_prof;
        
        String add_prof = pessoa
            +"<br><strong>Lattes do Professor: </strong>"+lattes
            +"<br><strong>Email do Professor: </strong>"+email
            +"<br><strong>Formação do Professor: </strong>"+formacao
            +"<br><strong>Especialidade do Professor: </strong>"+especialidade
            +"<br><strong>Tipo Professor: </strong>"+tipo
            +"<br><strong>Salário Professor: </strong>"+salario_prof
            +"</font>";
        try
        {
            new ProfessorView().SalvarProfessor(add_prof, salario_prof_save);
        } catch(Exception e)
        {
            throw new Exception(e.getMessage());
        }
        
    }
    
    
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EscolaSys;

import java.util.*;
import javax.swing.*;
import java.lang.*;
/**
 *
 * @author 1171139648
 */
public class Professor extends Pessoa{
    
    protected String lattes;
    protected String email;
    protected String formacao;
    protected String especialidade;
    protected String tipo_entrada;
    protected int tipo;
    protected boolean validar_lattes, validar_email, validar_formacao, validar_especialidade, validar_tipo;
    protected int cadastrado = 0;
    public double salario_professor;
    
    public void cadastrarProfessor()
    {
        super.cadastrarPessoa();
        
        lattes = JOptionPane.showInputDialog("Lattes do Professor");
        validar_lattes = validarNumero(lattes);
        
        while(lattes.length() < 2 || validar_lattes == true)
        {
            JOptionPane.showMessageDialog(null, "Lattes Inválido");
            lattes = JOptionPane.showInputDialog("Lattes do Professor");
            validar_lattes = validarNumero(lattes);
        }
        
        email = JOptionPane.showInputDialog("Email do Professor");
        validar_email = validarNumero(email);
        boolean validar_tipoEmail = validarEmail(email);
        
        while(email.length() < 2 || validar_email == true || validar_tipoEmail == false)
        {
            JOptionPane.showMessageDialog(null, "Email Inválido");
            email = JOptionPane.showInputDialog("Email do Professor");
            validar_email = validarNumero(email);
            validar_tipoEmail = validarEmail(email);
        }
        
        formacao = JOptionPane.showInputDialog("Formação do Professor");
        validar_formacao = validarNumero(formacao);
        
        while(formacao.length() < 2 || validar_formacao == true)
        {
            JOptionPane.showMessageDialog(null, "Formação Inválida");
            formacao = JOptionPane.showInputDialog("Formação do Professor");
            validar_formacao = validarNumero(formacao);
        }
        
        especialidade = JOptionPane.showInputDialog("Especialidade do Professor");
        validar_especialidade = validarNumero(especialidade);
        
        while(especialidade.length() < 2 || validar_especialidade == true)
        {
            JOptionPane.showMessageDialog(null, "Especialidade Inválida");
            especialidade = JOptionPane.showInputDialog("Especialidade do Professor");
            validar_especialidade = validarNumero(especialidade);
        }
        
        tipo_entrada = JOptionPane.showInputDialog("Nível do professor");
        validar_tipo = validarNumero(tipo_entrada);
        
        boolean verificar_valid = (validar_tipo == false) ? false : Integer.parseInt(tipo_entrada) <= 3;
        
        while(tipo_entrada.length() != 0 && verificar_valid == false)
        {
            JOptionPane.showMessageDialog(null, "Nível do professor inválido");
            tipo_entrada = JOptionPane.showInputDialog("Nível do professor");
            validar_tipo = validarNumero(tipo_entrada);
            verificar_valid = (validar_tipo == false) ? false : Integer.parseInt(tipo_entrada) <= 3;
        }
        
        tipo = Integer.parseInt(tipo_entrada);
        
        JOptionPane.showMessageDialog(null, "Professor Cadastrado com sucesso");
        cadastrado = 1;
        
    }
    
    public void exibirProfessor()
    {
        if(cadastrado == 1)
        {
            String mensagem_titulo = "Professor Cadastrado";
            String mensagem_corpo = super.exibirPessoa()
            +"<br><strong>Lattes do Professor: </strong>"+lattes
            +"<br><strong>Email do Professor: </strong>"+email
            +"<br><strong>Formação do Professor: </strong>"+formacao
            +"<br><strong>Especialidade do Professor: </strong>"+especialidade
            +"</font>";
            ShowPainel(mensagem_corpo, mensagem_titulo);
        
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Nenhum professor cadastrado ainda");
        }
    }
    
    public void calcularSalario()
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

        
        this.Set_SalProf(salario_professor);
    }
}

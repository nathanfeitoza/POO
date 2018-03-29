/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EscolaSys;

import java.util.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
/**
 *
 * @author 1171139648
 */
public class Pessoa extends Turma{
    
    protected String nome;
    protected String dtNasc;
    protected String cpf;
    protected String rg;
    protected String telefone; 

    protected Endereco endereco;
    
    
    public Pessoa()
    {
        endereco = new Endereco();
    }
    

    
    public void cadastrarPessoa()
    {
            nome = JOptionPane.showInputDialog("Entre com o nome: ");
            boolean validar_nome = validarNumero(nome);
            
            while(nome.length() < 2 || validar_nome == true)
            {
                JOptionPane.showMessageDialog(null, "O nome precisa ter mais de 2 caracteres");
                nome = JOptionPane.showInputDialog("Entre com o nome: ");
                validar_nome = validarNumero(nome);
            }
            
            boolean valid_data;
            
            dtNasc = JOptionPane.showInputDialog("Entre com a data de nascimento: ");
            valid_data = Validar_data(dtNasc);
            while(valid_data == false)
            {
                JOptionPane.showMessageDialog(null, "O data precisa ter de 10 caracteres - ex: 01/01/2001");    
                dtNasc = JOptionPane.showInputDialog("Entre com a data de nascimento: ");
                 valid_data = Validar_data(dtNasc);
            
            }
            
           cpf = JOptionPane.showInputDialog("Entre com o CPF: ");
           Boolean validado = validacpf(cpf);
           
            while(cpf.length() != 11 || validado == false)
           {
               JOptionPane.showMessageDialog(null, "CPF INVÁLIDO");
               cpf = JOptionPane.showInputDialog("Entre com o CPF: ");
                validado = validacpf(cpf);
               
               
           }
            
            rg = JOptionPane.showInputDialog("Entre com o RG: ");
            boolean validar_rg = validarNumero(rg);
            
            while(rg.length() < 7 || rg.length() > 12 || validar_rg == false)
            {
                JOptionPane.showMessageDialog(null,"RG Inválido");
            rg = JOptionPane.showInputDialog("Entre com o RG: ");
            validar_rg = validarNumero(rg);
            }
            
            telefone = JOptionPane.showInputDialog("Entre com o Telefone: ");
            boolean telefone_valido = validarNumero(telefone);

            while(telefone.length() < 10 || telefone_valido == false)
            {
                JOptionPane.showMessageDialog(null,"Telefone Inválido -> ddd numero_do_telefone");
            telefone = JOptionPane.showInputDialog("Entre com o Telefone: ");
            telefone_valido = validarNumero(telefone);
            }

            endereco.CadastrarEndereco();
            
    }
    
    public String exibirPessoa()
    {
        String dados =  "<font face='Arial'><strong>Nome:</strong> "+nome + "<br><strong>Data de Nascimento:</strong> "
                + dtNasc+"<br>"+endereco.exibirEndereco()+"<br><strong>RG:</strong> "+rg
                +"<br><strong>CPF:</strong> "+cpf+"<br><strong>Telefone:</strong> " +telefone;
        
        return dados;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EscolaSys.Model;

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
    
    public void cadastrarPessoa(String nome, String dtNasc, String cpf, String rg, String telefone,
            String[] endereco) throws Exception
    {
            this.nome = nome;
            boolean validar_nome = validarNumero(this.nome);
            
            if(nome.length() < 2 || validar_nome == true)
            {
                throw new Exception("Nome inválido");
            }
            
            boolean valid_data;
            
            this.dtNasc = dtNasc;
            valid_data = Validar_data(this.dtNasc);
            if(valid_data == false)
            {
                throw new Exception("Data Inválida");
            
            }
            
           this.cpf = cpf;
           Boolean validado = validacpf(this.cpf);
           
            if(this.cpf.length() != 11 || validado == false)
           {
               throw new Exception("CPF Inválido");
                    
           }
            
            this.rg = rg;
            boolean validar_rg = validarNumero(this.rg);
            
            if(this.rg.length() < 7 || rg.length() > 12 || validar_rg == false)
            {
                 throw new Exception("RG Inválido");
            }
            
            this.telefone = telefone;
            boolean telefone_valido = validarNumero(this.telefone);

            if(this.telefone.length() < 10 || telefone_valido == false)
            {
                throw new Exception("Telefone inválido");
            }

           this.endereco.CadastrarEndereco(endereco[0],endereco[1],endereco[2],
                   endereco[3],endereco[4],endereco[5],endereco[6]);
            
    }
    
    public String exibirPessoa()
    {
        String dados =  "<font face='Arial'><strong>Nome:</strong> "+nome + "<br><strong>Data de Nascimento:</strong> "
                + dtNasc+"<br>"+this.endereco.exibirEndereco()+"<br><strong>RG:</strong> "+rg
                +"<br><strong>CPF:</strong> "+cpf+"<br><strong>Telefone:</strong> " +telefone;
        
        return dados;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EscolaSys.Model;

import java.util.*;
import javax.swing.*;
import java.lang.*;

/**
 *
 * @author 1171139648
 */
public class Endereco extends Validacoes{
    
    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;
    private String bairro;
    private String cidade;
    private String uf;

    
    public void CadastrarEndereco(String logradouro, String numero, String complemento, String cep, 
            String bairro, String cidade, String uf) throws Exception
    {
        
            this.logradouro = logradouro;
            boolean validar_logra = validarNumero(logradouro);
            
            if(logradouro.length() < 1 || validar_logra == true)
            {
                throw new Exception("O endereço precisa ter mais de 1 caractere");
            }
            
            this.numero = numero;
            boolean validar_numero = validarNumero(numero);
            
            if(numero.length() < 1 || validar_numero == false)
            {
                throw new Exception("Número Inválido");
                
            }
            
            this.complemento = complemento;
            boolean validar_complemento = validarNumero(complemento);
            
            if(complemento.length() < 1 || validar_complemento == true)
            {
                throw new Exception("Complemento Inválido");
            }
            
            this.cep = cep;
             boolean validar_cep = validarNumero(cep);
            
             if(cep.length() < 8 || validar_cep == false)
             {
                 throw new Exception("CEP Inválido");
             }
            
            this.bairro = bairro;
            boolean validar_bairro = validarNumero(bairro);
            
            if(bairro.length() < 1 || validar_bairro == true)
            {
                throw new Exception("Bairro Inválido");
            }
            
            this.cidade = cidade;
            boolean validar_cidade = validarNumero(cidade);
            
            if(cidade.length() < 2 || validar_cidade == true)
            {
                throw new Exception("Cidade Inválida");
            }
            
            this.uf = uf;
            boolean validar_uf = validarNumero(uf);
            
            if(uf.length() != 2 || validar_uf == true)
            {
                throw new Exception("UF Inválido");
            }
            
            this.uf = this.uf.toUpperCase();
    }
    
    public String exibirEndereco()
    {
        String dados = "<strong>Endereço:</strong> "+logradouro+"<br><strong>Número:</strong> "+numero+"<br><strong>Complemento:</strong> "+complemento 
                + "<br><strong>CEP:</strong> "+cep+"<br><strong>Bairro:</strong> "+bairro+"<br><strong>Cidade:</strong> "+cidade+"<br><strong>Estado:</strong> "+uf;
        return dados;
    }
}

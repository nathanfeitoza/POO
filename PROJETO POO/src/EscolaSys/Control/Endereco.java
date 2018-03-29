/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EscolaSys.Control;

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

    
    public void CadastrarEndereco()
    {
        
            logradouro = JOptionPane.showInputDialog("Entre com o Endereço: ");
            boolean validar_logra = validarNumero(logradouro);
            
            while(logradouro.length() < 1 || validar_logra == true)
            {
                JOptionPane.showMessageDialog(null, "O endereço precisa ter mais de 1 caractere");
                logradouro = JOptionPane.showInputDialog("Entre com o Endereço: ");
                validar_logra = validarNumero(logradouro);
            }
            
            numero = JOptionPane.showInputDialog("Entre com o Número: ");
            boolean validar_numero = validarNumero(numero);
            
            while(numero.length() < 1 || validar_numero == false)
            {
                JOptionPane.showMessageDialog(null, "Número Inválido");
                numero = JOptionPane.showInputDialog("Entre com o Número: ");
                validar_numero = validarNumero(numero);
            }
            
            complemento = JOptionPane.showInputDialog("Entre com o Complemento: ");
            boolean validar_complemento = validarNumero(complemento);
            
            while(complemento.length() < 1 || validar_complemento == true)
            {
                JOptionPane.showMessageDialog(null, "Complemento Inválido");
                complemento = JOptionPane.showInputDialog("Entre com o Número: ");
                validar_complemento = validarNumero(complemento);
            }
            
            cep = JOptionPane.showInputDialog("Entre com o CEP: ");
             boolean validar_cep = validarNumero(cep);
            
             while(cep.length() < 8 || validar_cep == false)
             {
                 JOptionPane.showMessageDialog(null, "CEP Inválido");
                  cep = JOptionPane.showInputDialog("Entre com o CEP: ");
                  validar_cep = validarNumero(cep);
             }
            
            bairro = JOptionPane.showInputDialog("Entre com o Bairro: ");
            boolean validar_bairro = validarNumero(bairro);
            
            while(bairro.length() < 1 || validar_bairro == true)
            {
                JOptionPane.showMessageDialog(null, "Bairro Inválido");
                bairro = JOptionPane.showInputDialog("Entre com o Bairro: ");
                validar_bairro = validarNumero(bairro);
            }
            
            cidade = JOptionPane.showInputDialog("Entre com o Cidade: ");
            boolean validar_cidade = validarNumero(cidade);
            
            while(cidade.length() < 2 || validar_cidade == true)
            {
                JOptionPane.showMessageDialog(null, "Cidade Inválida");
                cidade = JOptionPane.showInputDialog("Entre com o Cidade: ");
                validar_cidade = validarNumero(cidade);
            }
            
            uf = JOptionPane.showInputDialog("Entre com seu UF: ");
            boolean validar_uf = validarNumero(uf);
            
            while(uf.length() != 2 || validar_uf == true)
            {
               JOptionPane.showMessageDialog(null, "UF Inválido");
               uf = JOptionPane.showInputDialog("Entre com seu UF: "); 
               validar_uf = validarNumero(uf);
            }
            
            uf = uf.toUpperCase();
    }
    
    public String exibirEndereco()
    {
        String dados = "<strong>Endereço:</strong> "+logradouro+"<br><strong>Número:</strong> "+numero+"<br><strong>Complemento:</strong> "+complemento 
                + "<br><strong>CEP:</strong> "+cep+"<br><strong>Bairro:</strong> "+bairro+"<br><strong>Cidade:</strong> "+cidade+"<br><strong>Estado:</strong> "+uf;
        return dados;
    }
}

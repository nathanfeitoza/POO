/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EscolaSys.Model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.awt.Dimension;
import java.math.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.*;
import javax.swing.*;

/**
 *
 * @author natha
 */
public class Validacoes {
   
  private static final String EMAIL_PATTERN = 
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
  int qntd_alunos;
  
  protected BancoDeDados bd;
    
    public Validacoes()
    {
        bd = new BancoDeDados();
    }
  
private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
    

    public boolean Validar_data(String data)
    {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        
        try{
           df.parse(data);   
            return true;
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            return false;
        }
    }

    public boolean validarNumero(String num)
    {
        boolean num_valido = true;
        try{
             Long.parseLong(num);
        }catch(NumberFormatException e){
            num_valido = false;
        }

        return num_valido;
    }
    
    public boolean validarNumeroDecimal(String num)
    {
        boolean num_valido = true;
        try{
             BigDecimal numero_decimal = new BigDecimal(num);
             
        }catch(NumberFormatException e){
            System.out.println(e.getMessage());
            num_valido = false;
        }

        return num_valido;
    }
    
    public boolean validarValorCurso(boolean validar_valor, String valorEntrada, double custo_minimo)
    {
        boolean testar;
        if(validar_valor == false)
        {
           testar = valorEntrada.length() < 1 || validar_valor == false;
        }
        else
        {
            testar = valorEntrada.length() >= 1 && (Double.parseDouble(valorEntrada)) >= custo_minimo;
        }
        return testar;
    }
    
    public static boolean validarEmail(String email){
        Matcher matcher = pattern.matcher(email);
        System.out.println(matcher.matches());
        return matcher.matches();
    }
    
    /*Função para validar cpf*/
    public  boolean validacpf(String strCpf)
    { 
         
        boolean validado=true; 
        boolean validar_numero = validarNumero(strCpf);
        if(validar_numero == true)
        {
        BigInteger cpf_long, cpf_valid, dividir_cpf;
        int     d1, d2;   
        int     digito1, digito2, resto;   
        int     digitoCPF = 0;
        cpf_long = new BigInteger(strCpf); /*BigInteger big1 = new BigInteger("1234567856656567242177779");*/
        cpf_valid = new BigInteger("11111111111");
        dividir_cpf = cpf_long.mod(cpf_valid);
        int compare = dividir_cpf.compareTo(new BigInteger("0"));
        String  nDigResult;   
                
                if(compare != 0)
                {
                
                    try{
                d1 = d2 = 0;   
                digito1 = digito2 = resto = 0;  
                for (int nCount = 1; nCount < strCpf.length() -1; nCount++) {   
                    digitoCPF = Integer.valueOf(strCpf.substring(nCount -1, nCount)).intValue();   
                    //multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.   
                    d1 = d1 + ( 11 - nCount ) * digitoCPF;   
                    //para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.   
                    d2 = d2 + ( 12 - nCount ) * digitoCPF;   
                };   
                //Primeiro resto da divisão por 11.   
                resto = (d1 % 11);

                //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.   
                if (resto < 2)   
                    digito1 = 0;   
                else  
                    digito1 = 11 - resto;   
                d2 += 2 * digito1;   
                //Segundo resto da divisão por 11.   
                resto = (d2 % 11);   
                //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.   
                if (resto < 2)   
                    digito2 = 0;   
                else  
                    digito2 = 11 - resto;   
                //Digito verificador do CPF que está sendo validado.   
                String nDigVerific = strCpf.substring(strCpf.length()-2, strCpf.length());   
                //Concatenando o primeiro resto com o segundo.   
                nDigResult = String.valueOf(digito1) + String.valueOf(digito2);   
                //comparar o digito verificador do cpf com o primeiro resto + o segundo resto. 
                return nDigVerific.equals(nDigResult);   
            }catch (Exception e){   
                System.err.println("Erro !"+e);   
                return false;   
            }  
         } else{ return false; }
                
        }
        else
        {
            return false;
        }
    }
    
}

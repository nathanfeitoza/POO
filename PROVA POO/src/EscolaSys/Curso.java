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
public class Curso extends Validacoes{
    
    protected String nome;
    protected String cargaHorariaEntrada;
    protected int cargaHoraria;
    protected String valorEntrada;
    protected double valor;
    protected String descricao;
    
    protected int qntd_alunos;
    protected double sal_prof;
    
    protected boolean validar_nome, validar_carga, validar_valor, validar_descricao;
    
    public void valores(int qntd_aluno, double salario_professor)
    {
        this.qntd_alunos = qntd_aluno;
        this.sal_prof = salario_professor;
    }
    
    public double calcularCustoMinimo()
    {
        double c_minimo;
        double total_custos = (0.18+0.20+0.33);
        
        double total_do_curso = (sal_prof*total_custos) + sal_prof;
        
        
        if(qntd_alunos != 0)
        {
             c_minimo = total_do_curso / qntd_alunos;
        }
        else
        {
            c_minimo = 0;
        }
        
        //JOptionPane.showMessageDialog(null, c_minimo);
        
        return c_minimo;
        
    }
    
    public void cadastrarCurso()
    {
        if(this.sal_prof != 0)
        {

            nome = JOptionPane.showInputDialog("Nome do curso");
            validar_descricao = validarNumero(nome);

            while(nome.length() < 1 || validar_descricao == true)
            {
                JOptionPane.showMessageDialog(null, "Nome inválido");
                nome = JOptionPane.showInputDialog("Nome do curso");
                validar_descricao = validarNumero(nome);

            }

            cargaHorariaEntrada = JOptionPane.showInputDialog(null,"Carga Horária do curso");
            validar_carga = validarNumero(cargaHorariaEntrada);

            while(cargaHorariaEntrada.length() < 1 || validar_carga == false)
            {
                JOptionPane.showMessageDialog(null, "Carga horária inválida");
                cargaHorariaEntrada = JOptionPane.showInputDialog(null,"Carga Horária do curso");
                validar_carga = validarNumero(cargaHorariaEntrada);
            }

            cargaHoraria = Integer.parseInt(cargaHorariaEntrada);

            valorEntrada = JOptionPane.showInputDialog(null,"Valor do curso");
            validar_valor = validarNumeroDecimal(valorEntrada);
            boolean testar;
            testar = validarValorCurso(validar_valor, valorEntrada, calcularCustoMinimo());


            while(testar == false)
            {
                JOptionPane.showMessageDialog(null, "Valor não satisfaz o custo minímo de: "+calcularCustoMinimo()+" para: "+this.qntd_alunos+" aluno(s)");
                 valorEntrada = JOptionPane.showInputDialog(null,"Valor do curso");
                 validar_valor = validarNumeroDecimal(valorEntrada);
                 testar = validarValorCurso(validar_valor, valorEntrada, calcularCustoMinimo());
            }

            valor = Double.parseDouble(valorEntrada);


            descricao = JOptionPane.showInputDialog("Descrição do curso");
            validar_descricao = validarNumero(descricao);

            while(descricao.length() < 1 || validar_descricao == true)
            {
                JOptionPane.showMessageDialog(null, "Descrição Inválida");
                descricao = JOptionPane.showInputDialog("Descrição do curso");
                validar_descricao = validarNumero(descricao);
            }

            JOptionPane.showMessageDialog(null, "Curso Cadastrado com sucesso");

            }
        else
        {
            JOptionPane.showMessageDialog(null, "É necessário cadastrar um professor antes, pois precisa-se verificar o custo mínimo do curso");
        }
        
    }
    
    public void exibirCurso()
    {
        if(nome != null && descricao != null && valor != 0 && cargaHoraria != 0)
        {
            String mensagem_titulo = "Curso Cadastrado";
            String mensagem_corpo = "<font face='Arial'>"+
                "<strong>Nome do curso: </strong>"+nome
                +"<br><strong>Carga Horária: </strong>"+cargaHoraria
                +"<br><strong>Valor: </strong>"+valor
                +"<br><strong>Descrição: </strong>"+descricao
                +"</font>";
            ShowPainel(mensagem_corpo, mensagem_titulo);
        
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Nenhum curso cadastrado ainda");
        }
    }
    
    
}

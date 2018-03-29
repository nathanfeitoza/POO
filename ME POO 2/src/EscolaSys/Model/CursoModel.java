/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EscolaSys.Model;

import EscolaSys.View.CursoView;
import java.util.*;
import com.google.gson.*;
/**
 *
 * @author 1171139648
 */
public class CursoModel extends Validacoes{
    
    protected String nome;
    protected String cargaHorariaEntrada;
    protected int cargaHoraria;
    protected String valorEntrada;
    protected double valor;
    protected String descricao;
   
    
    protected boolean validar_nome, validar_carga, validar_valor, validar_descricao;
    
    protected BancoDeDados bd;
    
    public CursoModel()
    {
        bd = new BancoDeDados();
    }
    
    public double salarioProfessor() throws Exception
    {
        double salario_prof = 0.00;
        try
        {
            Gson gson = new Gson();
            JsonElement jelement = new JsonParser().parse(bd.LerDados("professor").get(0));
            JsonArray  jobject = jelement.getAsJsonArray();
            
            JsonElement salario_s = jobject.get(1);
            
            salario_prof = Double.parseDouble(salario_s.getAsString());
            
            
        } catch(Exception e)
        {
            throw new Exception("Erro ao recuperar salário do professor: "+e.getMessage());
        } 
        
        return salario_prof;     
    }
    
    protected int QntdAlunos() throws Exception
    {
        int alunos_qntd;
        alunos_qntd = 0;
        
        try
        {
            ArrayList<String> dados = bd.LerDados("aluno");
            alunos_qntd = dados.size();
        } catch(Exception e)
        {
            throw new Exception(e.getMessage());
        } 
         
        return alunos_qntd;  
          
    }
    
    public double calcularCustoMinimo() throws Exception
    {
        double c_minimo = 0;
        double total_custos = (0.18+0.20+0.33);
        try{
            int alunos_quantidade = this.QntdAlunos();
            double sal_prof = this.salarioProfessor();

            double total_do_curso = (sal_prof*total_custos) + sal_prof;


            if(alunos_quantidade != 0)
            {
                 c_minimo = total_do_curso / alunos_quantidade;
            }
            else
            {
                c_minimo = 0;
            }
        } catch (Exception e)
        {
            throw new Exception(e.getMessage());
        } 
            return c_minimo;
        
        
        
        
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    public String getNome()
    {
        return this.nome;
    }
    
    public void setCargaH(String cargaH)
    {
        this.cargaHorariaEntrada = cargaH;
    }
    public String getCargaH()
    {
        return this.cargaHorariaEntrada;
    }
    
    public void setValor(String valor)
    {
        this.valorEntrada = valor;
    }
    public String getValor()
    {
        return this.valorEntrada;
    }
    
    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }
    public String getDescricao()
    {
        return this.descricao;
    }
    
    public void cadastrarCurso() throws Exception
    {
        try{
        if(this.salarioProfessor() != 0)
        {

            nome = this.getNome();
            validar_descricao = validarNumero(nome);

            if(nome.length() < 1 || validar_descricao == true)
            {
                throw new Exception("Nome inválido");

            }

            cargaHorariaEntrada = this.getCargaH();
            validar_carga = validarNumero(cargaHorariaEntrada);

            if(cargaHorariaEntrada.length() < 1 || validar_carga == false)
            {
                throw new Exception("Carga horária inválida");
            }

            cargaHoraria = Integer.parseInt(cargaHorariaEntrada);

            valorEntrada = this.getValor();
            validar_valor = validarNumeroDecimal(valorEntrada);
            boolean testar;
            testar = validarValorCurso(validar_valor, valorEntrada, calcularCustoMinimo());


            if(testar == false)
            {
                throw new Exception("Valor não satisfaz o custo minímo de: "+calcularCustoMinimo()+" para: "+this.QntdAlunos()+" aluno(s)");
            }

            valor = Double.parseDouble(valorEntrada);


            descricao = this.getDescricao();
            validar_descricao = validarNumero(descricao);

            if(descricao.length() < 1 || validar_descricao == true)
            {
                throw new Exception("Descrição Inválida");
            }
            String add_curso = "<font face='Arial'>"+
                "<strong>Nome do curso: </strong>"+nome
                +"<br><strong>Carga Horária: </strong>"+cargaHoraria
                +"<br><strong>Valor: </strong>"+valor
                +"<br><strong>Descrição: </strong>"+descricao
                +"</font>";
            new CursoView().SalvarCurso(add_curso);
        }
        else
        {
            throw new Exception("É necessário cadastrar um professor antes, pois precisa-se verificar o custo mínimo do curso");
        }
        } catch(Exception e)
        {
            throw new Exception("Erro ao cadastrar curso: "+e.getMessage());
        }
        
    }
    

    
}

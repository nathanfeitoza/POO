/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import EscolaSys.View.CursoView;
import EscolaSys.View.ProfessorView;
import EscolaSys.View.RecepcionistaView;
import java.util.*;
import javax.swing.*;
import java.lang.*;

/**
 *54554
 * @author 1171139648
 */
public class Escola {
  
    public void RodarTelaInicial()
    {
        EscolaMain escola = new EscolaMain();
        escola.setExtendedState(6);
        escola.setVisible(true);
    }
   
   public void RodarTelaCadastroMain()
   {
       CadastrarMain cadastro = new CadastrarMain();
       cadastro.setExtendedState(6);
       cadastro.setVisible(true);
   }
    public void RodarTelaDados()
    {
        ExibirDados exibir_dados = new ExibirDados();
        exibir_dados.setExtendedState(6);
        exibir_dados.setVisible(true);
    }
    

}

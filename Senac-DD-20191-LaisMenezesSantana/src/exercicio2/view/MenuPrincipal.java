package exercicio2.view;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import exercicio2.model.vo.UsuarioVO;

public class MenuPrincipal {
	private static final int OPCAO_CADASTRO = 1;
	private static final int OPCAO_EXCLUIR = 2;
	private static final int OPCAO_LISTAR_TODOS = 3;
	private static final int OPCAO_SAIR = 4;
	
	UsuarioVO u1 = new UsuarioVO(1, "Amanda", "amanda@email.com", "123456", 1);  
	UsuarioVO u2 = new UsuarioVO(2, "Beatriz", "beatriz@email.com", "1234567", 2);
	UsuarioVO[] usuarios = {u1, u2};
	
	Scanner teclado = new Scanner(System.in);
	
	public void apresentarMenuGrafico() {
		
		String textoMenu = " Usu�rios \n"
			     + "Op��es: \n"
				 + OPCAO_CADASTRO + " - Cadastro \n"
				 + OPCAO_EXCLUIR + " - Excluir \n"
				 + OPCAO_LISTAR_TODOS + " - Listar Todos \n"
				 + OPCAO_SAIR + " - Sair \n"
                + "Digite a Op��o (somente o n�mero): ";

		String opcaoInformada = JOptionPane.showInputDialog(textoMenu);
		
		try {
			int opcao = Integer.parseInt(opcaoInformada);
			encaminharParaTelaEscolhida(opcao);
		}catch(NumberFormatException nExp) {
			JOptionPane.showMessageDialog(null, "Informe um n�mero inteiro!");
			apresentarMenuGrafico();
		}
		
	}


	private void encaminharParaTelaEscolhida(int opcao) {
		switch(opcao){
			case OPCAO_CADASTRO: {
				MenuCadastro menuCadastro = new MenuCadastro();
				menuCadastro.apresentarMenuCadastro();
				break;
			}
			case OPCAO_EXCLUIR: {
				MenuExcluir menuExcluir = new MenuExcluir();
				menuExcluir.apresentarMenuExcluirGrafico();
				break;
			}
			case OPCAO_LISTAR_TODOS: {
				MenuListarTodos menuListarTodos = new MenuListarTodos();
				menuListarTodos.apresentarMenuListarTodosGrafico(usuarios);
				break;
			}
			case OPCAO_SAIR: {
				int opcaoSelecionada = JOptionPane.showConfirmDialog(null, 
						"Tem certeza?");
				switch (opcaoSelecionada) {
					case JOptionPane.YES_OPTION:
						JOptionPane.showMessageDialog(null, "At� mais");
						break;
					case JOptionPane.NO_OPTION:
						apresentarMenuGrafico();
						break;
					case JOptionPane.CANCEL_OPTION:
						apresentarMenuGrafico();
						break;	
				}
		}
	}
		if(opcao != OPCAO_SAIR) {
			apresentarMenuGrafico();	
		}

	}
}
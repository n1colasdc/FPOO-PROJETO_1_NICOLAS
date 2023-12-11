package br.org.sesisp.view;
import javax.swing.JOptionPane;
import br.org.sesisp.dao.crudDAO;
import br.org.sesisp.model.Aluno;

public class TelaMain {

	public static void main(String[] args) {

		//instanciando o DAO
		crudDAO inserir_aluno= new crudDAO();
		
		//instanciando o aluno
		Aluno aluno_1=new Aluno();
		
		//criando a opção de menu
		String opcao;
		int op;
		do {
			opcao = JOptionPane.showInputDialog("Selecione uma opcao:"+
		"\n 1- Inserir aluno; "+"\n 2- Atualizar cadastro do aluno; "+ "\n 3- Ver lista de alunos; "+ "\n 4- deletar aluno;"+"\n 0- sair.");
			
		op=Integer.parseInt(opcao);
		switch (op) {
		
		//primeira opção do menu
		case 1:
			aluno_1.setNome(JOptionPane.showInputDialog("Digite o nome do aluno: "));
			String ida_1 = JOptionPane.showInputDialog("Digite a idade do aluno: ");
			aluno_1.setIdade(Integer.parseInt(ida_1));
			inserir_aluno.create(aluno_1);
			JOptionPane.showMessageDialog(null, "nome: "+ aluno_1.getNome()+ "\n"+ "idade: "+ aluno_1.getIdade());
			break;
			
			
		//segunda opção do menu	
		case 2:
			aluno_1.setNome(JOptionPane.showInputDialog("Digite o novo nome do aluno: "));
			String ida_2 = JOptionPane.showInputDialog("Digite a idade do aluno: ");
			aluno_1.setIdade(Integer.parseInt(ida_2));
			System.out.println("Digite o RA do aluno a ser atualizado: ");
				String RA = JOptionPane.showInputDialog("Digite o RA do aluno a ser atualizado: ");
				aluno_1.setRa(Integer.parseInt(RA));
			inserir_aluno.update(aluno_1);
			JOptionPane.showInternalMessageDialog(null, "Nome: "+aluno_1.getNome());
			JOptionPane.showInternalMessageDialog(null, "Idade: "+aluno_1.getIdade());
			
			break;
			
			
			
		//terceira opção do menu
		case 3:
			for (Aluno pr : inserir_aluno.read()) {
				JOptionPane.showMessageDialog(null,"Nome: "+ pr.getNome() + "\n"+ "Idade: "+ pr.getIdade() + "\n" +"RA: "+ pr.getRa() );
			}
			break;
			
			//quarta opção do menu
		case 4:
			crudDAO remover_aluno = new crudDAO();
			System.out.println();
			String RA_2 = JOptionPane.showInputDialog("qual RA do aluno a ser excluido: ");
			remover_aluno.delete(Integer.parseInt(RA_2));
		default:
			break;
		}
		} while (op!=0);
	
	} // fim do void 
	
} //fim da classe

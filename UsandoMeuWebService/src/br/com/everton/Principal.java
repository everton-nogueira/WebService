package br.com.everton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.xml.rpc.ServiceException;

import br.com.everton.wsdl.MeuWebservice;
import br.com.everton.wsdl.Time;
import br.com.everton.wsdl.WebServiceImplServiceLocator;

public class Principal {
	
	private MeuWebservice calc;
	
	public static void main(String[] args) throws MalformedURLException {
		Principal principal = new Principal();
		principal.iniciaWebService();
		principal.montaTela(principal.calc);
	}

	private void montaTela(MeuWebservice meuWS) {
		JButton botaoAdd = new JButton("Adicionar");
	    JButton botaoFindAll = new JButton("Buscar Todos");
	    JButton botaoFindByName = new JButton("Buscar por Nome");
	    
		botaoAdd.addActionListener(criaActionListenerAdd(meuWS));
		botaoFindAll.addActionListener(criaActionListenerListarTodos(meuWS));
		botaoFindByName.addActionListener(criaActionListenerBuscarPorNome(meuWS));
		
		JPanel painel = new JPanel();
	    painel.add(botaoAdd);
	    painel.add(botaoFindAll);
	    painel.add(botaoFindByName);
		
		JFrame janela = new JFrame("Gerenciamento de Times");
		janela.add(painel);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}

	private void iniciaWebService() throws MalformedURLException {
		WebServiceImplServiceLocator locator = new WebServiceImplServiceLocator();
		try {
			calc = locator.getWebServiceImplPort();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	private ActionListener criaActionListenerAdd(MeuWebservice meuWS) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					String nome = JOptionPane.showInputDialog("Qual o nome do time?");
					Time time = new Time();
					time.setNome(nome);
					meuWS.addTime(time);						
				}catch(RemoteException e) {
					System.out.println("ROLOU UM ERRO QUANDO FUI INSERIR O TIME....");
				}
			}
		};
	}
	
	private ActionListener criaActionListenerListarTodos(MeuWebservice meuWS) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("TODOS OS TIMES");
					int count = 0;
					for(Time time : meuWS.buscaTodosTimes()) {
						System.out.println((++count)+"º Time: "+time.getNome());
					}
				} catch (RemoteException e1) {
					System.out.println("ROLOU UM ERRO AO BUSCAR OS TIMES....");
				}
			}
		};
	}
	
	private ActionListener criaActionListenerBuscarPorNome(MeuWebservice meuWS) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println(meuWS.buscaPorNome(JOptionPane.showInputDialog("Qual o nome do time?")).getNome());
				} catch (RemoteException e1) {
					System.out.println("ROLOU UM ERRO AO BUSCAR OS TIMES....");
				}
			}
		};
	}
    
}

package erp.contador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import erp.main.MainCT;

final class ContadorCT {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (contador == null || contador.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != 0) {
				return;
			}
			try {
				ContadorFAC.deletarRegistro(contador);
				getFrameCadastroContador().limparGUI();
				contador = new Contador();
				Msg.sucessoExcluiRegistro();
			} catch (Exception e) {
				Msg.erroExcluiRegistro();
			}
		}
	}

	public class FechaJanela implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				MainCT.getFrameCadastroContador().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFrameCadastroContador().reiniciarGUI();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFrameCadastroContador().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			contador = new Contador();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				MainCT.mostrarFrame(MainCT.getFrameMain());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Contador> contadors = new LinkedList<>();

			if (contador.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (contadors.add(ContadorFAC.getRegistro(contador))) {
					ContadorREL contadorREL = new ContadorREL(contadors);
					contadorREL.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Contador> contadors = new LinkedList<>();

			try {
				contadors = new LinkedList<>(ContadorFAC.pesquisarRegistro(contador));
			} catch (Exception e) {
				System.out.println(e);
			}
			ContadorREL contadorREL = new ContadorREL(contadors);
			contadorREL.retornarRelatorio(true);
		}
	}

	public class MostraFrameContador extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainCT.mostrarFrame(MainCT.getFrameCadastroContador());
			} else {
				MainCT.getFrameCadastroContador().reiniciarGUI();
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			contador = new Contador();
			getFrameCadastroContador().limparGUI();
			getPanelCadastroContador().getNomeGUI().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			contador = new Contador();
			atualizarObjeto();
			MainCT.getFramePesquisaContador().getPanelPesquisaContador()
					.pesquisarRegistroContador(contador);

			MainCT.mostrarFrame(MainCT.getFramePesquisaContador());
		}
	}

	public class SaidaSistema implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				int mensagem = Msg.confirmarSairDoSistema();
				if (mensagem == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Salva implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				int mensagem = Msg.confirmarSalvarRegistro();
				if (mensagem != JOptionPane.YES_OPTION) {
					return;
				}
				String nome = getPanelCadastroContador().getNomeGUI().getText();
				if (nome == null || nome.length() == 0) {
					getPanelCadastroContador().getNomeGUI().requestFocus();
					Msg.avisoCampoObrigatorio("Contador");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					ContadorFAC.salvarRegistro(contador);
					contador = new Contador();
					getFrameCadastroContador().limparGUI();
					getPanelCadastroContador().getNomeGUI().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				e.printStackTrace();
				Msg.erroInserirRegistro();
			}
		}
	}

	private Contador contador;

	ContadorCT() {
	}

	public void atualizarGui() {
		if (contador == null) {
			return;
		}
		getPanelCadastroContador().getCnpjGUI().setText(contador.getCnpj());
		getPanelCadastroContador().getNomeGUI().setText(contador.getNome());
		getPanelCadastroContador().getCpfGUI().setText(contador.getCpf());
		getPanelCadastroContador().getCrcGUI().setText(contador.getCrc());
		getPanelCadastroContador().getEmailGUI().setText(contador.getEmail());
		getPanelCadastroContador().getFaxGUI().setText(contador.getFax());
		getPanelCadastroContador().getFone1GUI().setText(contador.getFone1());
		getPanelCadastroContador().getFone2GUI().setText(contador.getFone2());
		getPanelCadastroContador().getSiteGUI().setText(contador.getSite());
	}

	public void atualizarObjeto() {
		contador.setCnpj(getPanelCadastroContador().getCnpjGUI().getText());
		contador.setCpf(getPanelCadastroContador().getCpfGUI().getText());
		contador.setCrc(getPanelCadastroContador().getCrcGUI().getText());
		contador.setNome(getPanelCadastroContador().getNomeGUI().getText());
		contador.setEmail(getPanelCadastroContador().getEmailGUI().getText());
		contador.setFax(getPanelCadastroContador().getFaxGUI().getText());
		contador.setFone1(getPanelCadastroContador().getFone1GUI().getText());
		contador.setFone2(getPanelCadastroContador().getFone2GUI().getText());
		contador.setSite(getPanelCadastroContador().getSiteGUI().getText());
	}

	public Contador getContador() {
		return contador;
	}

	public void setContador(Contador contador) {
		this.contador = contador;
	}

	public ContadorFC getFrameCadastroContador() {
		return MainCT.getFrameCadastroContador();
	}

	public ContadorPC getPanelCadastroContador() {
		return MainCT.getFrameCadastroContador().getPanelCadastroContador();
	}

	public ContadorFP getFramePesquisaContador() {
		return MainCT.getFramePesquisaContador();
	}

	public ContadorPP getPanelPesquisaContador() {
		return MainCT.getFramePesquisaContador().getPanelPesquisaContador();
	}
}

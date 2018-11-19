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

import erp.aop.gui.Msg;
import erp.main.MainGerenteEventos;

final class ContadorGerenteEventos {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class ExcluiRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (contador == null || contador.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != 0) {
				return;
			}
			try {
				ContadorDaoFacade.deletarRegistro(contador);
				getFrameCadastroContador().limparGui();
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
				MainGerenteEventos.getFrameCadastroContador().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFrameCadastroContador().reiniciarBox();
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
				MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameMain());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class ImprimiTodosRegistros implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Contador> contadors = new LinkedList<>();

			if (contador.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (contadors.add(ContadorDaoFacade.getRegistro(contador))) {
					ContadorRelatorio contadorRelatorio = new ContadorRelatorio(contadors);
					contadorRelatorio.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class ImprimiUnicoRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Contador> contadors = new LinkedList<>();

			try {
				contadors = new LinkedList<>(ContadorDaoFacade.pesquisarRegistro(contador));
			} catch (Exception e) {
				System.out.println(e);
			}
			ContadorRelatorio contadorRelatorio = new ContadorRelatorio(contadors);
			contadorRelatorio.retornarRelatorio(true);
		}
	}

	public class MostraFrameContador extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameCadastroContador());
			} else {
				MainGerenteEventos.getFrameCadastroContador().reiniciarBox();
			}
		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			contador = new Contador();
			getFrameCadastroContador().limparGui();
			getPanelCadastroContador().getTextFieldNome().requestFocus();
		}
	}

	public class PesquisaRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			contador = new Contador();
			atualizarObjeto();
			MainGerenteEventos.getFramePesquisaContador().getPanelPesquisaContador()
					.pesquisarRegistroContador(contador);

			MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFramePesquisaContador());
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
				String nome = getPanelCadastroContador().getTextFieldNome().getText();
				if (nome == null || nome.length() == 0) {
					getPanelCadastroContador().getTextFieldNome().requestFocus();
					Msg.avisoCampoObrigatorio("Contador");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					ContadorDaoFacade.salvarRegistro(contador);
					contador = new Contador();
					getFrameCadastroContador().limparGui();
					getPanelCadastroContador().getTextFieldNome().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				e.printStackTrace();
				Msg.erroInserirRegistro();
			}
		}
	}

	private Contador contador;

	ContadorGerenteEventos() {
	}

	public void atualizarGui() {
		if (contador == null) {
			return;
		}
		getPanelCadastroContador().getTextFieldCnpj().setText(contador.getCnpj());
		getPanelCadastroContador().getTextFieldNome().setText(contador.getNome());
		getPanelCadastroContador().getTextFieldCpf().setText(contador.getCpf());
		getPanelCadastroContador().getTextFieldCrc().setText(contador.getCrc());
		getPanelCadastroContador().getTextFieldEmail().setText(contador.getEmail());
		getPanelCadastroContador().getTextFieldFax().setText(contador.getFax());
		getPanelCadastroContador().getTextFieldFone1().setText(contador.getFone1());
		getPanelCadastroContador().getTextFieldFone2().setText(contador.getFone2());
		getPanelCadastroContador().getTextFieldSite().setText(contador.getSite());
	}

	public void atualizarObjeto() {
		contador.setCnpj(getPanelCadastroContador().getTextFieldCnpj().getText());
		contador.setCpf(getPanelCadastroContador().getTextFieldCpf().getText());
		contador.setCrc(getPanelCadastroContador().getTextFieldCrc().getText());
		contador.setNome(getPanelCadastroContador().getTextFieldNome().getText());
		contador.setEmail(getPanelCadastroContador().getTextFieldEmail().getText());
		contador.setFax(getPanelCadastroContador().getTextFieldFax().getText());
		contador.setFone1(getPanelCadastroContador().getTextFieldFone1().getText());
		contador.setFone2(getPanelCadastroContador().getTextFieldFone2().getText());
		contador.setSite(getPanelCadastroContador().getTextFieldSite().getText());
	}

	public Contador getContador() {
		return contador;
	}

	public void setContador(Contador contador) {
		this.contador = contador;
	}

	public FrameCadastroContador getFrameCadastroContador() {
		return MainGerenteEventos.getFrameCadastroContador();
	}

	public PanelCadastroContador getPanelCadastroContador() {
		return MainGerenteEventos.getFrameCadastroContador().getPanelCadastroContador();
	}

	public FramePesquisaContador getFramePesquisaContador() {
		return MainGerenteEventos.getFramePesquisaContador();
	}

	public PanelPesquisaContador getPanelPesquisaContador() {
		return MainGerenteEventos.getFramePesquisaContador().getPanelPesquisaContador();
	}
}

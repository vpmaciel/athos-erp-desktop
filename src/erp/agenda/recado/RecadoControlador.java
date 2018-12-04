package erp.agenda.recado;

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
import erp.main.MainControlador;

final class RecadoControlador {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class ExcluiRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (recado == null || recado.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				RecadoDaoFacade.deletarRegistro(recado);
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
				getFrameCadastroRecado().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFrameCadastroRecado().reiniciarGUI();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFrameCadastroRecado().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			recado = new Recado();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				MainControlador.mostrarFrame(MainControlador.getFrameMain());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class ImprimiTodosRegistros implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Recado> recados = new LinkedList<>();

			if (recado.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (recados.add(RecadoDaoFacade.getRegistro(recado))) {
					RecadoRelatorio recadoRelatorio = new RecadoRelatorio(recados);
					recadoRelatorio.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}

	public class ImprimiUnicoRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Recado> recados = new LinkedList<>();

			try {
				recados = new LinkedList<>(RecadoDaoFacade.pesquisarRegistro(recado));
			} catch (Exception e) {
				System.out.println(e);
			}
			RecadoRelatorio recadoRelatorio = new RecadoRelatorio(recados);
			recadoRelatorio.retornarRelatorio(true);
		}
	}

	public class MostraFrameRecado extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainControlador.mostrarFrame(MainControlador.getFrameCadastroEmpresa());
			} else {
				MainControlador.getFrameCadastroEmpresa().reiniciarGUI();
			}
		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			recado = new Recado();
			getFrameCadastroRecado().limparGUI();
			getPanelCadastroRecado().getTextFieldData().requestFocus();
		}
	}

	public class PesquisaRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			recado = new Recado();
			atualizarObjeto();
			getPanelPesquisaRecado().pesquisarRegistroRecado(recado);
			MainControlador.mostrarFrame(MainControlador.getFramePesquisaRecado());
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
				String data = getPanelCadastroRecado().getTextFieldData().getText();
				if (data == null || data.length() == 0) {
					getPanelCadastroRecado().getTextFieldData().requestFocus();
					Msg.avisoCampoObrigatorio("Data");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					RecadoDaoFacade.salvarRegistro(recado);
					recado = new Recado();
					MainControlador.getFrameCadastroRecado().limparGUI();
					getPanelCadastroRecado().getTextFieldData().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				e.printStackTrace();
				Msg.erroInserirRegistro();
			}
		}
	}

	private Recado recado;

	public void atualizarGui() {
		if (recado == null) {
			return;
		}
		getPanelCadastroRecado().getTextFieldRemetente().setText(recado.getRemetente());
		getPanelCadastroRecado().getTextFieldData().setText(recado.getData());
		getPanelCadastroRecado().getTextFieldRecado().setText(recado.getRecado());
		getPanelCadastroRecado().getTextFieldDestinatario().setText(recado.getDestinatario());
	}

	public void atualizarObjeto() {
		recado.setRemetente(getPanelCadastroRecado().getTextFieldRemetente().getText());
		recado.setData(getPanelCadastroRecado().getTextFieldData().getText());
		recado.setRecado(getPanelCadastroRecado().getTextFieldRecado().getText());
		recado.setDestinatario(getPanelCadastroRecado().getTextFieldDestinatario().getText());
	}

	public Recado getRecado() {
		return recado;
	}

	public void setRecado(Recado recado) {
		this.recado = recado;
	}

	public FCRecado getFrameCadastroRecado() {
		return MainControlador.getFrameCadastroRecado();
	}

	public PCRecado getPanelCadastroRecado() {
		return MainControlador.getFrameCadastroRecado().getPanelCadastroRecado();
	}

	public FPRecado getFramePesquisaRecado() {
		return MainControlador.getFramePesquisaRecado();
	}

	public PPRecado getPanelPesquisaRecado() {
		return MainControlador.getFramePesquisaRecado().getPanelPesquisaRecado();
	}
}

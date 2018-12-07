package erp.agenda.recado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import erp.main.MainCT;

final class RecadoCT {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (recado == null || recado.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				RecadoFAC.deletarRegistro(recado);
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
				getRecadoFC().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getRecadoFC().reiniciarGUI();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getRecadoFC().setVisible(false);
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
				MainCT.mostrarFrame(MainCT.getFrameMain());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Recado> recados = new LinkedList<>();

			if (recado.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (recados.add(RecadoFAC.getRegistro(recado))) {
					RecadoREL recadoREL = new RecadoREL(recados);
					recadoREL.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Recado> recados = new LinkedList<>();

			try {
				recados = new LinkedList<>(RecadoFAC.pesquisarRegistro(recado));
			} catch (Exception e) {
				System.out.println(e);
			}
			RecadoREL recadoREL = new RecadoREL(recados);
			recadoREL.retornarRelatorio(true);
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			recado = new Recado();
			getRecadoFC().limparGUI();
			getPanelCadastroRecado().getDataGUI().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			recado = new Recado();
			atualizarObjeto();
			getRecadoPP().pesquisarRegistroRecado(recado);
			MainCT.mostrarFrame(MainCT.getRecadoFP());
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
				String data = getPanelCadastroRecado().getDataGUI().getText();
				if (data == null || data.length() == 0) {
					getPanelCadastroRecado().getDataGUI().requestFocus();
					Msg.avisoCampoObrigatorio("Data");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					RecadoFAC.salvarRegistro(recado);
					recado = new Recado();
					MainCT.getRecadoFC().limparGUI();
					getPanelCadastroRecado().getDataGUI().requestFocus();
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
		getPanelCadastroRecado().getRemetenteGUI().setText(recado.getRemetente());
		getPanelCadastroRecado().getDataGUI().setText(recado.getData());
		getPanelCadastroRecado().getRecadoGUI().setText(recado.getRecado());
		getPanelCadastroRecado().getDestinatarioGUI().setText(recado.getDestinatario());
	}

	public void atualizarObjeto() {
		recado.setRemetente(getPanelCadastroRecado().getRemetenteGUI().getText());
		recado.setData(getPanelCadastroRecado().getDataGUI().getText());
		recado.setRecado(getPanelCadastroRecado().getRecadoGUI().getText());
		recado.setDestinatario(getPanelCadastroRecado().getDestinatarioGUI().getText());
	}

	public Recado getRecado() {
		return recado;
	}

	public void setRecado(Recado recado) {
		this.recado = recado;
	}

	public RecadoFC getRecadoFC() {
		return MainCT.getRecadoFC();
	}

	public RecadoPC getPanelCadastroRecado() {
		return MainCT.getRecadoFC().getRecadoPC();
	}

	public RecadoFP getRecadoFP() {
		return MainCT.getRecadoFP();
	}

	public RecadoPP getRecadoPP() {
		return MainCT.getRecadoFP().getRecadoPP();
	}
}

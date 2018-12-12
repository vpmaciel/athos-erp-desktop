package erp.agenda.recado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import erp.main.MainCont;

final class RecadoCont {

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
				RecadoFac.deletarRegistro(recado);
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
				getRecadoFc().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getRecadoFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getRecadoFc().setVisible(false);
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
				MainCont.mostrarFrame(MainCont.getMainFc());
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
				if (recados.add(RecadoFac.getRegistro(recado))) {
					RecadoRel recadoRel = new RecadoRel(recados);
					recadoRel.retornarRelatorio(true);
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
				recados = new LinkedList<>(RecadoFac.pesquisarRegistro(recado));
			} catch (Exception e) {
				System.out.println(e);
			}
			RecadoRel recadoRel = new RecadoRel(recados);
			recadoRel.retornarRelatorio(true);
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			recado = new Recado();
			getRecadoFc().limparGui();
			getRecadoPc().getDataGUI().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			recado = new Recado();
			atualizarObjeto();
			getRecadoPp().pesquisarRegistroRecado(recado);
			MainCont.mostrarFrame(MainCont.getAgendaRecadoFp());
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
				String data = getRecadoPc().getDataGUI().getText();
				if (data == null || data.length() == 0) {
					getRecadoPc().getDataGUI().requestFocus();
					Msg.avisoCampoObrigatorio("Data");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					RecadoFac.salvarRegistro(recado);
					recado = new Recado();
					MainCont.getAgendaRecadoFc().limparGui();
					getRecadoPc().getDataGUI().requestFocus();
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
		getRecadoPc().getRemetenteGUI().setText(recado.getRemetente());
		getRecadoPc().getDataGUI().setText(recado.getData());
		getRecadoPc().getRecadoGUI().setText(recado.getRecado());
		getRecadoPc().getDestinatarioGUI().setText(recado.getDestinatario());
	}

	public void atualizarObjeto() {
		recado.setRemetente(getRecadoPc().getRemetenteGUI().getText());
		recado.setData(getRecadoPc().getDataGUI().getText());
		recado.setRecado(getRecadoPc().getRecadoGUI().getText());
		recado.setDestinatario(getRecadoPc().getDestinatarioGUI().getText());
	}

	public Recado getRecado() {
		return recado;
	}

	public void setRecado(Recado recado) {
		this.recado = recado;
	}

	public RecadoFc getRecadoFc() {
		return MainCont.getAgendaRecadoFc();
	}

	public RecadoPc getRecadoPc() {
		return MainCont.getAgendaRecadoFc().getRecadoPc();
	}

	public RecadoFp getRecadoFp() {
		return MainCont.getAgendaRecadoFp();
	}

	public RecadoPp getRecadoPp() {
		return MainCont.getAgendaRecadoFp().getRecadoPp();
	}
}

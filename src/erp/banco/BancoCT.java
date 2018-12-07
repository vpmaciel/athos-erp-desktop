package erp.banco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import erp.main.MainFC;
import erp.main.MainCT;

final class BancoCT {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (banco == null || banco.getId() == null) {
				Msg.erroExcluiRegistro();
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				bancoFAC.deletarRegistro(banco);
				getBancoFC().limparGUI();
				banco = new Banco();
				Msg.sucessoExcluiRegistro();
			} catch (Exception e) {
				Msg.erroExcluiRegistro();
			}
		}
	}

	public class FechaJanela implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			getBancoFC().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getBancoFC().reiniciarGUI();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getBancoFC().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			banco = new Banco();
			getBancoPC().getNomeGUI().requestFocus();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			MainFC.mostrarFrame(MainFC.getFrameMain());
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Banco> bancos = new LinkedList<>();

			try {
				bancos = new LinkedList<>(bancoFAC.pesquisarRegistro(new Banco()));
			} catch (Exception e) {
				System.out.println(e);
			}

			BancoREL bancoREL = new BancoREL(bancos);
			bancoREL.retornarRelatorio(true);

		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Banco> bancos = new LinkedList<>();

			if (banco.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (bancos.add(bancoFAC.getRegistro(banco))) {
				BancoREL bancoREL = new BancoREL(bancos);
				bancoREL.retornarRelatorio(true);
			}

		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			banco = new Banco();
			getBancoFC().limparGUI();
			getBancoPC().getNomeGUI().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getBancoPP().pesquisarRegistroBanco(banco);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainFC.mostrarFrame(getBancoFP());
			}
		}
	}

	public class SaidaSistema implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (Msg.confirmarSairDoSistema() == JOptionPane.YES_OPTION) {
				System.exit(0);
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

				if ((getBancoPC().getNomeGUI().getText()) == null
						|| getBancoPC().getNomeGUI().getText().length() == 0) {
					getBancoPC().getNomeGUI().requestFocus();
					Msg.avisoCampoObrigatorio("NOME");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					bancoFAC.salvarBanco(banco);
					banco = new Banco();
					getBancoFC().limparGUI();
					getBancoPC().getNomeGUI().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroInserirRegistro();
				Msg.avisoCampoDuplicado("NOME", getBancoPC().getNomeGUI().getText());
			}
		}
	}

	private Banco banco;
	private final BancoFAC bancoFAC = new BancoFAC();

	public BancoCT() {

	}

	public void atualizarGui() {
		if (banco == null) {
			return;
		}
		getBancoPC().getNomeGUI().setText(banco.getNome());
		getBancoPC().getCodigoGUI().setText(banco.getCodigo());
	}

	public void atualizarObjeto() {
		banco.setCodigo(getBancoPC().getCodigoGUI().getText());
		banco.setNome(getBancoPC().getNomeGUI().getText());
	}

	public Banco getBanco() {
		return banco;
	}

	public BancoFC getBancoFC() {
		return MainCT.getBancoFC();
	}

	public BancoPC getBancoPC() {
		return MainCT.getBancoFC().getBancoPC();
	}

	public BancoFP getBancoFP() {
		return MainCT.getBancoFP();
	}

	public BancoPP getBancoPP() {
		return MainCT.getBancoFP().getBancoPP();
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}
}
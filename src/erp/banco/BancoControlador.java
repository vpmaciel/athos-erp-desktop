package erp.banco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import erp.main.FrameMain;
import erp.main.MainControlador;

final class BancoControlador {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class ExcluiRegistro implements ActionListener {

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
				bancoDaoFacade.deletarRegistro(banco);
				getFrameCadastroBanco().limparGUI();
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
			getFrameCadastroBanco().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFrameCadastroBanco().reiniciarGUI();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFrameCadastroBanco().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			banco = new Banco();
			getPanelCadastroBanco().getTextFieldNome().requestFocus();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			FrameMain.mostrarFrame(FrameMain.getFrameMain());
		}
	}

	public class ImprimiTodosRegistros implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Banco> bancos = new LinkedList<>();

			try {
				bancos = new LinkedList<>(bancoDaoFacade.pesquisarRegistro(new Banco()));
			} catch (Exception e) {
				System.out.println(e);
			}

			BancoRelatorio bancoRelatorio = new BancoRelatorio(bancos);
			bancoRelatorio.retornarRelatorio(true);

		}
	}

	public class ImprimiUnicoRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Banco> bancos = new LinkedList<>();

			if (banco.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (bancos.add(bancoDaoFacade.getRegistro(banco))) {
				BancoRelatorio bancoRelatorio = new BancoRelatorio(bancos);
				bancoRelatorio.retornarRelatorio(true);
			}

		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			banco = new Banco();
			getFrameCadastroBanco().limparGUI();
			getPanelCadastroBanco().getTextFieldNome().requestFocus();
		}
	}

	public class PesquisaRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getPanelPesquisaBanco().pesquisarRegistroBanco(banco);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				FrameMain.mostrarFrame(getFramePesquisaBanco());
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

				if ((getPanelCadastroBanco().getTextFieldNome().getText()) == null
						|| getPanelCadastroBanco().getTextFieldNome().getText().length() == 0) {
					getPanelCadastroBanco().getTextFieldNome().requestFocus();
					Msg.avisoCampoObrigatorio("NOME");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					bancoDaoFacade.salvarBanco(banco);
					banco = new Banco();
					getFrameCadastroBanco().limparGUI();
					getPanelCadastroBanco().getTextFieldNome().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroInserirRegistro();
				Msg.avisoCampoDuplicado("NOME", getPanelCadastroBanco().getTextFieldNome().getText());
			}
		}
	}

	private Banco banco;
	private final BancoDaoFacade bancoDaoFacade = new BancoDaoFacade();

	public BancoControlador() {

	}

	public void atualizarGui() {
		if (banco == null) {
			return;
		}
		getPanelCadastroBanco().getTextFieldNome().setText(banco.getNome());
		getPanelCadastroBanco().getTextFieldCodigo().setText(banco.getCodigo());
	}

	public void atualizarObjeto() {
		banco.setCodigo(getPanelCadastroBanco().getTextFieldCodigo().getText());
		banco.setNome(getPanelCadastroBanco().getTextFieldNome().getText());
	}

	public Banco getBanco() {
		return banco;
	}

	public FCBanco getFrameCadastroBanco() {
		return MainControlador.getFrameCadastroBanco();
	}

	public PCBanco getPanelCadastroBanco() {
		return MainControlador.getFrameCadastroBanco().getPanelCadastroBanco();
	}

	public FPBanco getFramePesquisaBanco() {
		return MainControlador.getFramePesquisaBanco();
	}

	public PPBanco getPanelPesquisaBanco() {
		return MainControlador.getFramePesquisaBanco().getPanelPesquisaBanco();
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}
}
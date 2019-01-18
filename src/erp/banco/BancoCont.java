package erp.banco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import erp.main.MainCont;
import erp.main.MainFc;

final class BancoCont {

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
				bancoFac.deletarRegistro(banco);
				getBancoFc().limparGui();
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
			getBancoFc().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getBancoFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getBancoFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			banco = new Banco();
			getBancoPc().getNomeGui().requestFocus();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			MainFc.mostrarFrame(MainFc.getFrameMain());
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Banco> bancos = new LinkedList<>();

			try {
				bancos = new LinkedList<>(bancoFac.pesquisarRegistro(new Banco()));
			} catch (Exception e) {
				System.out.println(e);
			}

			BancoRel bancoRel = new BancoRel(bancos);
			bancoRel.retornarRelatorio(true);

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
			if (bancos.add(bancoFac.getRegistro(banco))) {
				BancoRel bancoRel = new BancoRel(bancos);
				bancoRel.retornarRelatorio(true);
			}

		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			banco = new Banco();
			getBancoFc().limparGui();
			getBancoPc().getNomeGui().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getBancoPp().pesquisarRegistroBanco(banco);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainFc.mostrarFrame(getBancoFp());
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
				
				if(!getBancoPc().validarCamposCadastro()) {
					return;
				}

				if ((getBancoPc().getNomeGui().getText()) == null
						|| getBancoPc().getNomeGui().getText().length() == 0) {
					getBancoPc().getNomeGui().requestFocus();
					Msg.avisoCampoObrigatorio("NOME");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					bancoFac.salvarBanco(banco);
					banco = new Banco();
					getBancoFc().limparGui();
					getBancoPc().getNomeGui().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroInserirRegistro();
				Msg.avisoCampoDuplicado("NOME", getBancoPc().getNomeGui().getText());
			}
		}
	}

	private Banco banco;
	private final BancoFac bancoFac = new BancoFac();

	public BancoCont() {

	}

	public void atualizarGui() {
		if (banco == null) {
			return;
		}
		getBancoPc().getNomeGui().setText(banco.getNome());
		getBancoPc().getCodigoGui().setText(banco.getCodigo());
	}

	public void atualizarObjeto() {
		banco.setCodigo(getBancoPc().getCodigoGui().getText());
		banco.setNome(getBancoPc().getNomeGui().getText());
	}

	public Banco getBanco() {
		return banco;
	}

	public BancoFc getBancoFc() {
		return MainCont.getBancoFc();
	}

	public BancoPc getBancoPc() {
		return MainCont.getBancoFc().getBancoPc();
	}

	public BancoFp getBancoFp() {
		return MainCont.getBancoFp();
	}

	public BancoPp getBancoPp() {
		return MainCont.getBancoFp().getBancoPp();
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}
}
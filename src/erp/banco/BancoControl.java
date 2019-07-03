package erp.banco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import arquitetura.json.ArquivoJson;
import erp.main.MainControl;
import erp.main.MainFc;

final class BancoControl {

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
				BancoFac.deletarRegistro(banco);
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

	public class FormatoCsv implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Banco> listBanco = new LinkedList<>();

			try {
				listBanco = new LinkedList<>(BancoFac.pesquisarRegistro(new Banco()));
			} catch (Exception e) {
				e.printStackTrace();
			}

			BancoArqCsv bancoArqCsv = new BancoArqCsv(listBanco);
			bancoArqCsv.retornarArquivo(true);

		}
	}

	public class FormatoJson implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Banco> listBanco = new LinkedList<>();

			try {
				
				ArquivoJson<Banco> arquivoJson = new ArquivoJson<Banco>(banco, "banco");
				arquivoJson.gravarArquivo(BancoFac.getRegistro());
			} catch (Exception e) {
				e.printStackTrace();
			}

			BancoArqCsv bancoArqCsv = new BancoArqCsv(listBanco);
			bancoArqCsv.retornarArquivo(true);

		}
	}

	public class FormatoOds implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Banco> listBanco = new LinkedList<>();

			try {
				listBanco = new LinkedList<>(BancoFac.pesquisarRegistro(new Banco()));
			} catch (Exception e) {
				e.printStackTrace();
			}

			BancoArqOds bancoArqOds = new BancoArqOds(listBanco);
			bancoArqOds.retornarArquivo(true);

		}
	}

	public class FormatoTxt implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Banco> listBanco = new LinkedList<>();

			try {
				listBanco = new LinkedList<>(BancoFac.pesquisarRegistro(new Banco()));
			} catch (Exception e) {
				e.printStackTrace();
			}

			BancoArqTxt bancoArqTxt = new BancoArqTxt(listBanco);
			bancoArqTxt.retornarArquivo(true);
		}
	}

	public class FormatoXml implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Banco> listBanco = new LinkedList<>();

			try {
				listBanco = new LinkedList<>(BancoFac.pesquisarRegistro(new Banco()));
			} catch (Exception e) {
				e.printStackTrace();
			}

			BancoArqXml bancoArqXml = new BancoArqXml(listBanco);
			bancoArqXml.retornarArquivo(true);
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
			getBancoPc().getGuiNome().requestFocus();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			MainControl.mostrarFrame(MainFc.getFrameMain());
		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Banco> listBanco = new LinkedList<>();

			if (banco.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (listBanco.add(BancoFac.getRegistro(banco))) {
				BancoRel bancoRel = new BancoRel(listBanco);
				bancoRel.retornarRelatorio(true);
			}

		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			banco = new Banco();
			getBancoFc().limparGui();
			getBancoPc().getGuiNome().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getBancoPp().pesquisarRegistro(banco);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainControl.mostrarFrame(getBancoFp());
				getBancoFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}
	
	public class Registro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getBancoPp().pesquisarRegistro(new Banco());
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainControl.mostrarFrame(getBancoFp());
				getBancoFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}


	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Banco> listBanco = new LinkedList<>();

			try {
				listBanco = new LinkedList<>(BancoFac.pesquisarRegistro(new Banco()));
			} catch (Exception e) {
				e.printStackTrace();
			}

			BancoRel bancoRel = new BancoRel(listBanco);
			bancoRel.retornarRelatorio(true);

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

				if (!getBancoPc().validarGui()) {
					return;
				}

				if ((getBancoPc().getGuiNome().getText()) == null
						|| getBancoPc().getGuiNome().getText().length() == 0) {
					getBancoPc().getGuiNome().requestFocus();
					Msg.avisoCampoObrigatorio("NOME");
					return;
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					BancoFac.salvarBanco(banco);
					banco = new Banco();
					getBancoFc().limparGui();
					getBancoPc().getGuiNome().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Throwable throwable = e.getCause().getCause();
				String mensagem = throwable.toString();
				if (mensagem.contains("ConstraintViolationException")) {
					if (mensagem.contains("INDEX_BANCO_NOME")) {
						Msg.avisoCampoDuplicado("NOME");
						getBancoPc().getGuiNome().requestFocus();
					} else if (mensagem.contains("INDEX_BANCO_CODIGO")) {
						Msg.avisoCampoDuplicado("CÓDIGO");
						getBancoPc().getGuiCodigo().requestFocus();
					} else {
						Msg.avisoCampoDuplicado();
					}
				}
				e.printStackTrace();
				Msg.erroSalvarRegistro();
			}
		}
	}

	private Banco banco;

	public BancoControl() {

	}

	public void atualizarGui() {
		if (banco == null) {
			return;
		}
		getBancoPc().getGuiNome().setText(banco.getNome());
		getBancoPc().getGuiCodigo().setText(banco.getCodigo());
	}

	public void atualizarObjeto() {
		banco.setCodigo(getBancoPc().getGuiCodigo().getText());
		banco.setNome(getBancoPc().getGuiNome().getText());
	}

	public Banco getBanco() {
		return banco;
	}

	public BancoFc getBancoFc() {
		return MainControl.getBancoFc();
	}

	public BancoFp getBancoFp() {
		return MainControl.getBancoFp();
	}

	public BancoPc getBancoPc() {
		return MainControl.getBancoFc().getBancoPc();
	}

	public BancoPp getBancoPp() {
		return MainControl.getBancoFp().getBancoPp();
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}
}
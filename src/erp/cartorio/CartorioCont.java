package erp.cartorio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import erp.main.MainCont;

final class CartorioCont {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (cartorio == null || cartorio.getId() == null) {
				Msg.erroExcluiRegistro();
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				CartorioFac.deletarCartorio(cartorio);
				getCartorioFc().limparGui();
				cartorio = new Cartorio();
				Msg.sucessoExcluiRegistro();
			} catch (Exception e) {
				Msg.erroExcluiRegistro();
			}
		}
	}

	public class FechaJanela implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			getCartorioFc().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getCartorioFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getCartorioFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			cartorio = new Cartorio();
			getCartorioPc().getNomeFantasiaGui().requestFocus();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			MainCont.mostrarFrame(MainCont.getMainFc());
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Cartorio> cartorios = new LinkedList<>();

			try {
				cartorios = new LinkedList<>(CartorioFac.pesquisarRegistroCartorio(new Cartorio()));
			} catch (Exception e) {
				System.out.println(e);
			}
			CartorioRel cartorioRel = new CartorioRel(cartorios);
			cartorioRel.retornarRelatorio(true);
		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Cartorio> cartorios = new LinkedList<>();

			if (cartorio.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (cartorios.add(CartorioFac.getCartorio(cartorio))) {
				CartorioRel cartorioRel = new CartorioRel(cartorios);
				cartorioRel.retornarRelatorio(true);
			}

		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			cartorio = new Cartorio();
			getCartorioFc().limparGui();
			getCartorioPc().getNomeFantasiaGui().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getCartorioPp().pesquisarRegistroCartorio(cartorio);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getCartorioFp());
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

				if ((getCartorioPc().getNomeFantasiaGui().getText()) == null
						|| getCartorioPc().getNomeFantasiaGui().getText().length() == 0) {
					getCartorioPc().getNomeFantasiaGui().requestFocus();
					Msg.avisoCampoObrigatorio("NOME FANTASIA");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					CartorioFac.salvarCartorio(cartorio);
					cartorio = new Cartorio();
					getCartorioFc().limparGui();
					getCartorioPc().getNomeFantasiaGui().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroInserirRegistro();
			}
		}
	}

	private Cartorio cartorio;

	public CartorioCont() {

	}

	public void atualizarGui() {
		if (cartorio == null) {
			return;
		}
		getCartorioPc().getCnpjGui().setText(cartorio.getCnpj());
		getCartorioPc().getComarcaGui().setText(cartorio.getComarca());
		getCartorioPc().getDistritoGui().setText(cartorio.getDistrito());
		getCartorioPc().getMunicipioGui().setText(cartorio.getMunicipio());
		getCartorioPc().getNomeFantasiaGui().setText(cartorio.getNomeFantasia());
		getCartorioPc().getRazaoSocialGui().setText(cartorio.getRazaoSocial());
		getCartorioPc().getSubstitutoGui().setText(cartorio.getSubstituto());
		getCartorioPc().getTitularGui().setText(cartorio.getTitular());
		getCartorioPc().getEmailGui().setText(cartorio.getEmail());
		getCartorioPc().getFaxGui().setText(cartorio.getFax());
		getCartorioPc().getFone1Gui().setText(cartorio.getFone1());
		getCartorioPc().getFone2Gui().setText(cartorio.getFone2());
		getCartorioPc().getSiteGui().setText(cartorio.getSite());
		getCartorioPc().getBairroGui().setText(cartorio.getBairro());
		getCartorioPc().getCepGui().setText(cartorio.getCep());
		getCartorioPc().getCidadeGui().setText(cartorio.getCidade());
		getCartorioPc().getComplementoGui().setText(cartorio.getComplemento());
		getCartorioPc().getEstadoGui().setText(cartorio.getEstado());
		getCartorioPc().getLogradouroGui().setText(cartorio.getLogradouro());
		getCartorioPc().getPaisGui().setText(cartorio.getPais());
	}

	public void atualizarObjeto() {
		cartorio.setCnpj(getCartorioPc().getCnpjGui().getText());
		cartorio.setComarca(getCartorioPc().getComarcaGui().getText());
		cartorio.setDistrito(getCartorioPc().getDistritoGui().getText());
		cartorio.setMunicipio(getCartorioPc().getMunicipioGui().getText());
		cartorio.setNomeFantasia(getCartorioPc().getNomeFantasiaGui().getText());
		cartorio.setRazaoSocial(getCartorioPc().getRazaoSocialGui().getText());
		cartorio.setSubstituto(getCartorioPc().getSubstitutoGui().getText());
		cartorio.setTitular(getCartorioPc().getTitularGui().getText());
		cartorio.setEmail(getCartorioPc().getEmailGui().getText());
		cartorio.setFax(getCartorioPc().getFaxGui().getText());
		cartorio.setFone1(getCartorioPc().getFone1Gui().getText());
		cartorio.setFone2(getCartorioPc().getFone2Gui().getText());
		cartorio.setSite(getCartorioPc().getSiteGui().getText());
		cartorio.setBairro(getCartorioPc().getBairroGui().getText());
		cartorio.setCep(getCartorioPc().getCepGui().getText());
		cartorio.setCidade(getCartorioPc().getCidadeGui().getText());
		cartorio.setComplemento(getCartorioPc().getComplementoGui().getText());
		cartorio.setEstado(getCartorioPc().getEstadoGui().getText());
		cartorio.setLogradouro(getCartorioPc().getLogradouroGui().getText());
		cartorio.setPais(getCartorioPc().getPaisGui().getText());
	}

	public Cartorio getCartorio() {
		return cartorio;
	}

	public void setCartorio(Cartorio cartorio) {
		this.cartorio = cartorio;
	}

	public CartorioFc getCartorioFc() {
		return MainCont.getCartorioFc();
	}

	public CartorioPc getCartorioPc() {
		return MainCont.getCartorioFc().getCartorioPc();
	}

	public CartorioFp getCartorioFp() {
		return MainCont.getCartorioFp();
	}

	public CartorioPp getCartorioPp() {
		return MainCont.getCartorioFp().getCartorioPp();
	}
}
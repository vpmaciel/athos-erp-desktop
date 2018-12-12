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
				getCartorioFc().limparGUI();
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
			getCartorioFc().reiniciarGUI();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getCartorioFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			cartorio = new Cartorio();
			getCartorioPc().getNomeFantasiaGUI().requestFocus();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			MainCont.mostrarFrame(MainCont.getFrameMain());
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
			getCartorioFc().limparGUI();
			getCartorioPc().getNomeFantasiaGUI().requestFocus();
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

				if ((getCartorioPc().getNomeFantasiaGUI().getText()) == null
						|| getCartorioPc().getNomeFantasiaGUI().getText().length() == 0) {
					getCartorioPc().getNomeFantasiaGUI().requestFocus();
					Msg.avisoCampoObrigatorio("NOME FANTASIA");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					CartorioFac.salvarCartorio(cartorio);
					cartorio = new Cartorio();
					getCartorioFc().limparGUI();
					getCartorioPc().getNomeFantasiaGUI().requestFocus();
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
		getCartorioPc().getCnpjGUI().setText(cartorio.getCnpj());
		getCartorioPc().getComarcaGUI().setText(cartorio.getComarca());
		getCartorioPc().getDistritoGUI().setText(cartorio.getDistrito());
		getCartorioPc().getMunicipioGUI().setText(cartorio.getMunicipio());
		getCartorioPc().getNomeFantasiaGUI().setText(cartorio.getNomeFantasia());
		getCartorioPc().getRazaoSocialGUI().setText(cartorio.getRazaoSocial());
		getCartorioPc().getSubstitutoGUI().setText(cartorio.getSubstituto());
		getCartorioPc().getTitularGUI().setText(cartorio.getTitular());
		getCartorioPc().getEmailGUI().setText(cartorio.getEmail());
		getCartorioPc().getFaxGUI().setText(cartorio.getFax());
		getCartorioPc().getFone1GUI().setText(cartorio.getFone1());
		getCartorioPc().getFone2GUI().setText(cartorio.getFone2());
		getCartorioPc().getSiteGUI().setText(cartorio.getSite());
		getCartorioPc().getBairroGUI().setText(cartorio.getBairro());
		getCartorioPc().getCepGUI().setText(cartorio.getCep());
		getCartorioPc().getCidadeGUI().setText(cartorio.getCidade());
		getCartorioPc().getComplementoGUI().setText(cartorio.getComplemento());
		getCartorioPc().getEstadoGUI().setText(cartorio.getEstado());
		getCartorioPc().getLogradouroGUI().setText(cartorio.getLogradouro());
		getCartorioPc().getPaisGUI().setText(cartorio.getPais());
	}

	public void atualizarObjeto() {
		cartorio.setCnpj(getCartorioPc().getCnpjGUI().getText());
		cartorio.setComarca(getCartorioPc().getComarcaGUI().getText());
		cartorio.setDistrito(getCartorioPc().getDistritoGUI().getText());
		cartorio.setMunicipio(getCartorioPc().getMunicipioGUI().getText());
		cartorio.setNomeFantasia(getCartorioPc().getNomeFantasiaGUI().getText());
		cartorio.setRazaoSocial(getCartorioPc().getRazaoSocialGUI().getText());
		cartorio.setSubstituto(getCartorioPc().getSubstitutoGUI().getText());
		cartorio.setTitular(getCartorioPc().getTitularGUI().getText());
		cartorio.setEmail(getCartorioPc().getEmailGUI().getText());
		cartorio.setFax(getCartorioPc().getFaxGUI().getText());
		cartorio.setFone1(getCartorioPc().getFone1GUI().getText());
		cartorio.setFone2(getCartorioPc().getFone2GUI().getText());
		cartorio.setSite(getCartorioPc().getSiteGUI().getText());
		cartorio.setBairro(getCartorioPc().getBairroGUI().getText());
		cartorio.setCep(getCartorioPc().getCepGUI().getText());
		cartorio.setCidade(getCartorioPc().getCidadeGUI().getText());
		cartorio.setComplemento(getCartorioPc().getComplementoGUI().getText());
		cartorio.setEstado(getCartorioPc().getEstadoGUI().getText());
		cartorio.setLogradouro(getCartorioPc().getLogradouroGUI().getText());
		cartorio.setPais(getCartorioPc().getPaisGUI().getText());
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
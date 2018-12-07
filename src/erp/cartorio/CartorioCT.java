package erp.cartorio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import erp.main.MainCT;

final class CartorioCT {

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
				CartorioFAC.deletarCartorio(cartorio);
				getCartorioFC().limparGUI();
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
			getCartorioFC().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getCartorioFC().reiniciarGUI();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getCartorioFC().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			cartorio = new Cartorio();
			getCartorioPC().getNomeFantasiaGUI().requestFocus();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			MainCT.mostrarFrame(MainCT.getFrameMain());
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Cartorio> cartorios = new LinkedList<>();

			try {
				cartorios = new LinkedList<>(CartorioFAC.pesquisarRegistroCartorio(new Cartorio()));
			} catch (Exception e) {
				System.out.println(e);
			}
			CartorioREL cartorioREL = new CartorioREL(cartorios);
			cartorioREL.retornarRelatorio(true);
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
			if (cartorios.add(CartorioFAC.getCartorio(cartorio))) {
				CartorioREL cartorioREL = new CartorioREL(cartorios);
				cartorioREL.retornarRelatorio(true);
			}

		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			cartorio = new Cartorio();
			getCartorioFC().limparGUI();
			getCartorioPC().getNomeFantasiaGUI().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getCartorioPP().pesquisarRegistroCartorio(cartorio);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCT.mostrarFrame(getCartorioFP());
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

				if ((getCartorioPC().getNomeFantasiaGUI().getText()) == null
						|| getCartorioPC().getNomeFantasiaGUI().getText().length() == 0) {
					getCartorioPC().getNomeFantasiaGUI().requestFocus();
					Msg.avisoCampoObrigatorio("NOME FANTASIA");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					CartorioFAC.salvarCartorio(cartorio);
					cartorio = new Cartorio();
					getCartorioFC().limparGUI();
					getCartorioPC().getNomeFantasiaGUI().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroInserirRegistro();
			}
		}
	}

	private Cartorio cartorio;

	public CartorioCT() {

	}

	public void atualizarGui() {
		if (cartorio == null) {
			return;
		}
		getCartorioPC().getCnpjGUI().setText(cartorio.getCnpj());
		getCartorioPC().getComarcaGUI().setText(cartorio.getComarca());
		getCartorioPC().getDistritoGUI().setText(cartorio.getDistrito());
		getCartorioPC().getMunicipioGUI().setText(cartorio.getMunicipio());
		getCartorioPC().getNomeFantasiaGUI().setText(cartorio.getNomeFantasia());
		getCartorioPC().getRazaoSocialGUI().setText(cartorio.getRazaoSocial());
		getCartorioPC().getSubstitutoGUI().setText(cartorio.getSubstituto());
		getCartorioPC().getTitularGUI().setText(cartorio.getTitular());
		getCartorioPC().getEmailGUI().setText(cartorio.getEmail());
		getCartorioPC().getFaxGUI().setText(cartorio.getFax());
		getCartorioPC().getFone1GUI().setText(cartorio.getFone1());
		getCartorioPC().getFone2GUI().setText(cartorio.getFone2());
		getCartorioPC().getSiteGUI().setText(cartorio.getSite());
		getCartorioPC().getBairroGUI().setText(cartorio.getBairro());
		getCartorioPC().getCepGUI().setText(cartorio.getCep());
		getCartorioPC().getCidadeGUI().setText(cartorio.getCidade());
		getCartorioPC().getComplementoGUI().setText(cartorio.getComplemento());
		getCartorioPC().getEstadoGUI().setText(cartorio.getEstado());
		getCartorioPC().getLogradouroGUI().setText(cartorio.getLogradouro());
		getCartorioPC().getPaisGUI().setText(cartorio.getPais());
	}

	public void atualizarObjeto() {
		cartorio.setCnpj(getCartorioPC().getCnpjGUI().getText());
		cartorio.setComarca(getCartorioPC().getComarcaGUI().getText());
		cartorio.setDistrito(getCartorioPC().getDistritoGUI().getText());
		cartorio.setMunicipio(getCartorioPC().getMunicipioGUI().getText());
		cartorio.setNomeFantasia(getCartorioPC().getNomeFantasiaGUI().getText());
		cartorio.setRazaoSocial(getCartorioPC().getRazaoSocialGUI().getText());
		cartorio.setSubstituto(getCartorioPC().getSubstitutoGUI().getText());
		cartorio.setTitular(getCartorioPC().getTitularGUI().getText());
		cartorio.setEmail(getCartorioPC().getEmailGUI().getText());
		cartorio.setFax(getCartorioPC().getFaxGUI().getText());
		cartorio.setFone1(getCartorioPC().getFone1GUI().getText());
		cartorio.setFone2(getCartorioPC().getFone2GUI().getText());
		cartorio.setSite(getCartorioPC().getSiteGUI().getText());
		cartorio.setBairro(getCartorioPC().getBairroGUI().getText());
		cartorio.setCep(getCartorioPC().getCepGUI().getText());
		cartorio.setCidade(getCartorioPC().getCidadeGUI().getText());
		cartorio.setComplemento(getCartorioPC().getComplementoGUI().getText());
		cartorio.setEstado(getCartorioPC().getEstadoGUI().getText());
		cartorio.setLogradouro(getCartorioPC().getLogradouroGUI().getText());
		cartorio.setPais(getCartorioPC().getPaisGUI().getText());
	}

	public Cartorio getCartorio() {
		return cartorio;
	}

	public void setCartorio(Cartorio cartorio) {
		this.cartorio = cartorio;
	}

	public CartorioFC getCartorioFC() {
		return MainCT.getCartorioFC();
	}

	public CartorioPC getCartorioPC() {
		return MainCT.getCartorioFC().getCartorioPC();
	}

	public CartorioFP getCartorioFP() {
		return MainCT.getCartorioFP();
	}

	public CartorioPP getCartorioPP() {
		return MainCT.getCartorioFP().getCartorioPP();
	}
}
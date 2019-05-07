package erp.cartorio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import arquitetura.validacao.Mascara;
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
				CartorioFac.deletarRegistro(cartorio);
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
			getCartorioPc().getNomeGuiFantasia().requestFocus();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			MainCont.mostrarFrame(MainCont.getMainFc());
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
			if (cartorios.add(CartorioFac.getRegistro(cartorio))) {
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
			getCartorioPc().getNomeGuiFantasia().requestFocus();
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

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Cartorio> cartorios = new LinkedList<>();

			try {
				cartorios = new LinkedList<>(CartorioFac.pesquisarRegistro(new Cartorio()));
			} catch (Exception e) {
				System.out.println(e);
			}

			CartorioRel cartorioRel = new CartorioRel(cartorios);
			cartorioRel.retornarRelatorio(true);

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

				if ((getCartorioPc().getNomeGuiFantasia().getText()) == null
						|| getCartorioPc().getNomeGuiFantasia().getText().length() == 0) {
					getCartorioPc().getNomeGuiFantasia().requestFocus();
					Msg.avisoCampoObrigatorio("NOME FANTASIA");
					return;
				}

				Cartorio cartorioPesquisa = new Cartorio();
				cartorioPesquisa.setNomeFantasia(getCartorioPc().getNomeGuiFantasia().getText());
				Cartorio cartorioPesquisaRetornado = CartorioFac.consultarRegistro(cartorioPesquisa);

				if (cartorio.getId() == null && cartorioPesquisa.getNomeFantasia() != null
						&& cartorioPesquisaRetornado.getNomeFantasia() != null) {
					if (cartorioPesquisa.getNomeFantasia().equals(cartorioPesquisaRetornado.getNomeFantasia())) {
						Msg.avisoCampoDuplicado("NOME FANTASIA", cartorioPesquisa.getNomeFantasia());
						getCartorioPc().getNomeGuiFantasia().requestFocus();
						return;
					}
				}

				if (cartorio.getId() != null && cartorioPesquisa.getNomeFantasia() != null
						&& cartorioPesquisaRetornado.getNomeFantasia() != null) {
					if (!cartorio.getNomeFantasia().equals(cartorioPesquisa.getNomeFantasia())) {
						if (cartorioPesquisa.getNomeFantasia().equals(cartorioPesquisaRetornado.getNomeFantasia())) {
							Msg.avisoCampoDuplicado("NOME FANTASIA", cartorioPesquisa.getNomeFantasia());
							getCartorioPc().getNomeGuiFantasia().requestFocus();
						}
						return;
					}
				}

				cartorioPesquisa = new Cartorio();
				cartorioPesquisa.setRazaoSocial(getCartorioPc().getGuiRazaoSocial().getText());
				cartorioPesquisaRetornado = CartorioFac.consultarRegistro(cartorioPesquisa);

				if (cartorio.getId() == null && cartorioPesquisa.getRazaoSocial() != null
						&& cartorioPesquisaRetornado.getRazaoSocial() != null) {
					if (cartorioPesquisa.getRazaoSocial().equals(cartorioPesquisaRetornado.getRazaoSocial())) {
						Msg.avisoCampoDuplicado("RAZÃO SOCIAL", cartorioPesquisa.getRazaoSocial());
						getCartorioPc().getGuiRazaoSocial().requestFocus();
						return;
					}
				}

				if (cartorio.getId() != null && cartorioPesquisa.getRazaoSocial() != null
						&& cartorioPesquisaRetornado.getRazaoSocial() != null) {
					if (!cartorio.getRazaoSocial().equals(cartorioPesquisa.getRazaoSocial())) {
						if (cartorioPesquisa.getRazaoSocial().equals(cartorioPesquisaRetornado.getRazaoSocial())) {
							Msg.avisoCampoDuplicado("RAZÃO SOCIAL", cartorioPesquisa.getRazaoSocial());
							getCartorioPc().getGuiRazaoSocial().requestFocus();
						}
						return;
					}
				}

				cartorioPesquisa = new Cartorio();
				cartorioPesquisa.setCnpj(getCartorioPc().getGuiCnpj().getText());
				cartorioPesquisaRetornado = CartorioFac.consultarRegistro(cartorioPesquisa);

				if (cartorio.getId() == null && cartorioPesquisa.getCnpj() != null
						&& cartorioPesquisaRetornado.getCnpj() != null) {
					if (cartorioPesquisa.getCnpj().equals(cartorioPesquisaRetornado.getCnpj())) {
						Msg.avisoCampoDuplicado("CNPJ", cartorioPesquisa.getCnpj());
						getCartorioPc().getGuiCnpj().requestFocus();
						return;
					}
				}

				if (cartorio.getId() != null && cartorioPesquisa.getCnpj() != null
						&& cartorioPesquisaRetornado.getCnpj() != null) {
					if (!cartorio.getCnpj().equals(cartorioPesquisa.getCnpj())) {
						if (cartorioPesquisa.getCnpj().equals(cartorioPesquisaRetornado.getCnpj())) {
							Msg.avisoCampoDuplicado("CNPJ", cartorioPesquisa.getCnpj());
							getCartorioPc().getGuiCnpj().requestFocus();
						}
						return;
					}
				}

				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					CartorioFac.salvarRegistro(cartorio);
					cartorio = new Cartorio();
					getCartorioFc().limparGui();
					getCartorioPc().getNomeGuiFantasia().requestFocus();
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
		getCartorioPc().getGuiCnpj().setText(cartorio.getCnpj());
		getCartorioPc().getGuiComarca().setText(cartorio.getComarca());
		getCartorioPc().getGuiDistrito().setText(cartorio.getDistrito());
		getCartorioPc().getGuiMunicipio().setText(cartorio.getMunicipio());
		getCartorioPc().getNomeGuiFantasia().setText(cartorio.getNomeFantasia());
		getCartorioPc().getGuiRazaoSocial().setText(cartorio.getRazaoSocial());
		getCartorioPc().getGuiSubstituto().setText(cartorio.getSubstituto());
		getCartorioPc().getGuiTitular().setText(cartorio.getTitular());
		getCartorioPc().getGuiEmail().setText(cartorio.getEmail());
		getCartorioPc().getGuiFax().setText(cartorio.getFax());
		getCartorioPc().getGuiFone1().setText(cartorio.getFone1());
		getCartorioPc().getGuiFone2().setText(cartorio.getFone2());
		getCartorioPc().getGuiSite().setText(cartorio.getSite());
		getCartorioPc().getGuiBairro().setText(cartorio.getBairro());
		getCartorioPc().getGuiCep().setText(cartorio.getCep());
		getCartorioPc().getGuiCidade().setText(cartorio.getCidade());
		getCartorioPc().getGuiComplemento().setText(cartorio.getComplemento());
		getCartorioPc().getGuiEstado().setText(cartorio.getEstado());
		getCartorioPc().getGuiLogradouro().setText(cartorio.getLogradouro());
		getCartorioPc().getGuiPais().setText(cartorio.getPais());
	}

	public void atualizarObjeto() {
		cartorio.setCnpj(getCartorioPc().getGuiCnpj().getText());
		cartorio.setComarca(getCartorioPc().getGuiComarca().getText());
		cartorio.setDistrito(getCartorioPc().getGuiDistrito().getText());
		cartorio.setMunicipio(getCartorioPc().getGuiMunicipio().getText());
		cartorio.setNomeFantasia(getCartorioPc().getNomeGuiFantasia().getText());
		cartorio.setRazaoSocial(getCartorioPc().getGuiRazaoSocial().getText());
		cartorio.setSubstituto(getCartorioPc().getGuiSubstituto().getText());
		cartorio.setTitular(getCartorioPc().getGuiTitular().getText());
		cartorio.setEmail(getCartorioPc().getGuiEmail().getText());
		cartorio.setFax(getCartorioPc().getGuiFax().getText());
		cartorio.setFone1(getCartorioPc().getGuiFone1().getText());
		cartorio.setFone2(getCartorioPc().getGuiFone2().getText());
		cartorio.setSite(getCartorioPc().getGuiSite().getText());
		cartorio.setBairro(getCartorioPc().getGuiBairro().getText());
		cartorio.setCep(getCartorioPc().getGuiCep().getText());
		cartorio.setCidade(getCartorioPc().getGuiCidade().getText());
		cartorio.setComplemento(getCartorioPc().getGuiComplemento().getText());
		cartorio.setEstado(getCartorioPc().getGuiEstado().getText());
		cartorio.setLogradouro(getCartorioPc().getGuiLogradouro().getText());
		cartorio.setPais(getCartorioPc().getGuiPais().getText());

		if (getCartorioPc().getGuiCnpj().getText().equals(Mascara.getCnpjVazio())) {
			cartorio.setCnpj(null);
		}

		if (getCartorioPc().getGuiRazaoSocial().getText().length() == 0) {
			cartorio.setRazaoSocial(null);
		}

		if (getCartorioPc().getNomeGuiFantasia().getText().length() == 0) {
			cartorio.setNomeFantasia(null);
		}
	}

	public Cartorio getCartorio() {
		return cartorio;
	}

	public CartorioFc getCartorioFc() {
		return MainCont.getCartorioFc();
	}

	public CartorioFp getCartorioFp() {
		return MainCont.getCartorioFp();
	}

	public CartorioPc getCartorioPc() {
		return MainCont.getCartorioFc().getCartorioPc();
	}

	public CartorioPp getCartorioPp() {
		return MainCont.getCartorioFp().getCartorioPp();
	}

	public void setCartorio(Cartorio cartorio) {
		this.cartorio = cartorio;
	}
}
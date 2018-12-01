package erp.cartorio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import erp.main.MainGerenteEventos;

final class CartorioGerenteEventos {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class ExcluiRegistro implements ActionListener {

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
				CartorioDaoFacade.deletarCartorio(cartorio);
				getFrameCadastroCartorio().limparGui();
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
			getFrameCadastroCartorio().setVisible(false);
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFrameCadastroCartorio().reiniciarBox();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFrameCadastroCartorio().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			cartorio = new Cartorio();
			getPanelCadastroCartorio().getTextFieldNomeFantasia().requestFocus();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameMain());
		}
	}

	public class ImprimiTodosRegistros implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Cartorio> cartorios = new LinkedList<>();

			try {
				cartorios = new LinkedList<>(CartorioDaoFacade.pesquisarRegistroCartorio(new Cartorio()));
			} catch (Exception e) {
				System.out.println(e);
			}
			CartorioRelatorio cartorioRelatorio = new CartorioRelatorio(cartorios);
			cartorioRelatorio.retornarRelatorio(true);
		}
	}

	public class ImprimiUnicoRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Cartorio> cartorios = new LinkedList<>();

			if (cartorio.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (cartorios.add(CartorioDaoFacade.getCartorio(cartorio))) {
				CartorioRelatorio cartorioRelatorio = new CartorioRelatorio(cartorios);
				cartorioRelatorio.retornarRelatorio(true);
			}

		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			cartorio = new Cartorio();
			getFrameCadastroCartorio().limparGui();
			getPanelCadastroCartorio().getTextFieldNomeFantasia().requestFocus();
		}
	}

	public class PesquisaRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getPanelPesquisaCartorio().pesquisarRegistroCartorio(cartorio);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainGerenteEventos.mostrarFrame(getFramePesquisaCartorio());
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

				if ((getPanelCadastroCartorio().getTextFieldNomeFantasia().getText()) == null
						|| getPanelCadastroCartorio().getTextFieldNomeFantasia().getText().length() == 0) {
					getPanelCadastroCartorio().getTextFieldNomeFantasia().requestFocus();
					Msg.avisoCampoObrigatorio("NOME FANTASIA");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					CartorioDaoFacade.salvarCartorio(cartorio);
					cartorio = new Cartorio();
					getFrameCadastroCartorio().limparGui();
					getPanelCadastroCartorio().getTextFieldNomeFantasia().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroInserirRegistro();
			}
		}
	}

	private Cartorio cartorio;

	public CartorioGerenteEventos() {

	}

	public void atualizarGui() {
		if (cartorio == null) {
			return;
		}
		getPanelCadastroCartorio().getTextFieldCNPJ().setText(cartorio.getCnpj());
		getPanelCadastroCartorio().getTextFieldComarca().setText(cartorio.getComarca());
		getPanelCadastroCartorio().getTextFieldDistrito().setText(cartorio.getDistrito());
		getPanelCadastroCartorio().getTextFieldMunicipio().setText(cartorio.getMunicipio());
		getPanelCadastroCartorio().getTextFieldNomeFantasia().setText(cartorio.getNomeFantasia());
		getPanelCadastroCartorio().getTextFieldRazaoSocial().setText(cartorio.getRazaoSocial());
		getPanelCadastroCartorio().getTextFieldSubstituto().setText(cartorio.getSubstituto());
		getPanelCadastroCartorio().getTextFieldTitular().setText(cartorio.getTitular());
		getPanelCadastroCartorio().getTextFieldEmail().setText(cartorio.getEmail());
		getPanelCadastroCartorio().getTextFieldFax().setText(cartorio.getFax());
		getPanelCadastroCartorio().getTextFieldFone1().setText(cartorio.getFone1());
		getPanelCadastroCartorio().getTextFieldFone2().setText(cartorio.getFone2());
		getPanelCadastroCartorio().getTextFieldSite().setText(cartorio.getSite());
		getPanelCadastroCartorio().getTextFieldBairro().setText(cartorio.getBairro());
		getPanelCadastroCartorio().getTextFieldCep().setText(cartorio.getCep());
		getPanelCadastroCartorio().getTextFieldCidade().setText(cartorio.getCidade());
		getPanelCadastroCartorio().getTextFieldComplemento().setText(cartorio.getComplemento());
		getPanelCadastroCartorio().getTextFieldEstado().setText(cartorio.getEstado());
		getPanelCadastroCartorio().getTextFieldLogradouro().setText(cartorio.getLogradouro());
		getPanelCadastroCartorio().getTextFieldPais().setText(cartorio.getPais());
	}

	public void atualizarObjeto() {
		cartorio.setCnpj(getPanelCadastroCartorio().getTextFieldCNPJ().getText());
		cartorio.setComarca(getPanelCadastroCartorio().getTextFieldComarca().getText());
		cartorio.setDistrito(getPanelCadastroCartorio().getTextFieldDistrito().getText());
		cartorio.setMunicipio(getPanelCadastroCartorio().getTextFieldMunicipio().getText());
		cartorio.setNomeFantasia(getPanelCadastroCartorio().getTextFieldNomeFantasia().getText());
		cartorio.setRazaoSocial(getPanelCadastroCartorio().getTextFieldRazaoSocial().getText());
		cartorio.setSubstituto(getPanelCadastroCartorio().getTextFieldSubstituto().getText());
		cartorio.setTitular(getPanelCadastroCartorio().getTextFieldTitular().getText());
		cartorio.setEmail(getPanelCadastroCartorio().getTextFieldEmail().getText());
		cartorio.setFax(getPanelCadastroCartorio().getTextFieldFax().getText());
		cartorio.setFone1(getPanelCadastroCartorio().getTextFieldFone1().getText());
		cartorio.setFone2(getPanelCadastroCartorio().getTextFieldFone2().getText());
		cartorio.setSite(getPanelCadastroCartorio().getTextFieldSite().getText());
		cartorio.setBairro(getPanelCadastroCartorio().getTextFieldBairro().getText());
		cartorio.setCep(getPanelCadastroCartorio().getTextFieldCep().getText());
		cartorio.setCidade(getPanelCadastroCartorio().getTextFieldCidade().getText());
		cartorio.setComplemento(getPanelCadastroCartorio().getTextFieldComplemento().getText());
		cartorio.setEstado(getPanelCadastroCartorio().getTextFieldEstado().getText());
		cartorio.setLogradouro(getPanelCadastroCartorio().getTextFieldLogradouro().getText());
		cartorio.setPais(getPanelCadastroCartorio().getTextFieldPais().getText());
	}

	public Cartorio getCartorio() {
		return cartorio;
	}

	public void setCartorio(Cartorio cartorio) {
		this.cartorio = cartorio;
	}

	public FrameCadastroCartorio getFrameCadastroCartorio() {
		return MainGerenteEventos.getFrameCadastroCartorio();
	}

	public PanelCadastroCartorio getPanelCadastroCartorio() {
		return MainGerenteEventos.getFrameCadastroCartorio().getPanelCadastroCartorio();
	}

	public FramePesquisaCartorio getFramePesquisaCartorio() {
		return MainGerenteEventos.getFramePesquisaCartorio();
	}

	public PanelPesquisaCartorio getPanelPesquisaCartorio() {
		return MainGerenteEventos.getFramePesquisaCartorio().getPanelPesquisaCartorio();
	}
}
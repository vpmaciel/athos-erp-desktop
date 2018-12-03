package erp.imovel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import arquitetura.gui.Msg;
import erp.main.MainControlador;

final class ImovelControlador {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class ExcluiRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (imovel == null || imovel.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				ImovelDaoFacade.deletarRegistro(imovel);
				getFrameCadastroImovel().limparGui();
				imovel = new Imovel();
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
				getFrameCadastroImovel().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFrameCadastroImovel().reiniciarBox();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFrameCadastroImovel().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			imovel = new Imovel();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				MainControlador.mostrarFrame(MainControlador.getFrameMain());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class ImprimiTodosRegistros implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Imovel> imoveis = new LinkedList<>();

			if (imovel.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (imoveis.add(ImovelDaoFacade.getRegistro(imovel))) {
					ImovelRelatorio imovelRelatorio = new ImovelRelatorio(imoveis);
					imovelRelatorio.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class ImprimiUnicoRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Imovel> imoveis = new LinkedList<>();

			try {
				imoveis = new LinkedList<>(ImovelDaoFacade.pesquisarRegistro(imovel));
			} catch (Exception e) {
				System.out.println(e);
			}
			ImovelRelatorio imovelRelatorio = new ImovelRelatorio(imoveis);
			imovelRelatorio.retornarRelatorio(true);
		}
	}

	public class MostraFrameImovel extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainControlador.mostrarFrame(MainControlador.getFrameCadastroImovel());
			} else {
				getFrameCadastroImovel().reiniciarBox();
			}
		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			imovel = new Imovel();
			getFrameCadastroImovel().limparGui();
			getPanelCadastroImovel().getTextFieldNomeProprietario().requestFocus();
		}
	}

	public class PesquisaRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			imovel = new Imovel();
			ImovelControlador.this.atualizarObjeto();
			getPanelPesquisaImovel().pesquisarRegistroImovel(imovel);
			MainControlador.mostrarFrame(MainControlador.getFramePesquisaImovel());
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
				String nomeProprietario = getPanelCadastroImovel().getTextFieldNomeProprietario().getText();
				if (nomeProprietario == null || nomeProprietario.length() == 0) {
					getPanelCadastroImovel().getTextFieldNomeProprietario().requestFocus();
					Msg.avisoCampoObrigatorio("NomeFantasia");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					ImovelControlador.this.atualizarObjeto();
					ImovelDaoFacade.salvarRegistro(imovel);
					imovel = new Imovel();
					getFrameCadastroImovel().limparGui();
					getPanelCadastroImovel().getTextFieldNomeProprietario().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroInserirRegistro();
			}
		}
	}

	private Imovel imovel;

	public void atualizarGui() {
		if (imovel == null) {
			return;
		}
		getPanelCadastroImovel().getTextFieldNomeProprietario().setText(imovel.getNomeProprietario());
		getPanelCadastroImovel().getTextFieldCozinha().setText(imovel.getCozinha());
		getPanelCadastroImovel().getTextFieldSala().setText(imovel.getSala());
		getPanelCadastroImovel().getTextFieldQuarto().setText(imovel.getQuarto());
		getPanelCadastroImovel().getTextFieldEmail().setText(imovel.getEmail());
		getPanelCadastroImovel().getTextFieldFax().setText(imovel.getFax());
		getPanelCadastroImovel().getTextFieldFone1().setText(imovel.getFone1());
		getPanelCadastroImovel().getTextFieldFone2().setText(imovel.getFone2());
		getPanelCadastroImovel().getTextFieldBanheiro().setText(imovel.getBanheiro());
		getPanelCadastroImovel().getTextFieldSuite().setText(imovel.getSuite());
		getPanelCadastroImovel().getTextFieldVaranda().setText(imovel.getVaranda());
		getPanelCadastroImovel().getBoxTerraco().setSelectedItem(imovel.getTerracao());
		getPanelCadastroImovel().getTextFieldBairro().setText(imovel.getBairro());
		getPanelCadastroImovel().getTextFieldCep().setText(imovel.getCep());
		getPanelCadastroImovel().getTextFieldCidade().setText(imovel.getCidade());
		getPanelCadastroImovel().getTextFieldComplemento().setText(imovel.getComplemento());
		getPanelCadastroImovel().getTextFieldEstado().setText(imovel.getEstado());
		getPanelCadastroImovel().getTextFieldLogradouro().setText(imovel.getLogradouro());
		getPanelCadastroImovel().getTextFieldPais().setText(imovel.getPais());
		getPanelCadastroImovel().getTextFieldCNPJ().setText(imovel.getCnpj());
		getPanelCadastroImovel().getTextFieldCPF().setText(imovel.getCpfNumero());
		getPanelCadastroImovel().getBoxGaragem().setSelectedItem(imovel.getGaragem());
		getPanelCadastroImovel().getBoxPiscina().setSelectedItem(imovel.getPiscina());
	}

	public void atualizarObjeto() {
		imovel.setNomeProprietario(getPanelCadastroImovel().getTextFieldNomeProprietario().getText());
		imovel.setCozinha(getPanelCadastroImovel().getTextFieldCozinha().getText());
		imovel.setSala(getPanelCadastroImovel().getTextFieldSala().getText());
		imovel.setQuarto(getPanelCadastroImovel().getTextFieldQuarto().getText());
		imovel.setEmail(getPanelCadastroImovel().getTextFieldEmail().getText());
		imovel.setFax(getPanelCadastroImovel().getTextFieldFax().getText());
		imovel.setFone1(getPanelCadastroImovel().getTextFieldFone1().getText());
		imovel.setFone2(getPanelCadastroImovel().getTextFieldFone2().getText());
		imovel.setBanheiro(getPanelCadastroImovel().getTextFieldBanheiro().getText());
		imovel.setSuite(getPanelCadastroImovel().getTextFieldSuite().getText());
		imovel.setVaranda(getPanelCadastroImovel().getTextFieldVaranda().getText());
		imovel.setTerraco((String) getPanelCadastroImovel().getBoxTerraco().getSelectedItem());
		imovel.setBairro(getPanelCadastroImovel().getTextFieldBairro().getText());
		imovel.setCep(getPanelCadastroImovel().getTextFieldCep().getText());
		imovel.setCidade(getPanelCadastroImovel().getTextFieldCidade().getText());
		imovel.setComplemento(getPanelCadastroImovel().getTextFieldComplemento().getText());
		imovel.setEstado(getPanelCadastroImovel().getTextFieldEstado().getText());
		imovel.setLogradouro(getPanelCadastroImovel().getTextFieldLogradouro().getText());
		imovel.setPais(getPanelCadastroImovel().getTextFieldPais().getText());
		imovel.setCnpj(getPanelCadastroImovel().getTextFieldCNPJ().getText());
		imovel.setCpfNumero(getPanelCadastroImovel().getTextFieldCPF().getText());
		imovel.setGaragem((String) getPanelCadastroImovel().getBoxGaragem().getSelectedItem());
		imovel.setPiscina((String) getPanelCadastroImovel().getBoxPiscina().getSelectedItem());
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public FCImovel getFrameCadastroImovel() {
		return MainControlador.getFrameCadastroImovel();
	}

	public PCImovel getPanelCadastroImovel() {
		return MainControlador.getFrameCadastroImovel().getPanelCadastroImovel();
	}

	public FPImovel getFramePesquisaImovel() {
		return MainControlador.getFramePesquisaImovel();
	}

	public PPImovel getPanelPesquisaImovel() {
		return MainControlador.getFramePesquisaImovel().getPanelPesquisaImovel();
	}
}

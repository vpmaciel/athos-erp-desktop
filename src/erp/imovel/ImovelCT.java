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
import erp.main.MainCT;

final class ImovelCT {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (imovel == null || imovel.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				ImovelFAC.deletarRegistro(imovel);
				getImovelFC().limparGUI();
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
				getImovelFC().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getImovelFC().reiniciarGUI();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getImovelFC().setVisible(false);
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
				MainCT.mostrarFrame(MainCT.getFrameMain());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Imovel> imoveis = new LinkedList<>();

			if (imovel.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (imoveis.add(ImovelFAC.getRegistro(imovel))) {
					ImovelREL imovelREL = new ImovelREL(imoveis);
					imovelREL.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Imovel> imoveis = new LinkedList<>();

			try {
				imoveis = new LinkedList<>(ImovelFAC.pesquisarRegistro(imovel));
			} catch (Exception e) {
				System.out.println(e);
			}
			ImovelREL imovelREL = new ImovelREL(imoveis);
			imovelREL.retornarRelatorio(true);
		}
	}

	public class MostraFrameImovel extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainCT.mostrarFrame(MainCT.getImovelFC());
			} else {
				getImovelFC().reiniciarGUI();
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			imovel = new Imovel();
			getImovelFC().limparGUI();
			getImovelPC().getNomeProprietarioGUI().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			imovel = new Imovel();
			ImovelCT.this.atualizarObjeto();
			getImovelPP().pesquisarRegistroImovel(imovel);
			MainCT.mostrarFrame(MainCT.getImovelFP());
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
				String nomeProprietario = getImovelPC().getNomeProprietarioGUI().getText();
				if (nomeProprietario == null || nomeProprietario.length() == 0) {
					getImovelPC().getNomeProprietarioGUI().requestFocus();
					Msg.avisoCampoObrigatorio("NomeFantasia");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					ImovelCT.this.atualizarObjeto();
					ImovelFAC.salvarRegistro(imovel);
					imovel = new Imovel();
					getImovelFC().limparGUI();
					getImovelPC().getNomeProprietarioGUI().requestFocus();
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
		getImovelPC().getNomeProprietarioGUI().setText(imovel.getNomeProprietario());
		getImovelPC().getCozinhaGUI().setText(imovel.getCozinha());
		getImovelPC().getSalaGUI().setText(imovel.getSala());
		getImovelPC().getQuartoGUI().setText(imovel.getQuarto());
		getImovelPC().getEmailGUI().setText(imovel.getEmail());
		getImovelPC().getFaxGUI().setText(imovel.getFax());
		getImovelPC().getFone1GUI().setText(imovel.getFone1());
		getImovelPC().getFone2GUI().setText(imovel.getFone2());
		getImovelPC().getBanheiroGUI().setText(imovel.getBanheiro());
		getImovelPC().getSuiteGUI().setText(imovel.getSuite());
		getImovelPC().getVarandaGUI().setText(imovel.getVaranda());
		getImovelPC().getTerracoGUI().setSelectedItem(imovel.getTerracao());
		getImovelPC().getBairroGUI().setText(imovel.getBairro());
		getImovelPC().getCepGUI().setText(imovel.getCep());
		getImovelPC().getCidadeGUI().setText(imovel.getCidade());
		getImovelPC().getComplementoGUI().setText(imovel.getComplemento());
		getImovelPC().getEstadoGUI().setText(imovel.getEstado());
		getImovelPC().getLogradouroGUI().setText(imovel.getLogradouro());
		getImovelPC().getPaisGUI().setText(imovel.getPais());
		getImovelPC().getCnpjGUI().setText(imovel.getCnpj());
		getImovelPC().getCpfGUI().setText(imovel.getCpfNumero());
		getImovelPC().getGaragemGUI().setSelectedItem(imovel.getGaragem());
		getImovelPC().getPiscinaGUI().setSelectedItem(imovel.getPiscina());
	}

	public void atualizarObjeto() {
		imovel.setNomeProprietario(getImovelPC().getNomeProprietarioGUI().getText());
		imovel.setCozinha(getImovelPC().getCozinhaGUI().getText());
		imovel.setSala(getImovelPC().getSalaGUI().getText());
		imovel.setQuarto(getImovelPC().getQuartoGUI().getText());
		imovel.setEmail(getImovelPC().getEmailGUI().getText());
		imovel.setFax(getImovelPC().getFaxGUI().getText());
		imovel.setFone1(getImovelPC().getFone1GUI().getText());
		imovel.setFone2(getImovelPC().getFone2GUI().getText());
		imovel.setBanheiro(getImovelPC().getBanheiroGUI().getText());
		imovel.setSuite(getImovelPC().getSuiteGUI().getText());
		imovel.setVaranda(getImovelPC().getVarandaGUI().getText());
		imovel.setTerraco((String) getImovelPC().getTerracoGUI().getSelectedItem());
		imovel.setBairro(getImovelPC().getBairroGUI().getText());
		imovel.setCep(getImovelPC().getCepGUI().getText());
		imovel.setCidade(getImovelPC().getCidadeGUI().getText());
		imovel.setComplemento(getImovelPC().getComplementoGUI().getText());
		imovel.setEstado(getImovelPC().getEstadoGUI().getText());
		imovel.setLogradouro(getImovelPC().getLogradouroGUI().getText());
		imovel.setPais(getImovelPC().getPaisGUI().getText());
		imovel.setCnpj(getImovelPC().getCnpjGUI().getText());
		imovel.setCpfNumero(getImovelPC().getCpfGUI().getText());
		imovel.setGaragem((String) getImovelPC().getGaragemGUI().getSelectedItem());
		imovel.setPiscina((String) getImovelPC().getPiscinaGUI().getSelectedItem());
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public ImovelFC getImovelFC() {
		return MainCT.getImovelFC();
	}

	public ImovelPC getImovelPC() {
		return MainCT.getImovelFC().getImovelPC();
	}

	public ImovelFP getImovelFP() {
		return MainCT.getImovelFP();
	}

	public ImovelPP getImovelPP() {
		return MainCT.getImovelFP().getImovelPP();
	}
}

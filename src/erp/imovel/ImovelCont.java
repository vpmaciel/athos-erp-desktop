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
import erp.main.MainCont;

final class ImovelCont {

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
				ImovelFac.deletarRegistro(imovel);
				getImovelFc().limparGUI();
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
				getImovelFc().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getImovelFc().reiniciarGUI();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getImovelFc().setVisible(false);
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
				MainCont.mostrarFrame(MainCont.getFrameMain());
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
				if (imoveis.add(ImovelFac.getRegistro(imovel))) {
					ImovelRel imovelRel = new ImovelRel(imoveis);
					imovelRel.retornarRelatorio(true);
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
				imoveis = new LinkedList<>(ImovelFac.pesquisarRegistro(imovel));
			} catch (Exception e) {
				System.out.println(e);
			}
			ImovelRel imovelRel = new ImovelRel(imoveis);
			imovelRel.retornarRelatorio(true);
		}
	}

	public class MostraFrameImovel extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainCont.mostrarFrame(MainCont.getImovelFc());
			} else {
				getImovelFc().reiniciarGUI();
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			imovel = new Imovel();
			getImovelFc().limparGUI();
			getImovelPc().getNomeProprietarioGUI().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			imovel = new Imovel();
			ImovelCont.this.atualizarObjeto();
			getImovelPp().pesquisarRegistroImovel(imovel);
			MainCont.mostrarFrame(MainCont.getImovelFp());
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
				String nomeProprietario = getImovelPc().getNomeProprietarioGUI().getText();
				if (nomeProprietario == null || nomeProprietario.length() == 0) {
					getImovelPc().getNomeProprietarioGUI().requestFocus();
					Msg.avisoCampoObrigatorio("NomeFantasia");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					ImovelCont.this.atualizarObjeto();
					ImovelFac.salvarRegistro(imovel);
					imovel = new Imovel();
					getImovelFc().limparGUI();
					getImovelPc().getNomeProprietarioGUI().requestFocus();
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
		getImovelPc().getNomeProprietarioGUI().setText(imovel.getNomeProprietario());
		getImovelPc().getCozinhaGUI().setText(imovel.getCozinha());
		getImovelPc().getSalaGUI().setText(imovel.getSala());
		getImovelPc().getQuartoGUI().setText(imovel.getQuarto());
		getImovelPc().getEmailGUI().setText(imovel.getEmail());
		getImovelPc().getFaxGUI().setText(imovel.getFax());
		getImovelPc().getFone1GUI().setText(imovel.getFone1());
		getImovelPc().getFone2GUI().setText(imovel.getFone2());
		getImovelPc().getBanheiroGUI().setText(imovel.getBanheiro());
		getImovelPc().getSuiteGUI().setText(imovel.getSuite());
		getImovelPc().getVarandaGUI().setText(imovel.getVaranda());
		getImovelPc().getTerracoGUI().setSelectedItem(imovel.getTerracao());
		getImovelPc().getBairroGUI().setText(imovel.getBairro());
		getImovelPc().getCepGUI().setText(imovel.getCep());
		getImovelPc().getCidadeGUI().setText(imovel.getCidade());
		getImovelPc().getComplementoGUI().setText(imovel.getComplemento());
		getImovelPc().getEstadoGUI().setText(imovel.getEstado());
		getImovelPc().getLogradouroGUI().setText(imovel.getLogradouro());
		getImovelPc().getPaisGUI().setText(imovel.getPais());
		getImovelPc().getCnpjGUI().setText(imovel.getCnpj());
		getImovelPc().getCpfGUI().setText(imovel.getCpfNumero());
		getImovelPc().getGaragemGUI().setSelectedItem(imovel.getGaragem());
		getImovelPc().getPiscinaGUI().setSelectedItem(imovel.getPiscina());
	}

	public void atualizarObjeto() {
		imovel.setNomeProprietario(getImovelPc().getNomeProprietarioGUI().getText());
		imovel.setCozinha(getImovelPc().getCozinhaGUI().getText());
		imovel.setSala(getImovelPc().getSalaGUI().getText());
		imovel.setQuarto(getImovelPc().getQuartoGUI().getText());
		imovel.setEmail(getImovelPc().getEmailGUI().getText());
		imovel.setFax(getImovelPc().getFaxGUI().getText());
		imovel.setFone1(getImovelPc().getFone1GUI().getText());
		imovel.setFone2(getImovelPc().getFone2GUI().getText());
		imovel.setBanheiro(getImovelPc().getBanheiroGUI().getText());
		imovel.setSuite(getImovelPc().getSuiteGUI().getText());
		imovel.setVaranda(getImovelPc().getVarandaGUI().getText());
		imovel.setTerraco((String) getImovelPc().getTerracoGUI().getSelectedItem());
		imovel.setBairro(getImovelPc().getBairroGUI().getText());
		imovel.setCep(getImovelPc().getCepGUI().getText());
		imovel.setCidade(getImovelPc().getCidadeGUI().getText());
		imovel.setComplemento(getImovelPc().getComplementoGUI().getText());
		imovel.setEstado(getImovelPc().getEstadoGUI().getText());
		imovel.setLogradouro(getImovelPc().getLogradouroGUI().getText());
		imovel.setPais(getImovelPc().getPaisGUI().getText());
		imovel.setCnpj(getImovelPc().getCnpjGUI().getText());
		imovel.setCpfNumero(getImovelPc().getCpfGUI().getText());
		imovel.setGaragem((String) getImovelPc().getGaragemGUI().getSelectedItem());
		imovel.setPiscina((String) getImovelPc().getPiscinaGUI().getSelectedItem());
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public ImovelFc getImovelFc() {
		return MainCont.getImovelFc();
	}

	public ImovelPc getImovelPc() {
		return MainCont.getImovelFc().getImovelPc();
	}

	public ImovelFp getImovelFpp() {
		return MainCont.getImovelFp();
	}

	public ImovelPp getImovelPp() {
		return MainCont.getImovelFp().getImovelPp();
	}
}

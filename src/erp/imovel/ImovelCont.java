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
				getImovelFc().limparGui();
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
			getImovelFc().reiniciarGui();
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
				MainCont.mostrarFrame(MainCont.getMainFc());
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
				getImovelFc().reiniciarGui();
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			imovel = new Imovel();
			getImovelFc().limparGui();
			getImovelPc().getNomeProprietarioGui().requestFocus();
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
				String nomeProprietario = getImovelPc().getNomeProprietarioGui().getText();
				if (nomeProprietario == null || nomeProprietario.length() == 0) {
					getImovelPc().getNomeProprietarioGui().requestFocus();
					Msg.avisoCampoObrigatorio("NomeFantasia");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					ImovelCont.this.atualizarObjeto();
					ImovelFac.salvarRegistro(imovel);
					imovel = new Imovel();
					getImovelFc().limparGui();
					getImovelPc().getNomeProprietarioGui().requestFocus();
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
		getImovelPc().getNomeProprietarioGui().setText(imovel.getNomeProprietario());
		getImovelPc().getCozinhaGui().setText(imovel.getCozinha());
		getImovelPc().getSalaGui().setText(imovel.getSala());
		getImovelPc().getQuartoGui().setText(imovel.getQuarto());
		getImovelPc().getEmailGui().setText(imovel.getEmail());
		getImovelPc().getFaxGui().setText(imovel.getFax());
		getImovelPc().getFone1Gui().setText(imovel.getFone1());
		getImovelPc().getFone2Gui().setText(imovel.getFone2());
		getImovelPc().getBanheiroGui().setText(imovel.getBanheiro());
		getImovelPc().getSuiteGui().setText(imovel.getSuite());
		getImovelPc().getVarandaGui().setText(imovel.getVaranda());
		getImovelPc().getTerracoGui().setSelectedItem(imovel.getTerracao());
		getImovelPc().getBairroGui().setText(imovel.getBairro());
		getImovelPc().getCepGui().setText(imovel.getCep());
		getImovelPc().getCidadeGui().setText(imovel.getCidade());
		getImovelPc().getComplementoGui().setText(imovel.getComplemento());
		getImovelPc().getEstadoGui().setText(imovel.getEstado());
		getImovelPc().getLogradouroGui().setText(imovel.getLogradouro());
		getImovelPc().getPaisGui().setText(imovel.getPais());
		getImovelPc().getCnpjGui().setText(imovel.getCnpj());
		getImovelPc().getCpfGui().setText(imovel.getCpfNumero());
		getImovelPc().getGaragemGui().setSelectedItem(imovel.getGaragem());
		getImovelPc().getPiscinaGui().setSelectedItem(imovel.getPiscina());
	}

	public void atualizarObjeto() {
		imovel.setNomeProprietario(getImovelPc().getNomeProprietarioGui().getText());
		imovel.setCozinha(getImovelPc().getCozinhaGui().getText());
		imovel.setSala(getImovelPc().getSalaGui().getText());
		imovel.setQuarto(getImovelPc().getQuartoGui().getText());
		imovel.setEmail(getImovelPc().getEmailGui().getText());
		imovel.setFax(getImovelPc().getFaxGui().getText());
		imovel.setFone1(getImovelPc().getFone1Gui().getText());
		imovel.setFone2(getImovelPc().getFone2Gui().getText());
		imovel.setBanheiro(getImovelPc().getBanheiroGui().getText());
		imovel.setSuite(getImovelPc().getSuiteGui().getText());
		imovel.setVaranda(getImovelPc().getVarandaGui().getText());
		imovel.setTerraco((String) getImovelPc().getTerracoGui().getSelectedItem());
		imovel.setBairro(getImovelPc().getBairroGui().getText());
		imovel.setCep(getImovelPc().getCepGui().getText());
		imovel.setCidade(getImovelPc().getCidadeGui().getText());
		imovel.setComplemento(getImovelPc().getComplementoGui().getText());
		imovel.setEstado(getImovelPc().getEstadoGui().getText());
		imovel.setLogradouro(getImovelPc().getLogradouroGui().getText());
		imovel.setPais(getImovelPc().getPaisGui().getText());
		imovel.setCnpj(getImovelPc().getCnpjGui().getText());
		imovel.setCpfNumero(getImovelPc().getCpfGui().getText());
		imovel.setGaragem((String) getImovelPc().getGaragemGui().getSelectedItem());
		imovel.setPiscina((String) getImovelPc().getPiscinaGui().getSelectedItem());
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

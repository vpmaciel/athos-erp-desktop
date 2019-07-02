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
import erp.main.MainControl;

final class ImovelControl {

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
				e.printStackTrace();
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
				MainControl.mostrarFrame(MainControl.getMainFc());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Imovel> imovels = new LinkedList<>();

			if (imovel.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (imovels.add(ImovelFac.getRegistro(imovel))) {
				ImovelRel imovelRel = new ImovelRel(imovels);
				imovelRel.retornarRelatorio(true);
			}
		}
	}

	public class MostraFrameImovel extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainControl.mostrarFrame(MainControl.getImovelFc());
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
			getImovelPc().getGuiNomeProprietario().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getImovelPp().pesquisarRegistro(imovel);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainControl.mostrarFrame(getImovelFp());
				getImovelFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Registro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getImovelPp().pesquisarRegistro(new Imovel());
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainControl.mostrarFrame(getImovelFp());
				getImovelFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Imovel> imovels = new LinkedList<>();

			try {
				imovels = new LinkedList<>(ImovelFac.pesquisarRegistro(new Imovel()));
			} catch (Exception e) {
				e.printStackTrace();
			}

			ImovelRel imovelRel = new ImovelRel(imovels);
			imovelRel.retornarRelatorio(true);

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
				e.printStackTrace();
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
				String nomeProprietario = getImovelPc().getGuiNomeProprietario().getText();
				if (nomeProprietario == null || nomeProprietario.length() == 0) {
					getImovelPc().getGuiNomeProprietario().requestFocus();
					Msg.avisoCampoObrigatorio("NomeFantasia");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					ImovelControl.this.atualizarObjeto();
					ImovelFac.salvarRegistro(imovel);
					imovel = new Imovel();
					getImovelFc().limparGui();
					getImovelPc().getGuiNomeProprietario().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Msg.erroSalvarRegistro();
			}
		}
	}

	private Imovel imovel;

	public void atualizarGui() {
		if (imovel == null) {
			return;
		}
		getImovelPc().getGuiNomeProprietario().setText(imovel.getNomeProprietario());
		getImovelPc().getGuiCozinha().setText(imovel.getCozinha());
		getImovelPc().getGuiSala().setText(imovel.getSala());
		getImovelPc().getGuiQuarto().setText(imovel.getQuarto());
		getImovelPc().getGuiEmail().setText(imovel.getEmail());
		getImovelPc().getGuiFax().setText(imovel.getFax());
		getImovelPc().getGuiFone1().setText(imovel.getFone1());
		getImovelPc().getGuiFone2().setText(imovel.getFone2());
		getImovelPc().getGuiBanheiro().setText(imovel.getBanheiro());
		getImovelPc().getGuiSuite().setText(imovel.getSuite());
		getImovelPc().getGuiVaranda().setText(imovel.getVaranda());
		getImovelPc().getGuiTerraco().setSelectedItem(imovel.getTerraco());
		getImovelPc().getGuiBairro().setText(imovel.getEnderecoBairro());
		getImovelPc().getGuiCep().setText(imovel.getEnderecoCep());
		getImovelPc().getGuiCidade().setText(imovel.getEnderecoCidade());
		getImovelPc().getGuiComplemento().setText(imovel.getEnderecoComplemento());
		getImovelPc().getGuiEstado().setText(imovel.getEnderecoEstado());
		getImovelPc().getGuiLogradouro().setText(imovel.getEnderecoLogradouro());
		getImovelPc().getGuiPais().setText(imovel.getPais());
		getImovelPc().getGuiCnpj().setText(imovel.getCnpj());
		getImovelPc().getGuiCpf().setText(imovel.getCpf());
		getImovelPc().getGuiGaragem().setSelectedItem(imovel.getGaragem());
		getImovelPc().getGuiPiscina().setSelectedItem(imovel.getPiscina());
	}

	public void atualizarObjeto() {
		imovel.setNomeProprietario(getImovelPc().getGuiNomeProprietario().getText());
		imovel.setCozinha(getImovelPc().getGuiCozinha().getText());
		imovel.setSala(getImovelPc().getGuiSala().getText());
		imovel.setQuarto(getImovelPc().getGuiQuarto().getText());
		imovel.setEmail(getImovelPc().getGuiEmail().getText());
		imovel.setFax(getImovelPc().getGuiFax().getText());
		imovel.setFone1(getImovelPc().getGuiFone1().getText());
		imovel.setFone2(getImovelPc().getGuiFone2().getText());
		imovel.setBanheiro(getImovelPc().getGuiBanheiro().getText());
		imovel.setSuite(getImovelPc().getGuiSuite().getText());
		imovel.setVaranda(getImovelPc().getGuiVaranda().getText());
		imovel.setTerraco((String) getImovelPc().getGuiTerraco().getSelectedItem());
		imovel.setEnderecoBairro(getImovelPc().getGuiBairro().getText());
		imovel.setEnderecoCep(getImovelPc().getGuiCep().getText());
		imovel.setEnderecoCidade(getImovelPc().getGuiCidade().getText());
		imovel.setEnderecoComplemento(getImovelPc().getGuiComplemento().getText());
		imovel.setEnderecoEstado(getImovelPc().getGuiEstado().getText());
		imovel.setEnderecoLogradouro(getImovelPc().getGuiLogradouro().getText());
		imovel.setPais(getImovelPc().getGuiPais().getText());
		imovel.setCnpj(getImovelPc().getGuiCnpj().getText());
		imovel.setCpf(getImovelPc().getGuiCpf().getText());
		imovel.setGaragem((String) getImovelPc().getGuiGaragem().getSelectedItem());
		imovel.setPiscina((String) getImovelPc().getGuiPiscina().getSelectedItem());
	}

	public Imovel getImovel() {
		return imovel;
	}

	public ImovelFc getImovelFc() {
		return MainControl.getImovelFc();
	}

	public ImovelFp getImovelFp() {
		return MainControl.getImovelFp();
	}

	public ImovelPc getImovelPc() {
		return MainControl.getImovelFc().getImovelPc();
	}

	public ImovelPp getImovelPp() {
		return MainControl.getImovelFp().getImovelPp();
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
}

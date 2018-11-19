package erp.agenda.evento.tipoevento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import erp.aop.gui.Msg;
import erp.empresa.Empresa;
import erp.main.MainGerenteEventos;
import erp.main.PanelSobre;

final class TipoEventoGerenteEventos {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class ExcluiRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (tipoEvento == null || tipoEvento.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				TipoEventoDaoFacade.deletarRegistro(tipoEvento);
				getFrameCadastroTipoEvento().limparGui();
				tipoEvento = new TipoEvento();
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
				getFrameCadastroTipoEvento().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFrameCadastroTipoEvento().reiniciarBox();
			atualizarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFrameCadastroTipoEvento().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			tipoEvento = new TipoEvento();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameMain());
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class ImprimiTodosRegistros implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<TipoEvento> tipoEventos = new LinkedList<>();

			if (tipoEvento.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (tipoEventos.add(TipoEventoDaoFacade.getRegistro(tipoEvento))) {
					TipoEventoRelatorio tipoEventoRelatorio = new TipoEventoRelatorio(tipoEventos);
					tipoEventoRelatorio.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}

	public class ImprimiUnicoRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<TipoEvento> tipoEventos = new LinkedList<>();

			try {
				tipoEventos = new LinkedList<>(TipoEventoDaoFacade.pesquisarRegistro(tipoEvento));
			} catch (Exception e) {
				System.out.println(e);
			}
			TipoEventoRelatorio tipoEventoRelatorio = new TipoEventoRelatorio(tipoEventos);
			tipoEventoRelatorio.retornarRelatorio(true);
		}
	}

	public class MostraFrameEmpresa extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getButton() == MouseEvent.BUTTON1) {
				MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFrameCadastroEmpresa());
			} else {
				MainGerenteEventos.getFrameCadastroEmpresa().reiniciarBox();
			}
		}
	}

	public class NovoFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			tipoEvento = new TipoEvento();
			MainGerenteEventos.getFrameCadastroAgenda().limparGui();
			getPanelCadastroTipoEvento().getTextFieldNome().requestFocus();
		}
	}

	public class PesquisaRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			tipoEvento = new TipoEvento();
			atualizarObjeto();
			getPanelPesquisaTipoEvento().pesquisarRegistroAgenda(tipoEvento);
			MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFramePesquisaAgenda());
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
				String nome = getPanelCadastroTipoEvento().getTextFieldNome().getText();
				if (nome == null || nome.length() == 0) {
					getPanelCadastroTipoEvento().getTextFieldNome().requestFocus();
					Msg.avisoCampoObrigatorio("Nome");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					TipoEventoDaoFacade.salvarRegistro(tipoEvento);
					tipoEvento = new TipoEvento();
					MainGerenteEventos.getFrameCadastroAgenda().limparGui();
					getPanelCadastroTipoEvento().getTextFieldNome().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				e.printStackTrace();
				Msg.erroInserirRegistro();
			}
		}
	}

	private TipoEvento tipoEvento;

	public void atualizarGui() {
		if (tipoEvento == null) {
			return;
		}
		getPanelCadastroTipoEvento().getTextFieldNome().setText(tipoEvento.getNome());
		getPanelCadastroTipoEvento().getTextFieldSexo().setSelectedItem(tipoEvento.getSexo());
		getPanelCadastroTipoEvento().getTextFieldEmail().setText(tipoEvento.getEmail());
		getPanelCadastroTipoEvento().getTextFieldFax().setText(tipoEvento.getFax());
		getPanelCadastroTipoEvento().getTextFieldFone1().setText(tipoEvento.getFone1());
		getPanelCadastroTipoEvento().getTextFieldFone2().setText(tipoEvento.getFone2());
		getPanelCadastroTipoEvento().getBoxEmpresa().setSelectedItem(tipoEvento.getEmpresa());
		getPanelCadastroTipoEvento().getTextFieldBairro().setText(tipoEvento.getBairro());
		getPanelCadastroTipoEvento().getTextFieldCep().setText(tipoEvento.getCep());
		getPanelCadastroTipoEvento().getTextFieldCidade().setText(tipoEvento.getCidade());
		getPanelCadastroTipoEvento().getTextFieldComplemento().setText(tipoEvento.getComplemento());
		getPanelCadastroTipoEvento().getTextFieldEstado().setText(tipoEvento.getEstado());
		getPanelCadastroTipoEvento().getTextFieldLogradouro().setText(tipoEvento.getLogradouro());
		getPanelCadastroTipoEvento().getTextFieldPais().setText(tipoEvento.getPais());
		getPanelCadastroTipoEvento().getTextFieldCNPJ().setText(tipoEvento.getCnpj());
		getPanelCadastroTipoEvento().getTextFieldCPF().setText(tipoEvento.getCpfNumero());
	}

	public void atualizarObjeto() {
		tipoEvento.setNome(getPanelCadastroTipoEvento().getTextFieldNome().getText());
		tipoEvento.setSexo((String) getPanelCadastroTipoEvento().getTextFieldSexo().getSelectedItem());
		tipoEvento.setEmail(getPanelCadastroTipoEvento().getTextFieldEmail().getText());
		tipoEvento.setFax(getPanelCadastroTipoEvento().getTextFieldFax().getText());
		tipoEvento.setFone1(getPanelCadastroTipoEvento().getTextFieldFone1().getText());
		tipoEvento.setFone2(getPanelCadastroTipoEvento().getTextFieldFone2().getText());
		tipoEvento.setEmpresa((Empresa) getPanelCadastroTipoEvento().getBoxEmpresa().getSelectedItem());
		tipoEvento.setBairro(getPanelCadastroTipoEvento().getTextFieldBairro().getText());
		tipoEvento.setCep(getPanelCadastroTipoEvento().getTextFieldCep().getText());
		tipoEvento.setCidade(getPanelCadastroTipoEvento().getTextFieldCidade().getText());
		tipoEvento.setComplemento(getPanelCadastroTipoEvento().getTextFieldComplemento().getText());
		tipoEvento.setEstado(getPanelCadastroTipoEvento().getTextFieldEstado().getText());
		tipoEvento.setLogradouro(getPanelCadastroTipoEvento().getTextFieldLogradouro().getText());
		tipoEvento.setPais(getPanelCadastroTipoEvento().getTextFieldPais().getText());
		tipoEvento.setCnpj(getPanelCadastroTipoEvento().getTextFieldCNPJ().getText());
		tipoEvento.setCpfNumero(getPanelCadastroTipoEvento().getTextFieldCPF().getText());
	}

	public TipoEvento getEvento() {
		return tipoEvento;
	}

	public void setAgenda(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	
	public FrameCadastroTipoEvento getFrameCadastroTipoEvento() {
		return MainGerenteEventos.getFrameCadastroTipoEvento();
	}
	
	public PanelCadastroTipoEvento getPanelCadastroTipoEvento() {
		return MainGerenteEventos.getFrameCadastroTipoEvento().getPanelCadastroTipoEvento();
	}
	
	public FramePesquisaTipoEvento getFramePesquisaTipoEvento() {
		return MainGerenteEventos.getFramePesquisaTipoEvento();
	}

	public PanelPesquisaTipoEvento getPanelPesquisaTipoEvento() {
		return MainGerenteEventos.getFramePesquisaTipoEvento().getPanelPesquisaTipoEvento();
	}
}

package erp.agenda.recado;

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

final class RecadoGerenteEventos {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				JOptionPane.showMessageDialog(MainGerenteEventos.getFrameMain(), new PanelSobre(), "Sobre o Sistema", -1);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class ExcluiRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (recado == null || recado.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				RecadoDaoFacade.deletarRegistro(recado);
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
				getFrameCadastroRecado().setVisible(false);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getFrameCadastroRecado().reiniciarBox();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getFrameCadastroRecado().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			recado = new Recado();
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
			List<Recado> recados = new LinkedList<>();

			if (recado.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}

			try {
				if (recados.add(RecadoDaoFacade.getRegistro(recado))) {
					RecadoRelatorio recadoRelatorio = new RecadoRelatorio(recados);
					recadoRelatorio.retornarRelatorio(true);
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}

	public class ImprimiUnicoRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Recado> recados = new LinkedList<>();

			try {
				recados = new LinkedList<>(RecadoDaoFacade.pesquisarRegistro(recado));
			} catch (Exception e) {
				System.out.println(e);
			}
			RecadoRelatorio recadoRelatorio = new RecadoRelatorio(recados);
			recadoRelatorio.retornarRelatorio(true);
		}
	}

	public class MostraFrameRecado extends MouseAdapter {

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
			recado = new Recado();
			getFrameCadastroRecado().limparGui();
			getPanelCadastroRecado().getTextFieldNome().requestFocus();
		}
	}

	public class PesquisaRegistro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			recado = new Recado();
			atualizarObjeto();
			getPanelPesquisaRecado().pesquisarRegistroRecado(recado);
			MainGerenteEventos.mostrarFrame(MainGerenteEventos.getFramePesquisaRecado());
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
				String nome = getPanelCadastroRecado().getTextFieldNome().getText();
				if (nome == null || nome.length() == 0) {
					getPanelCadastroRecado().getTextFieldNome().requestFocus();
					Msg.avisoCampoObrigatorio("Nome");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					RecadoDaoFacade.salvarRegistro(recado);
					recado = new Recado();
					MainGerenteEventos.getFrameCadastroRecado().limparGui();
					getPanelCadastroRecado().getTextFieldNome().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				e.printStackTrace();
				Msg.erroInserirRegistro();
			}
		}
	}

	private Recado recado;

	public void atualizarGui() {
		if (recado == null) {
			return;
		}
		getPanelCadastroRecado().getTextFieldNome().setText(recado.getNome());
		getPanelCadastroRecado().getTextFieldSexo().setSelectedItem(recado.getSexo());
		getPanelCadastroRecado().getTextFieldEmail().setText(recado.getEmail());
		getPanelCadastroRecado().getTextFieldFax().setText(recado.getFax());
		getPanelCadastroRecado().getTextFieldFone1().setText(recado.getFone1());
		getPanelCadastroRecado().getTextFieldFone2().setText(recado.getFone2());
		getPanelCadastroRecado().getBoxEmpresa().setSelectedItem(recado.getEmpresa());
		getPanelCadastroRecado().getTextFieldBairro().setText(recado.getBairro());
		getPanelCadastroRecado().getTextFieldCep().setText(recado.getCep());
		getPanelCadastroRecado().getTextFieldCidade().setText(recado.getCidade());
		getPanelCadastroRecado().getTextFieldComplemento().setText(recado.getComplemento());
		getPanelCadastroRecado().getTextFieldEstado().setText(recado.getEstado());
		getPanelCadastroRecado().getTextFieldLogradouro().setText(recado.getLogradouro());
		getPanelCadastroRecado().getTextFieldPais().setText(recado.getPais());
		getPanelCadastroRecado().getTextFieldCNPJ().setText(recado.getCnpj());
		getPanelCadastroRecado().getTextFieldCPF().setText(recado.getCpfNumero());
	}

	public void atualizarObjeto() {
		recado.setNome(getPanelCadastroRecado().getTextFieldNome().getText());
		recado.setSexo((String) getPanelCadastroRecado().getTextFieldSexo().getSelectedItem());
		recado.setEmail(getPanelCadastroRecado().getTextFieldEmail().getText());
		recado.setFax(getPanelCadastroRecado().getTextFieldFax().getText());
		recado.setFone1(getPanelCadastroRecado().getTextFieldFone1().getText());
		recado.setFone2(getPanelCadastroRecado().getTextFieldFone2().getText());
		recado.setEmpresa((Empresa) getPanelCadastroRecado().getBoxEmpresa().getSelectedItem());
		recado.setBairro(getPanelCadastroRecado().getTextFieldBairro().getText());
		recado.setCep(getPanelCadastroRecado().getTextFieldCep().getText());
		recado.setCidade(getPanelCadastroRecado().getTextFieldCidade().getText());
		recado.setComplemento(getPanelCadastroRecado().getTextFieldComplemento().getText());
		recado.setEstado(getPanelCadastroRecado().getTextFieldEstado().getText());
		recado.setLogradouro(getPanelCadastroRecado().getTextFieldLogradouro().getText());
		recado.setPais(getPanelCadastroRecado().getTextFieldPais().getText());
		recado.setCnpj(getPanelCadastroRecado().getTextFieldCNPJ().getText());
		recado.setCpfNumero(getPanelCadastroRecado().getTextFieldCPF().getText());
	}

	public Recado getRecado() {
		return recado;
	}

	public void setRecado(Recado recado) {
		this.recado = recado;
	}
	
	public FrameCadastroRecado getFrameCadastroRecado() {
		return MainGerenteEventos.getFrameCadastroRecado();
	}
	
	public PanelCadastroRecado getPanelCadastroRecado() {
		return MainGerenteEventos.getFrameCadastroRecado().getPanelCadastroRecado();
	}
	
	public FramePesquisaRecado getFramePesquisaRecado() {
		return MainGerenteEventos.getFramePesquisaRecado();
	}

	public PanelPesquisaRecado getPanelPesquisaRecado() {
		return MainGerenteEventos.getFramePesquisaRecado().getPanelPesquisaRecado();
	}
}

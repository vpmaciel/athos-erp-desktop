package erp.veiculo;

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
import erp.centrocusto.CentroCusto;
import erp.main.MainCont;
import erp.veiculo.marca.VeiculoMarca;
import erp.veiculo.modelo.VeiculoModelo;

final class VeiculoCont {

	public class Ajuda implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			Msg.ajuda();
		}
	}

	public class MostraFrame extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getSource() == getVeiculoPc().getLabelCentroCusto()) {
				MainCont.mostrarFrame(MainCont.getCentroCustoFc());
			} else if (event.getSource() == getVeiculoPc().getLabelVeiculoMarca()) {
				MainCont.mostrarFrame(MainCont.getVeiculoMarcaFc());
			} else if (event.getSource() == getVeiculoPc().getLabelVeiculoModelo()) {
				MainCont.mostrarFrame(MainCont.getVeiculoModeloFc());
			} else {
				MainCont.getCentroCustoFc().reiniciarGui();
			}
		}
	}

	public class Exclui implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (veiculo == null || veiculo.getId() == null) {
				return;
			}
			if (Msg.confirmarExcluiRegistro() != JOptionPane.YES_OPTION) {
				return;
			}
			try {
				VeiculoFac.deletarRegistro(veiculo);
				getVeiculoFc().limparGui();
				veiculo = new Veiculo();
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
				getVeiculoFc().setVisible(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public class Frame extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			getVeiculoFc().reiniciarGui();
		}

		@Override
		public void windowClosing(WindowEvent e) {
			getVeiculoFc().setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			veiculo = new Veiculo();
			getVeiculoPc().getGuiPlaca().requestFocus();
		}
	}

	public class Home implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			try {
				MainCont.mostrarFrame(MainCont.getMainFc());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public class Imprime implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			List<Veiculo> veiculos = new LinkedList<>();

			if (veiculo.getId() == null) {
				Msg.avisoImprimiRegistroNaoCadastrado();
				return;
			}
			if (veiculos.add(VeiculoFac.getRegistro(veiculo))) {
				VeiculoRel veiculoRel = new VeiculoRel(veiculos);
				veiculoRel.retornarRelatorio(true);
			}
		}
	}

	public class Novo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			veiculo = new Veiculo();
			getVeiculoFc().limparGui();
			getVeiculoPc().getGuiPlaca().requestFocus();
		}
	}

	public class Pesquisa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			atualizarObjeto();
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getVeiculoPp().pesquisarRegistro(veiculo);
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getVeiculoFp());
				getVeiculoFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Registro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			long totalPesquisaRegistro = 0;
			totalPesquisaRegistro = getVeiculoPp().pesquisarRegistro(new Veiculo());
			Msg.avisoRegistroEncontrado(totalPesquisaRegistro);

			if (totalPesquisaRegistro > 0) {
				MainCont.mostrarFrame(getVeiculoFp());
				getVeiculoFp().setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			}
		}
	}

	public class Relatorio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			List<Veiculo> veiculos = new LinkedList<>();

			try {
				veiculos = new LinkedList<>(VeiculoFac.pesquisarRegistro(new Veiculo()));
			} catch (Exception e) {
				e.printStackTrace();
			}

			VeiculoRel veiculoRel = new VeiculoRel(veiculos);
			veiculoRel.retornarRelatorio(true);

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
				String placa = getVeiculoPc().getGuiPlaca().getText();
				if (placa == null || placa.length() == 0) {
					getVeiculoPc().getGuiPlaca().requestFocus();
					Msg.avisoCampoObrigatorio("PLACA");
					return;
				}
				if (mensagem == JOptionPane.YES_OPTION) {
					atualizarObjeto();
					VeiculoFac.salvarRegistro(veiculo);
					veiculo = new Veiculo();
					MainCont.getVeiculoFc().limparGui();
					getVeiculoPc().getGuiPlaca().requestFocus();
					Msg.sucessoSalvarRegistro();
				}
			} catch (Exception e) {
				Throwable throwable = e.getCause();
				if (throwable != null) {
					throwable = e.getCause().getCause();
				}
				String mensagem = "";
				if (throwable != null) {
					mensagem = throwable.toString();
				}

				if (mensagem.contains("ConstraintViolationException")) {
					if (mensagem.contains("INDEX_VEICULO_PLACA")) {
						Msg.avisoCampoDuplicado("PLACA");
						getVeiculoPc().getGuiPlaca().requestFocus();
					} else if (mensagem.contains("INDEX_VEICULO_RENAVAM")) {
						Msg.avisoCampoDuplicado("RENAVAM");
						getVeiculoPc().getGuiRenavam().requestFocus();
					} else if (mensagem.contains("INDEX_VEICULO_CHASSI")) {
						Msg.avisoCampoDuplicado("CHASSI");
						getVeiculoPc().getGuiChassi().requestFocus();
					} else {
						Msg.avisoCampoDuplicado();
					}
				}
				e.printStackTrace();
				Msg.erroSalvarRegistro();
			}
		}
	}

	private static Veiculo veiculo;

	public void atualizarGui() {
		if (veiculo == null) {
			return;
		}
		getVeiculoPc().getGuiAtividade().setSelectedItem(veiculo.getAtividade());
		getVeiculoPc().getGuiAdaptadoDeficiente().setSelectedItem(veiculo.getAdaptadoDeficiente());
		getVeiculoPc().getGuiCarroceria().setSelectedItem(veiculo.getCarroceria());
		getVeiculoPc().getGuiChassiRemarcado().setSelectedItem(veiculo.getChassiRemarcado());
		getVeiculoPc().getGuiCombustivel().setSelectedItem(veiculo.getCombustivel());
		getVeiculoPc().getGuiCor().setSelectedItem(veiculo.getCor());
		getVeiculoPc().getGuiEspecie().setSelectedItem(veiculo.getEspecie());
		getVeiculoPc().getGuiFabricacao().setSelectedItem(veiculo.getFabricacao());
		getVeiculoPc().getGuiIpva().setSelectedItem(veiculo.getIpva());
		getVeiculoPc().getGuiRestricoes().setSelectedItem(veiculo.getRestricoes());
		getVeiculoPc().getGuiTipo().setSelectedItem(veiculo.getTipo());
		getVeiculoPc().getGuiAnoFabricacao().setText(veiculo.getAnoFabricacao());
		getVeiculoPc().getGuiAnoModelo().setText(veiculo.getAnoModelo());
		getVeiculoPc().getGuiBairro().setText(veiculo.getBairro());
		getVeiculoPc().getGuiCapCarga().setText(veiculo.getCapCarga());
		getVeiculoPc().getGuiCapacidadePassageiros().setText(veiculo.getCapacidadePassageiros());
		getVeiculoPc().getGuiCategoria().setSelectedItem(veiculo.getCategoria());
		getVeiculoPc().getGuiSubCategoria().setSelectedItem(veiculo.getSubCategoria());
		getVeiculoPc().getGuiCep().setText(veiculo.getCep());
		getVeiculoPc().getGuiChassi().setText(veiculo.getChassi());
		getVeiculoPc().getGuiCilindrada().setText(veiculo.getCilindrada());
		getVeiculoPc().getGuiCilindros().setText(veiculo.getCilindros());
		getVeiculoPc().getGuiCmtTon().setText(veiculo.getCmtTon());
		getVeiculoPc().getGuiComplemento().setText(veiculo.getComplemento());
		getVeiculoPc().getGuiDataCompra().setText(veiculo.getDataCompra());
		getVeiculoPc().getGuiDataVenda().setText(veiculo.getDataVenda());
		getVeiculoPc().getGuiEixos().setText(veiculo.getEixos());
		getVeiculoPc().getGuiEstado().setText(veiculo.getEstado());
		getVeiculoPc().getGuiLogradouro().setText(veiculo.getLogradouro());
		getVeiculoPc().getGuiVeiculoMarca().setSelectedItem(veiculo.getMarca());
		getVeiculoPc().getGuiVeiculoModelo().setSelectedItem(veiculo.getModelo());
		getVeiculoPc().getGuiMunicipioEmplacamento().setText(veiculo.getMunicipioEmplacamento());
		getVeiculoPc().getGuiEstadoEmplacamento().setSelectedItem(veiculo.getEstadoEmplacamento());
		getVeiculoPc().getGuiPais().setText(veiculo.getPais());
		getVeiculoPc().getGuiPlaca().setText(veiculo.getPlaca());
		getVeiculoPc().getGuiPotencia().setText(veiculo.getPotencia());
		getVeiculoPc().getGuiProprietarioAnteriorCnpj().setText(veiculo.getProprietarioAnteriorCnpj());
		getVeiculoPc().getGuiProprietarioAnteriorCpf().setText(veiculo.getProprietarioAnteriorCpf());
		getVeiculoPc().getGuiProprietarioAnteriorEmail().setText(veiculo.getProprietarioAnteriorEmail());
		getVeiculoPc().getGuiProprietarioAnteriorFax().setText(veiculo.getProprietarioAnteriorFax());
		getVeiculoPc().getGuiProprietarioAnteriorNome().setText(veiculo.getProprietarioAnteriorNome());
		getVeiculoPc().getGuiProprietarioAnteriorFone1().setText(veiculo.getProprietarioAnteriorFone1());
		getVeiculoPc().getGuiProprietarioAnteriorFone2().setText(veiculo.getProprietarioAnteriorFone2());
		getVeiculoPc().getGuiProprietarioCnpj().setText(veiculo.getProprietarioCnpj());
		getVeiculoPc().getGuiProprietarioCpf().setText(veiculo.getProprietarioCpf());
		getVeiculoPc().getGuiProprietarioEmail().setText(veiculo.getProprietarioEmail());
		getVeiculoPc().getGuiProprietarioFax().setText(veiculo.getProprietarioFax());
		getVeiculoPc().getGuiProprietarioFone1().setText(veiculo.getProprietarioFone1());
		getVeiculoPc().getGuiProprietarioFone2().setText(veiculo.getProprietarioFone2());
		getVeiculoPc().getGuiProprietarioNome().setText(veiculo.getProprietarioNome());
		getVeiculoPc().getGuiProprietarioRGNumero().setText(veiculo.getProprietarioRGNumero());
		getVeiculoPc().getGuiProprietarioRGOrgaoEmisssor().setText(veiculo.getProprietarioRGOrgaoEmisssor());
		getVeiculoPc().getGuiValorCompra().setText(String.valueOf(veiculo.getValorCompra()));
		getVeiculoPc().getGuiValorVenda().setText(String.valueOf(veiculo.getValorVenda()));
		getVeiculoPc().getGuiRenavam().setText(veiculo.getRenavam());
		getVeiculoPc().getGuiCidade().setText(veiculo.getCidade());
		getVeiculoPc().getGuiNumeroMotor().setText(veiculo.getNumeroMotor());
		getVeiculoPc().getGuiMesReferenciaCompra().setSelectedItem(veiculo.getMesReferenciaCompra());
		getVeiculoPc().getGuiMesReferenciaVenda().setSelectedItem(veiculo.getMesReferenciaVenda());
		getVeiculoPc().getGuiAnoReferenciaCompra().setText(veiculo.getAnoReferenciaCompra());
		getVeiculoPc().getGuiAnoReferenciaVenda().setText(veiculo.getAnoReferenciaVenda());
		getVeiculoPc().getGuiAnoReferenciaCadastro().setText(veiculo.getAnoReferenciaCadastro());
		getVeiculoPc().getGuiMarchas().setText(veiculo.getMarchas());
		getVeiculoPc().getGuiZeroKm().setSelectedItem(veiculo.getZeroKm());
		getVeiculoPc().getGuiPneus().setSelectedItem(veiculo.getPneus());
		getVeiculoPc().getGuiDesconto().setText(String.valueOf(veiculo.getDesconto()));
		getVeiculoPc().getGuiRodas().setSelectedItem(veiculo.getRodas());
		getVeiculoPc().getGuiCambio().setSelectedItem(veiculo.getCambio());
		getVeiculoPc().getGuiRodas().setSelectedItem(veiculo.getRodas());
		getVeiculoPc().getGuiValvulas().setText(veiculo.getValvulas());
		getVeiculoPc().getGuiRebaixado().setSelectedItem(veiculo.getRebaixado());
		getVeiculoPc().getGuiQuilometragem().setText(veiculo.getQuilometragem());
		getVeiculoPc().getGuiCentroCusto().setSelectedItem(veiculo.getCentroCusto());
		getVeiculoPc().getGuiLucro().setText(veiculo.getLucro());
		getVeiculoPc().getGuiPrejuizo().setText(veiculo.getPrejuizo());
		getVeiculoPc().getGuiDepreciacao().setText(veiculo.getDepreciacao());
		getVeiculoPc().getGuiNumeroPortas().setText(String.valueOf(veiculo.getNumeroPortas()));
	}

	public void atualizarObjeto() {
		veiculo.setAnoFabricacao(getVeiculoPc().getGuiAnoFabricacao().getText());
		veiculo.setAnoModelo(getVeiculoPc().getGuiAnoModelo().getText());
		veiculo.setAtividade((String) getVeiculoPc().getGuiAtividade().getSelectedItem());
		veiculo.setAdaptadoDeficiente((String) getVeiculoPc().getGuiAdaptadoDeficiente().getSelectedItem());
		veiculo.setBairro(getVeiculoPc().getGuiBairro().getText());
		veiculo.setCapCarga(getVeiculoPc().getGuiCapCarga().getText());
		veiculo.setCapacidadePassageiros(getVeiculoPc().getGuiCapacidadePassageiros().getText());
		veiculo.setCarroceria((String) getVeiculoPc().getGuiCarroceria().getSelectedItem());
		veiculo.setCategoria((String) getVeiculoPc().getGuiCategoria().getSelectedItem());
		veiculo.setSubCategoria((String) getVeiculoPc().getGuiSubCategoria().getSelectedItem());
		veiculo.setCep(getVeiculoPc().getGuiCep().getText());
		veiculo.setChassi(getVeiculoPc().getGuiChassi().getText());
		veiculo.setChassiRemarcado((String) getVeiculoPc().getGuiChassiRemarcado().getSelectedItem());
		veiculo.setCidade(getVeiculoPc().getGuiCidade().getText());
		veiculo.setCilindrada(getVeiculoPc().getGuiCilindrada().getText());
		veiculo.setCilindros(getVeiculoPc().getGuiCilindros().getText());
		veiculo.setCmtTon(getVeiculoPc().getGuiCmtTon().getText());
		veiculo.setCombustivel((String) getVeiculoPc().getGuiCombustivel().getSelectedItem());
		veiculo.setComplemento(getVeiculoPc().getGuiComplemento().getText());
		veiculo.setCor((String) getVeiculoPc().getGuiCor().getSelectedItem());
		veiculo.setDataCompra(getVeiculoPc().getGuiDataCompra().getText());
		veiculo.setDataVenda(getVeiculoPc().getGuiDataVenda().getText());
		veiculo.setEixos(getVeiculoPc().getGuiEixos().getText());
		veiculo.setEspecie((String) getVeiculoPc().getGuiEspecie().getSelectedItem());
		veiculo.setEstado(getVeiculoPc().getGuiEstado().getText());
		veiculo.setFabricacao((String) getVeiculoPc().getGuiFabricacao().getSelectedItem());
		veiculo.setIpva((String) getVeiculoPc().getGuiIpva().getSelectedItem());
		veiculo.setLogradouro(getVeiculoPc().getGuiLogradouro().getText());
		veiculo.setMarca((VeiculoMarca) getVeiculoPc().getGuiVeiculoMarca().getSelectedItem());
		veiculo.setModelo((VeiculoModelo) getVeiculoPc().getGuiVeiculoModelo().getSelectedItem());
		veiculo.setMunicipioEmplacamento(getVeiculoPc().getGuiMunicipioEmplacamento().getText());
		veiculo.setEstadoEmplacamento((String) getVeiculoPc().getGuiEstadoEmplacamento().getSelectedItem());
		veiculo.setPais(getVeiculoPc().getGuiPais().getText());
		veiculo.setPlaca(getVeiculoPc().getGuiPlaca().getText());
		veiculo.setPotencia(getVeiculoPc().getGuiPotencia().getText());
		veiculo.setProprietarioAnteriorCnpj(getVeiculoPc().getGuiProprietarioAnteriorCnpj().getText());
		veiculo.setProprietarioAnteriorCpf(getVeiculoPc().getGuiProprietarioAnteriorCpf().getText());
		veiculo.setProprietarioAnteriorEmail(getVeiculoPc().getGuiProprietarioAnteriorEmail().getText());
		veiculo.setProprietarioAnteriorFax(getVeiculoPc().getGuiProprietarioAnteriorFax().getText());
		veiculo.setProprietarioAnteriorFone1(getVeiculoPc().getGuiProprietarioAnteriorFone1().getText());
		veiculo.setProprietarioAnteriorFone2(getVeiculoPc().getGuiProprietarioAnteriorFone2().getText());
		veiculo.setProprietarioAnteriorNome(getVeiculoPc().getGuiProprietarioAnteriorNome().getText());
		veiculo.setProprietarioCnpj(getVeiculoPc().getGuiProprietarioCnpj().getText());
		veiculo.setProprietarioCpf(getVeiculoPc().getGuiProprietarioCpf().getText());
		veiculo.setProprietarioEmail(getVeiculoPc().getGuiProprietarioEmail().getText());
		veiculo.setProprietarioFax(getVeiculoPc().getGuiProprietarioFax().getText());
		veiculo.setProprietarioFone1(getVeiculoPc().getGuiProprietarioFone1().getText());
		veiculo.setProprietarioFone2(getVeiculoPc().getGuiProprietarioFone2().getText());
		veiculo.setProprietarioNome(getVeiculoPc().getGuiProprietarioNome().getText());
		veiculo.setProprietarioRGNumero(getVeiculoPc().getGuiProprietarioRGNumero().getText());
		veiculo.setProprietarioRGOrgaoEmisssor(getVeiculoPc().getGuiProprietarioRGOrgaoEmisssor().getText());
		veiculo.setRenavam(getVeiculoPc().getGuiRenavam().getText());
		veiculo.setRestricoes((String) getVeiculoPc().getGuiRestricoes().getSelectedItem());
		veiculo.setTipo((String) getVeiculoPc().getGuiTipo().getSelectedItem());
		try {
			veiculo.setValorCompra(Double.parseDouble(getVeiculoPc().getGuiValorCompra().getText()));
		} catch (Exception e) {
			veiculo.setValorCompra(0);
		}
		try {
			veiculo.setValorVenda(Double.parseDouble(getVeiculoPc().getGuiValorVenda().getText()));
		} catch (Exception e) {
			veiculo.setValorVenda(0);
		}
		veiculo.setNumeroMotor(getVeiculoPc().getGuiNumeroMotor().getText());
		veiculo.setMesReferenciaCompra((String) getVeiculoPc().getGuiMesReferenciaCompra().getSelectedItem());
		veiculo.setMesReferenciaVenda((String) getVeiculoPc().getGuiMesReferenciaVenda().getSelectedItem());
		veiculo.setAnoReferenciaCompra(getVeiculoPc().getGuiAnoReferenciaCompra().getText());
		veiculo.setAnoReferenciaVenda(getVeiculoPc().getGuiAnoReferenciaVenda().getText());
		veiculo.setAnoReferenciaCadastro(getVeiculoPc().getGuiAnoReferenciaCadastro().getText());
		veiculo.setMarchas(getVeiculoPc().getGuiMarchas().getText());
		veiculo.setZeroKm((String) getVeiculoPc().getGuiZeroKm().getSelectedItem());
		veiculo.setPneus((String) getVeiculoPc().getGuiPneus().getSelectedItem());
		try {
			veiculo.setDesconto(Double.parseDouble(getVeiculoPc().getGuiDesconto().getText()));
		} catch (Exception e) {
			veiculo.setDesconto(0);
		}
		veiculo.setRodas((String) getVeiculoPc().getGuiRodas().getSelectedItem());
		veiculo.setCambio((String) getVeiculoPc().getGuiCambio().getSelectedItem());
		veiculo.setRodas((String) getVeiculoPc().getGuiRodas().getSelectedItem());
		veiculo.setValvulas(getVeiculoPc().getGuiValvulas().getText());
		veiculo.setRebaixado((String) getVeiculoPc().getGuiRebaixado().getSelectedItem());
		veiculo.setQuilometragem(getVeiculoPc().getGuiQuilometragem().getText());
		veiculo.setCentroCusto((CentroCusto) getVeiculoPc().getGuiCentroCusto().getSelectedItem());
		veiculo.setLucro(getVeiculoPc().getGuiLucro().getText());
		veiculo.setPrejuizo(getVeiculoPc().getGuiPrejuizo().getText());
		veiculo.setDepreciacao(getVeiculoPc().getGuiDepreciacao().getText());
		try {
			veiculo.setNumeroPortas(Integer.parseInt(getVeiculoPc().getGuiNumeroPortas().getText()));
		} catch (Exception e) {
			veiculo.setNumeroPortas(0);
		}
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public VeiculoFc getVeiculoFc() {
		return MainCont.getVeiculoFc();
	}

	public VeiculoFp getVeiculoFp() {
		return MainCont.getVeiculoFp();
	}

	public VeiculoPc getVeiculoPc() {
		return MainCont.getVeiculoFc().getVeiculoPc();
	}

	public VeiculoPp getVeiculoPp() {
		return MainCont.getVeiculoFp().getVeiculoPp();
	}

	public void setVeiculo(Veiculo veiculo) {
		VeiculoCont.veiculo = veiculo;
	}
}

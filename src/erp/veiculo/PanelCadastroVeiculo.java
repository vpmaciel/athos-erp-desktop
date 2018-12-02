package erp.veiculo;

import java.util.Collections;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.gui.FocusTabListener;
import arquitetura.gui.Gui;
import arquitetura.gui.GuiGerenteEventos;
import arquitetura.gui.TamanhoLowerCase;
import arquitetura.gui.TamanhoUpperCase;
import arquitetura.registro.ToolBar;
import arquitetura.util.SpringUtilities;
import erp.centrocusto.CentroCusto;
import erp.centrocusto.CentroCustoDaoFacade;
import erp.centrocusto.CentroCustoSort;
import erp.main.MainGerenteEventos;
import erp.veiculo.marca.VeiculoMarca;
import erp.veiculo.modelo.VeiculoModelo;

@SuppressWarnings("serial")
public final class PanelCadastroVeiculo extends JPanel implements Gui {

	private ToolBar toolBar;
	private GuiGerenteEventos guiGerenteEventos;
	private JLabel labelSubCategoria;
	private JLabel labelCambio;
	private JLabel labelNumeroMotor;
	private JLabel labelMesReferenciaCadastro;
	private JLabel labelAnoReferenciaCadastro;
	private JLabel labelMesReferenciaCompra;
	private JLabel labelMesReferenciaVenda;
	private JLabel labelAnoReferenciaCompra;
	private JLabel labelAnoReferenciaVenda;
	private JLabel labelVeiculoModelo;
	private JLabel labelVeiculoMarca;
	private JLabel labelMarchas;
	private JLabel labelZeroKm;
	private JLabel labelVeiculoDeficiente;
	private JLabel labelPneus;
	private JLabel labelRodas;
	private JLabel labelValvulas;
	private JLabel labelRebaixado;
	private JLabel labelQuilometragem;
	private JLabel labelCentroCusto;
	private JLabel labelLucro;
	private JLabel labelDesconto;
	private JLabel labelPrejuizo;
	private JLabel labelDepreciacao;
	private JLabel labelEstadoEmplacamento;
	private JComboBox<VeiculoModelo> boxVeiculoModelo;
	private JComboBox<String> boxEstadoEmplacamento;
	private JComboBox<String> boxVeiculoDeficiente;
	private JComboBox<String> boxMesReferenciaCadastro;
	private JTextField textFieldAnoReferenciaCadastro;
	private JComboBox<String> boxMesReferenciaCompra;
	private JComboBox<String> boxMesReferenciaVenda;
	private JTextField textFieldAnoReferenciaCompra;
	private JTextField textFieldNumeroMotor;
	private JTextField textFieldAnoReferenciaVenda;
	private JTextField textFieldMarchas;
	private JComboBox<String> boxZeroKm;
	private JComboBox<String> boxPneus;
	private JTextField textFieldDesconto;
	private JComboBox<String> boxRodas;
	private JTextField textFieldValvulas;
	private JComboBox<String> boxRebaixado;
	private JTextField textFieldQuilometragem;
	private JComboBox<CentroCusto> boxCentroCusto;
	private JTextField textFieldLucro;
	private JTextField textFieldPrejuizo;
	private JTextField textFieldDepreciacao;
	private JComboBox<VeiculoMarca> boxVeiculoMarca;
	private JComboBox<String> boxCambio;
	private JComboBox<String> boxSubCategoria;
	private JComboBox<String> boxCombustivel;
	private JTextField textFieldPlaca;
	private JComboBox<String> boxChassiRemarcado;
	private JComboBox<String> boxTipo;
	private JComboBox<String> boxAtividade;
	private JComboBox<String> boxCor;
	private JComboBox<String> boxEspecie;
	private JTextField textFieldRenavam;
	private JTextField textFieldMunicipioEmplacamento;
	private JTextField textFieldChassi;
	private JLabel labelChassiRemarcado;
	private JLabel labelTipo;
	private JLabel labelAtividade;
	private JLabel labelCor;
	private JLabel labelCombustivel;
	private JLabel labelPlaca;
	private JLabel labelRenavam;
	private JLabel labelMunicipioEmplacamento;
	private JLabel labelChassi;
	private JLabel labelDataCompra;
	private JLabel labelDataVenda;
	private JLabel labelProprietarioNome;
	private JLabel labelProprietarioEmail;
	private JLabel labelProprietarioCPF;
	private JTextField textFieldProprietarioEmail;
	private JTextField textFieldMarca;
	private JTextField textFieldProprietarioNome;
	private JTextField textFieldDataVenda;
	private JTextField textFieldDataCompra;
	private JTextField textFieldProprietarioAnteriorCNPJ;
	private JTextField textFieldProprietarioAnteriorNome;
	private JTextField textFieldProprietarioAnteriorRGNumero;
	private JTextField textFieldProprietarioAnteriorRGOrgaoEmissor;
	private JTextField textFieldProprietarioAnteriorCPF;
	private JTextField textFieldProprietarioRGNumero;
	private JTextField textFieldProprietarioRGOrgaoEmisssor;
	private JTextField textFieldProprietarioAnteriorFax;
	private JTextField textFieldProprietarioCNPJ;
	private JTextField textFieldProprietarioCPF;
	private JLabel labelProprietarioAnteriorCNPJ;
	private JLabel labelProprietarioAnteriorNome;
	private JLabel labelProprietarioAnteriorCPF;
	private JLabel labelProprietarioRGNumero;
	private JLabel labelProprietarioRGOrgaoEmisssor;
	private JLabel labelProprietarioAnteriorFax;
	private JLabel labelProprietarioCNPJ;
	private JLabel labelProprietarioAnteriorRGNumero;
	private JLabel labelProprietarioAnteriorRGOrgaoEmissor;
	private JTextField textFieldProprietarioFax;
	private JTextField textFieldValorCompra;
	private JTextField textFieldValorVenda;
	private JLabel labelValorVenda;
	private JTextField textFieldProprietarioFone1;
	private JTextField textFieldProprietarioFone2;
	private JLabel labelProprietarioFone2;
	private JLabel labelProprietarioFax;
	private JLabel labelProprietarioFone1;
	private JLabel labelValorCompra;
	private JTextField textFieldBairro;
	private JTextField textFieldCep;
	private JTextField textFieldCidade;
	private JTextField textFieldEstado;
	private JTextField textFieldLogradouro;
	private JTextField textFieldPais;
	private JTextField textFieldComplemento;
	private JLabel labelBairro;
	private JLabel labelCep;
	private JLabel labelCidade;
	private JLabel labelComplemento;
	private JLabel labelEstado;
	private JLabel labelLogradouro;
	private JLabel labelPais;
	private JTextField textFieldCmtTon;
	private JTextField textFieldEixos;
	private JTextField textFieldModelo;
	private JLabel labelCategoria;
	private JLabel labelCmtTon;
	private JLabel labelEixos;
	private JLabel labelEspecie;
	private JLabel labelAnoFabricacao;
	private JLabel labelAnoModelo;
	private JLabel labelPotencia;
	private JLabel labelCilindros;
	private JLabel labelCilindrada;
	private JLabel labelCapacidaPassageiros;
	private JLabel labelFabricacao;
	private JLabel labelCarroceria;
	private JLabel labelCapCarga;
	private JLabel labelRestricoes;
	private JLabel labelIpva;
	private JLabel labelProprietarioAnteriorFone1;
	private JLabel labelProprietarioAnteriorFone2;
	private JLabel labelProprietarioAnteriorEmail;
	private JTextField textFieldAnoFabricacao;
	private JTextField textFieldAnoModelo;
	private JTextField textFieldPotencia;
	private JTextField textFieldCilindros;
	private JTextField textFieldCilindrada;
	private JTextField textFieldCapacidadePassageiros;
	private JComboBox<String> boxFabricacao;
	private JComboBox<String> boxCategoria;
	private JComboBox<String> boxCarroceria;
	private JTextField textFieldCapCarga;
	private JComboBox<String> boxRestricoes;
	private JComboBox<String> boxIpva;
	private JTextField textFieldProprietarioAnteriorFone1;
	private JTextField textFieldProprietarioAnteriorFone2;
	private JTextField textFieldProprietarioAnteriorEmail;

	public PanelCadastroVeiculo() {
		iniciarLayout();
		iniciarGui();
		iniciarFocusTabListener();
		iniciarGuiGerenteEventos();
	}

	@Override
	public void atualizarTable() {

	}

	public JLabel getLabelZeroKm() {
		return labelZeroKm;
	}

	public JComboBox<VeiculoModelo> getBoxVeiculoModelo() {
		return boxVeiculoModelo;
	}

	public JComboBox<String> getBoxEstadoEmplacamento() {
		return boxEstadoEmplacamento;
	}

	public JComboBox<String> getBoxVeiculoDeficiente() {
		return boxVeiculoDeficiente;
	}

	public JComboBox<String> getBoxMesReferenciaCadastro() {
		return boxMesReferenciaCadastro;
	}

	public JTextField getTextFieldAnoReferenciaCadastro() {
		return textFieldAnoReferenciaCadastro;
	}

	public JComboBox<String> getBoxMesReferenciaCompra() {
		return boxMesReferenciaCompra;
	}

	public JComboBox<String> getBoxMesReferenciaVenda() {
		return boxMesReferenciaVenda;
	}

	public JTextField getTextFieldAnoReferenciaCompra() {
		return textFieldAnoReferenciaCompra;
	}

	public JTextField getTextFieldNumeroMotor() {
		return textFieldNumeroMotor;
	}

	public JTextField getTextFieldAnoReferenciaVenda() {
		return textFieldAnoReferenciaVenda;
	}

	public JTextField getTextFieldMarchas() {
		return textFieldMarchas;
	}

	public JComboBox<String> getBoxZeroKm() {
		return boxZeroKm;
	}

	public JComboBox<String> getBoxPneus() {
		return boxPneus;
	}

	public JTextField getTextFieldDesconto() {
		return textFieldDesconto;
	}

	public JComboBox<String> getBoxRodas() {
		return boxRodas;
	}

	public JTextField getTextFieldValvulas() {
		return textFieldValvulas;
	}

	public JComboBox<String> getBoxRebaixado() {
		return boxRebaixado;
	}

	public JTextField getTextFieldQuilometragem() {
		return textFieldQuilometragem;
	}

	public JComboBox<CentroCusto> getBoxCentroCusto() {
		return boxCentroCusto;
	}

	public JTextField getTextFieldLucro() {
		return textFieldLucro;
	}

	public JTextField getTextFieldPrejuizo() {
		return textFieldPrejuizo;
	}

	public JTextField getTextFieldDepreciacao() {
		return textFieldDepreciacao;
	}

	public JComboBox<VeiculoMarca> getBoxVeiculoMarca() {
		return boxVeiculoMarca;
	}

	public JComboBox<String> getBoxCambio() {
		return boxCambio;
	}

	public JComboBox<String> getBoxSubCategoria() {
		return boxSubCategoria;
	}

	public JTextField getTextFieldProprietarioAnteriorRGNumero() {
		return textFieldProprietarioAnteriorRGNumero;
	}

	public JTextField getTextFieldProprietarioAnteriorRGOrgaoEmissor() {
		return textFieldProprietarioAnteriorRGOrgaoEmissor;
	}

	public void setTextFieldAnoFabricacao(JTextField textFieldAnoFabricacao) {
		this.textFieldAnoFabricacao = textFieldAnoFabricacao;
	}

	public JComboBox<String> getBoxAtividade() {
		return boxAtividade;
	}

	public JComboBox<String> getBoxCarroceria() {
		return boxCarroceria;
	}

	public JComboBox<String> getBoxCategoria() {
		return boxCategoria;
	}

	public JComboBox<String> getBoxChassiRemarcado() {
		return boxChassiRemarcado;
	}

	public JComboBox<String> getBoxCombustivel() {
		return boxCombustivel;
	}

	public JComboBox<String> getBoxCor() {
		return boxCor;
	}

	public JComboBox<String> getBoxEspecie() {
		return boxEspecie;
	}

	public JComboBox<String> getBoxFabricacao() {
		return boxFabricacao;
	}

	public JComboBox<String> getBoxIpva() {
		return boxIpva;
	}

	public JComboBox<String> getBoxRestricoes() {
		return boxRestricoes;
	}

	public JComboBox<String> getBoxTipo() {
		return boxTipo;
	}

	@Override
	public GuiGerenteEventos getGuiGerenteEventos() {
		return guiGerenteEventos;
	}

	public JTextField getTextFieldAnoFabricacao() {
		return textFieldAnoFabricacao;
	}

	public JTextField getTextFieldAnoModelo() {
		return textFieldAnoModelo;
	}

	public JTextField getTextFieldBairro() {
		return textFieldBairro;
	}

	public JTextField getTextFieldCapacidadePassageiros() {
		return textFieldCapacidadePassageiros;
	}

	public JTextField getTextFieldCapCarga() {
		return textFieldCapCarga;
	}

	public JTextField getTextFieldCep() {
		return textFieldCep;
	}

	public JTextField getTextFieldChassi() {
		return textFieldChassi;
	}

	public JTextField getTextFieldCidade() {
		return textFieldCidade;
	}

	public JTextField getTextFieldCilindrada() {
		return textFieldCilindrada;
	}

	public JTextField getTextFieldCilindros() {
		return textFieldCilindros;
	}

	public JTextField getTextFieldCmtTon() {
		return textFieldCmtTon;
	}

	public JTextField getTextFieldComplemento() {
		return textFieldComplemento;
	}

	public JTextField getTextFieldDataCompra() {
		return textFieldDataCompra;
	}

	public JTextField getTextFieldDataVenda() {
		return textFieldDataVenda;
	}

	public JTextField getTextFieldEixos() {
		return textFieldEixos;
	}

	public JTextField getTextFieldEstado() {
		return textFieldEstado;
	}

	public JTextField getTextFieldLogradouro() {
		return textFieldLogradouro;
	}

	public JTextField getTextFieldMarca() {
		return textFieldMarca;
	}

	public JTextField getTextFieldModelo() {
		return textFieldModelo;
	}

	public JTextField getTextFieldMunicipioEmplacamento() {
		return textFieldMunicipioEmplacamento;
	}

	public JTextField getTextFieldPais() {
		return textFieldPais;
	}

	public JTextField getTextFieldPlaca() {
		return textFieldPlaca;
	}

	public JTextField getTextFieldPotencia() {
		return textFieldPotencia;
	}

	public JTextField getTextFieldProprietarioAnteriorCNPJ() {
		return textFieldProprietarioAnteriorCNPJ;
	}

	public JTextField getTextFieldProprietarioAnteriorCPF() {
		return textFieldProprietarioAnteriorCPF;
	}

	public JTextField getTextFieldProprietarioAnteriorEmail() {
		return textFieldProprietarioAnteriorEmail;
	}

	public JTextField getTextFieldProprietarioAnteriorFax() {
		return textFieldProprietarioAnteriorFax;
	}

	public JTextField getTextFieldProprietarioAnteriorFone1() {
		return textFieldProprietarioAnteriorFone1;
	}

	public JTextField getTextFieldProprietarioAnteriorFone2() {
		return textFieldProprietarioAnteriorFone2;
	}

	public JTextField getTextFieldProprietarioAnteriorNome() {
		return textFieldProprietarioAnteriorNome;
	}

	public JTextField getTextFieldProprietarioCNPJ() {
		return textFieldProprietarioCNPJ;
	}

	public JTextField getTextFieldProprietarioCPF() {
		return textFieldProprietarioCPF;
	}

	public JTextField getTextFieldProprietarioEmail() {
		return textFieldProprietarioEmail;
	}

	public JTextField getTextFieldProprietarioFax() {
		return textFieldProprietarioFax;
	}

	public JTextField getTextFieldProprietarioFone1() {
		return textFieldProprietarioFone1;
	}

	public JTextField getTextFieldProprietarioFone2() {
		return textFieldProprietarioFone2;
	}

	public JTextField getTextFieldProprietarioNome() {
		return textFieldProprietarioNome;
	}

	public JTextField getTextFieldProprietarioRGNumero() {
		return textFieldProprietarioRGNumero;
	}

	public JTextField getTextFieldProprietarioRGOrgaoEmisssor() {
		return textFieldProprietarioRGOrgaoEmisssor;
	}

	public JTextField getTextFieldRenavam() {
		return textFieldRenavam;
	}

	public JTextField getTextFieldValorCompra() {
		return textFieldValorCompra;
	}

	public JTextField getTextFieldValorVenda() {
		return textFieldValorVenda;
	}

	public ToolBar getToolBar() {
		return toolBar;
	}

	@Override
	public void iniciarFocusTabListener() {
		@SuppressWarnings("unused")
		FocusTabListener focusTabListener = new FocusTabListener(this);
	}

	@Override
	public void iniciarGui() {
		toolBar = new ToolBar();

		this.add(toolBar.getToolBar());

		labelPlaca = new JLabel("PLACA");
		add(labelPlaca);

		textFieldPlaca = new JTextField();
		textFieldPlaca.setDocument(new TamanhoUpperCase(8));
		add(textFieldPlaca);

		labelVeiculoMarca = new JLabel("MARCA DO VEÍCULO");
		add(labelVeiculoMarca);

		boxVeiculoMarca = new JComboBox<VeiculoMarca>();
		add(boxVeiculoMarca);

		labelVeiculoModelo = new JLabel("MODELO DO VEÍCULO");
		add(labelVeiculoModelo);

		boxVeiculoModelo = new JComboBox<VeiculoModelo>();
		add(boxVeiculoModelo);

		labelChassi = new JLabel("CHASSI");
		add(labelChassi);

		textFieldChassi = new JTextField();
		textFieldChassi.setDocument(new TamanhoUpperCase(20));
		add(textFieldChassi);

		labelNumeroMotor = new JLabel("NÚMERO DO MOTOR");
		add(labelNumeroMotor);

		textFieldNumeroMotor = new JTextField();
		textFieldNumeroMotor.setDocument(new TamanhoUpperCase(15));
		add(textFieldNumeroMotor);

		labelRenavam = new JLabel("RENAVAM");
		add(labelRenavam);

		textFieldRenavam = new JTextField();
		textFieldRenavam.setDocument(new TamanhoUpperCase(15));
		add(textFieldRenavam);

		labelChassiRemarcado = new JLabel("CHASSI REMARCADO");
		add(labelChassiRemarcado);

		boxChassiRemarcado = new JComboBox<String>();
		boxChassiRemarcado.addItem("");
		boxChassiRemarcado.addItem("SIM");
		boxChassiRemarcado.addItem("NÃO");
		add(boxChassiRemarcado);

		labelValorCompra = new JLabel("VALOR DE COMPRA");
		add(labelValorCompra);

		textFieldValorCompra = new JTextField();
		textFieldValorCompra.setDocument(new TamanhoUpperCase(10));
		add(textFieldValorCompra);

		labelValorVenda = new JLabel("VALOR DE VENDA");
		add(labelValorVenda);

		textFieldValorVenda = new JTextField();
		textFieldValorVenda.setDocument(new TamanhoUpperCase(10));
		add(textFieldValorVenda);

		labelDesconto = new JLabel("DESCONTO");
		add(labelDesconto);

		textFieldDesconto = new JTextField();
		textFieldDesconto.setDocument(new TamanhoUpperCase(10));
		add(textFieldDesconto);

		labelLucro = new JLabel("LUCRO");
		add(labelLucro);

		textFieldLucro = new JTextField();
		textFieldLucro.setDocument(new TamanhoUpperCase(10));
		add(textFieldLucro);

		labelPrejuizo = new JLabel("PREJUÍZO");
		add(labelPrejuizo);

		textFieldPrejuizo = new JTextField();
		textFieldPrejuizo.setDocument(new TamanhoUpperCase(10));
		add(textFieldPrejuizo);

		labelDepreciacao = new JLabel("DEPRECIAÇÃO");
		add(labelDepreciacao);

		textFieldDepreciacao = new JTextField();
		textFieldDepreciacao.setDocument(new TamanhoUpperCase(10));
		add(textFieldDepreciacao);

		labelDataCompra = new JLabel("DATA DA COMPRA");
		add(labelDataCompra);

		textFieldDataCompra = new JTextField();
		textFieldDataCompra.setDocument(new TamanhoUpperCase(10));
		add(textFieldDataCompra);

		labelDataVenda = new JLabel("DATA DA VENDA");
		add(labelDataVenda);

		textFieldDataVenda = new JTextField();
		textFieldDataVenda.setDocument(new TamanhoLowerCase(10));
		add(textFieldDataVenda);

		labelMesReferenciaCadastro = new JLabel("MÊS DE REFERÊNCIA DO CADASTRO");
		add(labelMesReferenciaCadastro);

		boxMesReferenciaCadastro = new JComboBox<String>();
		boxMesReferenciaCadastro.addItem("");
		boxMesReferenciaCadastro.addItem("JANEIRO");
		boxMesReferenciaCadastro.addItem("FEVEREIRO");
		boxMesReferenciaCadastro.addItem("MARÇO");
		boxMesReferenciaCadastro.addItem("ABRIL");
		boxMesReferenciaCadastro.addItem("MAIO");
		boxMesReferenciaCadastro.addItem("JUNHO");
		boxMesReferenciaCadastro.addItem("JULHO");
		boxMesReferenciaCadastro.addItem("AGOSTO");
		boxMesReferenciaCadastro.addItem("SETEMBRO");
		boxMesReferenciaCadastro.addItem("OUTUBRO");
		boxMesReferenciaCadastro.addItem("NOVEMBRO");
		boxMesReferenciaCadastro.addItem("DEZEMBRO");
		add(boxMesReferenciaCadastro);

		labelAnoReferenciaCadastro = new JLabel("ANO DE REFERÊNCIA DO CADASTRO");
		add(labelAnoReferenciaCadastro);

		textFieldAnoReferenciaCadastro = new JTextField();
		textFieldAnoReferenciaCadastro.setDocument(new TamanhoUpperCase(10));
		add(textFieldAnoReferenciaCadastro);

		labelMesReferenciaCompra = new JLabel("MÊS DE REFERÊNCIA DA COMPRA");
		add(labelMesReferenciaCompra);

		boxMesReferenciaCompra = new JComboBox<String>();
		boxMesReferenciaCompra.addItem("");
		boxMesReferenciaCompra.addItem("JANEIRO");
		boxMesReferenciaCompra.addItem("FEVEREIRO");
		boxMesReferenciaCompra.addItem("MARÇO");
		boxMesReferenciaCompra.addItem("ABRIL");
		boxMesReferenciaCompra.addItem("MAIO");
		boxMesReferenciaCompra.addItem("JUNHO");
		boxMesReferenciaCompra.addItem("JULHO");
		boxMesReferenciaCompra.addItem("AGOSTO");
		boxMesReferenciaCompra.addItem("SETEMBRO");
		boxMesReferenciaCompra.addItem("OUTUBRO");
		boxMesReferenciaCompra.addItem("NOVEMBRO");
		boxMesReferenciaCompra.addItem("DEZEMBRO");
		add(boxMesReferenciaCompra);

		labelAnoReferenciaCompra = new JLabel("ANO DE REFERÊNCIA DA COMPRA");
		add(labelAnoReferenciaCompra);

		textFieldAnoReferenciaCompra = new JTextField();
		textFieldAnoReferenciaCompra.setDocument(new TamanhoUpperCase(10));
		add(textFieldAnoReferenciaCompra);

		labelMesReferenciaVenda = new JLabel("MÊS DE REFERÊNCIA DA VENDA");
		add(labelMesReferenciaVenda);

		boxMesReferenciaVenda = new JComboBox<String>();
		boxMesReferenciaVenda.addItem("");
		boxMesReferenciaVenda.addItem("JANEIRO");
		boxMesReferenciaVenda.addItem("FEVEREIRO");
		boxMesReferenciaVenda.addItem("MARÇO");
		boxMesReferenciaVenda.addItem("ABRIL");
		boxMesReferenciaVenda.addItem("MAIO");
		boxMesReferenciaVenda.addItem("JUNHO");
		boxMesReferenciaVenda.addItem("JULHO");
		boxMesReferenciaVenda.addItem("AGOSTO");
		boxMesReferenciaVenda.addItem("SETEMBRO");
		boxMesReferenciaVenda.addItem("OUTUBRO");
		boxMesReferenciaVenda.addItem("NOVEMBRO");
		boxMesReferenciaVenda.addItem("DEZEMBRO");

		add(boxMesReferenciaVenda);

		labelAnoReferenciaVenda = new JLabel("ANO DE REFERÊNCIA DA VENDA");
		add(labelAnoReferenciaVenda);

		textFieldAnoReferenciaVenda = new JTextField();
		textFieldAnoReferenciaVenda.setDocument(new TamanhoUpperCase(10));
		add(textFieldAnoReferenciaVenda);

		labelMunicipioEmplacamento = new JLabel("MUNICÍPIO DE EMPLACAMENTO");
		add(labelMunicipioEmplacamento);

		textFieldMunicipioEmplacamento = new JTextField();
		textFieldMunicipioEmplacamento.setDocument(new TamanhoUpperCase(50));
		add(textFieldMunicipioEmplacamento);

		labelEstadoEmplacamento = new JLabel("ESTADO DE EMPLACAMENTO");
		add(labelEstadoEmplacamento);

		boxEstadoEmplacamento = new JComboBox<String>();
		boxEstadoEmplacamento.addItem("");
		boxEstadoEmplacamento.addItem("ACRE");
		boxEstadoEmplacamento.addItem("ALAGOAS");
		boxEstadoEmplacamento.addItem("AMAPÁ");
		boxEstadoEmplacamento.addItem("AMAZONAS");
		boxEstadoEmplacamento.addItem("BAHIA");
		boxEstadoEmplacamento.addItem("CEARÁ");
		boxEstadoEmplacamento.addItem("DISTRITO FEDERAL");
		boxEstadoEmplacamento.addItem("ESPÍRITO SANTO");
		boxEstadoEmplacamento.addItem("GOIÁS");
		boxEstadoEmplacamento.addItem("MARANHÃO");
		boxEstadoEmplacamento.addItem("MATO GROSSO");
		boxEstadoEmplacamento.addItem("MATO GROSSO DO SUL");
		boxEstadoEmplacamento.addItem("MINAS GERAIS");
		boxEstadoEmplacamento.addItem("PARÁ");
		boxEstadoEmplacamento.addItem("PARAÍBA");
		boxEstadoEmplacamento.addItem("PARANÁ");
		boxEstadoEmplacamento.addItem("PERNAMBUCO");
		boxEstadoEmplacamento.addItem("PIAUÍ");
		boxEstadoEmplacamento.addItem("RIO DE JANEIRO");
		boxEstadoEmplacamento.addItem("RIO GRANDE DO NORTE");
		boxEstadoEmplacamento.addItem("RIO GRANDE DO SUL");
		boxEstadoEmplacamento.addItem("RONDÔNIA");
		boxEstadoEmplacamento.addItem("RORAIMA");
		boxEstadoEmplacamento.addItem("SANTA CATARINA");
		boxEstadoEmplacamento.addItem("SÃO PAULO");
		boxEstadoEmplacamento.addItem("SERGIPE");
		boxEstadoEmplacamento.addItem("TOCANTINS");
		add(boxEstadoEmplacamento);

		labelProprietarioNome = new JLabel("NOME DO PROPRIETÁRIO");
		add(labelProprietarioNome);

		textFieldProprietarioNome = new JTextField();
		textFieldProprietarioNome.setDocument(new TamanhoUpperCase(50));
		add(textFieldProprietarioNome);

		labelProprietarioRGNumero = new JLabel("IDENTIDADE NÚMERO (PROPRIETÁRIO)");
		add(labelProprietarioRGNumero);

		textFieldProprietarioRGNumero = new JTextField();
		textFieldProprietarioRGNumero.setDocument(new TamanhoUpperCase(15));
		add(textFieldProprietarioRGNumero);

		labelProprietarioRGOrgaoEmisssor = new JLabel("IDENTIDADE ÓRGÃO EMISSOR (PROPRIETÁRIO)");
		add(labelProprietarioRGOrgaoEmisssor);

		textFieldProprietarioRGOrgaoEmisssor = new JTextField();
		textFieldProprietarioRGOrgaoEmisssor.setDocument(new TamanhoUpperCase(20));
		add(textFieldProprietarioRGOrgaoEmisssor);

		labelProprietarioCPF = new JLabel("CPF (PROPRIETÁRIO)");
		add(labelProprietarioCPF);

		textFieldProprietarioCPF = new JTextField();
		textFieldProprietarioCPF.setDocument(new TamanhoUpperCase(14));
		add(textFieldProprietarioCPF);

		labelProprietarioCNPJ = new JLabel("CNPJ (PROPRIETÁRIO)");
		add(labelProprietarioCNPJ);

		textFieldProprietarioCNPJ = new JTextField();
		textFieldProprietarioCNPJ.setDocument(new TamanhoUpperCase(19));
		add(textFieldProprietarioCNPJ);

		labelProprietarioFone1 = new JLabel("TELEFONE (PROPRIETÁRIO)");
		add(labelProprietarioFone1);

		textFieldProprietarioFone1 = new JTextField();
		textFieldProprietarioFone1.setDocument(new TamanhoUpperCase(20));
		add(textFieldProprietarioFone1);

		labelProprietarioFone2 = new JLabel("TELEFONE (PROPRIETÁRIO)");
		add(labelProprietarioFone2);

		textFieldProprietarioFone2 = new JTextField();
		textFieldProprietarioFone2.setDocument(new TamanhoUpperCase(20));
		add(textFieldProprietarioFone2);

		labelProprietarioFax = new JLabel("FAX (PROPRIETÁRIO)");
		add(labelProprietarioFax);

		textFieldProprietarioFax = new JTextField();
		textFieldProprietarioFax.setDocument(new TamanhoUpperCase(20));
		add(textFieldProprietarioFax);

		labelProprietarioEmail = new JLabel("EMAIL (PROPRIETÁRIO)");
		add(labelProprietarioEmail);

		textFieldProprietarioEmail = new JTextField();
		textFieldProprietarioEmail.setDocument(new TamanhoUpperCase(50));
		add(textFieldProprietarioEmail);

		labelPais = new JLabel("PAÍS (ENDEREÇO DO PROPRIETÁRIO)");
		add(labelPais);

		textFieldPais = new JTextField();
		textFieldPais.setDocument(new TamanhoUpperCase(50));
		add(textFieldPais);

		labelEstado = new JLabel("ESTADO (ENDEREÇO DO PROPRIETÁRIO)");
		add(labelEstado);

		textFieldEstado = new JTextField();
		textFieldEstado.setDocument(new TamanhoUpperCase(50));
		add(textFieldEstado);

		labelCidade = new JLabel("CIDADE (ENDEREÇO DO PROPRIETÁRIO)");
		add(labelCidade);

		textFieldCidade = new JTextField();
		textFieldCidade.setDocument(new TamanhoUpperCase(50));
		add(textFieldCidade);

		labelBairro = new JLabel("BAIRRO (ENDEREÇO DO PROPRIETÁRIO)");
		add(labelBairro);

		textFieldBairro = new JTextField();
		textFieldBairro.setDocument(new TamanhoUpperCase(50));
		add(textFieldBairro);

		labelLogradouro = new JLabel("LOGRADOURO (ENDEREÇO DO PROPRIETÁRIO)");
		add(labelLogradouro);

		textFieldLogradouro = new JTextField();
		textFieldLogradouro.setDocument(new TamanhoUpperCase(50));
		add(textFieldLogradouro);

		labelComplemento = new JLabel("COMPLEMENTO (ENDEREÇO DO PROPRIETÁRIO)");
		add(labelComplemento);

		textFieldComplemento = new JTextField();
		textFieldComplemento.setDocument(new TamanhoUpperCase(20));
		add(textFieldComplemento);

		labelCep = new JLabel("CEP (ENDEREÇO DO PROPRIETÁRIO)");
		add(labelCep);

		textFieldCep = new JTextField();
		textFieldCep.setDocument(new TamanhoUpperCase(10));
		add(textFieldCep);

		labelAnoFabricacao = new JLabel("ANO DE FABRICAÇÃO (VEÍCULO)");
		add(labelAnoFabricacao);

		textFieldAnoFabricacao = new JTextField();
		textFieldAnoFabricacao.setDocument(new TamanhoUpperCase(4));
		add(textFieldAnoFabricacao);

		labelAnoModelo = new JLabel("ANO MODELO (VEÍCULO)");
		add(labelAnoModelo);

		textFieldAnoModelo = new JTextField();
		textFieldAnoModelo.setDocument(new TamanhoUpperCase(4));
		add(textFieldAnoModelo);

		labelCor = new JLabel("COR (VEÍCULO)");
		add(labelCor);

		boxCor = new JComboBox<String>();
		boxCor.addItem("");
		boxCor.addItem("AMARELA");
		boxCor.addItem("AZUL");
		boxCor.addItem("BEGE");
		boxCor.addItem("BRANCA");
		boxCor.addItem("CINZA");
		boxCor.addItem("DOURADA");
		boxCor.addItem("GRENA");
		boxCor.addItem("LARANJA");
		boxCor.addItem("MARROM");
		boxCor.addItem("PRATA");
		boxCor.addItem("PRETA");
		boxCor.addItem("ROSA");
		boxCor.addItem("ROXA");
		boxCor.addItem("VERDE");
		boxCor.addItem("VERMELHA");
		boxCor.addItem("FANTASIA");
		add(boxCor);

		labelZeroKm = new JLabel("ZERO KM (VEÍCULO)");
		add(labelZeroKm);

		boxZeroKm = new JComboBox<String>();
		boxZeroKm.addItem("");
		boxZeroKm.addItem("SIM");
		boxZeroKm.addItem("NÃO");
		add(boxZeroKm);

		labelVeiculoDeficiente = new JLabel("VEÍCULO ADAPTADO PARA DEFICIENTE");
		add(labelVeiculoDeficiente);

		boxVeiculoDeficiente = new JComboBox<String>();
		boxVeiculoDeficiente.addItem("");
		boxVeiculoDeficiente.addItem("SIM");
		boxVeiculoDeficiente.addItem("NÃO");
		add(boxVeiculoDeficiente);

		labelCapacidaPassageiros = new JLabel("CAPACIDADE DE PASSAGEIROS");
		add(labelCapacidaPassageiros);

		textFieldCapacidadePassageiros = new JTextField();
		textFieldCapacidadePassageiros.setDocument(new TamanhoUpperCase(3));
		add(textFieldCapacidadePassageiros);

		labelCombustivel = new JLabel("COMBUSTÍVEL");
		add(labelCombustivel);

		boxCombustivel = new JComboBox<String>();
		boxCombustivel.addItem("");
		boxCombustivel.addItem("ALCOOL");
		boxCombustivel.addItem("GASOLINA");
		boxCombustivel.addItem("DIESEL");
		boxCombustivel.addItem("GASOGENIO");
		boxCombustivel.addItem("GAS METANO");
		boxCombustivel.addItem("ELT FT INT");
		boxCombustivel.addItem("ELT FT EXT");
		boxCombustivel.addItem("ALCOOL/GAS NATURAL COMBUSTIVEL");
		boxCombustivel.addItem("ALCOOL/GNV");
		boxCombustivel.addItem("GASOL/GNV");
		boxCombustivel.addItem("DIESEL/GNV");
		boxCombustivel.addItem("ALC/GASOL");
		boxCombustivel.addItem("GAS/ALC/GNV");
		boxCombustivel.addItem("GASOLINA/ELETRICO");
		boxCombustivel.addItem("GASOL/GNC");
		boxCombustivel.addItem("VIDE/CAMPO/OBSERVACAO");
		boxCombustivel.addItem("DIESEL/GAS NATURAL COMBUSTÍVEL");
		add(boxCombustivel);

		labelFabricacao = new JLabel("FABRICAÇÃO");
		add(labelFabricacao);

		boxFabricacao = new JComboBox<String>();
		boxFabricacao.addItem("");
		boxFabricacao.addItem("NACIONAL");
		boxFabricacao.addItem("IMPORTADO");
		add(boxFabricacao);

		labelSubCategoria = new JLabel("SUB CATEGORIA");
		add(labelSubCategoria);

		boxSubCategoria = new JComboBox<String>();
		boxSubCategoria.addItem("");
		boxSubCategoria.addItem("SUV/CROSSOVER");
		boxSubCategoria.addItem("PICK-UP");
		boxSubCategoria.addItem("PICK-UP PEQUENA");
		boxSubCategoria.addItem("PICK-UP GRANDE");
		boxSubCategoria.addItem("SEDÃ GRANDE");
		boxSubCategoria.addItem("SEDÃ MÉDIO");
		boxSubCategoria.addItem("SEDÃ COMPACTO");
		boxSubCategoria.addItem("SEDÃ PEQUENO");
		boxSubCategoria.addItem("PERUA (STATION WAGON)");
		boxSubCategoria.addItem("SW MÉDIO");
		boxSubCategoria.addItem("SW GRANDE");
		boxSubCategoria.addItem("HATCH PEQUENO");
		boxSubCategoria.addItem("HATCH ESPORTIVO");
		boxSubCategoria.addItem("HATCH MÉDIO");
		boxSubCategoria.addItem("HATCH COMPACTO");
		boxSubCategoria.addItem("HATCHBACK");
		boxSubCategoria.addItem("COUPÉ/CONVERSÍVEL");
		boxSubCategoria.addItem("MINIVAN");
		boxSubCategoria.addItem("MONOCAB");
		boxSubCategoria.addItem("GRANCAB");
		boxSubCategoria.addItem("SPORTS");
		boxSubCategoria.addItem("FURGÕES");
		boxSubCategoria.addItem("FURGÕES PEQUENOS");
		boxSubCategoria.addItem("CARGA");
		boxSubCategoria.addItem("AMBULÂNCIA");
		boxSubCategoria.addItem("PASSAGEIRO");
		add(boxSubCategoria);

		labelPneus = new JLabel("PNEUS");
		add(labelPneus);

		boxPneus = new JComboBox<String>();
		boxPneus.addItem("");
		boxPneus.addItem("OFF-ROAD");
		boxPneus.addItem("MISTO");
		boxPneus.addItem("VERDE");
		add(boxPneus);

		labelRodas = new JLabel("RODAS (ARO)");
		add(labelRodas);

		boxRodas = new JComboBox<String>();
		boxRodas.addItem("");
		boxRodas.addItem("12");
		boxRodas.addItem("13");
		boxRodas.addItem("14");
		boxRodas.addItem("15");
		boxRodas.addItem("16");
		boxRodas.addItem("16,5");
		boxRodas.addItem("17");
		boxRodas.addItem("18");
		boxRodas.addItem("19");
		boxRodas.addItem("20");
		boxRodas.addItem("21");
		boxRodas.addItem("22");
		boxRodas.addItem("23");
		boxRodas.addItem("24");
		boxRodas.addItem("25");
		boxRodas.addItem("26");
		boxRodas.addItem("27");
		boxRodas.addItem("28");
		boxRodas.addItem("29");
		boxRodas.addItem("30");
		add(boxRodas);

		labelValvulas = new JLabel("VÁLVULAS");
		add(labelValvulas);

		textFieldValvulas = new JTextField();
		textFieldValvulas.setDocument(new TamanhoUpperCase(10));
		add(textFieldValvulas);

		labelRebaixado = new JLabel("REBAIXADO");
		add(labelRebaixado);

		boxRebaixado = new JComboBox<String>();
		boxRebaixado.addItem("");
		boxRebaixado.addItem("SIM");
		boxRebaixado.addItem("NÃO");
		add(boxRebaixado);

		labelQuilometragem = new JLabel("QUILOMETRAGEM");
		add(labelQuilometragem);

		textFieldQuilometragem = new JTextField();
		textFieldQuilometragem.setDocument(new TamanhoUpperCase(10));
		add(textFieldQuilometragem);

		labelCentroCusto = new JLabel("CENTRO DE CUSTO");
		add(labelCentroCusto);

		boxCentroCusto = new JComboBox<CentroCusto>();
		List<CentroCusto> centroCustos = (List<CentroCusto>) CentroCustoDaoFacade.getRegistro();
		Collections.sort(centroCustos, new CentroCustoSort().new Nome());
		for (CentroCusto c : centroCustos) {
			boxCentroCusto.addItem(c);
		}

		add(boxCentroCusto);

		labelTipo = new JLabel("TIPO");
		add(labelTipo);

		boxTipo = new JComboBox<String>();
		boxTipo.addItem("");
		boxTipo.addItem("CICLOMOTOR");
		boxTipo.addItem("MOTONETA");
		boxTipo.addItem("MOTOCICLETA");
		boxTipo.addItem("TRICICLO");
		boxTipo.addItem("AUTOMÓVEL");
		boxTipo.addItem("MICROÔNIBUS");
		boxTipo.addItem("ÔNIBUS");
		boxTipo.addItem("REBOQUE");
		boxTipo.addItem("SEMIREBOQUE");
		boxTipo.addItem("CAMIONETA");
		boxTipo.addItem("CAMINHÃO");
		boxTipo.addItem("CAMINHÃO TRATOR");
		boxTipo.addItem("TRATOR RODAS");
		boxTipo.addItem("TRATOR ESTEIRAS");
		boxTipo.addItem("TRATOR MISTO");
		boxTipo.addItem("QUADRICICLO");
		boxTipo.addItem("CHASSI PLATAFORMA");
		boxTipo.addItem("CAMINHONETE");
		boxTipo.addItem("UTILITÁRIO");
		boxTipo.addItem("MOTORCASA");
		add(boxTipo);

		labelAtividade = new JLabel("ATIVIDADE");
		add(labelAtividade);

		boxAtividade = new JComboBox<String>();
		boxAtividade.addItem("");
		boxAtividade.addItem("USO PRÓPRIO/OUTROS");
		boxAtividade.addItem("LOCADORA");
		boxAtividade.addItem("TÁXI");
		boxAtividade.addItem("ESCOLAR");
		boxAtividade.addItem("COLEÇÃO");
		add(boxAtividade);

		labelCambio = new JLabel("CAMBIO");
		add(labelCambio);

		boxCambio = new JComboBox<String>();
		boxCambio.addItem("");
		boxCambio.addItem("CÂMBIO CVT");
		boxCambio.addItem("CÂMBIO AUTOMATIZADO DUPLA EMBREAGEM");
		boxCambio.addItem("CÂMBIO AUTOMATIZADO UMA EMBREAGEM");
		boxCambio.addItem("CÂMBIO MANUAL");
		boxCambio.addItem("CÂMBIO AUTOMÁTICO");
		add(boxCambio);

		labelMarchas = new JLabel("MARCHAS");
		add(labelMarchas);

		textFieldMarchas = new JTextField();
		textFieldMarchas.setDocument(new TamanhoUpperCase(10));
		add(textFieldMarchas);

		labelEspecie = new JLabel("ESPÉCIE");
		add(labelEspecie);

		boxEspecie = new JComboBox<String>();
		boxEspecie.addItem("");
		boxEspecie.addItem("PASSAGEIRO");
		boxEspecie.addItem("CARGA");
		boxEspecie.addItem("MISTO");
		boxEspecie.addItem("CORRIDA");
		boxEspecie.addItem("TRAÇÃO");
		boxEspecie.addItem("ESPECIAL");
		boxEspecie.addItem("COLEÇÃO");
		add(boxEspecie);

		labelPotencia = new JLabel("POTÊNCIA-CV");
		add(labelPotencia);

		textFieldPotencia = new JTextField();
		textFieldPotencia.setDocument(new TamanhoUpperCase(10));
		add(textFieldPotencia);

		labelCilindros = new JLabel("N.CILINDROS");
		add(labelCilindros);

		textFieldCilindros = new JTextField();
		textFieldCilindros.setDocument(new TamanhoUpperCase(2));
		add(textFieldCilindros);

		labelCilindrada = new JLabel("CILINDRADA:");
		add(labelCilindrada);

		textFieldCilindrada = new JTextField();
		textFieldCilindrada.setDocument(new TamanhoUpperCase(4));
		add(textFieldCilindrada);

		labelCategoria = new JLabel("CATEGORIA");
		add(labelCategoria);

		boxCategoria = new JComboBox<String>();
		boxCategoria.addItem("");
		boxCategoria.addItem("PARTICULAR");
		boxCategoria.addItem("ALUGUEL");
		boxCategoria.addItem("OFICIAL");
		boxCategoria.addItem("EXPERIÊNCIA");
		boxCategoria.addItem("APRENDIZAGEM");
		boxCategoria.addItem("FABRICANTE EXPERIÊNCIA");
		boxCategoria.addItem("COLEÇÃO");
		boxCategoria.addItem("CMD-CHEFE MISSÃO DIPLOMATICA");
		boxCategoria.addItem("CC-CORPO CONSULAR");
		boxCategoria.addItem("OI-ORGANISMO INTERNACIONAL");
		boxCategoria.addItem("CD-CORPO DIPLOMATICO");
		boxCategoria.addItem("MRRI-MISSÃO/REPART./REPRES.INT");
		boxCategoria.addItem("ACI -ACORDO DE COOP. INTERN.");
		add(boxCategoria);

		labelCarroceria = new JLabel("CARROCERIA");
		add(labelCarroceria);

		boxCarroceria = new JComboBox<String>();
		boxCarroceria.addItem("");
		boxCarroceria.addItem("NENHUMA");
		boxCarroceria.addItem("NÃO INFORMADO");
		boxCarroceria.addItem("NÃO SE APLICA");
		boxCarroceria.addItem("COMERCIO");
		boxCarroceria.addItem("TRANSP GRANITO");
		boxCarroceria.addItem("ROLLON ROLOFF");
		boxCarroceria.addItem("AMBULANCIA");
		boxCarroceria.addItem("BASCULANTE");
		boxCarroceria.addItem("BLINDADA");
		boxCarroceria.addItem("BOMBEIRO");
		boxCarroceria.addItem("BUGGY");
		boxCarroceria.addItem("CAB DUPLA");
		boxCarroceria.addItem("C. ABERTA");
		boxCarroceria.addItem("C.FECHADA");
		boxCarroceria.addItem("CH P/CTAINER");
		boxCarroceria.addItem("CONVERSIVEL");
		boxCarroceria.addItem("FUNERAL");
		boxCarroceria.addItem("FURGAO");
		boxCarroceria.addItem("JIPE");
		boxCarroceria.addItem("KIT TRICIC");
		boxCarroceria.addItem("LIMUSINE");
		boxCarroceria.addItem("MEC.OPERAC.");
		boxCarroceria.addItem("MOTOR CASA");
		boxCarroceria.addItem("PRANCHA");
		boxCarroceria.addItem("SIDE CAR/INTERCAMBIAVEL");
		boxCarroceria.addItem("SILO");
		boxCarroceria.addItem("TANQUE");
		boxCarroceria.addItem("TRAILER");
		boxCarroceria.addItem("MILITAR");
		boxCarroceria.addItem("TR PRESO");
		boxCarroceria.addItem("T.RECREATIVO");
		boxCarroceria.addItem("T.TRABALHAT.");
		boxCarroceria.addItem("CONT.C.AB.");
		boxCarroceria.addItem("PR.CONTEIN.");
		boxCarroceria.addItem("CAB.EST.");
		boxCarroceria.addItem("DOLLY");
		boxCarroceria.addItem("INTERCAMBIAVEL");
		boxCarroceria.addItem("AB.C.DUPLA");
		boxCarroceria.addItem("AB/CB.ESTEND.");
		boxCarroceria.addItem("AB.CAB.SUPLEMENTAR");
		boxCarroceria.addItem("FC.CABINE DUPLA");
		boxCarroceria.addItem("FECHADA/CABINE ESTENDIDA");
		boxCarroceria.addItem("FECH.CABINE SUPLEMENTAR");
		boxCarroceria.addItem("ABERTA/INTERCAMBIAVEL");
		boxCarroceria.addItem("CABINE DUPLA / INACABADA");
		boxCarroceria.addItem("MECANISMO OPERACIONAL/CAB/DUPL");
		boxCarroceria.addItem("TRANSP.TORAS/M.BRUTA");
		boxCarroceria.addItem("TRIO ELETRICO");
		boxCarroceria.addItem("ABERTA/MEC.OPERACIONAL");
		boxCarroceria.addItem("FECHADA/MECANISMO OPERACIONAL");
		boxCarroceria.addItem("TANQUE/MECANISMO OPERACIONAL");
		boxCarroceria.addItem("PRANCHA/MECANISMO OPERACIONAL");
		boxCarroceria.addItem("ABERTA/MEC OPERACIONAL/C DUPLA");
		boxCarroceria.addItem("ABERTA/MEC OPERCIONAL/C ESTEN");
		boxCarroceria.addItem("ABERTA/MEC OPERACIONAL/C SUPLEM");
		boxCarroceria.addItem("FECHADA/MEC OPERACIONAL/C DUPL");
		boxCarroceria.addItem("FECHADA/MEC OPERACIONAL/C EST");
		boxCarroceria.addItem("FECHADA/MEC OPERACIONAL/C SUP");
		boxCarroceria.addItem("TANQUE/CABINE DUPLA");
		boxCarroceria.addItem("TANQUE/CABINE ESTENDIDA");
		boxCarroceria.addItem("TANQUE/CABINE SUPLEMENTAR");
		boxCarroceria.addItem("TANQUE/MEC OPERACIONAL/C DUPLA");
		boxCarroceria.addItem("TANQUE/MEC OPERACIONAL/C ESTEN");
		boxCarroceria.addItem("TANQUE/MEC OPERACIONAL/C SUPL");
		boxCarroceria.addItem("ROLLON ROLLOFF/CABINE DUPLA");
		boxCarroceria.addItem("ROLLON ROLLOFF/C ESTENDIDA");
		boxCarroceria.addItem("ROLLON ROLLOFF/C SUPLEMENTAR");
		boxCarroceria.addItem("BASCULANTE/CABINE DUPLA");
		boxCarroceria.addItem("BASCULANTE/CABINE ESTENDIDA");
		boxCarroceria.addItem("BASC/C/SUPL");
		boxCarroceria.addItem("PRANCHA/CABINE DUPLA");
		boxCarroceria.addItem("PRANCHA/CABINE ESTENDIDA");
		boxCarroceria.addItem("PRANCHA/CABINE SUPLEMENTAR");
		boxCarroceria.addItem("PRANCHA/MEC OPERAC/C DUPLA");
		boxCarroceria.addItem("PRANCHA/MEC OPERAC/C ESTENDIDA");
		boxCarroceria.addItem("PRANCHA/MEC OPERAC/C SUPLEMENT");
		boxCarroceria.addItem("ABERTA/INTERCAMBIAVEL/CAB DUPL");
		boxCarroceria.addItem("ABERTA/INTERCAMBIAVEL/CAB ESTE");
		boxCarroceria.addItem("ABERTA/INTERCAMBIAVLE/CAB SUP");
		boxCarroceria.addItem("ABERTA/CABINE TRIPLA");
		boxCarroceria.addItem("FECHADA/CABINE TRIPLA");
		boxCarroceria.addItem("SILO/BASCULANTE");
		boxCarroceria.addItem("CHASSI CONTEINER/CABINE LINEAR");
		boxCarroceria.addItem("MECANISMO OPERACIONAL/CABINE LINEAR");
		boxCarroceria.addItem("PRANCHA/CABINE LINEAR");
		boxCarroceria.addItem("SILO/CABINE LINEAR");
		boxCarroceria.addItem("CONTEINER/CARROCERIA AB/CAB LINEAR");
		boxCarroceria.addItem("PRANCHA CONTEINER/CABINE LINEAR");
		boxCarroceria.addItem("ROLL-ON-ROLL-OFF/CABINE LINEAR");
		boxCarroceria.addItem("TRANSPORTE TORAS/CABINE LINEAR");
		boxCarroceria.addItem("CARROCERIA AB/INTERCAMBIAVEL/C LINE");
		boxCarroceria.addItem("CARROCERIA AB/MEC OP/CAB LINEAR");
		boxCarroceria.addItem("TANQUE/MEC. OP/CABINE LINEAR");
		boxCarroceria.addItem("CABINE LINEAR/PRANCHA/MEC. OP");
		boxCarroceria.addItem("TRANSPORTE DE GRANITO/CABINE LINEAR");
		boxCarroceria.addItem("SILO/BASCULANTE/CABINE LINEAR");
		boxCarroceria.addItem("BASCULANTE/MEC.OP/CABINE LINEAR");
		boxCarroceria.addItem("INACABADA/CABINE LINEAR");
		boxCarroceria.addItem("CABINE TRIPLA");
		boxCarroceria.addItem("MECANISMO OPERACIONAL/CABINE TRIPLA");
		boxCarroceria.addItem("INACABADA/CABINE TRIPLA");
		boxCarroceria.addItem("TANQUE PRODUTO PERIGOSO/CAB. LINEAR");
		boxCarroceria.addItem("TANQUE PRODUTO PERIGOSO/CAB SUPLEM");
		boxCarroceria.addItem("SOM/CABINE DUPLA");
		boxCarroceria.addItem("TANQUE PRODUTO PERIGOSO/MEC OP");
		boxCarroceria.addItem("TANQ PROD PERI/MEC OP/CABINE ESTEND");
		boxCarroceria.addItem("TANQ PROD PERI/MEC OP/CABINE DUPLA");
		boxCarroceria.addItem("TANQ PROD PERI/MEC OP/CABINE SUPLEM");
		boxCarroceria.addItem("TANQ PROD PERI/MEC OP/CABINE LINEAR");
		boxCarroceria.addItem("TRANSPORTE TORAS/ MECANISMO OPERAC");
		boxCarroceria.addItem("TRASN TORAS/MEC OP/ CABINE ESTENDID");
		boxCarroceria.addItem("TRANSPORTE TORAS/MEC OP/CAB DUPLA");
		boxCarroceria.addItem("TRASPORTE TORAS/MEC OP/ CAB SUPLEM");
		boxCarroceria.addItem("TRANSPORTE TORAS/ MEC OP/CAB LINEAR");
		boxCarroceria.addItem("COMBOIO");
		boxCarroceria.addItem("SILO/CABINE ESTENDIDA");
		boxCarroceria.addItem("TRANSPORTE ESCOLAR");
		boxCarroceria.addItem("CABINE SUPLEMENTAR");
		boxCarroceria.addItem("MEC.OPERACIONAL/CAB.ESTENDIDA");
		boxCarroceria.addItem("BASCULA/MECANISMO OPERACIONAL");
		boxCarroceria.addItem("CHASSI CONTEINER CABINE ESTENDIDA");
		boxCarroceria.addItem("TRANSP.DE TORAS/ CABINE ESTENDIDA");
		boxCarroceria.addItem("SILO BASCULANTE CABINE ESTENDIDA");
		boxCarroceria.addItem("CONTAINER/C.ABERTA/CB.ESTENDIDA");
		boxCarroceria.addItem("PRANCHA CONTEINER/CAB. ESTENDIDA");
		boxCarroceria.addItem("TRANSP/VALORES");
		boxCarroceria.addItem("TRANSPORTE DE VALORES M.OPERACIONAL");
		boxCarroceria.addItem("TANQUE PRODUTO PERIGOSO");
		boxCarroceria.addItem("INACABADA");
		boxCarroceria.addItem("TRANSPORTE DE GRANITO CAB.ESTENDIDA");
		boxCarroceria.addItem("BASCULANTE/M.OPERCIONAL/C.ESTENDIDA");
		boxCarroceria.addItem("CHASSI CONTAINER CABINE DUPLA");
		boxCarroceria.addItem("SILO CABINE DUPLA");
		boxCarroceria.addItem("CONTEINER/C.ABERTA/C.DUPLA");
		boxCarroceria.addItem("PRANCHA CONTEINER C.DUPLA");
		boxCarroceria.addItem("TRANSPORTE TORAS C. DUPLA");
		boxCarroceria.addItem("TRANSPORTE DE GRANITO/ C. DUPLA");
		boxCarroceria.addItem("SILO/BASCULANTE/C.DUPLA");
		boxCarroceria.addItem("BASCULANTE/M.OPERACIONAL/C.DUPLA");
		boxCarroceria.addItem("CHASSI CONTEINER/C.SUPLEMENTAR");
		boxCarroceria.addItem("M.OPERACIONAL/C. SUPLEMENTAR");
		boxCarroceria.addItem("SILO/CAB. SUPLEMENTAR");
		boxCarroceria.addItem("CONTEINER/C.ABERTA/C.SUPLEMENTAR");
		boxCarroceria.addItem("TANQUE/PROD.PERIGISO/C.ESTENDIDA");
		boxCarroceria.addItem("CARROC.FECHADA/MEC.OPER/CAB.LINEAR");
		boxCarroceria.addItem("SOM");
		boxCarroceria.addItem("PRANCHA CONTEINER CAB.SUPLEMENTAR");
		boxCarroceria.addItem("TRANSPORTE DE TORAS CAB.SUPLEMENTAR");
		boxCarroceria.addItem("TANQUE/C LINEAR");
		boxCarroceria.addItem("TANQ PP/C.LINEAR");
		add(boxCarroceria);

		labelCapCarga = new JLabel("CAP.CARGA TON");
		add(labelCapCarga);

		textFieldCapCarga = new JTextField();
		textFieldCapCarga.setDocument(new TamanhoUpperCase(10));
		add(textFieldCapCarga);

		labelCmtTon = new JLabel("CMT-TON");
		add(labelCmtTon);

		textFieldCmtTon = new JTextField();
		textFieldCmtTon.setDocument(new TamanhoUpperCase(10));
		add(textFieldCmtTon);

		labelEixos = new JLabel("N.EIXOS:");
		add(labelEixos);

		textFieldEixos = new JTextField();
		textFieldEixos.setDocument(new TamanhoUpperCase(2));
		add(textFieldEixos);

		labelRestricoes = new JLabel("MODALIDADE DE RESTRIÇÕES");
		add(labelRestricoes);

		boxRestricoes = new JComboBox<String>();
		boxRestricoes.addItem("");
		boxRestricoes.addItem("ALIENADO");
		boxRestricoes.addItem("SEM ALIENAÇÃO");
		boxRestricoes.addItem("RESERVA DE DOMÍNIO");
		add(boxRestricoes);

		labelIpva = new JLabel("ISENTO/IMUNE IPVA");
		add(labelIpva);

		boxIpva = new JComboBox<String>();
		boxIpva.addItem("");
		boxIpva.addItem("SIM");
		boxIpva.addItem("NÃO");
		add(boxIpva);

		labelProprietarioAnteriorNome = new JLabel("NOME (PROPRIETÁRIO ANTERIOR)");
		add(labelProprietarioAnteriorNome);

		textFieldProprietarioAnteriorNome = new JTextField();
		textFieldProprietarioAnteriorNome.setDocument(new TamanhoUpperCase(50));
		add(textFieldProprietarioAnteriorNome);

		labelProprietarioAnteriorCPF = new JLabel("CPF (PROPRIETÁRIO ANTERIOR)");
		add(labelProprietarioAnteriorCPF);

		textFieldProprietarioAnteriorCPF = new JTextField();
		textFieldProprietarioAnteriorCPF.setDocument(new TamanhoUpperCase(14));
		add(textFieldProprietarioAnteriorCPF);

		labelProprietarioAnteriorCNPJ = new JLabel("CNPJ (PROPRIETÁRIO ANTERIOR)");
		add(labelProprietarioAnteriorCNPJ);

		textFieldProprietarioAnteriorCNPJ = new JTextField();
		textFieldProprietarioAnteriorCNPJ.setDocument(new TamanhoUpperCase(19));
		add(textFieldProprietarioAnteriorCNPJ);

		labelProprietarioAnteriorRGNumero = new JLabel("RG NÚMERO (PROPRIETÁRIO ANTERIOR)");
		add(labelProprietarioAnteriorRGNumero);

		textFieldProprietarioAnteriorRGNumero = new JTextField();
		textFieldProprietarioAnteriorRGNumero.setDocument(new TamanhoUpperCase(15));
		add(textFieldProprietarioAnteriorRGNumero);

		labelProprietarioAnteriorRGOrgaoEmissor = new JLabel("RG ORGÃO EMISSOR (PROPRIETÁRIO ANTERIOR)");
		add(labelProprietarioAnteriorRGOrgaoEmissor);

		textFieldProprietarioAnteriorRGOrgaoEmissor = new JTextField();
		textFieldProprietarioAnteriorRGOrgaoEmissor.setDocument(new TamanhoUpperCase(20));
		add(textFieldProprietarioAnteriorRGOrgaoEmissor);

		labelProprietarioAnteriorFone1 = new JLabel("TELEFONE (PROPRIETÁRIO ANTERIOR)");
		add(labelProprietarioAnteriorFone1);

		textFieldProprietarioAnteriorFone1 = new JTextField();
		textFieldProprietarioAnteriorFone1.setDocument(new TamanhoUpperCase(20));
		add(textFieldProprietarioAnteriorFone1);

		labelProprietarioAnteriorFone2 = new JLabel("TELEFONE (PROPRIETÁRIO ANTERIOR)");
		add(labelProprietarioAnteriorFone2);

		textFieldProprietarioAnteriorFone2 = new JTextField();
		textFieldProprietarioAnteriorFone2.setDocument(new TamanhoUpperCase(20));
		add(textFieldProprietarioAnteriorFone2);

		labelProprietarioAnteriorFax = new JLabel("FAX (PROPRIETÁRIO ANTERIOR)");
		add(labelProprietarioAnteriorFax);

		textFieldProprietarioAnteriorFax = new JTextField();
		textFieldProprietarioAnteriorFax.setDocument(new TamanhoUpperCase(20));
		add(textFieldProprietarioAnteriorFax);

		labelProprietarioAnteriorEmail = new JLabel("EMAIL (PROPRIETÁRIO ANTERIOR)");
		add(labelProprietarioAnteriorEmail);

		textFieldProprietarioAnteriorEmail = new JTextField();
		textFieldProprietarioAnteriorEmail.setDocument(new TamanhoUpperCase(50));
		add(textFieldProprietarioAnteriorEmail);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 157, 1, // rows, cols
				5, 5, // initX, initY
				5, 5); // xPad, yPad
		setOpaque(true); // content panes must be opaque
	}

	@Override
	public void iniciarGuiGerenteEventos() {
		guiGerenteEventos = new GuiGerenteEventos(this);
	}

	@Override
	public void iniciarGerenteEventos() {

	}

	@Override
	public void iniciarLayout() {
		setLayout(new SpringLayout());
	}

	@Override
	public void iniciarTable() {

	}

	@Override
	public void limparGui() {

	}

	@Override
	public void reiniciarBox() {
		CentroCusto centroCusto = null;
		List<CentroCusto> centroCustos = (List<CentroCusto>) CentroCustoDaoFacade.getRegistro();
		Collections.sort(centroCustos, new CentroCustoSort().new Nome());
		this.boxCentroCusto.removeAllItems();
		for (CentroCusto b : centroCustos) {
			this.boxCentroCusto.addItem(b);
		}
		if (!MainGerenteEventos.getFrameCadastroVeiculo().isShowing()
				&& MainGerenteEventos.getFrameCadastroVeiculo().getVeiculoGerenteEventos().getVeiculo() != null) {
			centroCusto = MainGerenteEventos.getFrameCadastroVeiculo().getVeiculoGerenteEventos().getVeiculo().getCentroCusto();
			boxCentroCusto.setSelectedItem(centroCusto);
		}
	}
}

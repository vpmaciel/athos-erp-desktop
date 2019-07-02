package erp.veiculo;

import java.util.Collections;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.Sis;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.EntradaMaiuscula;
import arquitetura.gui.EntradaMinuscula;
import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.registro.ToolBar;
import arquitetura.util.SpringUtilities;
import arquitetura.validacao.Mascara;
import erp.centrocusto.CentroCusto;
import erp.centrocusto.CentroCustoComp;
import erp.centrocusto.CentroCustoFac;
import erp.main.MainControl;
import erp.veiculo.marca.VeiculoMarca;
import erp.veiculo.marca.VeiculoMarcaComp;
import erp.veiculo.marca.VeiculoMarcaFac;
import erp.veiculo.modelo.VeiculoModelo;
import erp.veiculo.modelo.VeiculoModeloComp;
import erp.veiculo.modelo.VeiculoModeloFac;

@SuppressWarnings("serial")
public final class VeiculoPc extends JPanel implements Gui {

	private JComboBox<String> boxAdaptadoDeficiente;
	private JComboBox<String> boxAtividade;
	private JComboBox<String> boxCambio;
	private JComboBox<String> boxCarroceria;
	private JComboBox<String> boxCategoria;
	private JComboBox<CentroCusto> boxCentroCusto;
	private JComboBox<String> boxChassiRemarcado;
	private JComboBox<String> boxCombustivel;
	private JComboBox<String> boxCor;
	private JComboBox<String> boxEspecie;
	private JComboBox<String> boxEstadoEmplacamento;
	private JComboBox<String> boxFabricacao;
	private JComboBox<String> boxIpva;
	private JComboBox<String> boxMesReferenciaCadastro;
	private JComboBox<String> boxMesReferenciaCompra;
	private JComboBox<String> boxMesReferenciaVenda;
	private JComboBox<String> boxPneus;
	private JComboBox<String> boxRebaixado;
	private JComboBox<String> boxRestricoes;
	private JComboBox<String> boxRodas;
	private JComboBox<String> boxSubCategoria;
	private JComboBox<String> boxTipo;
	private JComboBox<VeiculoMarca> boxVeiculoMarca;
	private JComboBox<VeiculoModelo> boxVeiculoModelo;
	private JComboBox<String> boxZeroKm;
	private ConfiguracaoGui configuracaoGui;
	private JFormattedTextField fieldAnoFabricacao;
	private JFormattedTextField fieldAnoModelo;
	private JFormattedTextField fieldAnoReferenciaCadastro;
	private JFormattedTextField fieldAnoReferenciaCompra;
	private JFormattedTextField fieldAnoReferenciaVenda;
	private JTextField fieldBairro;
	private JTextField fieldCapaenderecoCidadePassageiros;
	private JTextField fieldCapCarga;
	private JFormattedTextField fieldCep;
	private JTextField fieldChassi;
	private JTextField fieldCidade;
	private JTextField fieldCilindrada;
	private JTextField fieldCilindros;
	private JTextField fieldCmtTon;
	private JTextField fieldComplemento;
	private JFormattedTextField fieldDataCompra;
	private JFormattedTextField fieldDataVenda;
	private JTextField fieldDepreciacao;
	private JTextField fieldDesconto;
	private JTextField fieldEixos;
	private JTextField fieldEstado;
	private JTextField fieldLogradouro;
	private JTextField fieldLucro;
	private JTextField fieldMarchas;
	private JTextField fieldMunicipioEmplacamento;
	private JTextField fieldNumeroMotor;
	private JTextField fieldNumeroPortas;
	private JTextField fieldPais;
	private JTextField fieldPlaca;
	private JTextField fieldPotencia;
	private JTextField fieldPrejuizo;
	private JFormattedTextField fieldProprietarioAnteriorCNPJ;
	private JFormattedTextField fieldProprietarioAnteriorCPF;
	private JTextField fieldProprietarioAnteriorEmail;
	private JFormattedTextField fieldProprietarioAnteriorFax;
	private JFormattedTextField fieldProprietarioAnteriorFone1;
	private JFormattedTextField fieldProprietarioAnteriorFone2;
	private JTextField fieldProprietarioAnteriorNome;
	private JTextField fieldProprietarioAnteriorRGNumero;
	private JTextField fieldProprietarioAnteriorRGOrgaoEmissor;
	private JFormattedTextField fieldProprietarioCNPJ;
	private JFormattedTextField fieldProprietarioCPF;
	private JTextField fieldProprietarioEmail;
	private JFormattedTextField fieldProprietarioFax;
	private JFormattedTextField fieldProprietarioFone1;
	private JFormattedTextField fieldProprietarioFone2;
	private JTextField fieldProprietarioNome;
	private JTextField fieldProprietarioRGNumero;
	private JTextField fieldProprietarioRGOrgaoEmisssor;
	private JTextField fieldQuilometragem;
	private JTextField fieldRenavam;
	private JTextField fieldValorCompra;
	private JTextField fieldValorVenda;
	private JTextField fieldValvulas;
	private JLabel labelCentroCusto;
	private JLabel labelVeiculoMarca;
	private JLabel labelVeiculoModelo;
	private ToolBar toolBar;

	public VeiculoPc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
	}

	@Override
	public void atualizarTable() {

	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public JLabel getLabelCentroCusto() {
		return labelCentroCusto;
	}

	public JLabel getLabelVeiculoMarca() {
		return labelVeiculoMarca;
	}

	public JLabel getLabelVeiculoModelo() {
		return labelVeiculoModelo;
	}

	public JComboBox<String> getGuiAdaptadoDeficiente() {
		return boxAdaptadoDeficiente;
	}

	public JFormattedTextField getGuiAnoFabricacao() {
		return fieldAnoFabricacao;
	}

	public JFormattedTextField getGuiAnoModelo() {
		return fieldAnoModelo;
	}

	public JTextField getGuiAnoReferenciaCadastro() {
		return fieldAnoReferenciaCadastro;
	}

	public JFormattedTextField getGuiAnoReferenciaCompra() {
		return fieldAnoReferenciaCompra;
	}

	public JFormattedTextField getGuiAnoReferenciaVenda() {
		return fieldAnoReferenciaVenda;
	}

	public JComboBox<String> getGuiAtividade() {
		return boxAtividade;
	}

	public JTextField getGuiBairro() {
		return fieldBairro;
	}

	public JComboBox<String> getGuiCambio() {
		return boxCambio;
	}

	public JTextField getGuiCapaenderecoCidadePassageiros() {
		return fieldCapaenderecoCidadePassageiros;
	}

	public JTextField getGuiCapCarga() {
		return fieldCapCarga;
	}

	public JComboBox<String> getGuiCarroceria() {
		return boxCarroceria;
	}

	public JComboBox<String> getGuiCategoria() {
		return boxCategoria;
	}

	public JComboBox<CentroCusto> getGuiCentroCusto() {
		return boxCentroCusto;
	}

	public JFormattedTextField getGuiCep() {
		return fieldCep;
	}

	public JTextField getGuiChassi() {
		return fieldChassi;
	}

	public JComboBox<String> getGuiChassiRemarcado() {
		return boxChassiRemarcado;
	}

	public JTextField getGuiCidade() {
		return fieldCidade;
	}

	public JTextField getGuiCilindrada() {
		return fieldCilindrada;
	}

	public JTextField getGuiCilindros() {
		return fieldCilindros;
	}

	public JTextField getGuiCmtTon() {
		return fieldCmtTon;
	}

	public JComboBox<String> getGuiCombustivel() {
		return boxCombustivel;
	}

	public JTextField getGuiComplemento() {
		return fieldComplemento;
	}

	public JComboBox<String> getGuiCor() {
		return boxCor;
	}

	public JFormattedTextField getGuiDataCompra() {
		return fieldDataCompra;
	}

	public JFormattedTextField getGuiDataVenda() {
		return fieldDataVenda;
	}

	public JTextField getGuiDepreciacao() {
		return fieldDepreciacao;
	}

	public JTextField getGuiDesconto() {
		return fieldDesconto;
	}

	public JTextField getGuiEixos() {
		return fieldEixos;
	}

	public JComboBox<String> getGuiEspecie() {
		return boxEspecie;
	}

	public JTextField getGuiEstado() {
		return fieldEstado;
	}

	public JComboBox<String> getGuiEstadoEmplacamento() {
		return boxEstadoEmplacamento;
	}

	public JComboBox<String> getGuiFabricacao() {
		return boxFabricacao;
	}

	public JComboBox<String> getGuiIpva() {
		return boxIpva;
	}

	public JTextField getGuiLogradouro() {
		return fieldLogradouro;
	}

	public JTextField getGuiLucro() {
		return fieldLucro;
	}

	public JTextField getGuiMarchas() {
		return fieldMarchas;
	}

	public JComboBox<String> getGuiMesReferenciaCadastro() {
		return boxMesReferenciaCadastro;
	}

	public JComboBox<String> getGuiMesReferenciaCompra() {
		return boxMesReferenciaCompra;
	}

	public JComboBox<String> getGuiMesReferenciaVenda() {
		return boxMesReferenciaVenda;
	}

	public JTextField getGuiMunicipioEmplacamento() {
		return fieldMunicipioEmplacamento;
	}

	public JTextField getGuiNumeroMotor() {
		return fieldNumeroMotor;
	}

	public JTextField getGuiNumeroPortas() {
		return fieldNumeroPortas;
	}

	public JTextField getGuiPais() {
		return fieldPais;
	}

	public JTextField getGuiPlaca() {
		return fieldPlaca;
	}

	public JComboBox<String> getGuiPneus() {
		return boxPneus;
	}

	public JTextField getGuiPotencia() {
		return fieldPotencia;
	}

	public JTextField getGuiPrejuizo() {
		return fieldPrejuizo;
	}

	public JFormattedTextField getGuiProprietarioAnteriorCnpj() {
		return fieldProprietarioAnteriorCNPJ;
	}

	public JFormattedTextField getGuiProprietarioAnteriorCpf() {
		return fieldProprietarioAnteriorCPF;
	}

	public JTextField getGuiProprietarioAnteriorEmail() {
		return fieldProprietarioAnteriorEmail;
	}

	public JFormattedTextField getGuiProprietarioAnteriorFax() {
		return fieldProprietarioAnteriorFax;
	}

	public JFormattedTextField getGuiProprietarioAnteriorFone1() {
		return fieldProprietarioAnteriorFone1;
	}

	public JFormattedTextField getGuiProprietarioAnteriorFone2() {
		return fieldProprietarioAnteriorFone2;
	}

	public JTextField getGuiProprietarioAnteriorNome() {
		return fieldProprietarioAnteriorNome;
	}

	public JTextField getGuiProprietarioAnteriorRGNumero() {
		return fieldProprietarioAnteriorRGNumero;
	}

	public JTextField getGuiProprietarioAnteriorRGOrgaoEmissor() {
		return fieldProprietarioAnteriorRGOrgaoEmissor;
	}

	public JFormattedTextField getGuiProprietarioCnpj() {
		return fieldProprietarioCNPJ;
	}

	public JFormattedTextField getGuiProprietarioCpf() {
		return fieldProprietarioCPF;
	}

	public JTextField getGuiProprietarioEmail() {
		return fieldProprietarioEmail;
	}

	public JFormattedTextField getGuiProprietarioFax() {
		return fieldProprietarioFax;
	}

	public JFormattedTextField getGuiProprietarioFone1() {
		return fieldProprietarioFone1;
	}

	public JFormattedTextField getGuiProprietarioFone2() {
		return fieldProprietarioFone2;
	}

	public JTextField getGuiProprietarioNome() {
		return fieldProprietarioNome;
	}

	public JTextField getGuiProprietarioRGNumero() {
		return fieldProprietarioRGNumero;
	}

	public JTextField getGuiProprietarioRGOrgaoEmisssor() {
		return fieldProprietarioRGOrgaoEmisssor;
	}

	public JTextField getGuiQuilometragem() {
		return fieldQuilometragem;
	}

	public JComboBox<String> getGuiRebaixado() {
		return boxRebaixado;
	}

	public JTextField getGuiRenavam() {
		return fieldRenavam;
	}

	public JComboBox<String> getGuiRestricoes() {
		return boxRestricoes;
	}

	public JComboBox<String> getGuiRodas() {
		return boxRodas;
	}

	public JComboBox<String> getGuiSubCategoria() {
		return boxSubCategoria;
	}

	public JComboBox<String> getGuiTipo() {
		return boxTipo;
	}

	public JTextField getGuiValorCompra() {
		return fieldValorCompra;
	}

	public JTextField getGuiValorVenda() {
		return fieldValorVenda;
	}

	public JTextField getGuiValvulas() {
		return fieldValvulas;
	}

	public JComboBox<String> getGuiVeiculoDeficiente() {
		return boxAdaptadoDeficiente;
	}

	public JComboBox<VeiculoMarca> getGuiVeiculoMarca() {
		return boxVeiculoMarca;
	}

	public JComboBox<VeiculoModelo> getGuiVeiculoModelo() {
		return boxVeiculoModelo;
	}

	public JComboBox<String> getGuiZeroKm() {
		return boxZeroKm;
	}

	public ToolBar getToolBar() {
		return toolBar;
	}

	@Override
	public void iniciarControlador() {

	}

	@Override
	public void iniciarFocoControlador() {
		@SuppressWarnings("unused")
		FocoEvento focoEvento = new FocoEvento(this);
	}

	@Override
	public void iniciarGui() {
		toolBar = new ToolBar();

		this.add(toolBar.getToolBar());

		add(new JLabel("PLACA"));

		fieldPlaca = new JTextField();
		fieldPlaca.setDocument(new EntradaMaiuscula(8));
		add(fieldPlaca);

		labelVeiculoMarca = new JLabel("MARCA DO VEÍCULO");
		labelVeiculoMarca.setCursor(Sis.getNovaJanelaCursor());
		add(labelVeiculoMarca);

		boxVeiculoMarca = new JComboBox<VeiculoMarca>();

		List<VeiculoMarca> veiculoMarcas = (List<VeiculoMarca>) VeiculoMarcaFac.getRegistro();
		Collections.sort(veiculoMarcas, new VeiculoMarcaComp().new Marca());

		for (VeiculoMarca veiculoMarca : veiculoMarcas) {
			boxVeiculoMarca.addItem(veiculoMarca);
		}

		add(boxVeiculoMarca);

		labelVeiculoModelo = new JLabel("MODELO DO VEÍCULO");
		labelVeiculoModelo.setCursor(Sis.getNovaJanelaCursor());
		add(labelVeiculoModelo);

		boxVeiculoModelo = new JComboBox<VeiculoModelo>();

		List<VeiculoModelo> veiculoModelos = (List<VeiculoModelo>) VeiculoModeloFac.getRegistro();

		Collections.sort(veiculoModelos, new VeiculoModeloComp().new Modelo());

		for (VeiculoModelo v : veiculoModelos) {
			boxVeiculoModelo.addItem(v);
		}

		add(boxVeiculoModelo);

		add(new JLabel("CHASSI"));

		fieldChassi = new JTextField();
		fieldChassi.setDocument(new EntradaMaiuscula(20));
		add(fieldChassi);

		add(new JLabel("NÚMERO DO MOTOR"));

		fieldNumeroMotor = new JTextField();
		fieldNumeroMotor.setDocument(new EntradaMaiuscula(15));
		add(fieldNumeroMotor);

		add(new JLabel("RENAVAM"));

		fieldRenavam = new JTextField();
		fieldRenavam.setDocument(new EntradaMaiuscula(15));
		add(fieldRenavam);

		add(new JLabel("CHASSI REMARCADO"));

		boxChassiRemarcado = new JComboBox<String>();
		boxChassiRemarcado.addItem("");
		boxChassiRemarcado.addItem("SIM");
		boxChassiRemarcado.addItem("NÃO");
		add(boxChassiRemarcado);

		add(new JLabel("NÚMERO DE PORTAS"));

		fieldNumeroPortas = new JTextField();
		fieldNumeroPortas.setDocument(new EntradaMaiuscula(1));
		add(fieldNumeroPortas);

		add(new JLabel("VALOR DE COMPRA"));

		fieldValorCompra = new JTextField();
		fieldValorCompra.setDocument(new EntradaMaiuscula(10));
		add(fieldValorCompra);

		add(new JLabel("VALOR DE VENDA"));

		fieldValorVenda = new JTextField();
		fieldValorVenda.setDocument(new EntradaMaiuscula(10));
		add(fieldValorVenda);

		add(new JLabel("DESCONTO"));

		fieldDesconto = new JTextField();
		fieldDesconto.setDocument(new EntradaMaiuscula(10));
		add(fieldDesconto);

		add(new JLabel("LUCRO"));

		fieldLucro = new JTextField();
		fieldLucro.setDocument(new EntradaMaiuscula(10));
		add(fieldLucro);

		add(new JLabel("PREJUÍZO"));

		fieldPrejuizo = new JTextField();
		fieldPrejuizo.setDocument(new EntradaMaiuscula(10));
		add(fieldPrejuizo);

		add(new JLabel("DEPRECIAÇÃO"));

		fieldDepreciacao = new JTextField();
		fieldDepreciacao.setDocument(new EntradaMaiuscula(10));
		add(fieldDepreciacao);

		add(new JLabel("DATA DA COMPRA"));

		fieldDataCompra = new JFormattedTextField(Mascara.getData());
		add(fieldDataCompra);

		add(new JLabel("DATA DA VENDA"));

		fieldDataVenda = new JFormattedTextField(Mascara.getData());
		add(fieldDataVenda);

		add(new JLabel("MÊS DE REFERÊNCIA DO CADASTRO"));

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

		add(new JLabel("ANO DE REFERÊNCIA DO CADASTRO"));

		fieldAnoReferenciaCadastro = new JFormattedTextField(Mascara.getAno());
		fieldAnoReferenciaCadastro.setDocument(new EntradaMaiuscula(10));
		add(fieldAnoReferenciaCadastro);

		add(new JLabel("MÊS DE REFERÊNCIA DA COMPRA"));

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

		add(new JLabel("ANO DE REFERÊNCIA DA COMPRA"));

		fieldAnoReferenciaCompra = new JFormattedTextField(Mascara.getAno());
		add(fieldAnoReferenciaCompra);

		add(new JLabel("MÊS DE REFERÊNCIA DA VENDA"));

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

		add(new JLabel("ANO DE REFERÊNCIA DA VENDA"));

		fieldAnoReferenciaVenda = new JFormattedTextField(Mascara.getAno());
		fieldAnoReferenciaVenda.setDocument(new EntradaMaiuscula(10));
		add(fieldAnoReferenciaVenda);

		add(new JLabel("MUNICÍPIO DE EMPLACAMENTO"));

		fieldMunicipioEmplacamento = new JTextField();
		fieldMunicipioEmplacamento.setDocument(new EntradaMaiuscula(50));
		add(fieldMunicipioEmplacamento);

		add(new JLabel("ESTADO DE EMPLACAMENTO"));

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

		add(new JLabel("NOME DO PROPRIETÁRIO"));

		fieldProprietarioNome = new JTextField();
		fieldProprietarioNome.setDocument(new EntradaMaiuscula(50));
		add(fieldProprietarioNome);

		add(new JLabel("IDENTIDADE NÚMERO ( PROPRIETÁRIO )"));

		fieldProprietarioRGNumero = new JTextField();
		fieldProprietarioRGNumero.setDocument(new EntradaMaiuscula(15));
		add(fieldProprietarioRGNumero);

		add(new JLabel("IDENTIDADE ÓRGÃO EMISSOR ( PROPRIETÁRIO )"));

		fieldProprietarioRGOrgaoEmisssor = new JTextField();
		fieldProprietarioRGOrgaoEmisssor.setDocument(new EntradaMaiuscula(20));
		add(fieldProprietarioRGOrgaoEmisssor);

		add(new JLabel("CPF ( PROPRIETÁRIO )"));

		fieldProprietarioCPF = new JFormattedTextField(Mascara.getCpf());
		add(fieldProprietarioCPF);

		add(new JLabel("CNPJ ( PROPRIETÁRIO )"));

		fieldProprietarioCNPJ = new JFormattedTextField(Mascara.getCnpj());
		add(fieldProprietarioCNPJ);

		add(new JLabel("TELEFONE ( PROPRIETÁRIO )"));

		fieldProprietarioFone1 = new JFormattedTextField(Mascara.getFone());
		add(fieldProprietarioFone1);

		add(new JLabel("TELEFONE ( PROPRIETÁRIO )"));

		fieldProprietarioFone2 = new JFormattedTextField(Mascara.getFone());
		add(fieldProprietarioFone2);

		add(new JLabel("FAX ( PROPRIETÁRIO )"));

		fieldProprietarioFax = new JFormattedTextField(Mascara.getFax());
		add(fieldProprietarioFax);

		add(new JLabel("EMAIL ( PROPRIETÁRIO )"));

		fieldProprietarioEmail = new JTextField();
		fieldProprietarioEmail.setDocument(new EntradaMinuscula(50));
		add(fieldProprietarioEmail);

		add(new JLabel("PAÍS ( ENDEREÇO DO PROPRIETÁRIO )"));

		fieldPais = new JTextField();
		fieldPais.setDocument(new EntradaMaiuscula(50));
		add(fieldPais);

		add(new JLabel("ESTADO ( ENDEREÇO DO PROPRIETÁRIO )"));

		fieldEstado = new JTextField();
		fieldEstado.setDocument(new EntradaMaiuscula(50));
		add(fieldEstado);

		add(new JLabel("CIDADE ( ENDEREÇO DO PROPRIETÁRIO )"));

		fieldCidade = new JTextField();
		fieldCidade.setDocument(new EntradaMaiuscula(50));
		add(fieldCidade);

		add(new JLabel("BAIRRO ( ENDEREÇO DO PROPRIETÁRIO )"));

		fieldBairro = new JTextField();
		fieldBairro.setDocument(new EntradaMaiuscula(50));
		add(fieldBairro);

		add(new JLabel("LOGRADOURO ( ENDEREÇO DO PROPRIETÁRIO )"));

		fieldLogradouro = new JTextField();
		fieldLogradouro.setDocument(new EntradaMaiuscula(50));
		add(fieldLogradouro);

		add(new JLabel("COMPLEMENTO ( ENDEREÇO DO PROPRIETÁRIO )"));

		fieldComplemento = new JTextField();
		fieldComplemento.setDocument(new EntradaMaiuscula(20));
		add(fieldComplemento);

		add(new JLabel("CEP ( ENDEREÇO DO PROPRIETÁRIO )"));

		fieldCep = new JFormattedTextField(Mascara.getEnderecoCep());
		add(fieldCep);

		add(new JLabel("ANO DE FABRICAÇÃO ( VEÍCULO )"));

		fieldAnoFabricacao = new JFormattedTextField(Mascara.getAno());
		add(fieldAnoFabricacao);

		add(new JLabel("ANO MODELO ( VEÍCULO )"));

		fieldAnoModelo = new JFormattedTextField(Mascara.getAno());
		add(fieldAnoModelo);

		add(new JLabel("COR (VEÍCULO)"));

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

		add(new JLabel("ZERO KM (VEÍCULO)"));

		boxZeroKm = new JComboBox<String>();
		boxZeroKm.addItem("");
		boxZeroKm.addItem("SIM");
		boxZeroKm.addItem("NÃO");
		add(boxZeroKm);

		add(new JLabel("VEÍCULO ADAPTADO PARA DEFICIENTE"));

		boxAdaptadoDeficiente = new JComboBox<String>();
		boxAdaptadoDeficiente.addItem("");
		boxAdaptadoDeficiente.addItem("SIM");
		boxAdaptadoDeficiente.addItem("NÃO");
		add(boxAdaptadoDeficiente);

		add(new JLabel("CAPACIDADE DE PASSAGEIROS"));

		fieldCapaenderecoCidadePassageiros = new JTextField();
		fieldCapaenderecoCidadePassageiros.setDocument(new EntradaMaiuscula(3));
		add(fieldCapaenderecoCidadePassageiros);

		add(new JLabel("COMBUSTÍVEL"));

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

		add(new JLabel("FABRICAÇÃO"));

		boxFabricacao = new JComboBox<String>();
		boxFabricacao.addItem("");
		boxFabricacao.addItem("NACIONAL");
		boxFabricacao.addItem("IMPORTADO");
		add(boxFabricacao);

		add(new JLabel("SUB CATEGORIA"));

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

		add(new JLabel("PNEUS"));

		boxPneus = new JComboBox<String>();
		boxPneus.addItem("");
		boxPneus.addItem("OFF-ROAD");
		boxPneus.addItem("MISTO");
		boxPneus.addItem("VERDE");
		add(boxPneus);

		add(new JLabel("RODAS (ARO)"));

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

		add(new JLabel("VÁLVULAS"));

		fieldValvulas = new JTextField();
		fieldValvulas.setDocument(new EntradaMaiuscula(10));
		add(fieldValvulas);

		add(new JLabel("REBAIXADO"));

		boxRebaixado = new JComboBox<String>();
		boxRebaixado.addItem("");
		boxRebaixado.addItem("SIM");
		boxRebaixado.addItem("NÃO");
		add(boxRebaixado);

		add(new JLabel("QUILOMETRAGEM"));

		fieldQuilometragem = new JTextField();
		fieldQuilometragem.setDocument(new EntradaMaiuscula(10));
		add(fieldQuilometragem);

		labelCentroCusto = new JLabel("CENTRO DE CUSTO");
		add(labelCentroCusto);

		boxCentroCusto = new JComboBox<CentroCusto>();
		List<CentroCusto> centroCustos = (List<CentroCusto>) CentroCustoFac.getRegistro();
		Collections.sort(centroCustos, new CentroCustoComp().new Nome());
		for (CentroCusto c : centroCustos) {
			boxCentroCusto.addItem(c);
		}

		add(boxCentroCusto);

		add(new JLabel("TIPO"));

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

		add(new JLabel("ATIVIDADE"));

		boxAtividade = new JComboBox<String>();
		boxAtividade.addItem("");
		boxAtividade.addItem("USO PRÓPRIO/OUTROS");
		boxAtividade.addItem("LOCADORA");
		boxAtividade.addItem("TÁXI");
		boxAtividade.addItem("ESCOLAR");
		boxAtividade.addItem("COLEÇÃO");
		add(boxAtividade);

		add(new JLabel("CAMBIO"));

		boxCambio = new JComboBox<String>();
		boxCambio.addItem("");
		boxCambio.addItem("CÂMBIO CVT");
		boxCambio.addItem("CÂMBIO AUTOMATIZADO DUPLA EMBREAGEM");
		boxCambio.addItem("CÂMBIO AUTOMATIZADO UMA EMBREAGEM");
		boxCambio.addItem("CÂMBIO MANUAL");
		boxCambio.addItem("CÂMBIO AUTOMÁTICO");
		add(boxCambio);

		add(new JLabel("MARCHAS"));

		fieldMarchas = new JTextField();
		fieldMarchas.setDocument(new EntradaMaiuscula(10));
		add(fieldMarchas);

		add(new JLabel("ESPÉCIE"));

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

		add(new JLabel("POTÊNCIA-CV"));

		fieldPotencia = new JTextField();
		fieldPotencia.setDocument(new EntradaMaiuscula(10));
		add(fieldPotencia);

		add(new JLabel("N.CILINDROS"));

		fieldCilindros = new JTextField();
		fieldCilindros.setDocument(new EntradaMaiuscula(2));
		add(fieldCilindros);

		add(new JLabel("CILINDRADA"));

		fieldCilindrada = new JTextField();
		fieldCilindrada.setDocument(new EntradaMaiuscula(4));
		add(fieldCilindrada);

		add(new JLabel("CATEGORIA"));

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

		add(new JLabel("CARROCERIA"));

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

		add(new JLabel("CAP.CARGA TON"));

		fieldCapCarga = new JTextField();
		fieldCapCarga.setDocument(new EntradaMaiuscula(10));
		add(fieldCapCarga);

		add(new JLabel("CMT-TON"));

		fieldCmtTon = new JTextField();
		fieldCmtTon.setDocument(new EntradaMaiuscula(10));
		add(fieldCmtTon);

		add(new JLabel("N.EIXOS"));

		fieldEixos = new JTextField();
		fieldEixos.setDocument(new EntradaMaiuscula(2));
		add(fieldEixos);

		add(new JLabel("MODALIDADE DE RESTRIÇÕES"));

		boxRestricoes = new JComboBox<String>();
		boxRestricoes.addItem("");
		boxRestricoes.addItem("ALIENADO");
		boxRestricoes.addItem("SEM ALIENAÇÃO");
		boxRestricoes.addItem("RESERVA DE DOMÍNIO");
		add(boxRestricoes);

		add(new JLabel("ISENTO/IMUNE IPVA"));

		boxIpva = new JComboBox<String>();
		boxIpva.addItem("");
		boxIpva.addItem("SIM");
		boxIpva.addItem("NÃO");
		add(boxIpva);

		add(new JLabel("NOME ( PROPRIETÁRIO ANTERIOR )"));

		fieldProprietarioAnteriorNome = new JTextField();
		fieldProprietarioAnteriorNome.setDocument(new EntradaMaiuscula(50));
		add(fieldProprietarioAnteriorNome);

		add(new JLabel("CPF ( PROPRIETÁRIO ANTERIOR )"));

		fieldProprietarioAnteriorCPF = new JFormattedTextField(Mascara.getCpf());
		add(fieldProprietarioAnteriorCPF);

		add(new JLabel("CNPJ ( PROPRIETÁRIO ANTERIOR )"));

		fieldProprietarioAnteriorCNPJ = new JFormattedTextField(Mascara.getCnpj());
		add(fieldProprietarioAnteriorCNPJ);

		add(new JLabel("RG NÚMERO ( PROPRIETÁRIO ANTERIOR )"));

		fieldProprietarioAnteriorRGNumero = new JTextField();
		fieldProprietarioAnteriorRGNumero.setDocument(new EntradaMaiuscula(15));
		add(fieldProprietarioAnteriorRGNumero);

		add(new JLabel("RG ORGÃO EMISSOR ( PROPRIETÁRIO ANTERIOR )"));

		fieldProprietarioAnteriorRGOrgaoEmissor = new JTextField();
		fieldProprietarioAnteriorRGOrgaoEmissor.setDocument(new EntradaMaiuscula(20));
		add(fieldProprietarioAnteriorRGOrgaoEmissor);

		add(new JLabel("TELEFONE ( PROPRIETÁRIO ANTERIOR )"));

		fieldProprietarioAnteriorFone1 = new JFormattedTextField(Mascara.getFone());
		add(fieldProprietarioAnteriorFone1);

		add(new JLabel("TELEFONE ( PROPRIETÁRIO ANTERIOR )"));

		fieldProprietarioAnteriorFone2 = new JFormattedTextField(Mascara.getFone());
		add(fieldProprietarioAnteriorFone2);

		add(new JLabel("FAX ( PROPRIETÁRIO ANTERIOR )"));

		fieldProprietarioAnteriorFax = new JFormattedTextField(Mascara.getFax());
		add(fieldProprietarioAnteriorFax);

		add(new JLabel("EMAIL ( PROPRIETÁRIO ANTERIOR )"));

		fieldProprietarioAnteriorEmail = new JTextField();
		fieldProprietarioAnteriorEmail.setDocument(new EntradaMaiuscula(50));
		add(fieldProprietarioAnteriorEmail);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 159, 1, // rows, cols
				5, 5, // initX, initY
				5, 5); // xPad, yPad
		setOpaque(true); // content panes must be opaque
	}

	@Override
	public void iniciarGuiControlador() {
		configuracaoGui = new ConfiguracaoGui(this);
	}

	@Override
	public void iniciarLayout() {
		setBorder(Sis.getBordaPainel());
		setLayout(new SpringLayout());
	}

	@Override
	public void iniciarTabela() {

	}

	@Override
	public void limparGui() {

	}

	@Override
	public void reiniciarGui() {
		CentroCusto centroCusto = null;
		List<CentroCusto> centroCustos = (List<CentroCusto>) CentroCustoFac.getRegistro();
		Collections.sort(centroCustos, new CentroCustoComp().new Nome());
		this.boxCentroCusto.removeAllItems();

		for (CentroCusto b : centroCustos) {
			this.boxCentroCusto.addItem(b);
		}

		VeiculoMarca veiculoMarca = null;
		List<VeiculoMarca> veiculoMarcas = (List<VeiculoMarca>) VeiculoMarcaFac.getRegistro();
		Collections.sort(veiculoMarcas, new VeiculoMarcaComp().new Marca());
		this.boxVeiculoMarca.removeAllItems();

		for (VeiculoMarca v : veiculoMarcas) {
			this.boxVeiculoMarca.addItem(v);
		}

		VeiculoModelo veiculoModelo = null;
		List<VeiculoModelo> veiculoModelos = (List<VeiculoModelo>) VeiculoModeloFac.getRegistro();
		Collections.sort(veiculoModelos, new VeiculoModeloComp().new Modelo());
		this.boxVeiculoModelo.removeAllItems();

		for (VeiculoModelo v : veiculoModelos) {
			this.boxVeiculoModelo.addItem(v);
		}

		if (!MainControl.getVeiculoFc().isShowing() && MainControl.getVeiculoFc().getVeiculoCont().getVeiculo() != null) {
			centroCusto = MainControl.getVeiculoFc().getVeiculoCont().getVeiculo().getCentroCusto();
			boxCentroCusto.setSelectedItem(centroCusto);

			veiculoMarca = MainControl.getVeiculoFc().getVeiculoCont().getVeiculo().getMarca();
			boxVeiculoMarca.setSelectedItem(veiculoMarca);

			veiculoModelo = MainControl.getVeiculoFc().getVeiculoCont().getVeiculo().getModelo();
			boxVeiculoModelo.setSelectedItem(veiculoModelo);
		}
	}
}

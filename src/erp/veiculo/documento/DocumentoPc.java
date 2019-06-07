package erp.veiculo.documento;

import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import arquitetura.AOP;
import arquitetura.gui.ConfiguracaoGui;
import arquitetura.gui.EntradaMaiuscula;
import arquitetura.gui.FocoEvento;
import arquitetura.gui.Gui;
import arquitetura.gui.registro.ToolBar;
import arquitetura.util.SpringUtilities;
import arquitetura.validacao.Mascara;
import erp.main.MainCont;
import erp.veiculo.Veiculo;
import erp.veiculo.VeiculoComp;
import erp.veiculo.VeiculoFac;

@SuppressWarnings("serial")
public final class DocumentoPc extends JPanel implements Gui {

	private JComboBox<String> boxLocalDocumento;
	private JComboBox<String> boxSituacaoDocumento;
	private JComboBox<String> boxMesRecebimentoDocumento;
	private JTextField fieldAnoRecebimentoDocumento;
	private JComboBox<String> boxMesDevolucaoDocumento;
	private JTextField fieldAnoDevolucaoDocumento;
	private ConfiguracaoGui configuracaoGui;
	private JComboBox<Veiculo> boxVeiculo;
	private JFormattedTextField fieldCNPJRecebedorDocumento;
	private JTextField fieldNomeProprietário;
	private JFormattedTextField fieldCPFRecebedorDocumento;
	private JTextField fieldDiaDevolucaoDocumento;
	private JTextField fieldDiaRecebimentoDocumento;
	private JTextField fieldNomeRecebedorDocumento;
	private JTextField fieldRGNumeroRecebedorDocumento;
	private JTextField fieldRGOrgaoEmisssorRecebedorDocumento;
	private JLabel labelVeiculo;
	private ToolBar toolBar;

	public DocumentoPc() {
		iniciarLayout();
		iniciarGui();
		iniciarFocoControlador();
		iniciarGuiControlador();
	}
	
	public JLabel getLabelVeiculo() {
		return labelVeiculo;
	}

	public JComboBox<String> getGuiMesRecebimentoDocumento() {
		return boxMesRecebimentoDocumento;
	}

	public JTextField getGuiAnoRecebimentoDocumento() {
		return fieldAnoRecebimentoDocumento;
	}

	public JComboBox<String> getGuiMesDevolucaoDocumento() {
		return boxMesDevolucaoDocumento;
	}

	public JTextField getGuiAnoDevolucaoDocumento() {
		return fieldAnoDevolucaoDocumento;
	}

	public JComboBox<String> getGuiLocalDocumento() {
		return boxLocalDocumento;
	}

	public JComboBox<String> getGuiSituacaoDocumento() {
		return boxSituacaoDocumento;
	}

	public JComboBox<Veiculo> getGuiVeiculo() {
		return boxVeiculo;
	}

	public JTextField getGuiCNPJRecebedorDocumento() {
		return fieldCNPJRecebedorDocumento;
	}

	public JTextField getGuiNomeProprietário() {
		return fieldNomeProprietário;
	}

	public JFormattedTextField getGuiCPFRecebedorDocumento() {
		return fieldCPFRecebedorDocumento;
	}

	public JTextField getGuiDiaDevolucaoDocumento() {
		return fieldDiaDevolucaoDocumento;
	}

	public JTextField getGuiDiaRecebimentoDocumento() {
		return fieldDiaRecebimentoDocumento;
	}

	public JTextField getGuiNomeRecebedorDocumento() {
		return fieldNomeRecebedorDocumento;
	}

	public JTextField getGuiRGNumeroRecebedorDocumento() {
		return fieldRGNumeroRecebedorDocumento;
	}

	public JTextField getGuiRGOrgaoEmisssorRecebedorDocumento() {
		return fieldRGOrgaoEmisssorRecebedorDocumento;
	}

	@Override
	public void atualizarTable() {

	}

	@Override
	public ConfiguracaoGui getConfiguracaoGui() {
		return configuracaoGui;
	}

	public ToolBar getTB() {
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

		
		
		add(toolBar.getToolBar());
		
		labelVeiculo = new JLabel("PLACA");
		labelVeiculo.setCursor(AOP.getNovaJanelaCursor());
		add(labelVeiculo);

		boxVeiculo = new JComboBox<Veiculo>();

		List<Veiculo> listVeiculo = (List<Veiculo>) VeiculoFac.getRegistro();
		Collections.sort(listVeiculo, new VeiculoComp().new Placa());

		for (Veiculo veiculo : listVeiculo) {
			boxVeiculo.addItem(veiculo);
		}

		add(boxVeiculo);

		add(new JLabel("NOME DA PESSOA QUE RECEBEU O DOCUMENTO"));

		fieldNomeRecebedorDocumento = new JTextField();
		fieldNomeRecebedorDocumento.setDocument(new EntradaMaiuscula(50));
		add(fieldNomeRecebedorDocumento);

		add(new JLabel("IDENTIDADE DA PESSOA QUE RECEBEU O DOCUMENTO"));

		fieldRGNumeroRecebedorDocumento = new JTextField();
		fieldRGNumeroRecebedorDocumento.setDocument(new EntradaMaiuscula(15));
		add(fieldRGNumeroRecebedorDocumento);

		add(new JLabel("IDENTIDADE ÓRGÃO EMISSOR DA PESSOA QUE RECEBEU O DOCUMENTO"));

		fieldRGOrgaoEmisssorRecebedorDocumento = new JTextField();
		fieldRGOrgaoEmisssorRecebedorDocumento.setDocument(new EntradaMaiuscula(20));
		add(fieldRGOrgaoEmisssorRecebedorDocumento);

		add(new JLabel("CPF DA PESSOA QUE RECEBEU O DOCUMENTO"));

		fieldCPFRecebedorDocumento = new JFormattedTextField(Mascara.getCpf());
		add(fieldCPFRecebedorDocumento);

		add(new JLabel("CNPJ DA PESSOA QUE RECEBEU O DOCUMENTO"));

		fieldCNPJRecebedorDocumento = new JFormattedTextField(Mascara.getCnpj());
		add(fieldCNPJRecebedorDocumento);

		add(new JLabel("SITUAÇÃO DO DOCUMENTO"));

		boxSituacaoDocumento = new JComboBox<String>();
		boxSituacaoDocumento.addItem("");
		boxSituacaoDocumento.addItem("AGUARDANDO");
		boxSituacaoDocumento.addItem("PROCESSANDO");
		boxSituacaoDocumento.addItem("PRONTO");
		add(boxSituacaoDocumento);

		add(new JLabel("DOCUMENTO ESTA ATUALMENTE COM"));

		boxLocalDocumento = new JComboBox<String>();
		boxLocalDocumento.addItem("");
		boxLocalDocumento.addItem("CONSESSSIONÁRIA");
		boxLocalDocumento.addItem("DESPACHANTE");
		boxLocalDocumento.addItem("CLIENTE");
		boxLocalDocumento.addItem("DELEGACIA - DETRAN");
		boxLocalDocumento.addItem("FÁBRICA");
		boxLocalDocumento.addItem("LOJA");
		boxLocalDocumento.addItem("BANCO");
		add(boxLocalDocumento);

		add(new JLabel("ANO DE RECEBIMENTO DO DOCUMENTO"));

		fieldAnoRecebimentoDocumento = new JFormattedTextField(Mascara.getAno());
		add(fieldAnoRecebimentoDocumento);

		add(new JLabel("MÊS DE RECEBIMENTO DO DOCUMENTO"));

		boxMesRecebimentoDocumento = new JComboBox<String>();
		boxMesRecebimentoDocumento.addItem("");
		boxMesRecebimentoDocumento.addItem("JANEIRO");
		boxMesRecebimentoDocumento.addItem("FEVEREIRO");
		boxMesRecebimentoDocumento.addItem("MARÇO");
		boxMesRecebimentoDocumento.addItem("ABRIL");
		boxMesRecebimentoDocumento.addItem("MAIO");
		boxMesRecebimentoDocumento.addItem("JUNHO");
		boxMesRecebimentoDocumento.addItem("JULHO");
		boxMesRecebimentoDocumento.addItem("AGOSTO");
		boxMesRecebimentoDocumento.addItem("SETEMBRO");
		boxMesRecebimentoDocumento.addItem("OUTUBRO");
		boxMesRecebimentoDocumento.addItem("NOVEMBRO");
		boxMesRecebimentoDocumento.addItem("DEZEMBRO");
		add(boxMesRecebimentoDocumento);

		add(new JLabel("DIA DE RECEBIMENTO DO DOCUMENTO"));

		fieldDiaRecebimentoDocumento = new JTextField();
		fieldDiaRecebimentoDocumento.setDocument(new EntradaMaiuscula(2));
		add(fieldDiaRecebimentoDocumento);

		add(new JLabel("ANO DE DEVOLUÇÃO DO DOCUMENTO"));

		fieldAnoDevolucaoDocumento = new JFormattedTextField(Mascara.getAno());
		add(fieldAnoDevolucaoDocumento);

		add(new JLabel("MÊS DE DEVOLUÇÃO DO DOCUMENTO"));

		boxMesDevolucaoDocumento = new JComboBox<String>();
		boxMesDevolucaoDocumento.addItem("");
		boxMesDevolucaoDocumento.addItem("JANEIRO");
		boxMesDevolucaoDocumento.addItem("FEVEREIRO");
		boxMesDevolucaoDocumento.addItem("MARÇO");
		boxMesDevolucaoDocumento.addItem("ABRIL");
		boxMesDevolucaoDocumento.addItem("MAIO");
		boxMesDevolucaoDocumento.addItem("JUNHO");
		boxMesDevolucaoDocumento.addItem("JULHO");
		boxMesDevolucaoDocumento.addItem("AGOSTO");
		boxMesDevolucaoDocumento.addItem("SETEMBRO");
		boxMesDevolucaoDocumento.addItem("OUTUBRO");
		boxMesDevolucaoDocumento.addItem("NOVEMBRO");
		boxMesDevolucaoDocumento.addItem("DEZEMBRO");
		add(boxMesDevolucaoDocumento);

		add(new JLabel("DIA DE DEVOLUÇÃO DO DOCUMENTO"));

		fieldDiaDevolucaoDocumento = new JTextField();
		fieldDiaDevolucaoDocumento.setDocument(new EntradaMaiuscula(2));
		add(fieldDiaDevolucaoDocumento);

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(this, 29, 1, // rows, cols
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
		setBorder(BorderFactory.createTitledBorder("DOCUMENTO"));
		setLayout(new SpringLayout());
	}

	@Override
	public void iniciarTabela() {

	}

	@Override
	public void limparGui() {
		configuracaoGui.limparGui();
	}

	@Override
	public void reiniciarGui() {
		Veiculo veiculo = null;
		List<Veiculo> listVeiculo = (List<Veiculo>) VeiculoFac.getRegistro();
		Collections.sort(listVeiculo, new VeiculoComp().new Placa());
		this.boxVeiculo.removeAllItems();

		for (Veiculo v : listVeiculo) {
			this.boxVeiculo.addItem(v);
		}

		if (!MainCont.getVeiculoDocumentoFc().isShowing() && MainCont.getVeiculoDocumentoFc().getDocumentoCont().getDocumento() != null) {
			veiculo = MainCont.getVeiculoDocumentoFc().getDocumentoCont().getDocumento().getVeiculo();
			boxVeiculo.setSelectedItem(veiculo);
		}

	}
}
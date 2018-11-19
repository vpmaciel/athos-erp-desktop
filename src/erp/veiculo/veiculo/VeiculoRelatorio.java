package erp.veiculo.veiculo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import erp.aop.relatorio.Relatorio;

public class VeiculoRelatorio {

	private PdfWriter writer = null;
	private Document document = new Document();
	private String arquivo = "veiculo.pdf";
	private String titulo = "VEÍCULOS";
	private Relatorio relatorio = new Relatorio();

	public VeiculoRelatorio(List<Veiculo> veiculos) {
		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (Veiculo veiculo : veiculos) {
				document.newPage();
				document.add(new Paragraph("ANO FABRICAÇÃO: " + veiculo.getAnoFabricacao()));
				document.add(new Paragraph("ANO MODELO: " + veiculo.getAnoModelo()));
				document.add(new Paragraph("ATIVIDADE: " + veiculo.getAtividade()));
				document.add(new Paragraph("BAIRRO: " + veiculo.getBairro()));
				document.add(new Paragraph("CAP.CARGA TON: " + veiculo.getCapCarga()));
				document.add(new Paragraph("CAP. PASSAGEIROS: " + veiculo.getCapacidadePassageiros()));
				document.add(new Paragraph("CARROCERIA: " + veiculo.getCarroceria()));
				document.add(new Paragraph("CATEGORIA: " + veiculo.getCategoria()));
				document.add(new Paragraph("CEP: " + veiculo.getCep()));
				document.add(new Paragraph("CHASSI: " + veiculo.getChassi()));
				document.add(new Paragraph("CHASSI REMARCADO: " + veiculo.getChassiRemarcado()));
				document.add(new Paragraph("CIDADE: " + veiculo.getCidade()));
				document.add(new Paragraph("CILINDRADA: " + veiculo.getCilindrada()));
				document.add(new Paragraph("CILINDROS: " + veiculo.getCilindros()));
				document.add(new Paragraph("CMT-TON: " + veiculo.getCmtTon()));
				document.add(new Paragraph("COMBUSTÍVEL: " + veiculo.getCombustivel()));
				document.add(new Paragraph("COMPLEMENTO: " + veiculo.getComplemento()));
				document.add(new Paragraph("COR: " + veiculo.getCor()));
				document.add(new Paragraph("DATA COMPRA: " + veiculo.getDataCompra()));
				document.add(new Paragraph("DATA VENDA: " + veiculo.getDataVenda()));
				document.add(new Paragraph("EIXOS: " + veiculo.getEixos()));
				document.add(new Paragraph("ESPÉCIE: " + veiculo.getEspecie()));
				document.add(new Paragraph("ESTADO: " + veiculo.getEstado()));
				document.add(new Paragraph("FABRICAÇÃO: " + veiculo.getFabricacao()));
				document.add(new Paragraph("IPVA: " + veiculo.getIpva()));
				document.add(new Paragraph("LOGRADOURO: " + veiculo.getLogradouro()));
				document.add(new Paragraph("MARCA: " + veiculo.getMarca()));
				document.add(new Paragraph("MODELO: " + veiculo.getModelo()));
				document.add(new Paragraph("NUNICÍPIO DE EMPLACAMENTO: " + veiculo.getMunicipioEmplacamento()));
				document.add(new Paragraph("PAÍS: " + veiculo.getPais()));
				document.add(new Paragraph("PLACA: " + veiculo.getPlaca()));
				document.add(new Paragraph("POTÊNCIA: " + veiculo.getPotencia()));
				document.add(new Paragraph("CNPJ (PROPRIETÁRIO ANTERIOR): " + veiculo.getProprietarioAnteriorCNPJ()));
				document.add(new Paragraph("CPF (PROPRIETÁRIO ANTERIOR): " + veiculo.getProprietarioAnteriorCPF()));
				document.add(
						new Paragraph("E-MAIL (PROPRIETÁRIO ANTERIOR): " + veiculo.getProprietarioAnteriorEmail()));
				document.add(new Paragraph("FAX (PROPRIETÁRIO ANTERIOR): " + veiculo.getProprietarioAnteriorFax()));
				document.add(
						new Paragraph("TELEFONE (PROPRIETÁRIO ANTERIOR): " + veiculo.getProprietarioAnteriorFone1()));
				document.add(
						new Paragraph("TELEFONE (PROPRIETÁRIO ANTERIOR): " + veiculo.getProprietarioAnteriorFone2()));
				document.add(new Paragraph("NOME (PROPRIETÁRIO ANTERIOR): " + veiculo.getProprietarioAnteriorNome()));
				document.add(new Paragraph("CNPJ: " + veiculo.getProprietarioCNPJ()));
				document.add(new Paragraph("CPF: " + veiculo.getProprietarioCPF()));
				document.add(new Paragraph("E-MAIL: " + veiculo.getProprietarioEmail()));
				document.add(new Paragraph("FAX: " + veiculo.getProprietarioFax()));
				document.add(new Paragraph("TELEFONE: " + veiculo.getProprietarioFone1()));
				document.add(new Paragraph("TELEFONE: " + veiculo.getProprietarioFone2()));
				document.add(new Paragraph("NOME DO PROPRIETÁRIO: " + veiculo.getProprietarioNome()));
				document.add(new Paragraph("IDENTIDADE: " + veiculo.getProprietarioRGNumero()));
				document.add(new Paragraph("IDENTIDADE ÓRGÃO EMISSOR: " + veiculo.getProprietarioRGOrgaoEmisssor()));
				document.add(new Paragraph("RENAVAM: " + veiculo.getRenavam()));
				document.add(new Paragraph("RESTRIÇÃO FINANCEIRA: " + veiculo.getRestricoes()));
				document.add(new Paragraph("TIPO: " + veiculo.getTipo()));
				document.add(new Paragraph("VALOR DE COMPRA: " + veiculo.getValorCompra()));
				document.add(new Paragraph("VALOR DE VENDA: " + veiculo.getValorVenda()));
				document.add(new Paragraph("\n"));
			}
		} catch (DocumentException | FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
		relatorio.getRodape(writer, document);
		document.close();
		relatorio.retornarRelatorio(arquivo, false);
	}

	public File retornarRelatorio(boolean abrirRelatorio) {
		return relatorio.retornarRelatorio(arquivo, abrirRelatorio);
	}

}

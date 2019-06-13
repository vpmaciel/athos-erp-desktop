package erp.fornecedor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import arquitetura.data.Data;
import arquitetura.relatorio.Relatorio;

public class FornecedorRel {

	private String arquivo = Data.getHora() + "-fornecedor.pdf";
	private Document document = new Document();
	private Relatorio relatorio = new Relatorio();
	private String titulo = "FORNECEDORES";
	private PdfWriter writer = null;

	public FornecedorRel(List<Fornecedor> fornecedores) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (Fornecedor fornecedor : fornecedores) {
				document.newPage();
				document.add(new Paragraph("NOME FANTASIA: " + fornecedor.getNomeFantasia()));
				document.add(new Paragraph("RAMO DE ATIVIDADE: " + fornecedor.getRamoAtividade()));
				document.add(new Paragraph("TIPO DE EMPRESA: " + fornecedor.getTipoEmpresa()));
				document.add(new Paragraph("FATURAMENTO MENSAL: " + fornecedor.getFaturamentoMensal()));
				document.add(new Paragraph("CNPJ: " + fornecedor.getCnpj()));
				document.add(new Paragraph("CPF: " + fornecedor.getCpf()));
				document.add(new Paragraph("NÚMERO DE FUNCIONÁRIOS: " + fornecedor.getNumeroFuncionarios()));
				document.add(new Paragraph("INSCRIÇÃO ESTADUAL: " + fornecedor.getInscricaoEstadual()));
				document.add(new Paragraph("DATA DE FUNDAÇÃO: " + fornecedor.getDataFundacao()));
				document.add(new Paragraph("INSCRIÇÃO MUNICIPAL: " + fornecedor.getInscricaoMunicipal()));
				document.add(new Paragraph("CAPITAL SOCIAL: " + fornecedor.getCapitalSocial()));
				document.add(new Paragraph("RAZÃO SOCIAL: " + fornecedor.getRazaoSocial()));
				document.add(new Paragraph("FAX: " + fornecedor.getFax()));
				document.add(new Paragraph("TELEFONE: " + fornecedor.getFone1()));
				document.add(new Paragraph("TELEFONE: " + fornecedor.getFone2()));
				document.add(new Paragraph("E-MAIL: " + fornecedor.getEmail()));
				document.add(new Paragraph("PAÍS: " + fornecedor.getPais()));
				document.add(new Paragraph("ESTADO: " + fornecedor.getEstado()));
				document.add(new Paragraph("CIDADE: " + fornecedor.getCidade()));
				document.add(new Paragraph("BAIRRO: " + fornecedor.getBairro()));
				document.add(new Paragraph("LOGRADOURO: " + fornecedor.getLogradouro()));
				document.add(new Paragraph("COMPLEMENTO: " + fornecedor.getComplemento()));
				document.add(new Paragraph("CEP: " + fornecedor.getCep()));
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

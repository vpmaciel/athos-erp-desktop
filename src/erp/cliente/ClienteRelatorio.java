package erp.cliente;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import arquitetura.relatorio.Relatorio;

public class ClienteRelatorio {

	private PdfWriter writer = null;
	private Document document = new Document();
	private String arquivo = "cliente.pdf";
	private String titulo = "CLIENTES";
	private Relatorio relatorio = new Relatorio();

	public ClienteRelatorio(List<Cliente> clientes) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (Cliente cliente : clientes) {
				document.newPage();
				document.add(new Paragraph("NOME: " + cliente.getNome()));
				document.add(new Paragraph("SEXO: " + cliente.getSexo()));
				document.add(new Paragraph("RG NÚMERO: " + cliente.getRgNumero()));
				document.add(new Paragraph("RG ÓRGÃO EMISSSOR: " + cliente.getRgOrgaoEmissor()));
				document.add(new Paragraph("CNPJ: " + cliente.getCnpj()));
				document.add(new Paragraph("CPF: " + cliente.getCpfNumero()));
				document.add(new Paragraph("DATA CADASTRO: " + cliente.getDataCadastro()));
				document.add(new Paragraph("CARGO: " + cliente.getCargo()));
				document.add(new Paragraph("SALÁRIO: " + cliente.getSalario()));
				document.add(new Paragraph("CATEGORIA: " + cliente.getClasseEconomica()));
				document.add(new Paragraph("EMPRESA: " + cliente.getEmpresa()));
				document.add(new Paragraph("ESTADO CIVIL: " + cliente.getEstadoCivil()));
				document.add(new Paragraph("FAX: " + cliente.getFax()));
				document.add(new Paragraph("TELEFONE: " + cliente.getFone1()));
				document.add(new Paragraph("TELEFONE: " + cliente.getFone2()));
				document.add(new Paragraph("E-MAIL: " + cliente.getEmail()));
				document.add(new Paragraph("PAÍS: " + cliente.getPais()));
				document.add(new Paragraph("ESTADO: " + cliente.getEstado()));
				document.add(new Paragraph("CIDADE: " + cliente.getCidade()));
				document.add(new Paragraph("BAIRRO: " + cliente.getBairro()));
				document.add(new Paragraph("LOGRADOURO: " + cliente.getLogradouro()));
				document.add(new Paragraph("COMPLEMENTO: " + cliente.getComplemento()));
				document.add(new Paragraph("CEP: " + cliente.getCep()));
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

package erp.agenda.contato;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import arquitetura.relatorio.Relatorio;

public class ContatoRel {

	private String arquivo = "contato.pdf";
	private Document document = new Document();
	private Relatorio relatorio = new Relatorio();
	private String titulo = "CONTATOS";
	private PdfWriter writer = null;

	public ContatoRel(List<Contato> contatos) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (Contato contato : contatos) {
				document.newPage();
				document.add(new Paragraph("NOME: " + contato.getNome()));
				document.add(new Paragraph("SEXO: " + contato.getSexo()));
				document.add(new Paragraph("CNPJ: " + contato.getCnpj()));
				document.add(new Paragraph("CPF: " + contato.getCpf()));
				document.add(new Paragraph("EMPRESA: " + contato.getEmpresa()));
				document.add(new Paragraph("FAX: " + contato.getFax()));
				document.add(new Paragraph("TELEFONE: " + contato.getFone1()));
				document.add(new Paragraph("TELEFONE: " + contato.getFone2()));
				document.add(new Paragraph("E-MAIL: " + contato.getEmail()));
				document.add(new Paragraph("PAÍS: " + contato.getPais()));
				document.add(new Paragraph("ESTADO: " + contato.getEstado()));
				document.add(new Paragraph("CIDADE: " + contato.getCidade()));
				document.add(new Paragraph("BAIRRO: " + contato.getBairro()));
				document.add(new Paragraph("LOGRADOURO: " + contato.getLogradouro()));
				document.add(new Paragraph("COMPLEMENTO: " + contato.getComplemento()));
				document.add(new Paragraph("CEP: " + contato.getCep()));
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

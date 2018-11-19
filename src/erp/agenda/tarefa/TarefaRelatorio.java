package erp.agenda.tarefa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import erp.aop.relatorio.Relatorio;

public class TarefaRelatorio {
	
	private PdfWriter writer = null;
	private Document document = new Document();
	private String arquivo = "tarefa.pdf";
	private String titulo = "TAREFAS";
	private Relatorio relatorio = new Relatorio();
	
	public TarefaRelatorio(List<Tarefa> tarefas) {
		
		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (Tarefa tarefa : tarefas) {
				document.newPage();
				document.add(new Paragraph("NOME: " + tarefa.getNome()));
				document.add(new Paragraph("SEXO: " + tarefa.getSexo()));
				document.add(new Paragraph("CNPJ: " + tarefa.getCnpj()));
				document.add(new Paragraph("CPF: " + tarefa.getCpfNumero()));
				document.add(new Paragraph("SALÁRIO: " + tarefa.getSalario()));
				document.add(new Paragraph("EMPRESA: " + tarefa.getEmpresa()));
				document.add(new Paragraph("FAX: " + tarefa.getFax()));
				document.add(new Paragraph("TELEFONE: " + tarefa.getFone1()));
				document.add(new Paragraph("TELEFONE: " + tarefa.getFone2()));
				document.add(new Paragraph("E-MAIL: " + tarefa.getEmail()));
				document.add(new Paragraph("PAÍS: " + tarefa.getPais()));
				document.add(new Paragraph("ESTADO: " + tarefa.getEstado()));
				document.add(new Paragraph("CIDADE: " + tarefa.getCidade()));
				document.add(new Paragraph("BAIRRO: " + tarefa.getBairro()));
				document.add(new Paragraph("LOGRADOURO: " + tarefa.getLogradouro()));
				document.add(new Paragraph("COMPLEMENTO: " + tarefa.getComplemento()));
				document.add(new Paragraph("CEP: " + tarefa.getCep()));
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

package erp.veiculo.documento;

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

public class DocumentoRel {

	private String arquivo = Data.getHora() +"-documento.pdf";
	private Document document = new Document();
	private Relatorio relatorio = new Relatorio();
	private String titulo = "CLIENTES";
	private PdfWriter writer = null;

	public DocumentoRel(List<Documento> documentos) {

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(arquivo));
			relatorio.criarRelatorio(writer, document, titulo);

			for (Documento documento : documentos) {
				document.newPage();
				document.add(new Paragraph("NÚMERO DO PROTOCOLO: " + documento.getId()));
				document.add(new Paragraph("PLACA DO VEÍCULO: " + documento.getVeiculo().getPlaca()));
				document.add(new Paragraph("RENAVAM: " + documento.getVeiculo().getRenavam()));
				document.add(new Paragraph("CHASSI: " + documento.getVeiculo().getChassi()));
				document.add(new Paragraph("NOME DO PROPRIETÁRIO DO VEÍCULO: " + documento.getVeiculo().getProprietarioNome()));
				document.add(new Paragraph("MARCA: " + documento.getVeiculo().getMarca()));
				document.add(new Paragraph("MODELO: " + documento.getVeiculo().getModelo()));
				document.add(new Paragraph("SITUAÇÃO DO DOCUMENTO: " + documento.getSituacaoDocumento()));
				document.add(new Paragraph("------------------------------"));
				document.add(new Paragraph("ANO DE RECEBIMENTO DO DOCUMENTO (CRV E CRLV): " + documento.getAnoRecebimentoDocumento()));
				document.add(new Paragraph("MÊS DE RECEBIMENTO DO DOCUMENTO (CRV E CRLV): " + documento.getMesRecebimentoDocumento()));
				document.add(new Paragraph("DIA DE RECEBIMENTO DO DOCUMENTO (CRV E CRLV): " + documento.getDiaRecebimentoDocumento()));
				document.add(new Paragraph("------------------------------"));
				document.add(new Paragraph("ANO DE DEVOLUÇÃO DO DOCUMENTO (CRV E CRLV): " + documento.getAnoDevolucaoDocumento()));
				document.add(new Paragraph("MÊS DE DEVOLUÇÃO DO DOCUMENTO (CRV E CRLV): " + documento.getMesDevolucaoDocumento()));
				document.add(new Paragraph("DIA DE DEVOLUÇÃO DO DOCUMENTO (CRV E CRLV): " + documento.getDiaDevolucaoDocumento()));
				document.add(new Paragraph("------------------------------"));
				document.add(new Paragraph("NOME DO RECEBEDOR DO DOCUMENTO (CRV E CRLV): " + documento.getNomeRecebedorDocumento()));
				document.add(new Paragraph("IDENTIDADE DO RECEBEDOR: " + documento.getRgNumeroRecebedorDocumento()));
				document.add(new Paragraph("ORGÃO EMISSOR DE IDENTIDADE DO RECEBEDOR: " + documento.getRgOrgaoEmisssorRecebedorDocumento()));
				document.add(new Paragraph("CNPJ DO RECEBEDOR DO DOCUMENTO (CRV E CRLV): " + documento.getCnpjRecebedorDocumento()));
				document.add(new Paragraph("CPF DO RECEBEDOR DO DOCUMENTO (CRV E CRLV): " + documento.getCpfRecebedorDocumento()));
				document.add(new Paragraph("DOCUMENTO ESTÁ EM POSSE COM (CRV E CRLV): " + documento.getLocalDocumento()));
				document.add(new Paragraph("------------------------------"));
				document.add(new Paragraph("ASSINATURA DO RECEBEDOR DO DOCUMENTO (CRV E CRLV):_____________________________________________________________ "));
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

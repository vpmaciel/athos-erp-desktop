package erp.agenda.contato;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import arquitetura.Sis;
import arquitetura.data.Data;
import arquitetura.gui.Msg;

public class ContatoArqCsv {

	private final String arquivo = Sis.getCaminhoDadosCsv() + "[erp-agenda-contato]-" + Data.getDataHoraArquivo() + ".csv";
	
	private BufferedWriter bufferedWriter = null;
	private final String CSV_SEPARATOR = String.format("%s", "\t");
	private File file;

	public ContatoArqCsv(final List<Contato> listContato) {
		try {
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivo), "UTF-8"));

			StringBuffer cabecalho = new StringBuffer();
			cabecalho.append("ID");
			cabecalho.append(CSV_SEPARATOR);
			cabecalho.append("NOME");
			cabecalho.append(CSV_SEPARATOR);
			cabecalho.append("SEXO");
			cabecalho.append(CSV_SEPARATOR);
			cabecalho.append("E-MAIL");
			cabecalho.append(CSV_SEPARATOR);
			cabecalho.append("FAX");
			cabecalho.append(CSV_SEPARATOR);
			cabecalho.append("FONE");
			cabecalho.append(CSV_SEPARATOR);
			cabecalho.append("FONE");
			cabecalho.append(CSV_SEPARATOR);
			cabecalho.append("EMPRESA");
			cabecalho.append(CSV_SEPARATOR);
			cabecalho.append("ENDEREÇO-BAIRRO");
			cabecalho.append(CSV_SEPARATOR);
			cabecalho.append("ENDEREÇO-CEP");
			cabecalho.append(CSV_SEPARATOR);
			cabecalho.append("ENDEREÇO-CIDADE");
			cabecalho.append(CSV_SEPARATOR);
			cabecalho.append("ENDEREÇO-COMPLEMENTO");
			cabecalho.append(CSV_SEPARATOR);
			cabecalho.append("ENDEREÇO-ESTADO");
			cabecalho.append(CSV_SEPARATOR);
			cabecalho.append("ENDEREÇO-LOGRADOURO");
			cabecalho.append(CSV_SEPARATOR);
			cabecalho.append("ENDEREÇO-PAÍS");
			cabecalho.append(CSV_SEPARATOR);
			cabecalho.append("CNPJ");
			cabecalho.append(CSV_SEPARATOR);
			cabecalho.append("CPF");
			bufferedWriter.write(cabecalho.toString());
			bufferedWriter.newLine();

			for (Contato contato : listContato) {
				StringBuffer linha = new StringBuffer();
				linha.append(contato.getId());
				linha.append(CSV_SEPARATOR);
				linha.append(contato.getNome());
				linha.append(CSV_SEPARATOR);
				linha.append(contato.getSexo());
				linha.append(CSV_SEPARATOR);
				linha.append(contato.getEmail());
				linha.append(CSV_SEPARATOR);
				linha.append(contato.getFax());
				linha.append(CSV_SEPARATOR);
				linha.append(contato.getFone1());
				linha.append(CSV_SEPARATOR);
				linha.append(contato.getFone2());
				linha.append(CSV_SEPARATOR);
				linha.append(contato.getEmpresa());
				linha.append(CSV_SEPARATOR);
				linha.append(contato.getEnderecoBairro());
				linha.append(CSV_SEPARATOR);
				linha.append(contato.getEnderecoCep());
				linha.append(CSV_SEPARATOR);
				linha.append(contato.getEnderecoCidade());
				linha.append(CSV_SEPARATOR);
				linha.append(contato.getEnderecoComplemento());
				linha.append(CSV_SEPARATOR);
				linha.append(contato.getEnderecoEstado());
				linha.append(CSV_SEPARATOR);
				linha.append(contato.getEnderecoLogradouro());
				linha.append(CSV_SEPARATOR);
				linha.append(contato.getEnderecoPais());
				linha.append(CSV_SEPARATOR);
				linha.append(contato.getCnpj());
				linha.append(CSV_SEPARATOR);
				linha.append(contato.getCpf());
				bufferedWriter.write(linha.toString());
				bufferedWriter.newLine();
			}
			bufferedWriter.flush();
			bufferedWriter.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			Msg.erroCodificacao();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			Msg.erroArquivoNaoEncontrado();
		} catch (IOException e) {
			e.printStackTrace();
			Msg.erroAbrirArquivo();
		}
	}

	public File retornarArquivo(boolean abrirArquivo) {

		try {
			Sis.abrirDiretorio(Sis.getCaminhoDadosCsv());
			file = new File(arquivo);
			if (abrirArquivo) {
				Desktop.getDesktop().open(file);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return file;
	}
}

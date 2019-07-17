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

public class ContatoArqTxt {

	private final String arquivo = Sis.getCaminhoDadosTxt() + "[contato]-" + Data.getDataHoraArquivo() + ".txt";
	private BufferedWriter bufferedWriter = null;
	private File file;

	public ContatoArqTxt(final List<Contato> listContato) {
		try {
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivo), "UTF-8"));

			for (Contato contato : listContato) {
				StringBuffer linha = new StringBuffer();
				linha.append("ID:\t");
				linha.append(contato.getId());
				bufferedWriter.write(linha.toString());
				
				linha = new StringBuffer();
				bufferedWriter.newLine();
				linha.append("NOME:\t");
				linha.append(contato.getNome());
				bufferedWriter.write(linha.toString());
				
				linha = new StringBuffer();
				bufferedWriter.newLine();
				linha.append("SEXO:\t");
				linha.append(contato.getSexo());
				bufferedWriter.write(linha.toString());
			
				linha = new StringBuffer();
				bufferedWriter.newLine();
				linha.append("E-MAIL:\t");
				linha.append(contato.getEmail());
				bufferedWriter.write(linha.toString());
			
				linha = new StringBuffer();
				bufferedWriter.newLine();
				linha.append("FAX:\t");
				linha.append(contato.getFax());
				bufferedWriter.write(linha.toString());
			
				linha = new StringBuffer();
				bufferedWriter.newLine();
				linha.append("FONE:\t");
				linha.append(contato.getFone1());
				bufferedWriter.write(linha.toString());
			
				linha = new StringBuffer();
				bufferedWriter.newLine();
				linha.append("FONE:\t");
				linha.append(contato.getFone2());
				bufferedWriter.write(linha.toString());
			
				linha = new StringBuffer();
				bufferedWriter.newLine();
				linha.append("EMPRESA:\t");
				linha.append(contato.getEmpresa());
				bufferedWriter.write(linha.toString());
			
				linha = new StringBuffer();
				bufferedWriter.newLine();
				linha.append("BAIRRO:\t");
				linha.append(contato.getEnderecoBairro());
				bufferedWriter.write(linha.toString());
			
				linha = new StringBuffer();
				bufferedWriter.newLine();
				linha.append("CEP:\t");
				linha.append(contato.getEnderecoCep());
				bufferedWriter.write(linha.toString());
			
				linha = new StringBuffer();
				bufferedWriter.newLine();
				linha.append("CIDADE:\t");
				linha.append(contato.getEnderecoCidade());
				bufferedWriter.write(linha.toString());
			
				linha = new StringBuffer();
				bufferedWriter.newLine();
				linha.append("COMPLEMENTO:\t");
				linha.append(contato.getEnderecoComplemento());
				bufferedWriter.write(linha.toString());
			
				linha = new StringBuffer();
				bufferedWriter.newLine();
				linha.append("ESTADO:\t");
				linha.append(contato.getEnderecoEstado());
				bufferedWriter.write(linha.toString());
			
				linha = new StringBuffer();
				bufferedWriter.newLine();
				linha.append("LOGRADOURO:\t");
				linha.append(contato.getEnderecoLogradouro());
				bufferedWriter.write(linha.toString());
			
				linha = new StringBuffer();
				bufferedWriter.newLine();
				linha.append("PAÍS:\t");
				linha.append(contato.getEnderecoPais());
				bufferedWriter.write(linha.toString());
			
				linha = new StringBuffer();
				bufferedWriter.newLine();
				linha.append("CNPJ:\t");
				linha.append(contato.getCnpj());
				bufferedWriter.write(linha.toString());

				linha = new StringBuffer();
				bufferedWriter.newLine();
				linha.append("CPF:\t");
				linha.append(contato.getCpf());
				bufferedWriter.write(linha.toString());
				bufferedWriter.newLine();
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
			Sis.abrirDiretorio(Sis.getCaminhoDadosTxt());
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

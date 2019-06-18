
package erp.banco;

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

public class BancoArquivoCsv {

	private final String arquivo = Sis.getCaminhoDadosCsv() + "[banco]-" + Data.getDataHoraArquivo() + ".csv";
	
	private final String CSV_SEPARATOR = String.format("%s", "\t");
	private BufferedWriter bufferedWriter = null;
	private File file;

	public BancoArquivoCsv(final List<Banco> listBanco) {
		try {
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivo), "UTF-8"));

			StringBuffer cabecalho = new StringBuffer();
			cabecalho.append("ID");
			cabecalho.append(CSV_SEPARATOR);
			cabecalho.append("NOME");
			cabecalho.append(CSV_SEPARATOR);
			cabecalho.append("CÓDIGO");
			bufferedWriter.write(cabecalho.toString());
			bufferedWriter.newLine();

			for (Banco banco : listBanco) {
				StringBuffer linha = new StringBuffer();
				linha.append(banco.getId());
				linha.append(CSV_SEPARATOR);
				linha.append(banco.getNome());
				linha.append(CSV_SEPARATOR);
				linha.append(banco.getCodigo());
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

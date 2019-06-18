
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

public class BancoArquivoTxt {

	private final String arquivo = Sis.getCaminhoDadosTxt() + "[banco]-" + Data.getDataHoraArquivo() + ".txt";
	private BufferedWriter bufferedWriter = null;
	private File file;

	public BancoArquivoTxt(final List<Banco> listBanco) {
		try {
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivo), "UTF-8"));

			for (Banco banco : listBanco) {
				StringBuffer linha = new StringBuffer();
				linha.append("ID:\t");
				linha.append(banco.getId());
				bufferedWriter.write(linha.toString());
				
				linha = new StringBuffer();
				bufferedWriter.newLine();
				linha.append("NOME:\t");
				linha.append(banco.getNome());
				bufferedWriter.write(linha.toString());
				
				linha = new StringBuffer();
				bufferedWriter.newLine();
				linha.append("CÓDIGO:\t");
				linha.append(banco.getCodigo());
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

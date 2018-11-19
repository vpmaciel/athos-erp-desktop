package erp.aop.configuracao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;

import javax.swing.JOptionPane;

public class Arquivo {

	private static Locale local;

	public static void carregarConfiguracoes() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			File file = new File("depto.cfg");
			if (!file.exists()) {
				file.createNewFile();
			}
			fis = new FileInputStream("depto.cfg");
			ois = new ObjectInputStream(fis);
			Arquivo.setLocal((Locale) ois.readObject());
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Arquivo depto.cfg não pode ser carregado!", "Erro ao abrir arquivo",
					0);
		}
	}

	public static Locale getLocal() {
		return local;
	}

	public static void salvarConfiguracoes() {
		try {
			File file = new File("depto.cfg");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(new Object());
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Arquivo depto.cfg não pode ser gravado!", "Erro ao gravar arquivo", 0);
		}
	}

	public static void setLocal(Locale local) {
		Arquivo.local = local;
	}

	private Arquivo() {
	}
}

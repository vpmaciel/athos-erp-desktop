package erp.utilitarios.imc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import arquitetura.Util;

final class ImcControl {

	public class AlturaEvento extends KeyAdapter {

		@Override
		public void keyReleased(KeyEvent e) {
			int valor = e.getKeyCode();

			if (!lista.contains(valor)) {
				imcPc.getGuiAltura().setText("");
				return;
			}

			for (int i : lista) {
				if (valor == i) {
					atualizarObjeto();
					exibirMensagem();
				}
			}
		}
	}
	public class PesoEvento extends KeyAdapter {

		@Override
		public void keyReleased(KeyEvent e) {
			int valor = e.getKeyCode();

			if (!lista.contains(valor)) {
				imcPc.getGuiPeso().setText("");
				return;
			}

			for (int i : lista) {
				if (valor == i) {
					atualizarObjeto();
					exibirMensagem();
				}
			}
		}
	}

	public class SexoEvento implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			atualizarObjeto();
			exibirMensagem();
		}
	}

	private Imc imc = new Imc();

	private ImcPc imcPc;

	double imcResultado;

	List<Integer> lista = Util.caracteresNumericosDecimais();
	public ImcControl(ImcPc imcPc) {
		this.imcPc = imcPc;
	}

	public void atualizarGui() {
		if (imc == null) {
			return;
		}
		imcPc.getGuiAltura().setValue(imc.getAltura());
		imcPc.getGuiPeso().setValue(imc.getPeso());
		imcPc.getGuiSexo().setSelectedItem(imc.getSexo());

	}

	public void atualizarObjeto() {

		try {
			if (imcPc.getGuiAltura().getText().length() > 0) {
				double altura = Util.formatoDecimal().parse(imcPc.getGuiAltura().getText()).doubleValue();
				imc.setAltura(altura);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			imc.setAltura(1.0);
		}
		try {
			if (imcPc.getGuiPeso().getText().length() > 0) {
				double peso = Util.formatoDecimal().parse(imcPc.getGuiPeso().getText()).doubleValue();
				imc.setPeso(peso);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			imc.setPeso(0.0);
		}

		try {
			imcResultado = imc.getPeso() / (imc.getAltura() * imc.getAltura());
		} catch (Exception exception) {
			exception.printStackTrace();
			imcResultado = 0.0;
		}

		imc.setSexo((String) imcPc.getGuiSexo().getSelectedItem());
		exibirMensagem();
	}

	public void exibirMensagem() {
		if (imc.getSexo().equals("FEMININO")) {
			if (imcResultado <= 19.1) {
				imcPc.getGuiResultado().setText("está abaixo do peso");
			} else if (imcResultado > 19.1 && imcResultado <= 25.8) {
				imcPc.getGuiResultado().setText("está no seu peso ideal");
			} else if (imcResultado > 25.8 && imcResultado <= 27.3) {
				imcPc.getGuiResultado().setText("está marginalmente acima do peso");
			} else if (imcResultado > 27.3 && imcResultado <= 32.3) {
				imcPc.getGuiResultado().setText("está acima do peso ideal");
			} else {
				imcPc.getGuiResultado().setText("está obesa");
			}
		}
		if (imc.getSexo().equals("MASCULINO")) {
			if (imcResultado <= 20.7) {
				imcPc.getGuiResultado().setText("está abaixo do peso");
			} else if (imcResultado > 20.7 && imcResultado <= 26.4) {
				imcPc.getGuiResultado().setText("está no seu peso ideal");
			} else if (imcResultado > 26.4 && imcResultado <= 27.8) {
				imcPc.getGuiResultado().setText("está marginalmente acima do peso");
			} else if (imcResultado > 27.8 && imcResultado <= 31.1) {
				imcPc.getGuiResultado().setText("está acima do peso ideal");
			} else {
				imcPc.getGuiResultado().setText("está obeso");
			}
		}
	}
}

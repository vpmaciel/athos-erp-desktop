package erp.curriculo.certificado;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainCont;

final class CertificadoSel implements ListSelectionListener {

	JTable table;

	CertificadoSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Certificado certificadoPesquisaRegistro = new Certificado();
				certificadoPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], CertificadoTm.ID));

				if (table.getSelectedRow() != -1) {
					Certificado Certificado = CertificadoFac.getRegistro(certificadoPesquisaRegistro);
					CertificadoTm CertificadoTm = (CertificadoTm) table.getModel();
					CertificadoTm.getCertificado(table.getSelectedRow());
					MainCont.mostrarFrame(MainCont.getCurriculoCertificadoFc());
					MainCont.getCurriculoCertificadoFc().getCertificadoCont().setCertificado(Certificado);
					MainCont.getCurriculoCertificadoFc().getCertificadoCont().atualizarGui();
					MainCont.getCurriculoCertificadoFc().setFocusable(true);
					MainCont.getCurriculoCertificadoFp().setVisible(false);
				}
			}
		}
	}
}

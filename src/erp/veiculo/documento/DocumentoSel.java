package erp.veiculo.documento;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import erp.main.MainControl;

final class DocumentoSel implements ListSelectionListener {

	JTable table;

	DocumentoSel(JTable table) {
		this.table = table;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int[] selRows = table.getSelectedRows();
			TableModel tm = table.getModel();
			if (selRows.length > 0) {
				Documento documentoPesquisaRegistro = new Documento();
				documentoPesquisaRegistro.setId((Long) tm.getValueAt(selRows[0], DocumentoTm.ID));

				if (table.getSelectedRow() != -1) {
					Documento documento = DocumentoFac.getRegistro(documentoPesquisaRegistro);
					DocumentoTm documentoTm = (DocumentoTm) table.getModel();
					documentoTm.getDocumento(table.getSelectedRow());
					MainControl.mostrarFrame(MainControl.getVeiculoDocumentoFc());
					MainControl.getVeiculoDocumentoFc().getDocumentoCont().setDocumento(documento);
					MainControl.getVeiculoDocumentoFc().getDocumentoCont().atualizarGui();
					MainControl.getVeiculoDocumentoFc().setFocusable(true);
					MainControl.getVeiculoDocumentoFp().setVisible(false);
				}
			}
		}
	}
}

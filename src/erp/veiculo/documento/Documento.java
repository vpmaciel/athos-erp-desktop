package erp.veiculo.documento;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;

import erp.veiculo.Veiculo;

@SuppressWarnings("serial")
@PersistenceContext(unitName = "erp")
@Entity
public class Documento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(cascade = CascadeType.ALL)
	private Veiculo veiculo;
	@Column(length = 15)
	private String localDocumento;
	@Column(length = 15)
	private String situacaoDocumento;
	@Column(length = 15)
	private String mesRecebimentoDocumento;
	@Column(length = 4)
	private String anoRecebimentoDocumento;
	@Column(length = 2)
	private String diaRecebimentoDocumento;
	@Column(length = 15)
	private String mesDevolucaoDocumento;
	@Column(length = 4)
	private String anoDevolucaoDocumento;
	@Column(length = 3)
	private String diaDevolucaoDocumento;
	@Column(length = 14)
	private String cpfRecebedorDocumento;
	@Column(length = 19)
	private String cnpjRecebedorDocumento;
	@Column(length = 50)
	private String nomeRecebedorDocumento;
	@Column(length = 15)
	private String rgNumeroRecebedorDocumento;
	@Column(length = 15)
	private String rgOrgaoEmisssorRecebedorDocumento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpjRecebedorDocumento() {
		return cnpjRecebedorDocumento;
	}

	public void setCnpjRecebedorDocumento(String cnpjRecebedorDocumento) {
		this.cnpjRecebedorDocumento = cnpjRecebedorDocumento;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String getLocalDocumento() {
		return localDocumento;
	}

	public void setLocalDocumento(String localDocumento) {
		this.localDocumento = localDocumento;
	}

	public String getSituacaoDocumento() {
		return situacaoDocumento;
	}

	public void setSituacaoDocumento(String situacaoDocumento) {
		this.situacaoDocumento = situacaoDocumento;
	}

	public String getMesRecebimentoDocumento() {
		return mesRecebimentoDocumento;
	}

	public void setMesRecebimentoDocumento(String mesRecebimentoDocumento) {
		this.mesRecebimentoDocumento = mesRecebimentoDocumento;
	}

	public String getAnoRecebimentoDocumento() {
		return anoRecebimentoDocumento;
	}

	public void setAnoRecebimentoDocumento(String anoRecebimentoDocumento) {
		this.anoRecebimentoDocumento = anoRecebimentoDocumento;
	}

	public String getDiaRecebimentoDocumento() {
		return diaRecebimentoDocumento;
	}

	public void setDiaRecebimentoDocumento(String diaRecebimentoDocumento) {
		this.diaRecebimentoDocumento = diaRecebimentoDocumento;
	}

	public String getMesDevolucaoDocumento() {
		return mesDevolucaoDocumento;
	}

	public void setMesDevolucaoDocumento(String mesDevolucaoDocumento) {
		this.mesDevolucaoDocumento = mesDevolucaoDocumento;
	}

	public String getAnoDevolucaoDocumento() {
		return anoDevolucaoDocumento;
	}

	public void setAnoDevolucaoDocumento(String anoDevolucaoDocumento) {
		this.anoDevolucaoDocumento = anoDevolucaoDocumento;
	}

	public String getDiaDevolucaoDocumento() {
		return diaDevolucaoDocumento;
	}

	public void setDiaDevolucaoDocumento(String diaDevolucaoDocumento) {
		this.diaDevolucaoDocumento = diaDevolucaoDocumento;
	}

	public String getCpfRecebedorDocumento() {
		return cpfRecebedorDocumento;
	}

	public void setCpfRecebedorDocumento(String cpfRecebedorDocumento) {
		this.cpfRecebedorDocumento = cpfRecebedorDocumento;
	}

	public String getNomeRecebedorDocumento() {
		return nomeRecebedorDocumento;
	}

	public void setNomeRecebedorDocumento(String nomeRecebedorDocumento) {
		this.nomeRecebedorDocumento = nomeRecebedorDocumento;
	}

	public String getRgNumeroRecebedorDocumento() {
		return rgNumeroRecebedorDocumento;
	}

	public void setRgNumeroRecebedorDocumento(String rgNumeroRecebedorDocumento) {
		this.rgNumeroRecebedorDocumento = rgNumeroRecebedorDocumento;
	}

	public String getRgOrgaoEmisssorRecebedorDocumento() {
		return rgOrgaoEmisssorRecebedorDocumento;
	}

	public void setRgOrgaoEmisssorRecebedorDocumento(String rgOrgaoEmisssorRecebedorDocumento) {
		this.rgOrgaoEmisssorRecebedorDocumento = rgOrgaoEmisssorRecebedorDocumento;
	}

	@Override
	public String toString() {
		return this.veiculo.getPlaca();
	}
}

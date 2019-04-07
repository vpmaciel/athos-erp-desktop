package erp.veiculo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import erp.centrocusto.CentroCusto;
import erp.veiculo.marca.VeiculoMarca;
import erp.veiculo.modelo.VeiculoModelo;

@SuppressWarnings("serial")
@PersistenceContext(unitName = "erp")
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "placa", "renavam", "chassi", "numeroMotor" }) })
public class Veiculo implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne(cascade = CascadeType.ALL)
	private VeiculoMarca marca;
	@ManyToOne(cascade = CascadeType.ALL)
	private VeiculoModelo modelo;
	@Column(length = 9)
	private String numeroMotor;
	@Column(length = 9)
	private String mesReferenciaCompra;
	@Column(length = 9)
	private String mesReferenciaVenda;
	@Column(length = 3)
	private String anoReferenciaCompra;
	@Column(length = 4)
	private String anoReferenciaVenda;
	@Column(length = 50)
	private String nomeVeiculo;
	@Column(length = 50)
	private String transmissão;
	@Column(length = 2)
	private String marchas;
	@Column(length = 3)
	private String zeroKm;
	@Column(length = 50)
	private String pneus;
	@Column(length = 50)
	private String rodas;
	@Column(length = 1)
	private String valvulas;
	@Column(length = 3)
	private String rebaixado;
	@Column(length = 7)
	private String quilometragem;
	@ManyToOne(cascade = CascadeType.ALL)
	private CentroCusto centroCusto;
	@Column(length = 10)
	private String lucro;
	@Column(length = 10)
	private String prejuizo;
	@Column(length = 10)
	private String depreciacao;
	@Column(length = 32)
	private String combustivel;
	@Column(length = 8, nullable = false)
	private String placa;
	@Column(length = 3)
	private String chassiRemarcado;
	@Column(length = 17)
	private String tipo;
	@Column(length = 18)
	private String atividade;
	@Column(length = 8)
	private String cor;
	@Column(length = 10)
	private String especie;
	@Column(length = 15)
	private String renavam;
	@Column(length = 50)
	private String municipioEmplacamento;
	@Column(length = 20)
	private String chassi;
	@Column(length = 50)
	private String proprietarioEmail;
	@Column(length = 50, nullable = false)
	private String proprietarioNome;
	@Column(length = 10)
	private String dataVenda;
	@Column(length = 10)
	private String dataCompra;
	@Column(length = 19)
	private String proprietarioAnteriorCnpj;
	@Column(length = 50)
	private String proprietarioAnteriorNome;
	@Column(length = 14)
	private String proprietarioAnteriorCpf;
	@Column(length = 15)
	private String proprietarioAnteriorRGNumero;
	@Column(length = 20)
	private String proprietarioAnteriorRGOrgaoEmisssor;
	@Column(length = 15)
	private String proprietarioRGNumero;
	@Column(length = 20)
	private String proprietarioRGOrgaoEmisssor;
	@Column(length = 20)
	private String proprietarioAnteriorFax;
	@Column(length = 19)
	private String proprietarioCnpj;
	@Column(length = 14)
	private String proprietarioCpf;
	@Column(length = 20)
	private String proprietarioFax;
	@Column(length = 50)
	private String valorCompra;
	@Column(length = 10)
	private String valorVenda;
	@Column(length = 20)
	private String proprietarioFone1;
	@Column(length = 20)
	private String proprietarioFone2;
	@Column(length = 50)
	private String bairro;
	@Column(length = 10)
	private String cep;
	@Column(length = 50)
	private String cidade;
	@Column(length = 50)
	private String estado;
	@Column(length = 50)
	private String logradouro;
	@Column(length = 50)
	private String pais;
	@Column(length = 20)
	private String complemento;
	@Column(length = 50)
	private String categoria;
	@Column(length = 10)
	private String cmtTon;
	@Column(length = 2)
	private String eixos;
	@Column(length = 4)
	private String anoFabricacao;
	@Column(length = 4)
	private String anoModelo;
	@Column(length = 10)
	private String potencia;
	@Column(length = 2)
	private String cilindros;
	@Column(length = 4)
	private String cilindrada;
	@Column(length = 3)
	private String capacidadePassageiros;
	@Column(length = 9)
	private String fabricacao;
	@Column(length = 50)
	private String carroceria;
	@Column(length = 10)
	private String capCarga;
	@Column(length = 20)
	private String restricoes;
	@Column(length = 3)
	private String ipva;
	@Column(length = 20)
	private String proprietarioAnteriorFone1;
	@Column(length = 20)
	private String proprietarioAnteriorFone2;
	@Column(length = 20)
	private String proprietarioAnteriorEmail;

	public String getAnoFabricacao() {
		return anoFabricacao;
	}

	public String getAnoModelo() {
		return anoModelo;
	}

	public String getAnoReferenciaCompra() {
		return anoReferenciaCompra;
	}

	public String getAnoReferenciaVenda() {
		return anoReferenciaVenda;
	}

	public String getAtividade() {
		return atividade;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCapacidadePassageiros() {
		return capacidadePassageiros;
	}

	public String getCapCarga() {
		return capCarga;
	}

	public String getCarroceria() {
		return carroceria;
	}

	public String getCategoria() {
		return categoria;
	}

	public CentroCusto getCentroCusto() {
		return centroCusto;
	}

	public String getCep() {
		return cep;
	}

	public String getChassi() {
		return chassi;
	}

	public String getChassiRemarcado() {
		return chassiRemarcado;
	}

	public String getCidade() {
		return cidade;
	}

	public String getCilindrada() {
		return cilindrada;
	}

	public String getCilindros() {
		return cilindros;
	}

	public String getCmtTon() {
		return cmtTon;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCor() {
		return cor;
	}

	public String getDataCompra() {
		return dataCompra;
	}

	public String getDataVenda() {
		return dataVenda;
	}

	public String getDepreciacao() {
		return depreciacao;
	}

	public String getEixos() {
		return eixos;
	}

	public String getEspecie() {
		return especie;
	}

	public String getEstado() {
		return estado;
	}

	public String getFabricacao() {
		return fabricacao;
	}

	public Long getId() {
		return id;
	}

	public String getIpva() {
		return ipva;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getLucro() {
		return lucro;
	}

	public VeiculoMarca getMarca() {
		return marca;
	}

	public String getMesReferenciaCompra() {
		return mesReferenciaCompra;
	}

	public String getMesReferenciaVenda() {
		return mesReferenciaVenda;
	}

	public VeiculoModelo getModelo() {
		return modelo;
	}

	public String getMunicipioEmplacamento() {
		return municipioEmplacamento;
	}

	public String getNomeVeiculo() {
		return nomeVeiculo;
	}

	public String getPais() {
		return pais;
	}

	public String getPlaca() {
		return placa;
	}

	public String getPotencia() {
		return potencia;
	}

	public String getPrejuizo() {
		return prejuizo;
	}

	public String getProprietarioAnteriorCnpj() {
		return proprietarioAnteriorCnpj;
	}

	public String getProprietarioAnteriorCpf() {
		return proprietarioAnteriorCpf;
	}

	public String getProprietarioAnteriorEmail() {
		return proprietarioAnteriorEmail;
	}

	public String getProprietarioAnteriorFax() {
		return proprietarioAnteriorFax;
	}

	public String getProprietarioAnteriorFone1() {
		return proprietarioAnteriorFone1;
	}

	public String getProprietarioAnteriorFone2() {
		return proprietarioAnteriorFone2;
	}

	public String getProprietarioAnteriorNome() {
		return proprietarioAnteriorNome;
	}

	public String getProprietarioAnteriorRGNumero() {
		return proprietarioAnteriorRGNumero;
	}

	public String getProprietarioAnteriorRGOrgaoEmisssor() {
		return proprietarioAnteriorRGOrgaoEmisssor;
	}

	public String getProprietarioCNPJ() {
		return proprietarioCnpj;
	}

	public String getProprietarioCpf() {
		return proprietarioCpf;
	}

	public String getProprietarioEmail() {
		return proprietarioEmail;
	}

	public String getProprietarioFax() {
		return proprietarioFax;
	}

	public String getProprietarioFone1() {
		return proprietarioFone1;
	}

	public String getProprietarioFone2() {
		return proprietarioFone2;
	}

	public String getProprietarioNome() {
		return proprietarioNome;
	}

	public String getProprietarioRGNumero() {
		return proprietarioRGNumero;
	}

	public String getProprietarioRGOrgaoEmisssor() {
		return proprietarioRGOrgaoEmisssor;
	}

	public String getRenavam() {
		return renavam;
	}

	public String getRestricoes() {
		return restricoes;
	}

	public String getTipo() {
		return tipo;
	}

	public String getValorCompra() {
		return valorCompra;
	}

	public String getValorVenda() {
		return valorVenda;
	}

	public String getZeroKm() {
		return zeroKm;
	}

	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public void setAnoModelo(String anoModelo) {
		this.anoModelo = anoModelo;
	}

	public void setAnoReferenciaCompra(String anoReferenciaCompra) {
		this.anoReferenciaCompra = anoReferenciaCompra;
	}

	public void setAnoReferenciaVenda(String anoReferenciaVenda) {
		this.anoReferenciaVenda = anoReferenciaVenda;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCapacidadePassageiros(String capacidaPassageiros) {
		this.capacidadePassageiros = capacidaPassageiros;
	}

	public void setCapCarga(String capCarga) {
		this.capCarga = capCarga;
	}

	public void setCarroceria(String carroceria) {
		this.carroceria = carroceria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setCentroCusto(CentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public void setChassiRemarcado(String chassiRemarcado) {
		this.chassiRemarcado = chassiRemarcado;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setCilindrada(String cilindrada) {
		this.cilindrada = cilindrada;
	}

	public void setCilindros(String cilindros) {
		this.cilindros = cilindros;
	}

	public void setCmtTon(String cmtTon) {
		this.cmtTon = cmtTon;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
	}

	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}

	public void setDepreciacao(String depreciacao) {
		this.depreciacao = depreciacao;
	}

	public void setEixos(String eixos) {
		this.eixos = eixos;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setFabricacao(String fabricacao) {
		this.fabricacao = fabricacao;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIpva(String ipva) {
		this.ipva = ipva;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setLucro(String lucro) {
		this.lucro = lucro;
	}

	public void setMarca(VeiculoMarca marca) {
		this.marca = marca;
	}

	public void setMesReferenciaCompra(String mesReferenciaCompra) {
		this.mesReferenciaCompra = mesReferenciaCompra;
	}

	public void setMesReferenciaVenda(String mesReferenciaVenda) {
		this.mesReferenciaVenda = mesReferenciaVenda;
	}

	public void setModelo(VeiculoModelo modelo) {
		this.modelo = modelo;
	}

	public void setMunicipioEmplacamento(String municipioEmplacamento) {
		this.municipioEmplacamento = municipioEmplacamento;
	}

	public void setNomeVeiculo(String nomeVeiculo) {
		this.nomeVeiculo = nomeVeiculo;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	public void setPrejuizo(String prejuizo) {
		this.prejuizo = prejuizo;
	}

	public void setProprietarioAnteriorCnpj(String proprietarioAnteriorCNPJ) {
		this.proprietarioAnteriorCnpj = proprietarioAnteriorCNPJ;
	}

	public void setProprietarioAnteriorCpf(String proprietarioAnteriorCPF) {
		this.proprietarioAnteriorCpf = proprietarioAnteriorCPF;
	}

	public void setProprietarioAnteriorEmail(String proprietarioAnteriorEmail) {
		this.proprietarioAnteriorEmail = proprietarioAnteriorEmail;
	}

	public void setProprietarioAnteriorFax(String proprietarioAnteriorFax) {
		this.proprietarioAnteriorFax = proprietarioAnteriorFax;
	}

	public void setProprietarioAnteriorFone1(String proprietarioAnteriorFone1) {
		this.proprietarioAnteriorFone1 = proprietarioAnteriorFone1;
	}

	public void setProprietarioAnteriorFone2(String proprietarioAnteriorFone2) {
		this.proprietarioAnteriorFone2 = proprietarioAnteriorFone2;
	}

	public void setProprietarioAnteriorNome(String proprietarioAnteriorNome) {
		this.proprietarioAnteriorNome = proprietarioAnteriorNome;
	}

	public void setProprietarioAnteriorRGNumero(String proprietarioAnteriorRGNumero) {
		this.proprietarioAnteriorRGNumero = proprietarioAnteriorRGNumero;
	}

	public void setProprietarioAnteriorRGOrgaoEmisssor(String proprietarioAnteriorRGOrgaoEmisssor) {
		this.proprietarioAnteriorRGOrgaoEmisssor = proprietarioAnteriorRGOrgaoEmisssor;
	}

	public void setProprietarioCnpj(String proprietarioCNPJ) {
		this.proprietarioCnpj = proprietarioCNPJ;
	}

	public void setProprietarioCpf(String proprietarioCPF) {
		this.proprietarioCpf = proprietarioCPF;
	}

	public void setProprietarioEmail(String proprietarioEmail) {
		this.proprietarioEmail = proprietarioEmail;
	}

	public void setProprietarioFax(String proprietarioFax) {
		this.proprietarioFax = proprietarioFax;
	}

	public void setProprietarioFone1(String proprietarioFone1) {
		this.proprietarioFone1 = proprietarioFone1;
	}

	public void setProprietarioFone2(String proprietarioFone2) {
		this.proprietarioFone2 = proprietarioFone2;
	}

	public void setProprietarioNome(String proprietarioNome) {
		this.proprietarioNome = proprietarioNome;
	}

	public void setProprietarioRGNumero(String proprietarioRGNumero) {
		this.proprietarioRGNumero = proprietarioRGNumero;
	}

	public void setProprietarioRGOrgaoEmisssor(String proprietarioRGOrgaoEmisssor) {
		this.proprietarioRGOrgaoEmisssor = proprietarioRGOrgaoEmisssor;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public void setRestricoes(String restricoes) {
		this.restricoes = restricoes;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setValorCompra(String valorCompra) {
		this.valorCompra = valorCompra;
	}

	public void setValorVenda(String valorVenda) {
		this.valorVenda = valorVenda;
	}

	public void setZeroKm(String zeroKm) {
		this.zeroKm = zeroKm;
	}

	public String getNumeroMotor() {
		return numeroMotor;
	}

	public void setNumeroMotor(String numeroMotor) {
		this.numeroMotor = numeroMotor;
	}

	public String getTransmissão() {
		return transmissão;
	}

	public void setTransmissão(String transmissão) {
		this.transmissão = transmissão;
	}

	public String getMarchas() {
		return marchas;
	}

	public void setMarchas(String marchas) {
		this.marchas = marchas;
	}

	public String getPneus() {
		return pneus;
	}

	public void setPneus(String pneus) {
		this.pneus = pneus;
	}

	public String getRodas() {
		return rodas;
	}

	public void setRodas(String rodas) {
		this.rodas = rodas;
	}

	public String getValvulas() {
		return valvulas;
	}

	public void setValvulas(String valvulas) {
		this.valvulas = valvulas;
	}

	public String getRebaixado() {
		return rebaixado;
	}

	public void setRebaixado(String rebaixado) {
		this.rebaixado = rebaixado;
	}

	public String getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(String quilometragem) {
		this.quilometragem = quilometragem;
	}

	@Override
	public String toString() {
		return placa;
	}
}

package erp.veiculo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;

import erp.centrocusto.CentroCusto;
import erp.veiculo.marca.VeiculoMarca;
import erp.veiculo.modelo.VeiculoModelo;

@SuppressWarnings("serial")
@PersistenceContext(unitName = "erp")
@Entity
@Table(indexes = { @Index(name = "INDEX_VEICULO_PLACA", columnList = "placa", unique = true),
		@Index(name = "INDEX_VEICULO_RENAVAM", columnList = "renavam", unique = true),
		@Index(name = "INDEX_VEICULO_CHASSI", columnList = "chassi", unique = true) })
public class Veiculo implements Serializable {

	@Column(length = 3)
	private String adaptadoDeficiente;
	@Column(length = 4)
	private String anoFabricacao;
	@Column(length = 4)
	private String anoModelo;
	@Column(length = 4)
	private String anoReferenciaCadastro;
	@Column(length = 4)
	private String anoReferenciaCompra;
	@Column(length = 4)
	private String anoReferenciaVenda;
	@Column(length = 18)
	private String atividade;
	@Column(length = 10)
	private String cambio;
	@Column(length = 3)
	private String capaenderecoCidadePassageiros;
	@Column(length = 10)
	private String capCarga;
	@Column(length = 50)
	private String carroceria;
	@Column(length = 50)
	private String categoria;
	@ManyToOne(cascade = CascadeType.ALL)
	private CentroCusto centroCusto;
	@Column(length = 20)
	private String chassi;
	@Column(length = 3)
	private String chassiRemarcado;
	@Column(length = 4)
	private String cilindrada;
	@Column(length = 2)
	private String cilindros;
	@Column(length = 10)
	private String cmtTon;
	@Column(length = 32)
	private String combustivel;
	@Column(length = 8)
	private String cor;
	@Column(length = 10)
	private String dataCompra;
	@Column(length = 10)
	private String dataVenda;
	@Column(length = 10)
	private String depreciacao;
	private double desconto;
	@Column(length = 2)
	private String eixos;
	@Column(length = 50)
	private String enderecoBairro;
	@Column(length = 10)
	private String enderecoCep;
	@Column(length = 50)
	private String enderecoCidade;
	@Column(length = 20)
	private String enderecoComplemento;
	@Column(length = 50)
	private String enderecoEstado;
	@Column(length = 50)
	private String enderecoEstadoEmplacamento;
	@Column(length = 50)
	private String enderecoLogradouro;
	@Column(length = 10)
	private String especie;
	@Column(length = 9)
	private String fabricacao;
	@Id
	@GeneratedValue
	private Long id;
	@Column(length = 3)
	private String ipva;
	@Column(length = 10)
	private String lucro;
	@ManyToOne(cascade = CascadeType.ALL)
	private VeiculoMarca marca;
	@Column(length = 2)
	private String marchas;
	@Column(length = 9)
	private String mesReferenciaCadastro;
	@Column(length = 9)
	private String mesReferenciaCompra;
	@Column(length = 9)
	private String mesReferenciaVenda;
	@ManyToOne(cascade = CascadeType.ALL)
	private VeiculoModelo modelo;
	@Column(length = 50)
	private String municipioEmplacamento;
	@Column(length = 9)
	private String numeroMotor;
	private int numeroPotas;
	@Column(length = 50)
	private String pais;
	@Column(length = 8, nullable = false)
	private String placa;
	@Column(length = 50)
	private String pneus;
	@Column(length = 10)
	private String potencia;
	@Column(length = 10)
	private String prejuizo;
	@Column(length = 19)
	private String proprietarioAnteriorCnpj;
	@Column(length = 14)
	private String proprietarioAnteriorCpf;
	@Column(length = 20)
	private String proprietarioAnteriorEmail;
	@Column(length = 20)
	private String proprietarioAnteriorFax;
	@Column(length = 20)
	private String proprietarioAnteriorFone1;
	@Column(length = 20)
	private String proprietarioAnteriorFone2;
	@Column(length = 50)
	private String proprietarioAnteriorNome;
	@Column(length = 15)
	private String proprietarioAnteriorRGNumero;
	@Column(length = 20)
	private String proprietarioAnteriorRGOrgaoEmisssor;
	@Column(length = 19)
	private String proprietarioCnpj;
	@Column(length = 14)
	private String proprietarioCpf;
	@Column(length = 50)
	private String proprietarioEmail;
	@Column(length = 20)
	private String proprietarioFax;
	@Column(length = 20)
	private String proprietarioFone1;
	@Column(length = 20)
	private String proprietarioFone2;
	@Column(length = 50, nullable = false)
	private String proprietarioNome;
	@Column(length = 15)
	private String proprietarioRGNumero;
	@Column(length = 20)
	private String proprietarioRGOrgaoEmisssor;
	@Column(length = 7)
	private String quilometragem;
	@Column(length = 3)
	private String rebaixado;
	@Column(length = 15)
	private String renavam;
	@Column(length = 20)
	private String restricoes;
	@Column(length = 50)
	private String rodas;
	@Column(length = 50)
	private String subCategoria;
	@Column(length = 17)
	private String tipo;
	private double valorCompra;
	private double valorVenda;
	@Column(length = 1)
	private String valvulas;
	@Column(length = 3)
	private String zeroKm;

	public String getAdaptadoDeficiente() {
		return adaptadoDeficiente;
	}

	public String getAnoFabricacao() {
		return anoFabricacao;
	}

	public String getAnoModelo() {
		return anoModelo;
	}

	public String getAnoReferenciaCadastro() {
		return anoReferenciaCadastro;
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

	public String getCambio() {
		return cambio;
	}

	public String getCapaenderecoCidadePassageiros() {
		return capaenderecoCidadePassageiros;
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

	public String getChassi() {
		return chassi;
	}

	public String getChassiRemarcado() {
		return chassiRemarcado;
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

	public double getDesconto() {
		return desconto;
	}

	public String getEixos() {
		return eixos;
	}

	public String getEnderecoBairro() {
		return enderecoBairro;
	}

	public String getEnderecoCep() {
		return enderecoCep;
	}

	public String getEnderecoCidade() {
		return enderecoCidade;
	}

	public String getEnderecoComplemento() {
		return enderecoComplemento;
	}

	public String getEnderecoEstado() {
		return enderecoEstado;
	}

	public String getEnderecoEstadoEmplacamento() {
		return enderecoEstadoEmplacamento;
	}

	public String getEnderecoLogradouro() {
		return enderecoLogradouro;
	}

	public String getEspecie() {
		return especie;
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

	public String getLucro() {
		return lucro;
	}

	public VeiculoMarca getMarca() {
		return marca;
	}

	public String getMarchas() {
		return marchas;
	}

	public String getMesReferenciaCadastro() {
		return mesReferenciaCadastro;
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

	public String getNumeroMotor() {
		return numeroMotor;
	}

	public int getNumeroPortas() {
		return numeroPotas;
	}

	public int getNumeroPotas() {
		return numeroPotas;
	}

	public String getPais() {
		return pais;
	}

	public String getPlaca() {
		return placa;
	}

	public String getPneus() {
		return pneus;
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

	public String getProprietarioCnpj() {
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

	public String getQuilometragem() {
		return quilometragem;
	}

	public String getRebaixado() {
		return rebaixado;
	}

	public String getRenavam() {
		return renavam;
	}

	public String getRestricoes() {
		return restricoes;
	}

	public String getRodas() {
		return rodas;
	}

	public String getSubCategoria() {
		return subCategoria;
	}

	public String getTipo() {
		return tipo;
	}

	public double getValorCompra() {
		return valorCompra;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public String getValvulas() {
		return valvulas;
	}

	public String getZeroKm() {
		return zeroKm;
	}

	public void setAdaptadoDeficiente(String adaptadoDeficiente) {
		this.adaptadoDeficiente = adaptadoDeficiente;
	}

	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public void setAnoModelo(String anoModelo) {
		this.anoModelo = anoModelo;
	}

	public void setAnoReferenciaCadastro(String anoReferenciaCadastro) {
		this.anoReferenciaCadastro = anoReferenciaCadastro;
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

	public void setCambio(String cambio) {
		this.cambio = cambio;
	}

	public void setCapaenderecoCidadePassageiros(String capacidaPassageiros) {
		this.capaenderecoCidadePassageiros = capacidaPassageiros;
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

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public void setChassiRemarcado(String chassiRemarcado) {
		this.chassiRemarcado = chassiRemarcado;
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

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public void setEixos(String eixos) {
		this.eixos = eixos;
	}

	public void setEnderecoBairro(String enderecoBairro) {
		this.enderecoBairro = enderecoBairro;
	}

	public void setEnderecoCep(String enderecoCep) {
		this.enderecoCep = enderecoCep;
	}

	public void setEnderecoCidade(String enderecoCidade) {
		this.enderecoCidade = enderecoCidade;
	}

	public void setEnderecoComplemento(String enderecoComplemento) {
		this.enderecoComplemento = enderecoComplemento;
	}

	public void setEnderecoEstado(String enderecoEstado) {
		this.enderecoEstado = enderecoEstado;
	}

	public void setEnderecoEstadoEmplacamento(String enderecoEstadoEmplacamento) {
		this.enderecoEstadoEmplacamento = enderecoEstadoEmplacamento;
	}

	public void setEnderecoLogradouro(String enderecoLogradouro) {
		this.enderecoLogradouro = enderecoLogradouro;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
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

	public void setLucro(String lucro) {
		this.lucro = lucro;
	}

	public void setMarca(VeiculoMarca marca) {
		this.marca = marca;
	}

	public void setMarchas(String marchas) {
		this.marchas = marchas;
	}

	public void setMesReferenciaCadastro(String mesReferenciaCadastro) {
		this.mesReferenciaCadastro = mesReferenciaCadastro;
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

	public void setNumeroMotor(String numeroMotor) {
		this.numeroMotor = numeroMotor;
	}

	public void setNumeroPortas(int numeroPotas) {
		this.numeroPotas = numeroPotas;
	}

	public void setNumeroPotas(int numeroPotas) {
		this.numeroPotas = numeroPotas;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setPneus(String pneus) {
		this.pneus = pneus;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	public void setPrejuizo(String prejuizo) {
		this.prejuizo = prejuizo;
	}

	public void setProprietarioAnteriorCnpj(String proprietarioAnteriorCnpj) {
		this.proprietarioAnteriorCnpj = proprietarioAnteriorCnpj;
	}

	public void setProprietarioAnteriorCpf(String proprietarioAnteriorCpf) {
		this.proprietarioAnteriorCpf = proprietarioAnteriorCpf;
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

	public void setProprietarioCnpj(String proprietarioCnpj) {
		this.proprietarioCnpj = proprietarioCnpj;
	}

	public void setProprietarioCpf(String proprietarioCpf) {
		this.proprietarioCpf = proprietarioCpf;
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

	public void setQuilometragem(String quilometragem) {
		this.quilometragem = quilometragem;
	}

	public void setRebaixado(String rebaixado) {
		this.rebaixado = rebaixado;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public void setRestricoes(String restricoes) {
		this.restricoes = restricoes;
	}

	public void setRodas(String rodas) {
		this.rodas = rodas;
	}

	public void setSubCategoria(String subCategoria) {
		this.subCategoria = subCategoria;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public void setValvulas(String valvulas) {
		this.valvulas = valvulas;
	}

	public void setZeroKm(String zeroKm) {
		this.zeroKm = zeroKm;
	}

	@Override
	public String toString() {
		return placa;
	}
}

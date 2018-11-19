package erp.imovel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;

@SuppressWarnings("serial")
@PersistenceContext(unitName = "erp")
@Entity
public class Imovel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(length = 19)
	private String cnpj;
	@Column(length = 2)
	private String cozinha;
	@Column(length = 2)
	private String banheiro;
	@Column(length = 2)
	private String quarto;
	@Column(length = 2)
	private String suite;
	@Column(length = 14)
	private String cpfNumero;
	@Column(length = 50)
	private String email;
	@Column(length = 2)
	private String varanda;
	@Column(length = 20)
	private String fax;
	@Column(length = 20)
	private String fone1;
	@Column(length = 20)
	private String fone2;
	@Column(length = 50)
	private String nomeProprietario;
	@Column(length = 3)
	private String garagem;
	@Column(length = 3)
	private String piscina;
	@Column(length = 3)
	private String terraco;
	@Column(length = 2)
	private String sala;
	@Column(length = 50)
	private String pais;
	@Column(length = 50)
	private String estado;
	@Column(length = 50)
	private String cidade;
	@Column(length = 50)
	private String bairro;
	@Column(length = 50)
	private String logradouro;
	@Column(length = 20)
	private String complemento;
	@Column(length = 10)
	private String cep;

	public String getBairro() {
		return this.bairro;
	}

	public String getBanheiro() {
		return this.banheiro;
	}

	public String getCep() {
		return this.cep;
	}

	public String getCidade() {
		return this.cidade;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public String getCozinha() {
		return this.cozinha;
	}

	public String getCpfNumero() {
		return this.cpfNumero;
	}

	public String getEmail() {
		return this.email;
	}

	public String getEstado() {
		return this.estado;
	}

	public String getFax() {
		return this.fax;
	}

	public String getFone1() {
		return this.fone1;
	}

	public String getFone2() {
		return this.fone2;
	}

	public String getGaragem() {
		return this.garagem;
	}

	public Long getId() {
		return this.id;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public String getNomeProprietario() {
		return this.nomeProprietario;
	}

	public String getPais() {
		return this.pais;
	}

	public String getPiscina() {
		return this.piscina;
	}

	public String getQuarto() {
		return quarto;
	}

	public String getSala() {
		return this.sala;
	}

	public String getSuite() {
		return this.suite;
	}

	public String getTerracao() {
		return this.terraco;
	}

	public String getVaranda() {
		return this.varanda;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setBanheiro(String banheiro) {
		this.banheiro = banheiro;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setCozinha(String cozinha) {
		this.cozinha = cozinha;
	}

	public void setCpfNumero(String cpfNumero) {
		this.cpfNumero = cpfNumero;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public void setFone1(String fone1) {
		this.fone1 = fone1;
	}

	public void setFone2(String fone2) {
		this.fone2 = fone2;
	}

	public void setGaragem(String garagem) {
		this.garagem = garagem;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public void setPiscina(String piscina) {
		this.piscina = piscina;
	}

	public void setQuarto(String quarto) {
		this.quarto = quarto;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public void setTerraco(String terraco) {
		this.terraco = terraco;
	}

	public void setVaranda(String varanda) {
		this.varanda = varanda;
	}

	@Override
	public String toString() {
		return this.nomeProprietario;
	}
}

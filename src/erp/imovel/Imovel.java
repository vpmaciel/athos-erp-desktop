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

	@Column(length = 2)
	private String banheiro;
	@Column(length = 19)
	private String cnpj;
	@Column(length = 2)
	private String cozinha;
	@Column(length = 14)
	private String cpf;
	@Column(length = 50)
	private String email;
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
	private String enderecoLogradouro;
	@Column(length = 20)
	private String fax;
	@Column(length = 20)
	private String fone1;
	@Column(length = 20)
	private String fone2;
	@Column(length = 3)
	private String garagem;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50)
	private String nomeProprietario;
	@Column(length = 50)
	private String enderecoPais;
	@Column(length = 3)
	private String piscina;
	@Column(length = 2)
	private String quarto;
	@Column(length = 2)
	private String sala;
	@Column(length = 2)
	private String suite;
	@Column(length = 3)
	private String terraco;
	@Column(length = 2)
	private String varanda;

	public String getBanheiro() {
		return this.banheiro;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public String getCozinha() {
		return this.cozinha;
	}

	public String getCpf() {
		return this.cpf;
	}

	public String getEmail() {
		return this.email;
	}

	public String getEnderecoBairro() {
		return this.enderecoBairro;
	}

	public String getEnderecoCep() {
		return this.enderecoCep;
	}

	public String getEnderecoCidade() {
		return this.enderecoCidade;
	}

	public String getEnderecoComplemento() {
		return this.enderecoComplemento;
	}

	public String getEnderecoEstado() {
		return this.enderecoEstado;
	}

	public String getEnderecoLogradouro() {
		return this.enderecoLogradouro;
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

	public String getNomeProprietario() {
		return this.nomeProprietario;
	}

	public String getEnderecoPais() {
		return this.enderecoPais;
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

	public String getTerraco() {
		return this.terraco;
	}

	public String getVaranda() {
		return this.varanda;
	}

	public void setBanheiro(String banheiro) {
		this.banheiro = banheiro;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setCozinha(String cozinha) {
		this.cozinha = cozinha;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public void setEnderecoLogradouro(String enderecoLogradouro) {
		this.enderecoLogradouro = enderecoLogradouro;
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

	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}

	public void setEnderecoPais(String enderecoPais) {
		this.enderecoPais = enderecoPais;
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

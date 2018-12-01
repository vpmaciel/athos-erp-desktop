package arquitetura.validacao;

public class Anexo {

	private String dataAlteracao;
	private String dataCriacao;
	private String descricao;
	private Long id;
	private String localizacao;

	public String getDataAlteracao() {
		return this.dataAlteracao;
	}

	public String getDataCriacao() {
		return this.dataCriacao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public Long getId() {
		return this.id;
	}

	public String getLocalizacao() {
		return this.localizacao;
	}

	public void setDataAlteracao(String dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
}

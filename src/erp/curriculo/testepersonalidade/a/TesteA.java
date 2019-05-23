package erp.curriculo.testepersonalidade.a;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;

import erp.funcionario.Funcionario;

@SuppressWarnings("serial")
@PersistenceContext(unitName = "erp")
@Entity
@Table(indexes = { @Index(name = "INDEX_TESTE_A_FUNCIONARIO", columnList = "funcionario_id", unique = true) })
public class TesteA implements Serializable {

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "funcionario_id", referencedColumnName = "id")
	private Funcionario funcionario;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer totalOpcaoA;
	private Integer totalOpcaoC;
	private Integer totalOpcaoI;
	private Integer totalOpcaoO;

	public TesteA() {
		this.totalOpcaoA = 0;
		this.totalOpcaoC = 0;
		this.totalOpcaoO = 0;
		this.totalOpcaoI = 0;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public Long getId() {
		return id;
	}

	public Integer getTotalOpcaoA() {
		return totalOpcaoA;
	}

	public Integer getTotalOpcaoC() {
		return totalOpcaoC;
	}

	public Integer getTotalOpcaoI() {
		return totalOpcaoI;
	}

	public Integer getTotalOpcaoO() {
		return totalOpcaoO;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTotalOpcaoA() {
		if (this.totalOpcaoA == null) {
			this.totalOpcaoA = 1;
		} else {
			this.totalOpcaoA++;
		}
	}

	public void setTotalOpcaoC() {
		if (this.totalOpcaoC == null) {
			this.totalOpcaoC = 1;
		} else {
			this.totalOpcaoC++;
		}
	}

	public void setTotalOpcaoI() {
		if (this.totalOpcaoI == null) {
			this.totalOpcaoI = 1;
		} else {
			this.totalOpcaoI++;
		}
	}

	public void setTotalOpcaoO() {
		if (this.totalOpcaoO == null) {
			this.totalOpcaoO = 1;
		} else {
			this.totalOpcaoO++;
		}
	}
}

package erp.agenda.compromisso;

import java.util.Collection;

public interface CompromissoDao {

	public String construirQuery(StringBuilder compromisso);

	public void deletarRegistro(Compromisso compromisso);

	public Compromisso getRegistro(Compromisso compromisso);

	public Collection<Compromisso> getRegistro();

	public Collection<Compromisso> pesquisarRegistro(Compromisso compromisso);

	public void salvarRegistro(Compromisso compromisso);
}

package br.com.everton;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import br.com.everton.dto.Time;

@WebService
@SOAPBinding
public interface MeuWebservice {
	public void addTime(Time time);
	public List<Time> buscaTodosTimes();
	public Time buscaPorNome(String nome) throws Exception;
}

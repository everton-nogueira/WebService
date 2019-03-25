package br.com.everton;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.everton.dto.Time;


@WebService(endpointInterface = "br.com.everton.MeuWebservice")
public class WebServiceImpl implements MeuWebservice{
	
	private static List<Time> times = new ArrayList<Time>();
	
	@WebMethod
	public void addTime(Time time) {
		times.add(time);
	}
	
	@WebMethod
	public List<Time> buscaTodosTimes(){
		return times;
	}
	
	@WebMethod
	public Time buscaPorNome(String nome) throws Exception {
		List<Time> filtrados = times.stream().filter((time) -> time.getNome().equalsIgnoreCase(nome)).collect(Collectors.toList());
		if(filtrados != null) {
			if(filtrados.size() <= 0) {
				throw new Exception("Não existe um time com esse nome.");
			}else if(filtrados.size() > 1) {
				throw new Exception("Existe mais de um time com esse nome.");
			}else {
				return filtrados.get(0);
			}
		}
		return null;
	}
}

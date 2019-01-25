package Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mockito.Mockito;

@SuppressWarnings("rawtypes")
public class RequestBodyGenerator {

	public static Map gerarMassaDeDados(int porcentagem, Map mapa, List lista) {
		Map<String, Object> req = new HashMap<String, Object>();
		req.put("percentualReducaoBase", porcentagem);
		req.put("contasPreservadas", lista);
		req.put("emailContato", EntityGenericUtil.getStringEmail());
		req.put("emissor", EntityGenericUtil.getString());
		req.put("baseDados", mapa);
		return req;
	}

	public static Map gerarDadosServidor() {
		Map<String, Object> reqBase = new HashMap<String, Object>();
		reqBase.put("servidor", "10.60.30.23");
		reqBase.put("base", "Valhalla");
		reqBase.put("usuario", "UserValhalla");
		reqBase.put("senha", "UserValhalla");
		return reqBase;
	}

	public static List gerarListaContas() {
		List<Integer> listaContas = new ArrayList<Integer>();
		listaContas.add(EntityGenericUtil.getInteger());
		listaContas.add(EntityGenericUtil.getInteger());
		listaContas.add(EntityGenericUtil.getInteger());
		return listaContas;
	}

	public static List gerarListaString() {
		List<String> listaContas = new ArrayList<String>();
		listaContas.add(EntityGenericUtil.getString());
		listaContas.add(EntityGenericUtil.getString());
		listaContas.add(EntityGenericUtil.getString());
		return listaContas;
	}

	public static Object gerarMassaDados() {
		return gerarMassaDeDados(EntityGenericUtil.getIntegerBase10(), gerarDadosServidor(), gerarListaContas());
	}

	public static Object geradorDadosListaVazia() {
		return gerarMassaDeDados(EntityGenericUtil.getIntegerBase10(), gerarDadosServidor(), Mockito.anyList());
	}

	public static Object geradorRequestMockadaListaString() {
		return gerarMassaDeDados(EntityGenericUtil.getIntegerBase10(), gerarDadosServidor(), gerarListaString());
	}

	public static Map geradorRequestMockadaPorcentagemInvalida() {
		return gerarMassaDeDados(-1, gerarDadosServidor(), gerarListaString());
	}

	public static Map geradorRequestMockadaPorcentagemNaoInformada() {
		return gerarMassaDeDados(Mockito.anyInt(), gerarDadosServidor(), gerarListaString());
	}

	public static Object gerarBodyVazio() {
		return Mockito.anyMap();
	}

}

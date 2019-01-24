package Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mockito.Mockito;

@SuppressWarnings("rawtypes")
public class RequestBodyGenerator {


	
	
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

	public static List gerarListaVazia() {
		List<Integer> listaContas = new ArrayList<Integer>();
		return listaContas;
	}

	public static List gerarListaString() {
		List<String> listaContas = new ArrayList<String>();
		listaContas.add(EntityGenericUtil.getString());
		listaContas.add(EntityGenericUtil.getString());
		listaContas.add(EntityGenericUtil.getString());
		return listaContas;
	}

	public static Map gerarMassaDeDados(Map mapa, List lista) {
		Map<String, Object> req = new HashMap<String, Object>();
		req.put("percentualReducaoBase", EntityGenericUtil.getIntegerBase10());
		req.put("contasPreservadas", lista);
		req.put("emailContato", EntityGenericUtil.getStringEmail());
		req.put("emissor", EntityGenericUtil.getString());
		req.put("baseDados", mapa);
		return req;
	}

	public static Object gerarMassaDados() {
		return gerarMassaDeDados(gerarDadosServidor(), gerarListaContas());
	}

	public static Map geradorDadosListaVazia() {
		return gerarMassaDeDados(gerarDadosServidor(), gerarListaVazia());
	}

	public static Map geradorRequestMockadaListaString() {
		return gerarMassaDeDados(gerarDadosServidor(), gerarListaString());
	}

	public static Map gerarBodyVazio() {
		return Mockito.anyMap();
	}



	public static Map geradorRequestMockadaPorcentagemInvalida() {

		Map<String, Object> reqBase = new HashMap<String, Object>();
		reqBase.put("servidor", "10.60.30.23");
		reqBase.put("base", "Valhalla");
		reqBase.put("usuario", "UserValhalla");
		reqBase.put("senha", "UserValhalla");

		List<Integer> listaContas = new ArrayList<Integer>();
		listaContas.add(EntityGenericUtil.getInteger());
		listaContas.add(EntityGenericUtil.getInteger());
		listaContas.add(EntityGenericUtil.getInteger());

		Map<String, Object> req = new HashMap<String, Object>();
		req.put("percentualReducaoBase", -200);
		req.put("contasPreservadas", listaContas);
		req.put("emailContato", EntityGenericUtil.getStringEmail());
		req.put("emissor", EntityGenericUtil.getString());
		req.put("baseDados", reqBase);

		return req;
	}

	public static Map geradorRequestMockadaPorcentagemNaoInformada() {

		Map<String, Object> req = new HashMap<String, Object>();
		req.put("contasPreservadas", Mockito.anyList());
		req.put("emailContato", EntityGenericUtil.getStringEmail());
		req.put("emissor", EntityGenericUtil.getString());
		req.put("baseDados", Mockito.anyMap());

		return req;
	}

	public static Map gerarRequestMockado() {

		Map<String, Object> req = new HashMap<String, Object>();
		req.put("key", Mockito.anyInt());

		return req;
	}
}

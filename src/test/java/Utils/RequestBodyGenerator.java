package Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mockito.Mockito;

@SuppressWarnings("rawtypes")
public class RequestBodyGenerator {

	public static Map geradorRequestMockada() {

		Map<String, Object> reqBase = new HashMap<String, Object>();
		reqBase.put("servidor", EntityGenericUtil.getString());
		reqBase.put("base", EntityGenericUtil.getString());
		reqBase.put("usuario", EntityGenericUtil.getString());
		reqBase.put("senha", EntityGenericUtil.getString());

		List<Integer> listaContas = new ArrayList<Integer>();
		listaContas.add(EntityGenericUtil.getInteger());
		listaContas.add(EntityGenericUtil.getInteger());
		listaContas.add(EntityGenericUtil.getInteger());

		Map<String, Object> req = new HashMap<String, Object>();
		req.put("percentualReducaoBase", EntityGenericUtil.getIntegerBase10());
		req.put("contasPreservadas", listaContas);
		req.put("emailContato", EntityGenericUtil.getStringEmail());
		req.put("emissor", EntityGenericUtil.getString());
		req.put("baseDados", reqBase);

		return req;
	}

	public static Map geradorRequestMockadaListaVazia() {

		Map<String, Object> reqBase = new HashMap<String, Object>();
		reqBase.put("servidor", EntityGenericUtil.getString());
		reqBase.put("base", EntityGenericUtil.getString());
		reqBase.put("usuario", EntityGenericUtil.getString());
		reqBase.put("senha", EntityGenericUtil.getString());

		Map<String, Object> req = new HashMap<String, Object>();
		req.put("percentualReducaoBase", EntityGenericUtil.getIntegerBase10());
		req.put("contasPreservadas", Mockito.anyList());
		req.put("emailContato", EntityGenericUtil.getStringEmail());
		req.put("emissor", EntityGenericUtil.getString());
		req.put("baseDados", reqBase);

		return req;
	}

	public static Map geradorRequestMockadaListaString() {

		Map<String, Object> reqBase = new HashMap<String, Object>();
		reqBase.put("servidor", EntityGenericUtil.getString());
		reqBase.put("base", EntityGenericUtil.getString());
		reqBase.put("usuario", EntityGenericUtil.getString());
		reqBase.put("senha", EntityGenericUtil.getString());

		List<String> listaContas = new ArrayList<String>();
		listaContas.add(EntityGenericUtil.getString());
		listaContas.add(EntityGenericUtil.getString());
		listaContas.add(EntityGenericUtil.getString());

		Map<String, Object> req = new HashMap<String, Object>();
		req.put("percentualReducaoBase", EntityGenericUtil.getIntegerBase10());
		req.put("contasPreservadas", listaContas);
		req.put("emailContato", EntityGenericUtil.getStringEmail());
		req.put("emissor", EntityGenericUtil.getString());
		req.put("baseDados", reqBase);

		return req;
	}

	public static Map gerarBodyVazio() {
		return Mockito.anyMap();
	}

	public static Map gerarObjetoRequestDadosFixos() {

		Map<String, Object> reqBase = new HashMap<String, Object>();
		reqBase.put("servidor", "localhost");
		reqBase.put("base", "BMG");
		reqBase.put("usuario", "Kevin");
		reqBase.put("senha", "1234");

		List<Integer> listaContas = new ArrayList<Integer>();
		listaContas.add(123);

		Map<String, Object> req = new HashMap<String, Object>();
		req.put("percentualReducaoBase", 50);
		req.put("contasPreservadas", listaContas);
		req.put("emailContato", "kevin.ferreira@conductor.com.br");
		req.put("emissor", "BMG");
		req.put("baseDados", reqBase);

		return req;
	}
	
	public static Map geradorRequestMockadaPorcentagemInvalida() {

		Map<String, Object> reqBase = new HashMap<String, Object>();
		reqBase.put("servidor", EntityGenericUtil.getString());
		reqBase.put("base", EntityGenericUtil.getString());
		reqBase.put("usuario", EntityGenericUtil.getString());
		reqBase.put("senha", EntityGenericUtil.getString());

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
}

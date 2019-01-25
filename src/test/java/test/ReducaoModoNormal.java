package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Utils.EntityGenericUtil;
import Utils.RequestBodyGenerator;
import Utils.RequestGenerator;
import Utils.UrlUtils;
import io.restassured.response.Response;
import validacao.validador;

public class ReducaoModoNormal extends UrlUtils {
	public RequestGenerator request = new RequestGenerator();

	public validador validador = new validador();

	@Test
	public void ReducaoModoNormalTeste() {
		Response response = request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.gerarMassaDados(), UrlUtils.getUrlReducaoNormal(), 200);
		assertTrue(validador.validarBodyRequest(response));
	}

	@Test
	public void ReducaoModoNormalTestListaVazia() {
		Response response = request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.geradorDadosListaVazia(), UrlUtils.getUrlReducaoNormal(), 200);
		assertTrue(validador.validarBodyRequest(response));
	}

	@Test
	public void ReducaoModoNormalTestListaString() {
		request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.geradorRequestMockadaListaString(), UrlUtils.getUrlReducaoNormal(), 400);
	}

	@Test
	public void ReducaoModoNormalBodyVazio() {
		request.genericRequestPOST(EntityGenericUtil.getToken(), RequestBodyGenerator.gerarBodyVazio(),
				UrlUtils.getUrlReducaoNormal(), 500);
	}

	@Test
	public void ReducaoModoNormalPorcentagemInvalida() {
		request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.geradorRequestMockadaPorcentagemInvalida(), UrlUtils.getUrlReducaoNormal(), 400);
	}

}

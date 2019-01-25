package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Utils.EntityGenericUtil;
import Utils.RequestBodyGenerator;
import Utils.RequestGenerator;
import Utils.UrlUtils;
import io.restassured.response.Response;
import validacao.validador;

public class ReducaoModoRecuperacao {

	RequestGenerator request = new RequestGenerator();

	public validador validador = new validador();

	@Test
	public void ReducaoModoRecuperacaoTeste() {
		Response response = request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.gerarMassaDados(), UrlUtils.getUrlReducaoRecuperacao(), 200);
		assertTrue(validador.validarBodyRequest(response));
	}

	@Test
	public void ReducaoModoRecuperacaoTestListaVazia() {
		Response response = request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.geradorDadosListaVazia(), UrlUtils.getUrlReducaoRecuperacao(), 200);
		assertTrue(validador.validarBodyRequest(response));
	}

	@Test
	public void ReducaoModoRecuperacaoTestListaString() {
		Response response = request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.geradorRequestMockadaListaString(), UrlUtils.getUrlReducaoRecuperacao(), 200);
		assertTrue(validador.validarBodyRequest(response));
	}

	@Test
	public void ReducaoModoRecuperacaoBodyVazio() {
		request.genericRequestPOST(EntityGenericUtil.getToken(), RequestBodyGenerator.gerarBodyVazio(),
				UrlUtils.getUrlReducaoRecuperacao(), 500);
	}

	@Test
	public void ReducaoModoRecuperacaoPorcentagemInvalida() {
		Response response = 
		request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.geradorRequestMockadaPorcentagemInvalida(), UrlUtils.getUrlReducaoRecuperacao(),
				200);
		assertTrue(validador.validarBodyRequest(response));
	}

	@Test
	public void ReducaoModoRecuperacaoPorcentagemNaoInformada() {
		Response response = 
		request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.geradorRequestMockadaPorcentagemNaoInformada(),
				UrlUtils.getUrlReducaoRecuperacao(), 200);
		assertTrue(validador.validarBodyRequest(response));
	}
}

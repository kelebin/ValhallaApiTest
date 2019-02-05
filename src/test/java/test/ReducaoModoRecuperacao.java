package test;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

import Utils.EntityGenericUtil;
import Utils.RequestBodyGenerator;
import Utils.RequestGenerator;
import Utils.TiposStatus;
import Utils.UrlUtils;
import io.restassured.response.Response;
import validacao.validador;

public class ReducaoModoRecuperacao {

	RequestGenerator request = new RequestGenerator();

	public validador validador = new validador();

	@Test
	public void ReducaoModoRecuperacaoTeste() {

		try {
			Response response = request.genericRequestPOST(EntityGenericUtil.getToken(),
					RequestBodyGenerator.gerarMassaDados(), UrlUtils.getUrlReducaoRecuperacao(), TiposStatus.OK.getCodigo());
			assertTrue(validador.validarBodyRequest(response));
			validador.validarDadosBanco(response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void ReducaoModoRecuperacaoTestListaVazia() {

		try {
			Response response = request.genericRequestPOST(EntityGenericUtil.getToken(),
					RequestBodyGenerator.geradorDadosListaVazia(), UrlUtils.getUrlReducaoRecuperacao(), TiposStatus.OK.getCodigo());
			assertTrue(validador.validarBodyRequest(response));
			validador.validarDadosBanco(response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void ReducaoModoRecuperacaoTestListaString() {

		try {
			Response response = request.genericRequestPOST(EntityGenericUtil.getToken(),
					RequestBodyGenerator.geradorRequestMockadaListaString(), UrlUtils.getUrlReducaoRecuperacao(), TiposStatus.OK.getCodigo());
			assertTrue(validador.validarBodyRequest(response));
			validador.validarDadosBanco(response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void ReducaoModoRecuperacaoBodyVazio() {
		request.genericRequestPOST(EntityGenericUtil.getToken(), RequestBodyGenerator.gerarBodyVazio(),
				UrlUtils.getUrlReducaoRecuperacao(), TiposStatus.BadRequest.getCodigo());
	}

	@Test
	public void ReducaoModoRecuperacaoPorcentagemInvalida() {

		try {
			Response response = request.genericRequestPOST(EntityGenericUtil.getToken(),
					RequestBodyGenerator.geradorRequestMockadaPorcentagemInvalida(),
					UrlUtils.getUrlReducaoRecuperacao(), TiposStatus.OK.getCodigo());
			assertTrue(validador.validarBodyRequest(response));
			validador.validarDadosBanco(response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void ReducaoModoRecuperacaoPorcentagemNaoInformada() {

		try {
			Response response = request.genericRequestPOST(EntityGenericUtil.getToken(),
					RequestBodyGenerator.geradorRequestMockadaPorcentagemNaoInformada(),
					UrlUtils.getUrlReducaoRecuperacao(), TiposStatus.OK.getCodigo());
			assertTrue(validador.validarBodyRequest(response));
			validador.validarDadosBanco(response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}

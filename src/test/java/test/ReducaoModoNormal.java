package test;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

import Utils.EntityGenericUtil;
import Utils.RequestBodyGenerator;
import Utils.RequestGenerator;
import Utils.TiposStatus;
import Utils.UrlUtils;
import io.restassured.internal.http.Status;
import io.restassured.response.Response;
import validacao.validador;

public class ReducaoModoNormal extends UrlUtils {
	public RequestGenerator request = new RequestGenerator();
	public validador validador = new validador();

	@Test
	public void ReducaoModoNormalTeste() {

		try {
			Response response = request.genericRequestPOST(EntityGenericUtil.getToken(),
					RequestBodyGenerator.gerarMassaDados(), UrlUtils.getUrlReducaoNormal(),TiposStatus.OK.getCodigo());
			assertTrue(validador.validarBodyRequest(response));
			validador.validarDadosBanco(response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void ReducaoModoNormalTestListaVazia() {

		try {
			Response response = request.genericRequestPOST(EntityGenericUtil.getToken(),
					RequestBodyGenerator.geradorDadosListaVazia(), UrlUtils.getUrlReducaoNormal(), TiposStatus.OK.getCodigo());
			assertTrue(validador.validarBodyRequest(response));
			validador.validarDadosBanco(response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void ReducaoModoNormalTestListaString() {
		request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.geradorRequestMockadaListaString(), UrlUtils.getUrlReducaoNormal(), TiposStatus.BadRequest.getCodigo());
	}

	@Test
	public void ReducaoModoNormalBodyVazio() {
		request.genericRequestPOST(EntityGenericUtil.getToken(), RequestBodyGenerator.gerarBodyVazio(),
				UrlUtils.getUrlReducaoNormal(), TiposStatus.BadRequest.getCodigo());
	}

	@Test
	public void ReducaoModoNormalPorcentagemInvalida() {
		request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.geradorRequestMockadaPorcentagemInvalida(), UrlUtils.getUrlReducaoNormal(), TiposStatus.BadRequest.getCodigo());
	}

}

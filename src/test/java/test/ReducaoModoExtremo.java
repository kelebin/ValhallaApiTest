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

public class ReducaoModoExtremo {

	RequestGenerator request = new RequestGenerator();
	
	public validador validador = new validador();

	@Test
	public void ReducaoModoExtremoTeste() {
		
		try {
			Response response = 
			request.genericRequestPOST(EntityGenericUtil.getToken(), RequestBodyGenerator.gerarMassaDados(),
			UrlUtils.getUrlReducaoExtrema(), TiposStatus.OK.getCodigo());
			assertTrue(validador.validarBodyRequest(response));
			validador.validarDadosBanco(response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void ReducaoModoExtremoTestListaVazia() {
		request.genericRequestPOST(EntityGenericUtil.getToken(), RequestBodyGenerator.geradorDadosListaVazia(),
				UrlUtils.getUrlReducaoExtrema(), TiposStatus.InternalError.getCodigo());
	}

	@Test
	public void ReducaoModoExtremoTestListaString() {
		request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.geradorRequestMockadaListaString(), UrlUtils.getUrlReducaoExtrema(), TiposStatus.BadRequest.getCodigo());
	}

	@Test
	public void ReducaoModoExtremoBodyVazio() {
		request.genericRequestPOST(EntityGenericUtil.getToken(), RequestBodyGenerator.gerarBodyVazio(),
				UrlUtils.getUrlReducaoExtrema(), TiposStatus.BadRequest.getCodigo());
	}

	@Test
	public void ReducaoModoExtremoPorcentagemInvalida() {
		request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.geradorRequestMockadaPorcentagemInvalida(), UrlUtils.getUrlReducaoExtrema(), TiposStatus.BadRequest.getCodigo());
	}
	
	@Test
	public void ReducaoModoExtremoPorcentagemNaoInformada() {
		request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.geradorRequestMockadaPorcentagemNaoInformada(), UrlUtils.getUrlReducaoExtrema(), TiposStatus.BadRequest.getCodigo());
	}
}

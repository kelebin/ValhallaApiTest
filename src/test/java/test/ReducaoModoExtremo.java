package test;

import org.junit.Test;

import Utils.EntityGenericUtil;
import Utils.RequestBodyGenerator;
import Utils.RequestGenerator;
import Utils.UrlUtils;

public class ReducaoModoExtremo {

	RequestGenerator request = new RequestGenerator();

	@Test
	public void ReducaoModoExtremoTeste() {
		request.genericRequestPOST(EntityGenericUtil.getToken(), RequestBodyGenerator.gerarMassaDados(),
				UrlUtils.getUrlReducaoExtrema(), 200);
	}

	@Test
	public void ReducaoModoExtremoTestListaVazia() {
		request.genericRequestPOST(EntityGenericUtil.getToken(), RequestBodyGenerator.geradorDadosListaVazia(),
				UrlUtils.getUrlReducaoExtrema(), 500);
	}

	@Test
	public void ReducaoModoExtremoTestListaString() {
		request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.geradorRequestMockadaListaString(), UrlUtils.getUrlReducaoExtrema(), 400);
	}

	@Test
	public void ReducaoModoExtremoBodyVazio() {
		request.genericRequestPOST(EntityGenericUtil.getToken(), RequestBodyGenerator.gerarBodyVazio(),
				UrlUtils.getUrlReducaoExtrema(), 500);
	}

	@Test
	public void ReducaoModoExtremoPorcentagemInvalida() {
		request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.geradorRequestMockadaPorcentagemInvalida(), UrlUtils.getUrlReducaoExtrema(), 200);
	}
	
	@Test
	public void ReducaoModoExtremoPorcentagemNaoInformada() {
		request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.geradorRequestMockadaPorcentagemNaoInformada(), UrlUtils.getUrlReducaoExtrema(), 500);
	}
}

package test;

import org.junit.Test;

import Utils.EntityGenericUtil;
import Utils.RequestBodyGenerator;
import Utils.RequestGenerator;
import Utils.UrlUtils;

public class ReducaoModoRecuperacao {

	RequestGenerator request = new RequestGenerator();


	@Test
	public void ReducaoModoNormalTeste() {
		request.genericRequestPOST(EntityGenericUtil.getToken(), RequestBodyGenerator.geradorRequestMockada(),
				UrlUtils.getUrlReducaoRecuperacao(), 200);
	}

	@Test
	public void ReducaoModoNormalTestListaVazia() {
		request.genericRequestPOST(EntityGenericUtil.getToken(), RequestBodyGenerator.geradorRequestMockadaListaVazia(),
				UrlUtils.getUrlReducaoRecuperacao(), 200);
	}

	@Test
	public void ReducaoModoNormalTestListaString() {
		request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.geradorRequestMockadaListaString(), UrlUtils.getUrlReducaoRecuperacao(), 400);
	}

	@Test
	public void ReducaoModoNormalBodyVazio() {
		request.genericRequestPOST(EntityGenericUtil.getToken(), RequestBodyGenerator.gerarBodyVazio(),
				UrlUtils.getUrlReducaoRecuperacao(), 500);
	}

	@Test
	public void ReducaoModoNormalPorcentagemInvalida() {
		request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.geradorRequestMockadaPorcentagemInvalida(), UrlUtils.getUrlReducaoRecuperacao(), 200);
	}
	
	@Test
	public void ReducaoModoNormalPorcentagemNaoInformada() {
		request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.geradorRequestMockadaPorcentagemNaoInformada(), UrlUtils.getUrlReducaoRecuperacao(), 500);
	}
}

package test;

import org.junit.Test;

import Utils.EntityGenericUtil;
import Utils.RequestBodyGenerator;
import Utils.RequestGenerator;
import Utils.UrlUtils;

public class ReducaoModoRecuperacao {

	RequestGenerator request = new RequestGenerator();


	@Test
	public void ReducaoModoRecuperacaoTeste() {
		request.genericRequestPOST(EntityGenericUtil.getToken(), RequestBodyGenerator.geradorRequestMockada(),
				UrlUtils.getUrlReducaoRecuperacao(), 200);
	}

	@Test
	public void ReducaoModoRecuperacaoTestListaVazia() {
		request.genericRequestPOST(EntityGenericUtil.getToken(), RequestBodyGenerator.geradorRequestMockadaListaVazia(),
				UrlUtils.getUrlReducaoRecuperacao(), 200);
	}

	@Test
	public void ReducaoModoRecuperacaoTestListaString() {
		request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.geradorRequestMockadaListaString(), UrlUtils.getUrlReducaoRecuperacao(), 200);
	}

	@Test
	public void ReducaoModoRecuperacaoBodyVazio() {
		request.genericRequestPOST(EntityGenericUtil.getToken(), RequestBodyGenerator.gerarBodyVazio(),
				UrlUtils.getUrlReducaoRecuperacao(), 500);
	}

	@Test
	public void ReducaoModoRecuperacaoPorcentagemInvalida() {
		request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.geradorRequestMockadaPorcentagemInvalida(), UrlUtils.getUrlReducaoRecuperacao(), 200);
	}
	
	@Test
	public void ReducaoModoRecuperacaoPorcentagemNaoInformada() {
		request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.geradorRequestMockadaPorcentagemNaoInformada(), UrlUtils.getUrlReducaoRecuperacao(), 500);
	}
}

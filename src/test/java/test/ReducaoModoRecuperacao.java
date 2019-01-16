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
				UrlUtils.urlReducaoRecuperacao, 200);
	}

	@Test
	public void ReducaoModoNormalTestListaVazia() {
		request.genericRequestPOST(EntityGenericUtil.getToken(), RequestBodyGenerator.geradorRequestMockadaListaVazia(),
				UrlUtils.urlReducaoRecuperacao, 200);
	}

	@Test
	public void ReducaoModoNormalTestListaString() {
		request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.geradorRequestMockadaListaString(), UrlUtils.urlReducaoRecuperacao, 400);
	}

	@Test
	public void ReducaoModoNormalBodyVazio() {
		request.genericRequestPOST(EntityGenericUtil.getToken(), RequestBodyGenerator.gerarBodyVazio(),
				UrlUtils.urlReducaoRecuperacao, 500);
	}

	@Test
	public void ReducaoModoNormalPorcentagemInvalida() {
		request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.geradorRequestMockadaPorcentagemInvalida(), UrlUtils.urlReducaoRecuperacao, 200);
	}
}

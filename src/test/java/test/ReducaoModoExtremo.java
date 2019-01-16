package test;

import org.junit.Test;

import Utils.EntityGenericUtil;
import Utils.RequestBodyGenerator;
import Utils.RequestGenerator;
import Utils.UrlUtils;

public class ReducaoModoExtremo {

	RequestGenerator request = new RequestGenerator();

	@Test
	public void ReducaoModoNormalTeste() {
		request.genericRequestPOST(EntityGenericUtil.getToken(), RequestBodyGenerator.geradorRequestMockada(),
				UrlUtils.urlReducaoExtrema, 200);
	}

	@Test
	public void ReducaoModoNormalTestListaVazia() {
		request.genericRequestPOST(EntityGenericUtil.getToken(), RequestBodyGenerator.geradorRequestMockadaListaVazia(),
				UrlUtils.urlReducaoExtrema, 500);
	}

	@Test
	public void ReducaoModoNormalTestListaString() {
		request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.geradorRequestMockadaListaString(), UrlUtils.urlReducaoExtrema, 400);
	}

	@Test
	public void ReducaoModoNormalBodyVazio() {
		request.genericRequestPOST(EntityGenericUtil.getToken(), RequestBodyGenerator.gerarBodyVazio(),
				UrlUtils.urlReducaoExtrema, 500);
	}

	@Test
	public void ReducaoModoNormalPorcentagemInvalida() {
		request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.geradorRequestMockadaPorcentagemInvalida(), UrlUtils.urlReducaoExtrema, 200);
	}

}

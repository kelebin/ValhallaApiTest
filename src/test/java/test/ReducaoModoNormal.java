package test;

import org.junit.Test;

import Utils.EntityGenericUtil;
import Utils.RequestBodyGenerator;
import Utils.RequestGenerator;
import Utils.UrlUtils;

public class ReducaoModoNormal extends UrlUtils {
	RequestGenerator request = new RequestGenerator();

	@Test
	public void ReducaoModoNormalTeste() {
		request.genericRequestPOST(EntityGenericUtil.getToken(), RequestBodyGenerator.geradorRequestMockada(),
				UrlUtils.urlReducaoNormal, 200);
	}

	@Test
	public void ReducaoModoNormalTestListaVazia() {
		request.genericRequestPOST(EntityGenericUtil.getToken(), RequestBodyGenerator.geradorRequestMockadaListaVazia(),
				UrlUtils.urlReducaoNormal, 200);
	}

	@Test
	public void ReducaoModoNormalTestListaString() {
		request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.geradorRequestMockadaListaString(), UrlUtils.urlReducaoNormal, 400);
	}

	@Test
	public void ReducaoModoNormalBodyVazio() {
		request.genericRequestPOST(EntityGenericUtil.getToken(), RequestBodyGenerator.gerarBodyVazio(),
				UrlUtils.urlReducaoNormal, 500);
	}

	@Test
	public void ReducaoModoNormalPorcentagemInvalida() {
		request.genericRequestPOST(EntityGenericUtil.getToken(),
				RequestBodyGenerator.geradorRequestMockadaPorcentagemInvalida(), UrlUtils.urlReducaoNormal, 500);
	}
}

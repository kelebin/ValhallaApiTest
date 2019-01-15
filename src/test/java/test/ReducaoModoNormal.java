package test;

import org.junit.Test;

import Utils.RequestBodyGenerator;
import Utils.RequestGenerator;
import Utils.UrlUtils;

public class ReducaoModoNormal extends UrlUtils {
	RequestGenerator request = new RequestGenerator();

	@Test
	public void ReducaoModoNormalTeste() {
		request.genericRequestPOST(RequestBodyGenerator.token, RequestBodyGenerator.geradorRequestMockada(),
				UrlUtils.urlReducaoNormal, 200);
	}

	@Test
	public void ReducaoModoNormalTestListaVazia() {
		request.genericRequestPOST(RequestBodyGenerator.token, RequestBodyGenerator.geradorRequestMockadaListaVazia(),
				UrlUtils.urlReducaoNormal, 200);
	}

	@Test
	public void ReducaoModoNormalTestListaString() {
		request.genericRequestPOST(RequestBodyGenerator.token, RequestBodyGenerator.geradorRequestMockadaListaString(),
				UrlUtils.urlReducaoNormal, 400);
	}

}



 

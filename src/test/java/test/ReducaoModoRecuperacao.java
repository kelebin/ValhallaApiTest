package test;

import org.junit.Test;

import Utils.RequestBodyGenerator;
import Utils.RequestGenerator;
import Utils.UrlUtils;

public class ReducaoModoRecuperacao {

	RequestGenerator request = new RequestGenerator();
	
	@Test
	public void ReducaoModoRecuperacaoSucesso() {
		request.genericRequestPOST(RequestBodyGenerator.token, RequestBodyGenerator.geradorRequestMockada(), UrlUtils.urlReducaoRecuperacao, 200);
	}
}

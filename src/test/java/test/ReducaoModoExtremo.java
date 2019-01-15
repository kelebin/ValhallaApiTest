package test;

import org.junit.Test;

import Utils.RequestBodyGenerator;
import Utils.RequestGenerator;
import Utils.UrlUtils;

public class ReducaoModoExtremo {
 
	RequestGenerator request = new RequestGenerator();
	
	@Test
	public void ReducaoModoExtremoSucesso() {
		request.genericRequestPOST(RequestBodyGenerator.token,RequestBodyGenerator.geradorRequestMockada(), UrlUtils.urlReducaoExtrema, 200);
	}
	
	@Test
	public void ReducaoModoExtremoListaVazia() {
		request.genericRequestPOST(RequestBodyGenerator.token,RequestBodyGenerator.geradorRequestMockadaListaVazia(), UrlUtils.urlReducaoExtrema, 500);
	}
	
}

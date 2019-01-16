package Suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.ReducaoModoExtremo;
import test.ReducaoModoNormal;
import test.ReducaoModoRecuperacao;


@RunWith(Suite.class)
@SuiteClasses({
     ReducaoModoNormal.class,
     ReducaoModoExtremo.class,
     ReducaoModoRecuperacao.class
     })
public class SuiteClass {
	  
   
	

}

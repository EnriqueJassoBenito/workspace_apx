package com.bbva.sitd.lib.r001;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ThreadContext;
import com.bbva.sitd.dto.catalogo.EntretenimientoDTO;

import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.aop.framework.Advised;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/SITDR001-app.xml",
		"classpath:/META-INF/spring/SITDR001-app-test.xml",
		"classpath:/META-INF/spring/SITDR001-arc.xml",
		"classpath:/META-INF/spring/SITDR001-arc-test.xml" })
public class SITDR001Test {

	@Spy
	private Context context;

	@Resource(name = "sitdR001")
	private SITDR001 sitdR001;

	@Resource(name = "applicationConfigurationService")
	private ApplicationConfigurationService applicationConfigurationService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		context = new Context();
		ThreadContext.set(context);
		getObjectIntrospection();
	}
	
	private Object getObjectIntrospection() throws Exception{
		Object result = this.sitdR001;
		if(this.sitdR001 instanceof Advised){
			Advised advised = (Advised) this.sitdR001;
			result = advised.getTargetSource().getTarget();
		}
		return result;
	}
	
	@Test
	public void executeTest(){
		EntretenimientoDTO entretenimiento = new EntretenimientoDTO();
		sitdR001.execute(entretenimiento);
		Assert.assertEquals(0, context.getAdviceList().size());
	}

}

/**
 *  <b>日期：</b>Oct 24, 2013-2:53:49 PM<br/>
 *  <b>Copyright (c)</b> 2013 广州天健软件有限公司<br/>
 */
package cn.com.timekey.rmh.controller;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * <b>类名称：</b>ProjectIssuesControllerTest<br/>
 * <b>类描述：</b>ProjectIssuesController的测试类<br/>
 * <b>创建时间：</b>Oct 24, 2013 2:53:49 PM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class ProjectIssuesControllerTest {
	@Resource
	private WebApplicationContext wac;
	@Resource
	private ProjectIssuesController projectIssuesController;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(projectIssuesController)
				.build();
	}
	private final Log logger = LogFactory.getLog(getClass());

	@Test
	public void testGetUserWorkInfo() throws Exception {
		ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders
				.get("/ajax/project/work_info/3"));
		MvcResult mr = ra.andReturn();
		String result = mr.getResponse().getContentAsString();
		logger.info(result);
	}
}

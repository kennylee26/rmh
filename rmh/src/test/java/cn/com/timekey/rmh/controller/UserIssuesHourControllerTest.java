/**
 *  <b>日期：</b>Oct 21, 2013-10:16:10 AM<br/>
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
 * <b>类名称：</b>UserIssuesHourControllerTest<br/>
 * <b>类描述：</b>UserIssuesHourController的测试类<br/>
 * <b>创建时间：</b>Oct 21, 2013 10:16:10 AM<br/>
 * <b>备注：</b><br/>
 * 
 * @author kennylee <br />
 * @version 1.0.0<br/>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class UserIssuesHourControllerTest {

	@Resource
	private WebApplicationContext wac;
	@Resource
	private UserIssuesHourController userIssuesHourController;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(userIssuesHourController)
				.build();
	}

	private final Log logger = LogFactory.getLog(getClass());

	@Test
	public void testGetUserWorkInfo() throws Exception {
		ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders
				.get("/ajax/user/work_info/3")
				//.accept(MediaType.APPLICATION_JSON).param("page", "1")
				.param("type", "all"));
		MvcResult mr = ra.andReturn();
		String result = mr.getResponse().getContentAsString();
		logger.info(result);
	}
}

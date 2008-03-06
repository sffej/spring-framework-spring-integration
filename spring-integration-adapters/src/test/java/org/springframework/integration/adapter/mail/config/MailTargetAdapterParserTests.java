/*
 * Copyright 2002-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.adapter.mail.config;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.adapter.mail.MailTargetAdapter;
import org.springframework.integration.endpoint.DefaultMessageEndpoint;
import org.springframework.integration.handler.MessageHandler;

/**
 * @author Mark Fisher
 */
public class MailTargetAdapterParserTests {

	@Test
	public void testAdapterWithMailSenderReference() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"mailTargetAdapterParserTests.xml", this.getClass());
		DefaultMessageEndpoint endpoint = (DefaultMessageEndpoint) context.getBean("adapterWithMailSenderReference");
		MessageHandler handler = endpoint.getHandler();
		assertNotNull(handler);
		assertTrue(handler instanceof MailTargetAdapter);
	}

	@Test
	public void testAdapterWithHostProperty() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"mailTargetAdapterParserTests.xml", this.getClass());
		DefaultMessageEndpoint endpoint = (DefaultMessageEndpoint) context.getBean("adapterWithHostProperty");
		MessageHandler handler = endpoint.getHandler();
		assertNotNull(handler);
		assertTrue(handler instanceof MailTargetAdapter);
	}

}

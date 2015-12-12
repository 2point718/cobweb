/*
The MIT License (MIT)
Copyright (c) 2015 Renjith Mathew
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package com.github.e2point718;

import java.io.InputStreamReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.w3c.dom.Document;

import com.github.e2point718.dom.HTMLDOMImplementationImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import nu.validator.htmlparser.dom.HtmlDocumentBuilder;

/**
 * Unit test for simple App.
 */
public class CobwebTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public CobwebTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(CobwebTest.class);
	}

	public void testApp() throws Exception {

		HtmlDocumentBuilder hdb = new HtmlDocumentBuilder(new HTMLDOMImplementationImpl());
		Document document = hdb.parse(CobwebTest.class.getResourceAsStream("/test.html"));

		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.put("document", document);
		engine.eval(new InputStreamReader(Cobweb.class.getResourceAsStream("/coboot.js")));
		engine.eval(new InputStreamReader(CobwebTest.class.getResourceAsStream("/jquery-2.1.4.js")));

	}
}

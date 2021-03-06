package forer.dictionary;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import forer.dictionary.Dictionary;

public class DictionaryTest {

	@Test
	public void containsTest() throws IOException {
		Dictionary dic = new Dictionary();
		assertEquals(true, dic.contains("bis"));
		assertEquals(true, dic.contains("ar"));
		assertEquals(false, dic.contains("vit"));

	}

	@Test
	public void getDefinitionTest() throws IOException {
		Dictionary dic = new Dictionary();
		String BisDefinition = "{twice=adv} [adv]";
		assertEquals(BisDefinition, dic.getDefinition("bis"));
		String DoDefinition = "the first tone of the diatonic musical scale [n DOS] / to begin and carry through to completion [v DID or DIDST, DONE, DOING, present sing. 2d person DO, DOEST or DOST, 3d person DOES, DOETH or DOTH]";
		assertEquals(DoDefinition, dic.getDefinition("do"));
		String OptionDefinition = "to grant an option (a right to buy or sell something at a specified price within a specified time) on [v -ED, -ING, -S]";
		assertEquals(OptionDefinition, dic.getDefinition("option"));

		assertEquals(null, dic.getDefinition("belvedere"));

	}

}

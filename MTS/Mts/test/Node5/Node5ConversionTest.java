package Mts.test.Node5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Mts.impl.Node5Impl;

/**
 * Node5 ('convert' method) test cases
 * @author costellode
 */
public class Node5ConversionTest {

	@Test
    public void test1() {
		Node5Impl test = new Node5Impl();
		assertEquals((test.conversion(2, "EUR", "USD")), 2.26, 0);
    }

	@Test
    public void test2() {
		Node5Impl test = new Node5Impl();
		assertEquals((test.conversion(0, "EUR", "USD")), 0, 0);
    }

	@Test
    public void test3() {
		Node5Impl test = new Node5Impl();
		assertEquals((test.conversion(-2, "EUR", "USD")), -1, 0);
    }

	@Test
    public void test4() {
		Node5Impl test = new Node5Impl();
		assertEquals((test.conversion(100.02, "EUR", "USD")), 113.02, 0);
    }

	@Test
    public void test5() {
		Node5Impl test = new Node5Impl();
		assertEquals((test.conversion(123.200, "EUR", "USD")), 139.22, 0);
    }

}

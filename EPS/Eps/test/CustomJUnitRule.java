/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eps.test;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 *
 * @author Macbook
 */
public class CustomJUnitRule extends TestWatcher {
	

	@Override
	protected void failed(Throwable e, Description description) {
		System.out.println("FAIL " + description);
	}

	@Override
	protected void succeeded(Description description) {
		System.out.println("PASS " + description);
	}

	
}

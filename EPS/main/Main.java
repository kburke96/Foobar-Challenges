package main;

import org.junit.runner.JUnitCore;

import Eps.test.Node1Test;
import Eps.test.Node2Test;
import Eps.test.Node3Test;
import Eps.test.Node4Test;
import Eps.test.Node5Test;
import Eps.test.Node6Test;

public class Main {
	
	public static void main(String[] args) {

		JUnitCore core = new JUnitCore();
		
		int testNo = Integer.parseInt(args[0]);
		
		switch(testNo) {
			case 1: core.run(Node1Test.class);
					break;
			case 2: core.run(Node2Test.class);
					break;
			case 3: core.run(Node3Test.class);
					break;
			case 4: core.run(Node4Test.class);
					break;
			case 5: core.run(Node5Test.class);
					break;
			case 6: core.run(Node6Test.class);
					break;
		}
	}
}

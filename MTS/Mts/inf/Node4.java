package Mts.inf;

import java.util.ArrayList;

import Mts.impl.SwiftMessage;

public interface Node4  extends FooBarInfo{

	/**
	 * Basic routing - just find a route from A to B
	 * @param swiftMessage
	 * @return
	 */
    public ArrayList<String> routing(SwiftMessage swiftMessage);

}

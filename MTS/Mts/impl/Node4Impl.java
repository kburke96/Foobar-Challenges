package Mts.impl;

import java.util.ArrayList;

import Mts.Constants.Banks;
import Mts.Exceptions.TeamNameNotDefinedException;
import Mts.impl.banks.AMOCO;
import Mts.impl.banks.Bank;
import Mts.impl.banks.COCC;
import Mts.impl.banks.DBS;
import Mts.inf.Node4;

public class Node4Impl implements Node4{
    
    public static void main(String[] args)
    {
        
        Bank.init(); //getting to the init was very time consuming
        Node4Impl node4 = new Node4Impl();
        
        Bank goal = Bank.dbs;
        
        //Route AMOCO to DBS
        ArrayList<Bank> temps = Bank.amoco.getTrustedBanks();
        ArrayList<ArrayList<Bank>> bankPaths = new ArrayList<ArrayList<Bank>>();
        
        for(Bank bank : temps)
        {
            //bankPaths.add(node4.getBankPath(bank, dbs));
        	System.out.println(node4.search(bank,goal).getBankName());
        }
    }
    
    
    public Bank search(Bank source, Bank goal)
    {
        if(source.getTrustedBanks().contains(goal))
        {
        	System.out.println(source.getBankName());
            return source;
        }
        else
        {
        	Bank tempBank = null;
        	for(Bank b : source.getTrustedBanks())
        	{
        		tempBank = search(b, goal);
        	}
            return tempBank;
        }
    }
    
    public ArrayList<Bank> getBankPath(Bank source, Bank goal)
    {
        return null;
    }


	@Override
	public String getTeamName() throws TeamNameNotDefinedException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<String> routing(SwiftMessage swiftMessage) {
		// TODO Auto-generated method stub
		return null;
	}

}
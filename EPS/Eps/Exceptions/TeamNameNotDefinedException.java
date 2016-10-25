package Eps.Exceptions;

import Eps.Constants.Constants;

public class TeamNameNotDefinedException extends Exception {

    public TeamNameNotDefinedException()
    {
        super("Team name not defined\nPlease ensure you have created a team name variable in " + Constants.FOOBARINFO.value());
       // System.out.println(Constants.FOOBARINFO.value());
    }

}

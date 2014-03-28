package bestroomie.controller;

import java.awt.event.ActionListener;

public abstract class BRAbstractController implements ActionListener{
	public static final String ERROR_VALIDATION_FAILURE = "The user name and password dont match";
	public static final String ERROR_REG_FAILURE_USER_EXISTS = "The input email has been existed in the system";
	public static final String ERROR_INVALID_EMAIL = "The input email is invalid";
	
	
}

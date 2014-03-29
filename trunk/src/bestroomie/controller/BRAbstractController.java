package bestroomie.controller;

import java.awt.event.ActionListener;

import bestroomie.entities.BRAbstractEntity;

public abstract class BRAbstractController implements ActionListener{
	public static final String ERROR_VALIDATION_FAILURE = "The user name and password dont match";
	public static final String ERROR_REG_FAILURE_USER_EXISTS = "The input email has been existed in the system";
	public static final String ERROR_INVALID_EMAIL = "The input email is invalid";
	
	//When business on this controller/view is finished, specify which controller/view to go
	protected abstract void goToController(BRAbstractEntity e, BRAbstractController b);
	
}
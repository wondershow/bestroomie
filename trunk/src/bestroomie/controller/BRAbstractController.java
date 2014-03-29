package bestroomie.controller;

import java.awt.event.ActionListener;

import bestroomie.entities.BRAbstractEntity;

public abstract class BRAbstractController implements ActionListener{
	
	//When business on this controller/view is finished, specify which controller/view to go
	protected abstract void goToController(BRAbstractEntity e, BRAbstractController b);
	
}
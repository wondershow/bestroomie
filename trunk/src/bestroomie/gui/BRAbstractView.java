package bestroomie.gui;

import javax.swing.JFrame;
import bestroomie.controller.BRAbstractController;

public abstract class BRAbstractView extends JFrame{
	
	public abstract void registerListener(BRAbstractController a);
}

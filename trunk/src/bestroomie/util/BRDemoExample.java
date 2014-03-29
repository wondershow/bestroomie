package bestroomie.util;

import bestroomie.controller.BRLoginController;
import bestroomie.entities.BRUser;
import bestroomie.gui.BRLoginView;

public class BRDemoExample {

	public static void main(String args[]) {
		BRUser m = new BRUser("c","d");
		BRLoginView v = new BRLoginView();
		BRLoginController c = new BRLoginController(m,v);
		v.registerListener(c);
		v.setVisible(true);
	}
}

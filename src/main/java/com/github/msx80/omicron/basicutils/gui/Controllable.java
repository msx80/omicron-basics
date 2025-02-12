package com.github.msx80.omicron.basicutils.gui;

import com.github.msx80.omicron.api.Controller;

/**
 * A widget that can be controlled using an omicron Controller (keyboard or joystick).
 * The widget manager expect at most one Controllable widget to be present at any time.
 */
public interface Controllable {
	void control(Controller c);
}

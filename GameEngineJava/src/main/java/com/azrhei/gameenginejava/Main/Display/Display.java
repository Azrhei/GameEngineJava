package com.azrhei.gameenginejava.Main.Display;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL45.*;

/**
 *
 * @author Azrhei
 */
public class Display {

    private long _window;
    private long _title;
    private int _width;
    private int _height;
    private long _monitor;
    private int _isVisible;

    public long getWindow() {
        return _window;
    }

    public void setWindow(long window) {
        this._window = window;
    }

    public long getTitle() {
        return _title;
    }

    public void setTitle(long _title) {
        this._title = _title;
    }

    public long getMonitor() {
        return _monitor;
    }

    public void setMonitor(long _monitor) {
        this._monitor = _monitor;
    }

    public Display() {
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        glfwWindowHint(GLFW_VISIBLE, GLFW_TRUE);

        this._window = glfwCreateWindow(200, 200, "Welcome to GameEngine.", 0, 0);

        glfwSetKeyCallback(
                _window,
                (window, key, scancode, action, mods) -> {
                    if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) {
                        glfwSetWindowShouldClose(window, true);
                    }
                }
        );

        glfwSetWindowPos(
                _window,
                0,
                0
        );

        glfwMakeContextCurrent(_window);

    }

    public void isVisible(int flag) {
        _isVisible = flag;
        glfwShowWindow(_window);

    }

}

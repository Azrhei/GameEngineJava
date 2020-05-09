package com.azrhei.gameenginejava.Main;

import com.azrhei.gameenginejava.Main.Display.Display;

import java.awt.SystemColor;
import static java.awt.SystemColor.window;
import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.glfw.GLFWErrorCallback;
import static org.lwjgl.opengl.GL.*;
import static org.lwjgl.opengl.GL45.*;

/**
 *
 * @author Azrhei
 */
public class Main extends Thread {

    private Display display;

    public Main() {
        this.init();
    }

    private void init() {
        GLFWErrorCallback.createPrint(System.err).set();
    }

    @Override
    public void run() {

        if (!glfwInit()) {
            throw new IllegalStateException("GLFW Initialization failed.");
        }
        this.display = new Display();

        loop();
    }

    private void loop() {
        createCapabilities();

        glClearColor(1.0f, 0.0f, 0.0f, 0.0f);

        while (!glfwWindowShouldClose(display.getWindow())) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

            glfwSwapBuffers(display.getWindow()); // swap the color buffers

            glfwPollEvents();
        }
    }

    public static void main(String[] args) {
        (new Main()).start();
    }

}

package com.azrhei.gameenginejava.Main.Shaders;

import static org.lwjgl.opengl.GL45.*;

/**
 * You can either use the lwjgl.opengl.glxx shader constants, or use enum type.
 *
 * @author Azrhei
 */
public enum ShaderType {
    NO_SHADER(0),
    VERTEX_SHADER(GL_VERTEX_SHADER),
    FRAGMENT_SHADER(GL_FRAGMENT_SHADER),
    COMPUTER_SHADER(GL_COMPUTE_SHADER),
    GEOMETRY_SHADER(GL_GEOMETRY_SHADER);

    private int type;

    private ShaderType(int type) {
        this.type = type;
    }

    public int getShaderType() {
        return this.type;
    }
}

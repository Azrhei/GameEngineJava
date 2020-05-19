package com.azrhei.gameenginejava.Main.Shaders;

/**
 * Thrown when failed to load shader source and bin.
 * Leaves shader in undefined state. Assumes a reset to shader
 * @author Azrhei
 */
public class ShaderScriptFailedToLoad extends Exception {

    public ShaderScriptFailedToLoad(String _pathSource, String _pathBin) {
    }
    
}

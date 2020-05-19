package com.azrhei.gameenginejava.Main.Shaders;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Azrhei
 */
public interface IShaderScript {

    int getShaderId();
    int getShaderType();
    
    void cleanUp();
    
    void readSourceData(String path) throws IOException;

    void readBinData(String path)throws IOException;

    void compile();

    void logErrors();

}

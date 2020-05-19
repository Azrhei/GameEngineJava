package com.azrhei.gameenginejava.Main.Shaders;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import static org.lwjgl.opengl.GL45.*;
import java.nio.file.*;
import org.lwjgl.opengl.GL45;

/**
 *
 * @author Azrhei
 */
public class ShaderScript implements IShaderScript {

    private boolean isCompiled = false;
    private boolean isLoaded = false;
    private boolean isSaved = false;

    private String _shaderName;
    private String _path_to_shader_source;
    private String _path_to_shader_bin;
    private byte[] binData;
    private CharBuffer sourceData;
    private int shaderId, shaderType;

    public boolean isLoaded() {
        return isLoaded;
    }

    public boolean isCompiled() {
        return isCompiled;
    }

    public boolean isSaved() {
        return isSaved;
    }

    public void setSourceData(CharBuffer data) {
        this.sourceData = data;
        glShaderSource(shaderId, data);
        isLoaded = true;
    }

    private void setBinData(byte[] data) {
        binData = data;
        isLoaded = true;
        int[] shaders = {shaderId};

        GL45.glShaderBinary(shaders, 0, ByteBuffer.wrap(binData));
        isCompiled = true;
    }

    @Override
    public int getShaderId() {
        return shaderId;
    }

    @Override
    public int getShaderType() {
        return shaderType;
    }

    public void saveSourceData(String path) {

    }

    public void saveBinData(String path) {

    }

    @Override
    public final void readBinData(String path) throws IOException {
        setBinData(Files.readAllBytes(Paths.get(path)));
        isLoaded = true;
    }

    @Override
    public final void readSourceData(String path) throws IOException {
        this.setSourceData(CharBuffer.wrap(Files.readAllLines(Paths.get(path)).get(0).toCharArray()));
        isLoaded = true;
    }

    @Override
    public void compile() {
        if (!isCompiled) {
            glCompileShader(shaderId);
            isCompiled = true;
        }
    }

    public void delete() {
        glDeleteShader(this.shaderId);
    }

    public void load() throws ShaderScriptFailedToLoad, IOException {
        if (this._path_to_shader_source.isEmpty() && this._path_to_shader_bin.isEmpty()) {

        } else {
            loadSource(_path_to_shader_source, _path_to_shader_bin);
        }
    }

    public void loadSource(String _pathSource, String _pathBin) throws ShaderScriptFailedToLoad, IOException {
        Path _path_source = FileSystems.getDefault().getPath("", _pathSource);
        Path _path_bin = FileSystems.getDefault().getPath("", _pathBin);

        var _source_exists = Files.exists(_path_source);
        var _bin_exists = Files.exists(_path_bin);

        if (!_source_exists && !_bin_exists) {
            throw new ShaderScriptFailedToLoad(_pathSource, _pathBin);
        }

        if (_source_exists) {
            readSourceData(_pathSource);
        }

        if (_bin_exists) {
            readBinData(_pathBin);
        }
    }

    public void setName(String _name) {
        _shaderName = _name;
//        getHashName();
    }

    public String getName() {
        return _shaderName;
    }

    ShaderScript(int type) {
        super();
        shaderType = type;
        shaderId = glCreateShader(type);
    }

    ShaderScript(ShaderType type) {
        super();
        shaderType = type.getShaderType();
        shaderId = glCreateShader(shaderType);
    }

    ShaderScript(String path, int type) throws IOException {
        super();
        shaderType = type;
        shaderId = glCreateShader(type);
        readSourceData(path);
    }

    ShaderScript(String path, ShaderType type) throws IOException {
        super();
        shaderType = type.getShaderType();
        shaderId = glCreateShader(shaderType);
        readSourceData(path);
    }

    @Override
    public void cleanUp() {
        glDeleteShader(shaderId);
    }

    @Override
    public void logErrors() {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

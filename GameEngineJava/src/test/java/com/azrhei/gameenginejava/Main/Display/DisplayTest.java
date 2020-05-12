/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azrhei.gameenginejava.Main.Display;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joml.*;

import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.Assume.*;
import static org.lwjgl.glfw.GLFW.*;

/**
 *
 * @author Azrhei
 */

public class DisplayTest {
    
    private Display display;
    private String default_title = "Welcome to GameEngine.";

    private long window;
    private long monitor;
    private String title;
    private Vector2i position;
    private Vector2i dimension;
    
    public DisplayTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        glfwInit();
    }
    
    @AfterClass
    public static void tearDownClass() {
        glfwTerminate();
    }
    
    @Before
    public void setUp() {
        if(display == null)
        {
            display = new Display();
            
//            Field x = null;
//            try 
//            {
//                x = display.getClass().getDeclaredField("_window");
//                x.setAccessible(true);
//                this.window = x.getLong(x);
//                
//                x = display.getClass().getDeclaredField("_title");
//                x.setAccessible(true);
//                this.title = ((String) x.get(x));
//                
//                x = display.getClass().getDeclaredField("_monitor");
//                x.setAccessible(true);
//                this.monitor = (int) x.get(x);
//            } 
//            catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException ex)
//            {
//                Logger.getLogger(DisplayTest.class.getName()).log(Level.SEVERE, null, ex);
//                fail();
//            } 
             
        }
        
    }
    
    @After
    public void tearDown() {

    }

    /**
     * Test of getWindow method, of class Display.
     */
    @Test
    public void testGetWindow() {
        System.err.println("getWindow");
        assertNotNull(display.getWindow());
    }

    /**
     * Test of setWindow method, of class Display.
     */
    @Test
    public void testSetWindow() {
        System.out.println("setWindow");

        var newWindow = glfwCreateWindow(200, 200, "New Title", 0, 0);
        assumeNotNull(newWindow);

        display.setWindow(newWindow);
        assertEquals(newWindow, display.getWindow());
    }

    /**
     * Test of getTitle method, of class Display.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        
        String current_title = display.getTitle();
        assertArrayEquals(current_title.toCharArray(), default_title.toCharArray());
    }

    /**
     * Test of setTitle method, of class Display.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        
        var newTitle = "New Title";
        display.setTitle(newTitle);
        assertArrayEquals(display.getTitle().toCharArray(), newTitle.toCharArray());
    }

    /**
     * Test of getMonitor method, of class Display.
     */
    @Test
    public void testGetMonitor() 
    {
        System.out.println("getMonitor");
        var m = display.getMonitor();
        System.out.println(m);

    }

    /**
     * Test of setMonitor method, of class Display.
     */
    @Test
    public void testSetMonitor() {

    }

    /**
     * Test of isVisible method, of class Display.
     */
    @Test
    public void testIsVisible() {
    }
    
}

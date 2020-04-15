package org.lba.sample.file.txt;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.junit.Test;

public class FileTxtJUnitExample {

    @Test
    public void testReadFileWithClassLoader(){
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("lorem_ipsum.txt").getFile());
        assertTrue(file.exists());
 
    }
    
    @Test
    public void testReadFileWithClassLoader2() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("data01/lorem_ipsum_data01.txt").getFile());
        assertTrue(file.exists());
 
    }
    
    @Test
    public void testReadFileWithResource() {
        URL url = this.getClass().getResource("/lorem_ipsum.txt");
        File file = new File(url.getFile());
        assertTrue(file.exists());
    }
    
    @Test
    public void testReadFileWithResource2() throws IOException{
        InputStream is = this.getClass().getResourceAsStream("/data01/lorem_ipsum_data01.txt");
        assertNotNull(is);
    }
    
    @Test
    public void readFileRelativePath() {
        File file = new File("src/test/resources/lorem_ipsum.txt");
        assertTrue(file.exists());
    }
    
    @Test
    public void testReadAsStream() throws IOException{
        InputStream is = this.getClass().getResourceAsStream("/lorem_ipsum.txt");
        assertNotNull(is);
    }
    
    @Test
    public void testReadAsStream2() throws IOException{
        InputStream is = this.getClass().getResourceAsStream("/data01/lorem_ipsum_data01.txt");
        assertNotNull(is);
    }
}

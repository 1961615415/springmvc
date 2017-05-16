package test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class DomainMybatisGenerator {
	
    @Test
    public void testGenerateMybatis() throws Exception {
/*    	
    	  
        try {  
            System.out.println("start generator ...");  
            List<String> warnings = new ArrayList<String>();  
            boolean overwrite = true;  
            File configFile = new File(DomainMybatisGenerator.class.getResource("/orm-generator.xml").getFile()); 
            ConfigurationParser cp = new ConfigurationParser(warnings);  
            Configuration config = cp.parseConfiguration(configFile);  
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);  
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);  
            myBatisGenerator.generate(null);  
            System.out.println("end generator!");  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (XMLParserException e) {  
            e.printStackTrace();  
        } catch (InvalidConfigurationException e) {  
            e.printStackTrace();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    }  */
 
        List<String> warnings = new ArrayList<String>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        File configFile = new File(DomainMybatisGenerator.class.getResource("orm-generator.xml").getPath()); 
        Configuration config = cp.parseConfiguration(configFile);
            
        DefaultShellCallback shellCallback = new DefaultShellCallback(true);

        
        boolean gotException = false;
        try {
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
            myBatisGenerator.generate(null);
        } catch (InvalidConfigurationException e) {
            assertEquals(1, e.getErrors().size());
            gotException = true;
        }
        
        
     

        if (!gotException) {
//            fail("Should throw InvalidConfigurationException");
        	System.out.println("success!");
        }
    }
	
}

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;


public class MyPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    public Properties getAllProperties() throws IOException {
        return super.mergeProperties();
    }
    
   void tttt(){
	   try {
		Properties pp=this.getAllProperties();
	} catch (IOException e) {		
		e.printStackTrace();
	}
	  
   }
}

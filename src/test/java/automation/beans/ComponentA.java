package automation.beans;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("A")
public class ComponentA implements Test{

	Logger LOG = Logger.getLogger(ComponentA.class);
	
	@Override
	public void componentContent() {
		LOG.info("Component A");
	}	
}

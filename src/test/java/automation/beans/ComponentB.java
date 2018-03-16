package automation.beans;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("B")
public class ComponentB implements Test{

	Logger LOG = Logger.getLogger(ComponentB.class);
	
	@Override
	public void componentContent() {
		LOG.info("Component B");
	}	
}

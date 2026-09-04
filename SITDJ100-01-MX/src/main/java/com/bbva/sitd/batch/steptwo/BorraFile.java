package com.bbva.sitd.batch.steptwo;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.core.io.Resource;

public class BorraFile implements Tasklet {
	private Resource resource;
    
	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public BorraFile() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
		// TODO Auto-generated method stub
		 String archivo = resource.getFile().toString();
		 Path path = Paths.get(archivo);
		 Files.delete(path);
		 
		return RepeatStatus.FINISHED;
	}

}

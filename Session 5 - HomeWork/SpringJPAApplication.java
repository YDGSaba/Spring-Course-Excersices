package ir.freeland.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ir.freeland.springboot.persistence.base.JpaBaseInRun;
import ir.freeland.springboot.persistence.converter.ConverterRun;
import ir.freeland.springboot.persistence.lifecycle.LifecycleInRun;
import ir.freeland.springboot.persistence.repo.RepositoryRun;
import ir.freeland.springboot.persistence.service.ItemService;
import ir.freeland.springboot.relation.joincolumn.JoinColoumnRun;
import ir.freeland.springboot.relation.manytomany.ManyToManyRun;
import ir.freeland.springboot.relation.onetoone.foreignkeybased.ForeignKeyBasedRun;
//import ir.freeland.springboot.relation.onetoone.jointable.JointableRun;
import ir.freeland.springboot.relation.onetoone.jointable.JointableRun1;



@SpringBootApplication
@EnableJpaRepositories("ir.freeland.springboot.persistence.repo")
@EntityScan(basePackages =  {"ir.freeland.springboot.persistence.model",
							 "ir.freeland.springboot.relation",
							 "ir.freeland.springboot.persistence.converter"})
public class SpringJPAApplication {


	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringJPAApplication.class, args);
		
//		JpaBaseInRun JpaBaseInRun = context.getBean( JpaBaseInRun.class);
//		JpaBaseInRun.sampleRun();
		
		
		//with Hibernate
		// Execute JointableRun1 methods
//        JointableRun1 jointableRun = context.getBean(JointableRun1.class);
//        jointableRun.saveItemAndCorruptedItem(); // You can also call CRUD methods like find, update, or delete here.
		
        // Example to find an item by ID
//        jointableRun.findItem(1L); // Replace with actual ID

        
        //with Repository
        RepositoryRun repositoryRun = context.getBean(RepositoryRun.class);
        repositoryRun.sampleRun();
        
        
//		LifecycleInAction lifeCycle = context.getBean( LifecycleInAction.class);
//		lifeCycle.managedEntity();
//
		

		JoinColoumnRun JoinColoumnRun = context.getBean( JoinColoumnRun.class);
		JoinColoumnRun.sampleRun();
		
		ConverterRun ConverterRun = context.getBean( ConverterRun.class);
		ConverterRun.sampleRun();
		
		
//		ForeignKeyBasedRun foreignKeyBased = context.getBean( ForeignKeyBasedRun.class);
//		foreignKeyBased.sampleRun();
//		
//		JointableRun jointable = context.getBean( JointableRun.class);
//		jointable.sampleRun();
//		
//
//		ManyToManyRun ManyToManyRun = context.getBean( ManyToManyRun.class);
//		ManyToManyRun.sampleRun();
		
//		RepositoryRun repositoryRun = context.getBean( RepositoryRun.class);
//		repositoryRun.sampleRun();
	}

}

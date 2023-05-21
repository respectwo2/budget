package multicapmpus.kb3.kb3project;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import multicapmpus.kb3.kb3project.entity.Bgroup;
import multicapmpus.kb3.kb3project.entity.Bgroupmission;
import multicapmpus.kb3.kb3project.mapper.BgroupMapper;
import multicapmpus.kb3.kb3project.mapper.BgroupmissionMapper;

import multicapmpus.kb3.kb3project.service.BgroupService;
import multicapmpus.kb3.kb3project.service.BgroupmissionService;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBootApplication
public class Kb3projectApplication {
	
	private BgroupService bgroupService;
	private BgroupmissionService bgroupmissionservice;

	@Autowired
	public Kb3projectApplication(BgroupService bgroupService, 
								 BgroupmissionService bgroupmissionservice) {
		this.bgroupService = bgroupService;
		this.bgroupmissionservice = bgroupmissionservice;
	}
	public static void main(String[] args) {
	    ConfigurableApplicationContext context = SpringApplication.run(Kb3projectApplication.class, args);
	    Kb3projectApplication application = context.getBean(Kb3projectApplication.class);
	    
//	    application.execute();
	}
	
//	private void execute() {
//		insert();
//	}

//	private void insert() {
//		Bgroupmission bgm = new Bgroupmission();
//		bgm.setBgm_goal(300000);
//		bgm.setBgm_content("술값줄이기프로젝트");
//		bgm.setBgm_end("2023/05/30");
//		bgm.setBgm_start("2023/05/17");
//		bgm.setBgm_name("제발적당히좀써");
//		bgroupmissionservice.saveBgroupmission(bgm);
//		
//	}
}

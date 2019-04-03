package com.iba.courses.rest;


import com.iba.courses.domain.Student;
import com.iba.courses.repository.StudentRepository;
import com.iba.courses.service.DB2Connect;
import com.iba.courses.service.FileTransferProtocol;
import com.iba.courses.service.IMSConnect;
import com.iba.courses.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@RestController
@RequestMapping("api/student")
public class StudentApi {

    @Autowired
    IMSConnect ImsConnect;

    @Autowired
    DB2Connect DB2Connect;

    @Autowired
    FileTransferProtocol fileTransferProtocol;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllStudents")
    private List<Student> getAllStudents(){
        System.out.println("REST");
        return studentService.getAllStudents();
    }

    @GetMapping("/greeting/{myVariable}")
    private String greeting(@PathVariable String myVariable){
        System.out.println("in our first rest");
        return "Hello" + myVariable;
    }

    @PostMapping("/execute")
    private String postMethod(@RequestBody String s) throws Exception{
        ImsConnect = new IMSConnect();
        System.out.println(s);
        ImsConnect.init();
        ImsConnect.connect();
        System.out.println(ImsConnect.execute("/DIS TRAN ADDINV"));
        System.out.println("success");
        return ImsConnect.execute("/DIS TRAN ADDINV");
    }

    @PostMapping("/db2")
    private String db2execute(@RequestBody String s) throws Exception{
        DB2Connect = new DB2Connect();
       // System.out.println(s);
        DB2Connect.connect();
       // DB2Connect.execute("-DIS DDS");
      //  System.out.println("success");
        return DB2Connect.execute("-DIS DDS");
    }

    @PostMapping("/ftp")
    private void ftp(@RequestBody String s) throws Exception{
        fileTransferProtocol = new FileTransferProtocol();
        fileTransferProtocol.submit();
    }

    @PostMapping("/simplePost/{id}")
    private int postMethod(@RequestBody String s, @PathVariable int id){
        System.out.println(s);
        return id;
    }

    @PostMapping("/add")
    private void saveStudent(@RequestBody Student student){
        System.out.println(student);
        studentRepository.save(student);
    }

}

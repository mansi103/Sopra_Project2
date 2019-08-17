package com.sopra.steria.sopraproject.controllers;

import com.sopra.steria.sopraproject.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/in/saveUser")
public class UploadController {
    @Autowired
    FileService fileServices;


//	  @GetMapping("/upload") public String index() {
//		  return "multipartfile/uploadform";
//	  }

    @PostMapping("/upload")
    public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file, Model model) {
        try {
            System.out.println("hello");
            fileServices.store(file);
            model.addAttribute("message", "File uploaded successfully!");
            System.out.println("hello");
        } catch (Exception e) {
            model.addAttribute("message", "Fail! -> uploaded filename: " + file.getOriginalFilename());
        }
        return "redirect:/customer/list";
    }
}

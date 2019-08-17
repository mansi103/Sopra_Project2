package com.sopra.steria.sopraproject.controllers;

import com.sopra.steria.sopraproject.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DownloadController {
    @Autowired
    FileService fileServices;

    /*
     * Download Files
     */
    @GetMapping("/file")
    public void downloadFile(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=customers.csv");

        fileServices.loadFile(response.getWriter());
    }
}

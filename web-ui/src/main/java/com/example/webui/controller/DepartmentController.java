package com.example.webui.controller;

import com.example.webui.dto.DepartmentList;
import com.example.webui.dto.DepartmentRecord;
import com.example.webui.util.ExternalApi;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/ui")

public class DepartmentController {


    private RestTemplate restTemplate = new RestTemplate();


    @GetMapping("/departments")
    public String getDepartmentList(Model model) {
        try{
            ResponseEntity<DepartmentList> response = restTemplate.getForEntity(ExternalApi.DEPARTMENTS_URL, DepartmentList.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                model.addAttribute("departments", response.getBody().getDepartments());
                return "index";
            }else{
                return "redirect:/ui/home";
            }
        }catch (Exception e) {
            e.printStackTrace();
            return "redirect:/ui/home";
        }

    }
}

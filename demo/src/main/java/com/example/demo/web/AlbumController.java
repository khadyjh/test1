package com.example.demo.web;

import com.example.demo.Repositries.AlbumRepository;

import com.example.demo.domain.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;



@Controller
public class AlbumController {


    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/Albums")
    public String Add(Model model){
//        model.addAttribute("albums",albumRepository.findAll());
        return "home";
    }
    @GetMapping("/newAlbum")
    public String render(Model model){
        model.addAttribute("albums",albumRepository.findAll());
        return "albums";
    }

    @PostMapping("/addAlbum")
    public RedirectView createNewAlbum(@ModelAttribute Album album){
        albumRepository.save(album);
        return new RedirectView("newAlbum");
    }


}
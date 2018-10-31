package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class MainController {


    @Autowired
    DirectorRepository directorRepository;


    @RequestMapping("/")
    public String index(Model model){


        Director director = new Director();

        director.setName("Stephen Bullock");
        director.setGenre("Sci Fi");

        Movie movie =new Movie();
        movie.setTitle("Star wars");
        movie.setYear(2017);
        movie.setDescription("about stars");

        //add the movie to an empty list

        Set<Movie> movies = new HashSet<>();

        movies.add(movie);

        movie =new Movie();
        movie.setTitle("DeathStar Ewoks");
        movie.setYear(2017);
        movie.setDescription("about ewoks");
        movies.add(movie);

        //add the list of movies to the directory's movie list
        director.setMovies(movies);

        //save the director to the database

        directorRepository.save(director);

        //grab all the directors from the database and send them to the template

        model.addAttribute("directors", directorRepository.findAll());
        return "index";




    }

}

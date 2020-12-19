package fr.massi.wipw.controllers;


import fr.massi.wipw.models.Admin;
import fr.massi.wipw.models.AdminConnexion;
import fr.massi.wipw.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/connexion")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping
    public List<Admin> getAdmins(){
        return adminRepository.findAll();
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AdminConnexion connexion(@RequestBody final Admin admin){
        Admin adminBdd = adminRepository.findByEmail(admin.getEmail());
        AdminConnexion adminConnexion = new AdminConnexion();

        if(adminBdd != null){
            if(admin.getPassword().equals(adminBdd.getPassword())){
                adminConnexion.setStatus(true);
                adminConnexion.setAdmin(adminBdd);
            }else{
                adminConnexion.setStatus(false);
                adminConnexion.setAdmin(admin);
            }
        }else{
            adminConnexion.setStatus(false);
            adminConnexion.setAdmin(admin);
        }


        return adminConnexion;
    }
}

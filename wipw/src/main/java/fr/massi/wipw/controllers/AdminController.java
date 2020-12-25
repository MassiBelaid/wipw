package fr.massi.wipw.controllers;


import fr.massi.wipw.models.Admin;
import fr.massi.wipw.models.AdminConnexion;
import fr.massi.wipw.repositories.AdminRepository;
import fr.massi.wipw.services.AdminAuthentificationService;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;

import io.jsonwebtoken.Jwts;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin/connexion")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminAuthentificationService adminAuthentificationService;



    @GetMapping
    public List<Admin> getAdmins(){
        return adminRepository.findAll();
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public AdminConnexion connexion(@RequestBody final Admin admin){
        Admin adminBdd = adminRepository.findByEmail(admin.getEmail());
        AdminConnexion adminConnexion = new AdminConnexion();

        if(adminBdd != null){
            if(admin.getPassword().equals(adminBdd.getPassword())){
                adminConnexion.setStatus(true);
                String token = adminAuthentificationService.getJWTToken(adminBdd.getEmail());
                adminConnexion.setToken(token);
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

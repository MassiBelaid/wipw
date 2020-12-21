package fr.massi.wipw.controllers;


import fr.massi.wipw.models.Admin;
import fr.massi.wipw.models.AdminConnexion;
import fr.massi.wipw.repositories.AdminRepository;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

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


    @GetMapping
    public List<Admin> getAdmins(){
        return adminRepository.findAll();
    }


    @CrossOrigin(origins = "*")
    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AdminConnexion connexion(@RequestBody final Admin admin){
        Admin adminBdd = adminRepository.findByEmail(admin.getEmail());
        AdminConnexion adminConnexion = new AdminConnexion();

        if(adminBdd != null){
            if(admin.getPassword().equals(adminBdd.getPassword())){
                adminConnexion.setStatus(true);
                String token = getJWTToken(adminBdd.getEmail());
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


    private String getJWTToken(String username){

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN");

        String token = null;

        try {
            token = Jwts
                    .builder()
                    .setId("softtekJWT")
                    .setSubject(username)
                    .claim("authorities", grantedAuthorities.stream().map(GrantedAuthority::getAuthority)
                                                                            .collect(Collectors.toList()))
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + 600000))
                    .signWith(SignatureAlgorithm.HS512, "secretKey".getBytes("UTF-8")).compact();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "Bearer " + token;
    }
}

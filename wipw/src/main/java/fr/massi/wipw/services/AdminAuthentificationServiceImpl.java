package fr.massi.wipw.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AdminAuthentificationServiceImpl implements AdminAuthentificationService{

    @Override
    public String getJWTToken(String username) {
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

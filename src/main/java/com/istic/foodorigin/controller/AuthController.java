package com.istic.foodorigin.controller;

import com.istic.foodorigin.models.ERole;
import com.istic.foodorigin.models.Role;
import com.istic.foodorigin.models.TypeTransformateur;
import com.istic.foodorigin.models.User;
import com.istic.foodorigin.payload.request.LoginRequest;
import com.istic.foodorigin.payload.request.SignupRequest;
import com.istic.foodorigin.payload.response.JwtResponse;
import com.istic.foodorigin.payload.response.MessageResponse;
import com.istic.foodorigin.repository.RoleRepository;
import com.istic.foodorigin.repository.TypeTransformateurRepository;
import com.istic.foodorigin.repository.UserRepository;
import com.istic.foodorigin.security.jwt.JwtUtils;
import com.istic.foodorigin.security.services.UserDetailsImpl;
import com.istic.foodorigin.security.services.UserDetailsServiceImpl;
import com.istic.foodorigin.service.TransformateurService;
import com.istic.foodorigin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Point of contact allowing client applications
 * to make request on the database concerning the authentification.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    TypeTransformateurRepository typeTransformateurRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;

    @Autowired
    TransformateurService transformateurService;

    @PostMapping(value = "/signin", consumes = "application/json")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                roles));
    }

    @PostMapping(value = "/signup/{siret}", consumes = "application/json")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest, @PathVariable String siret) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Erreur: Ce nom d'utilisateur est déjà pris !"));
        }
        if (userService.getUserBySiretTransfo(siret) != null) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Erreur: Un compte existe déjà pour ce Siret!"));
        }
        if (transformateurService.getTransformateurBySiret(siret) == null) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Erreur: Ce Siret n'est pas enregistré dans notre base de données !"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        List<Role> roles = new ArrayList<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRole(roles.get(0));
        user.setUserActivation(false);
        TypeTransformateur type = typeTransformateurRepository.findByLibelle(signUpRequest.getTypeTransformateur());
        user.setTypeTransformateur(type);
        user.setTransformateur(transformateurService.getTransformateurBySiret(siret));
        user.setNumeroTelephone(signUpRequest.getNumeroTelephone());
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}

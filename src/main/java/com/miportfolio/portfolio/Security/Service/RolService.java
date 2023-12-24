
package com.miportfolio.portfolio.Security.Service;

import com.miportfolio.portfolio.Security.Entity.Rol;
import com.miportfolio.portfolio.Security.Enums.RolNombre;
import com.miportfolio.portfolio.Security.Repository.iRolRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
        @Autowired
        iRolRepository   irolRepository;
        
        public Optional<Rol> getRolNombre(RolNombre rolNombre){
            return irolRepository.findByRolNombre(rolNombre);
        }
        
        public void save(Rol rol){
            irolRepository.save(rol);
        }
}

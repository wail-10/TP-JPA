package ma.enset.hospital.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    private String userId;
    private String username;
    private String password;
    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER )
    private List<Role> roles=new ArrayList<>();
}

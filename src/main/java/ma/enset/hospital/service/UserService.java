package ma.enset.hospital.service;

import ma.enset.hospital.entities.Role;
import ma.enset.hospital.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String username);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username, String roleName);
}

package inventory.management.inventory.management.service;

import inventory.management.inventory.management.dto.UserRequestDto;
import inventory.management.inventory.management.dto.UserResponseDto;
import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto requestDto);
    UserResponseDto getUserById(Long id);
    List<UserResponseDto> getAllUsers();
    UserResponseDto updateUser(Long id, UserRequestDto requestDto);
    void deleteUser(Long id);
}
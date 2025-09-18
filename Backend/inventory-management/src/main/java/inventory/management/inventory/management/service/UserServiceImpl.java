package inventory.management.inventory.management.service;

import inventory.management.inventory.management.dto.UserRequestDto;
import inventory.management.inventory.management.dto.UserResponseDto;
import inventory.management.inventory.management.entity.User;
import inventory.management.inventory.management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto createUser(UserRequestDto requestDto) {
        User user = new User();
        user.setUsername(requestDto.getUsername());
        user.setEmail(requestDto.getEmail());
        user.setPasswordHash(requestDto.getPasswordHash());
        user.setFullName(requestDto.getFullName());
        user.setRole(User.Role.valueOf(requestDto.getRole()));
        user.setIsActive(requestDto.getIsActive());
        User saved = userRepository.save(user);
        return mapToResponseDto(saved);
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return mapToResponseDto(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream().map(this::mapToResponseDto).collect(Collectors.toList());
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto requestDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(requestDto.getUsername());
        user.setEmail(requestDto.getEmail());
        user.setPasswordHash(requestDto.getPasswordHash());
        user.setFullName(requestDto.getFullName());
        user.setRole(User.Role.valueOf(requestDto.getRole()));
        user.setIsActive(requestDto.getIsActive());
        User updated = userRepository.save(user);
        return mapToResponseDto(updated);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private UserResponseDto mapToResponseDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setUserId(user.getUserId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setFullName(user.getFullName());
        dto.setRole(user.getRole().toString());
        dto.setIsActive(user.getIsActive());
        dto.setCreatedAt(user.getCreatedAt());
        return dto;
    }
}
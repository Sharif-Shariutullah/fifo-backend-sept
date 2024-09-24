package com.example.fifotech.services.auth;

import com.example.fifotech.dto.SignupRequest;
import com.example.fifotech.dto.UserDto;
import com.example.fifotech.entity.User;
import com.example.fifotech.enums.UserRole;
import com.example.fifotech.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


//    @Autowired
//    private OrderRepository orderRepository;


    public UserDto createUser(SignupRequest signupRequest) {

        User user = new User();

        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setRole(UserRole.CUSTOMER);
        User createdUser = userRepository.save(user);


//Problem 01
//
//        Order order = new Order();
//
//        order.setAmount(0L);
//        order.setTotalAmount(0L);
//        order.setDiscount(0L);
//        order.setUser(createdUser);
//        order.setOrderStatus(OrderStatus.Pending);
//        orderRepository.save(order);


        UserDto userDto = new UserDto();
        userDto.setId(createdUser.getId());

        return userDto;
    }


    public Boolean hasUserWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();

    }

    @PostConstruct
    public void createAdminAccount() {
        User adminAccount = userRepository.findByRole(UserRole.ADMIN);
        if (null == adminAccount) {
            User user = new User();
            user.setEmail("admin@test.com");
            user.setName("admin");
            user.setRole(UserRole.ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(user);
        }
    }


}

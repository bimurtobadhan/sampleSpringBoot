package com.bimurto.sampleSpringBoot;

import com.bimurto.sampleSpringBoot.dao.BookDao;
import com.bimurto.sampleSpringBoot.domain.Book;
import com.bimurto.sampleSpringBoot.domain.User;
import com.bimurto.sampleSpringBoot.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Slf4j
@Configuration
public class SampleSpringBootApplicationDbInitializer implements CommandLineRunner {

    private UserRepository userRepository;
    private BookDao bookDao;

    @Autowired
    public SampleSpringBootApplicationDbInitializer(UserRepository userRepository, BookDao bookDao) {
        this.userRepository = userRepository;
        this.bookDao = bookDao;
    }

    @Transactional
    @Override
    public void run(String... args) {
        log.debug("Initialisation starts.");

//        for (int i = 0; i < 10; i++) {
//            User user = User.builder()
//                    .name("Name"+i)
//                    .dob(new Date())
//                    .city("Dhaka")
//                    .build();
//            userRepository.save(user);
//        }
//
//        List<User> userList = userRepository.findAll();
//        log.info("UserList Size : {}", userList.size());
//
//        for (int i = 0; i < 10; i++) {
//            Book book = Book.builder()
//                    .name("Name"+i)
//                    .author("Author"+i)
//                    .build();
//            bookDao.save(book);
//        }
//
//        for (int i = 1; i <= 10; i++) {
//            Book book = bookDao.getBookbyId((long)i);
//            log.info("Book {}", book);
//        }

    }
}

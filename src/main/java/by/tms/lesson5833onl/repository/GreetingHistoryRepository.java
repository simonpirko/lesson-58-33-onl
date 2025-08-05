package by.tms.lesson5833onl.repository;

import by.tms.lesson5833onl.entity.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingHistoryRepository extends JpaRepository<Greeting, Long> {
}

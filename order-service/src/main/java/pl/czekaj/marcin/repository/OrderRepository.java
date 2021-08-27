package pl.czekaj.marcin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.czekaj.marcin.entity.Order;

public interface OrderRepository extends MongoRepository<Order,String> {
}

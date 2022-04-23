package dev.rivaldi.springbootff4jdemo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends CrudRepository<Seller, String> {
}

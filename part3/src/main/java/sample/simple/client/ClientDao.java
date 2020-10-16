package sample.simple.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ClientDao extends JpaRepository<Client, Long> {

  public Client findByNom(String nom);

}
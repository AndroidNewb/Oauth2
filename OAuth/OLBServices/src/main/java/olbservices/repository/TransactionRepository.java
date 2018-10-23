package olbservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import olbservices.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

	public List<Transaction> findAllByfromAccount(String fromAccount);
	public List<Transaction> findAllBytoAccount(String toAccount);
	
}

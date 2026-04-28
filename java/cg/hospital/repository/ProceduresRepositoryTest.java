package cg.hospital.repository;

import cg.hospital.entity.Procedures;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProceduresRepositoryTest {

	@Autowired
	private ProceduresRepository proceduresRepository;

	@Test
	void testGetProcedures() {

		List<Procedures> list = proceduresRepository.findAll();

		assertNotNull(list, "Procedures list is NULL (DB connection issue)");

		assertFalse(list.isEmpty(), "No data found in Procedures table");

		list.forEach(System.out::println);
	}
}
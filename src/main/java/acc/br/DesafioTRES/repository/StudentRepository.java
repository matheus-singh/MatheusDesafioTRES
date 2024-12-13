package acc.br.DesafioTRES.repository;

import acc.br.DesafioTRES.repository.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByName(String name);
}

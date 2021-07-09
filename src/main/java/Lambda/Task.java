package Lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@AllArgsConstructor
public class Task {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private final String id;
        private final String title;
        private final TaskType type;
        private final LocalDate createdOn;
        private boolean done = false;
        private Set<String> tags = new HashSet<>() ;
        private LocalDate dueOn;
}



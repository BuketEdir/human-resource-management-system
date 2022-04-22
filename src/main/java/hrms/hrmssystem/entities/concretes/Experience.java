package hrms.hrmssystem.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "experiences")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resume"})
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "position")
    private String position;

    @Column(name = "start_year")
    private Date startYear;

    @Column(name = "quit_year")
    private Date quitYear;

    @Column(name = "experience_year")
    private int experinceYear;

    @Column(name = "is_continues")
    private boolean isContinues;

    @ManyToOne()
    @JoinColumn(name = "resume_id")
    private Resume resume;

}

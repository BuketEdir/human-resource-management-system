package hrms.hrmssystem.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="candidates")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resume","image","jobApplications"})
public class Candidate  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="candidate_email")
    private String candidateEmail;

    @Column(name="last_name")
    private String lastName;

    @Column(name ="nationality_number",unique = true)
    private String nationalityNo;

    @Column(name = "birth_date")
    private Date birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="resume_id",referencedColumnName = "id")
    private Resume resume;

    @ManyToMany(mappedBy ="candidates")
    private Set<JobApplication> jobApplications=new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="image_id",referencedColumnName = "id")
    private Image image;



}

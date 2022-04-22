package hrms.hrmssystem.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "job_applications")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resume","candidate"})
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @ManyToOne()
    @JoinColumn(name = "jobAnnouncement_id")
    private JobAnnouncement jobAnnouncement;


    @ManyToMany(cascade ={CascadeType.ALL})
    @JoinTable(
            name ="Application_Candidate",
            joinColumns = {@JoinColumn(name="application_id")},
            inverseJoinColumns={@JoinColumn(name="candidate_id")}
    )
    Set<Candidate> candidates=new HashSet<>();


    @ManyToMany(mappedBy ="jobApplication",fetch = FetchType.EAGER)
    private Set<Resume> resumes=new HashSet<>();


}

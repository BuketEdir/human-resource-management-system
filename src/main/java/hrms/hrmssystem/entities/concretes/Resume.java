package hrms.hrmssystem.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resume")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educations","experiences","languages"})
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "github_address")
    private String gitHubAddress;

    @Column(name = "linkedin_address")
    private String linkedinAddress;

    @Column(name = "cover_letter")
    private String coverLetter;


    @OneToMany(mappedBy = "resume")
    private List<Education> educations;


    @OneToMany(mappedBy = "resume")
    private List<Experience> experiences;


    @OneToMany(mappedBy = "resume")
    private List<Language> languages;

  @OneToOne(mappedBy = "resume")
  private Candidate candidate;


    @ManyToMany(cascade ={CascadeType.ALL})
    @JoinTable(
            name ="Resume_JobApplication",
            joinColumns = {@JoinColumn(name="resume_id")},
            inverseJoinColumns={@JoinColumn(name="job_application_id")}
    )
    Set<JobApplication> jobApplication=new HashSet<>();

}
